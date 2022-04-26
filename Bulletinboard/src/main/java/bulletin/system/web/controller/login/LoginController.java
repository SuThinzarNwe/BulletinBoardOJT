package bulletin.system.web.controller.login;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bulletin.system.bl.dto.login.LoginDTO;
import bulletin.system.bl.service.user.UserService;
import bulletin.system.web.form.login.LoginForm;

/**
 * <h2>LoginController Class</h2>
 * <p>
 * Process for Displaying LoginController
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
@Controller
public class LoginController {
	@Autowired
	UserService userService;
	/**
	 * <h2>messageSource</h2>
	 * <p>
	 * messageSource
	 * </p>
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * <h2>initView</h2>
	 * <p>
	 * init view for user login
	 * </p>
	 *
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView initView() {
		ModelAndView loginView = new ModelAndView("redirect:/showLogin");
		return loginView;
	}

	/**
	 * <h2>showLogin</h2>
	 * <p>
	 * Show Login For User
	 * </p>
	 *
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/showLogin", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView loginView = new ModelAndView("login");
		loginView.addObject("loginForm", new LoginForm());
		return loginView;
	}

	@RequestMapping(value = "/showLogin", method = RequestMethod.POST)
	public ModelAndView showUserLogin(@ModelAttribute("loginForm") @Valid LoginForm loginForm, BindingResult result,
			HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ParseException {
		ModelAndView userView = new ModelAndView("login");
		if (result.hasErrors()) {
			return userView;
		}
		LoginDTO loginUser = this.userService.doGetLoginResult(loginForm);
		if (loginUser != null && (loginUser.getPassword() != null && loginUser.getEmail() != null)) {
			session.setAttribute("LOGIN_USER", loginUser);
			session.setAttribute("loginUserId", loginUser.getId());

			userView = new ModelAndView("redirect:/postList");
		} else {
			userView = new ModelAndView("login");
			userView.addObject("errorMsg", messageSource.getMessage("M_SC_0001", null, null));
		}
		return userView;
	}

	/**
	 * <h2>logout</h2>
	 * <p>
	 * User Logout
	 * </p>
	 *
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(Model model, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		session.removeAttribute("LOGIN_USER");
		ModelAndView loginView = new ModelAndView("redirect:/showLogin");

		return loginView;
	}

}
