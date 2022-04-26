package bulletin.system.web.controller.user;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bulletin.system.bl.dto.user.UserDTO;
import bulletin.system.bl.service.user.UserService;
import bulletin.system.web.form.user.SearchUserForm;
import bulletin.system.web.form.user.UserForm;

/**
 * <h2>UserController Class</h2>
 * <p>
 * Process for Displaying UserController
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
@Controller
public class UserController {
	/**
	 * <h2>userService</h2>
	 * <p>
	 * userService
	 * </p>
	 */
	@Autowired
	UserService userService;
	/**
	 * <h2>messageSource</h2>
	 * <p>
	 * messageSource
	 * </p>
	 */
	@Autowired
	MessageSource messageSource;
	/**
	 * <h2>encode</h2>
	 * <p>
	 * encode
	 * </p>
	 */
	@Autowired
	private PasswordEncoder encode;

	/**
	 * <h2>userList</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param view
	 * @return
	 * @return ModelAndView
	 */
	@GetMapping(value = "/userList")
	public ModelAndView userList(ModelAndView view) {
		List<UserDTO> userList = this.userService.doGetAllUsers();
		view.setViewName("userList");
		view.addObject("userList", userList);
		view.addObject("searchUserForm", new SearchUserForm());
		return view;
	}

	/**
	 * <h2>searchUserList</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param view
	 * @param searchUserForm
	 * @return
	 * @return ModelAndView
	 */
	@PostMapping(value = "/userList")
	public ModelAndView searchUserList(ModelAndView view, @ModelAttribute SearchUserForm searchUserForm) {
		List<UserDTO> userList = this.userService.doGetAllUsers(searchUserForm);
		view.setViewName("userList");
		view.addObject("userList", userList);
		view.addObject("searchUserForm", searchUserForm);
		return view;
	}

	/**
	 * <h2>detailUser</h2>
	 * <p>
	 * Detail User By Selected Id
	 * </p>
	 *
	 * @param userId
	 * @param request
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/detailUser", method = RequestMethod.GET)
	public ModelAndView detailUser(@RequestParam("id") Integer userId, HttpServletRequest request)
			throws FileNotFoundException, IOException {
		ModelAndView userView = new ModelAndView("detailUser");
		UserForm userDetail = this.userService.doGetUserbyId(userId);
		userView.addObject("userDetail", userDetail);

		return userView;
	}

	/**
	 * <h2>createUser</h2>
	 * <p>
	 * Create User
	 * </p>
	 *
	 * @param model
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public ModelAndView createUser(Model model) {
		ModelAndView createUserView = new ModelAndView("createUser");
		createUserView.addObject("createUser", new UserForm());
		return createUserView;
	}

	/**
	 * <h2>insertUser</h2>
	 * <p>
	 * Insert User when ConfirmUser Button Click
	 * </p>
	 *
	 * @param userForm
	 * @param result
	 * @param session
	 * @param request
	 * @param imageData
	 * @return
	 * @throws ParseException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/createUserConfirm", params = "confirmUser", method = RequestMethod.POST)
	public ModelAndView insertUser(@ModelAttribute("createUser") @Valid UserForm userForm, BindingResult result,
			HttpSession session, HttpServletRequest request, @RequestParam("imageData") String imageData)
			throws ParseException {
		ModelAndView userConfirmView = null;
		if (result.hasErrors()) {
			userConfirmView = new ModelAndView("createUser");
			userConfirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
			return userConfirmView;
		}
		if (!userForm.getPassword().equals(request.getParameter("confirmPassword"))) {
			userConfirmView = new ModelAndView("createUser");
			userConfirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0009", null, null));
			return userConfirmView;
		}
		if (userService.doIsUserExist(userForm.getEmail())) {
			userConfirmView = new ModelAndView("createUser");
			userConfirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0010", null, null));
			return userConfirmView;
		}
		userConfirmView = new ModelAndView("createUserConfirm");
		if (imageData.length() > 0) {
			userForm.setProfile(imageData);
		}
		userConfirmView.addObject("userForm", userForm);
		return userConfirmView;
	}

	/**
	 * <h2>calcelUserMain</h2>
	 * <p>
	 * Cancel User Adding
	 * </p>
	 *
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/createUserConfirm", params = "clearUserData", method = RequestMethod.POST)
	public ModelAndView calcelUserMain() {
		ModelAndView createUserView = new ModelAndView("redirect:/userList");
		return createUserView;
	}

	/**
	 * <h2>insertUser</h2>
	 * <p>
	 * Insert User Into Database
	 * </p>
	 * 
	 * @param userForm
	 * @param result
	 * @param request
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 * @return ModelAndView
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/insertUser", params = "addUser", method = RequestMethod.POST)
	public ModelAndView insertUser(@ModelAttribute("createUser") @Valid UserForm userForm, BindingResult result,
			HttpServletRequest request) throws ParseException, IOException {
		int loginUserId = (int) request.getSession().getAttribute("loginUserId");
		Path path = Paths.get(request.getRealPath("/") + "/resources/profiles/" + userForm.getEmail());
		String userProfilePath = Files.createDirectories(path) + "/" + userForm.getEmail() + ".png";
		this.userService.doInsertUser(userForm, loginUserId, userProfilePath);
		ModelAndView createUserView = new ModelAndView("redirect:/userList");
		return createUserView;
	}

	/**
	 * <h2>calcelUser</h2>
	 * <p>
	 * Cancel Insert User
	 * </p>
	 * 
	 * @param userForm
	 * @param result
	 * @param session
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/insertUser", params = "cancel", method = RequestMethod.POST)
	public ModelAndView calcelUser(@ModelAttribute("createUser") @Valid UserForm userForm, BindingResult result,
			HttpSession session) {
		ModelAndView createUserView = new ModelAndView("createUser");
		createUserView.addObject("userForm", userForm);
		return createUserView;
	}

//UPDATE
	/**
	 * <h2>update</h2>
	 * <p>
	 * Update User Connect With View
	 * </p>
	 *
	 * @param userId
	 * @param request
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam("id") Integer userId, HttpServletRequest request)
			throws FileNotFoundException, IOException {
		ModelAndView updateView = new ModelAndView("updateUser");
		UserForm oldUserForm = this.userService.doGetUserbyId(userId);
		updateView.addObject("oldUserForm", oldUserForm);
		return updateView;
	}

	/**
	 * <h2>callUpdateUserConfirm</h2>
	 * <p>
	 * Update User Confirm
	 * </p>
	 *
	 * @param updateUserForm
	 * @param result
	 * @param session
	 * @param imageData
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/updateUserConfirm", params = "updateUserConfirm", method = RequestMethod.POST)
	public ModelAndView callUpdateUserConfirm(@ModelAttribute("editedUserForm") @Valid UserForm updateUserForm,
			BindingResult result, HttpSession session, @RequestParam("imageData") String imageData)
			throws ParseException, IOException {
		ModelAndView updateConfirmView = new ModelAndView("updateUser");
		if (result.hasErrors()) {
			updateConfirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0008", null, null));
			return updateConfirmView;
		}
		Boolean isUpdatedEmailExist = this.userService.doEmailExist(updateUserForm.getEmail(), updateUserForm.getId());
		if (isUpdatedEmailExist) {
			updateConfirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0010", null, null));
			return updateConfirmView;
		}
		UserForm userById = this.userService.doGetUserbyId(updateUserForm.getId());

		if (imageData == null || imageData == "" || imageData.isEmpty()) {
			updateUserForm.setProfile(userById.getProfile());
		} else {
			updateUserForm.setProfile(imageData);
		}
		updateConfirmView = new ModelAndView("updateUserConfirm");
		updateConfirmView.addObject("updateConfirmForm", updateUserForm);
		return updateConfirmView;
	}

	/**
	 * <h2>calcelUserUpdate</h2>
	 * <p>
	 * Cancel User Update
	 * </p>
	 *
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/updateUserConfirm", params = "cancelUser", method = RequestMethod.POST)
	public ModelAndView calcelUserUpdate() {
		ModelAndView createUserView = new ModelAndView("redirect:/userList");
		return createUserView;
	}

	/**
	 * <h2>updateUser</h2>
	 * <p>
	 * Update User Confirm
	 * </p>
	 *
	 * @param userForm
	 * @param result
	 * @param session
	 * @param request
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 * @return ModelAndView
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/editUser", params = "update", method = RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("finalConfirmUserForm") @Valid UserForm userForm,
			BindingResult result, HttpSession session, HttpServletRequest request) throws ParseException, IOException {
		int loginUserId = (int) request.getSession().getAttribute("loginUserId");
		Path path = Paths.get(request.getRealPath("/") + "/resources/profiles/" + userForm.getEmail());
		String userProfilePath = Files.createDirectories(path) + "/" + userForm.getEmail() + ".png";
		this.userService.doUpdateUser(userForm, loginUserId, userProfilePath);
		ModelAndView updateUserView = new ModelAndView("redirect:/userList");
		return updateUserView;
	}

	/**
	 * <h2>cancelUpdateUser</h2>
	 * <p>
	 * Update User Cancel
	 * </p>
	 *
	 * @param userForm
	 * @param result
	 * @param session
	 * @return
	 * @throws ParseException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/editUser", params = "cancel", method = RequestMethod.POST)
	public ModelAndView cancelUpdateUser(@ModelAttribute("finalConfirmUserForm") @Valid UserForm userForm,
			BindingResult result, HttpSession session) throws ParseException {
		ModelAndView updateUserView = new ModelAndView("updateUser");
		updateUserView.addObject("oldUserForm", userForm);
		return updateUserView;
	}

	/**
	 * <h2>deleteUser</h2>
	 * <p>
	 * Delete User BY Id
	 * </p>
	 *
	 * @param userId
	 * @param request
	 * @return
	 * @throws IOException
	 * @return ModelAndView
	 * @throws ParseException
	 */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam("id") Integer userId, HttpServletRequest request)
			throws IOException, ParseException {
		ModelAndView deleteUser = new ModelAndView("userList");
		this.userService.doDeleteUser(userId);
		deleteUser.addObject("errorMsg", messageSource.getMessage("M_SC_0013", null, null));
		return deleteUser;
	}

	/**
	 * <h2>changePassword</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param userId
	 * @param request
	 * @return
	 * @throws IOException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public ModelAndView changePassword(@RequestParam("id") Integer userId, HttpServletRequest request)
			throws IOException {
		ModelAndView updateView = new ModelAndView("changePassword");
		UserForm userById = this.userService.doGetUserbyId(userId);
		updateView.addObject("UserForm", userById);
		return updateView;
	}

	/**
	 * <h2>changePasswodFunction</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @param ConfirmPassword
	 * @param request
	 * @return
	 * @throws IOException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ModelAndView changePasswodFunction(@RequestParam("id") Integer userId,
			@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword,
			@RequestParam("confirmPassword") String ConfirmPassword, HttpServletRequest request) throws IOException {
		ModelAndView updateView = new ModelAndView("changePassword");
		UserForm userById = null;
		try {
			userById = this.userService.doGetUserbyId(userId);
		} catch (IOException e) {
			updateView = new ModelAndView("redirect:/error500");
		}
		boolean isPasswordMatch = encode.matches(oldPassword, userById.getPassword());
		if (isPasswordMatch == false || !isPasswordMatch) {
			updateView.addObject("userId", userId);
			updateView.addObject("errorMsg", messageSource.getMessage("M_SC_0017", null, null));
			return updateView;
		}
		if (!newPassword.equals(newPassword)) {
			updateView.addObject("userId", userId);
			updateView.addObject("errorMsg", messageSource.getMessage("M_SC_0022", null, null));
			return updateView;
		}
		if (newPassword.length() <= 7) {
			updateView.addObject("userId", userId);
			updateView.addObject("errorMsg", messageSource.getMessage("M_SC_0023", null, null));
			return updateView;
		}
		this.userService.doUpdatePassword(newPassword, userById.getId());
		updateView = new ModelAndView("redirect:/detailUser?id=" + userId);
		return updateView;
//		UserForm userById = this.userService.doGetUserbyId(userId);
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		boolean isPasswordMatch = passwordEncoder.matches(oldPassword, userById.getPassword());
//		if (isPasswordMatch && newPassword.equals(ConfirmPassword) && newPassword.length() > 7) {
//			this.userService.doUpdatePassword(newPassword, userId);
//			updateView = new ModelAndView("redirect:/detailUser?id=" + userId);
//			return updateView;
//		} else {
//			updateView.addObject("errorMsg", messageSource.getMessage("M_SC_0017", null, null));
//			updateView = new ModelAndView("redirect:/changePassword?id=" + userId);
//			return updateView;
//		}
	}
}
