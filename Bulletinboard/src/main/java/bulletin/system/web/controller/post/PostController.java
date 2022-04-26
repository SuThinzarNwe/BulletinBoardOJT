package bulletin.system.web.controller.post;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bulletin.system.bl.dto.post.PostDTO;
import bulletin.system.bl.service.post.PostService;
import bulletin.system.bl.service.user.UserService;
import bulletin.system.web.form.post.PostForm;
import bulletin.system.web.form.post.SearchPostForm;
import net.sf.jasperreports.engine.JRException;

/**
 * <h2>PostController Class</h2>
 * <p>
 * Process for Displaying PostController
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
/**
 * @author SuThinzarNwe
 *
 */
/**
 * @author SuThinzarNwe
 *
 */
@Controller
public class PostController {
	/**
	 * <h2>postService</h2>
	 * <p>
	 * postService
	 * </p>
	 */
	@Autowired
	private PostService postService;

	/**
	 * <h2>userService</h2>
	 * <p>
	 * userService
	 * </p>
	 */
	@SuppressWarnings("unused")
	@Autowired
	private UserService userService;
	/**
	 * <h2>session</h2>
	 * <p>
	 * session
	 * </p>
	 */
	@Autowired
	private HttpSession session;

	/**
	 * <h2>messageSource</h2>
	 * <p>
	 * messageSource
	 * </p>
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * <h2>createPostList</h2>
	 * <p>
	 * Create Post List With View
	 * </p>
	 *
	 * @param postForm
	 * @param request
	 * @param response
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/postList", method = RequestMethod.GET)
	public ModelAndView createPostList(PostForm postForm, HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IOException {
		int loginUserId = (int) request.getSession().getAttribute("loginUserId");
		ModelAndView postList = new ModelAndView("postList");
		List<PostDTO> listPost = this.postService.doGetPostList(loginUserId);
		postList.addObject("postList", listPost);
		return postList;
	}

	/**
	 * <h2>searchPostList</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param view
	 * @param searchPostForm
	 * @return
	 * @return ModelAndView
	 */
	@PostMapping(value = "/searchpostList")
	public ModelAndView searchPostList(ModelAndView view, @ModelAttribute SearchPostForm searchPostForm) {
		List<PostDTO> postList = this.postService.doGetAllPosts(searchPostForm);
		view.setViewName("postList");
		view.addObject("postList", postList);
		view.addObject("searchPostForm", searchPostForm);
		return view;
	}

	/**
	 * <h2>detailPost</h2>
	 * <p>
	 * Detail Post
	 * </p>
	 *
	 * @param postId
	 * @param request
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/detailPost", method = RequestMethod.GET)
	public ModelAndView detailPost(@RequestParam("id") Integer postId, HttpServletRequest request) {
		ModelAndView detailPostView = new ModelAndView("detailPost");
		PostForm detailPostForm = this.postService.dogetPostById(postId);
		detailPostView.addObject("detailPost", detailPostForm);
		return detailPostView;
	}

	/**
	 * <h2>createPost</h2>
	 * <p>
	 * Create Post View
	 * </p>
	 *
	 * @param model
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/createPost", method = RequestMethod.GET)
	public ModelAndView createPost(Model model) {
		ModelAndView createPostView = new ModelAndView("createPost");
		createPostView.addObject("createPost", new PostForm());
		return createPostView;
	}

	/**
	 * <h2>addPost</h2>
	 * <p>
	 * Adding Post
	 * </p>
	 *
	 * @param postForm
	 * @param result
	 * @param request
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/createPostConfirm", params = "confirmPost", method = RequestMethod.POST)
	public ModelAndView addPost(@ModelAttribute("createPost") @Valid PostForm postForm, BindingResult result,
			HttpServletRequest request) {

		ModelAndView postAddConfirm = new ModelAndView("createPost");
		if (result.hasErrors()) {
			postAddConfirm.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
			return postAddConfirm;
		}
		if (this.postService.doInsertTitleExist(postForm.getTitle())) {
			postAddConfirm.addObject("errorMsg", messageSource.getMessage("M_SC_0018", null, null));
			return postAddConfirm;
		}
		postAddConfirm = new ModelAndView("createPostConfirm");
		postAddConfirm.addObject("postForm", postForm);
		return postAddConfirm;
	}

	/**
	 * <h2>cancelPost</h2>
	 * <p>
	 * Redirect Cancel Button
	 * </p>
	 *
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/createPostConfirm", params = "back", method = RequestMethod.POST)
	public ModelAndView cancelPost() {
		ModelAndView createPostView = new ModelAndView("redirect:/postList");
		return createPostView;
	}

	/**
	 * <h2>createPostConfirm</h2>
	 * <p>
	 * Create Post Confirm When Add Button
	 * </p>
	 *
	 * @param postForm
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/insertPost", params = "addPost", method = RequestMethod.POST)
	public ModelAndView createPostConfirm(@ModelAttribute("postForm") @Valid PostForm postForm, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {
		int LoginUserID = (int) request.getSession().getAttribute("loginUserId");
		this.postService.doAddPost(postForm, LoginUserID);
		ModelAndView createPostView = new ModelAndView("redirect:/postList");
		return createPostView;
	}

	/**
	 * <h2>cancelPostConfirm</h2>
	 * <p>
	 * Cancel Post Adding
	 * </p>
	 *
	 * @param postForm
	 * @param result
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/insertPost", params = "cancel", method = RequestMethod.POST)
	public ModelAndView cancelPostConfirm(@ModelAttribute("createPost") @Valid PostForm postForm,
			BindingResult result) {
		ModelAndView createPostView = new ModelAndView("createPost");
		createPostView.addObject("rollBackPostForm", postForm);
		return createPostView;
	}

	/**
	 * <h2>update</h2>
	 * <p>
	 * Update Post By Id Connect with View
	 * </p>
	 *
	 * @param postId
	 * @param request
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/updatePost", method = RequestMethod.GET)
	public ModelAndView updatePost(@RequestParam("id") Integer postId, HttpServletRequest request) {
		ModelAndView updateView = new ModelAndView("updatePost");
		PostForm oldPostForm = this.postService.dogetPostById(postId);
		updateView.addObject("oldPostForm", oldPostForm);
		return updateView;
	}

	/**
	 * <h2>callUpdatePostConfirm</h2>
	 * <p>
	 * Call Post COnfirm when Confirm Button Click
	 * </p>
	 *
	 * @param updatePostForm
	 * @param result
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/updatePostConfirm", params = "update", method = RequestMethod.POST)
	public ModelAndView callUpdatePostConfirm(@ModelAttribute("editedPostForm") @Valid PostForm updatePostForm,
			BindingResult result) {
		ModelAndView updatePostView = new ModelAndView("updatePost");
		if (result.hasErrors()) {
			updatePostView.addObject("errorMsg", messageSource.getMessage("M_SC_0008", null, null));
			return updatePostView;
		}
		Boolean isPostTitleExist = this.postService.doUpdateTitleExist(updatePostForm.getTitle(),
				updatePostForm.getId());
		if (isPostTitleExist) {
			updatePostView.addObject("errorMsg", messageSource.getMessage("M_SC_0018", null, null));
			return updatePostView;
		}
		updatePostView = new ModelAndView("updatePostConfirm");
		Integer statusCode = updatePostForm.getStatus() == null ? 0 : updatePostForm.getStatus();
		updatePostForm.setStatus(statusCode);
		updatePostView.addObject("updatePostForm", updatePostForm);
		return updatePostView;

	}

	/**
	 * <h2>cancelUpdatePostMain</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param postForm
	 * @param result
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/updatePostConfirm", params = "cancel", method = RequestMethod.POST)
	public ModelAndView cancelUpdatePostMain(@ModelAttribute("finalCOnfirmPostForm") @Valid PostForm postForm,
			BindingResult result) {
		ModelAndView updatePostView = new ModelAndView("redirect:/postList");
		return updatePostView;

	}

	/**
	 * <h2>updatePost</h2>
	 * <p>
	 * Update Post When Update Button Click
	 * </p>
	 *
	 * @param postForm
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/editPost", params = "update", method = RequestMethod.POST)
	public ModelAndView updatePost(@ModelAttribute("finalConfirmPostForm") @Valid PostForm postForm,
			BindingResult result, HttpServletRequest request, HttpServletResponse response)
			throws ParseException, FileNotFoundException, IOException {
		int loginUserId = (int) request.getSession().getAttribute("loginUserId");
		this.postService.doUpdatePost(postForm, loginUserId);
		ModelAndView updatePostView = new ModelAndView("redirect:/postList");
		return updatePostView;
	}

	/**
	 * <h2>cancelUpdatePost</h2>
	 * <p>
	 * Cancel Update when Cancel button click
	 * </p>
	 *
	 * @param postForm
	 * @param result
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/editPost", params = "cancel", method = RequestMethod.POST)
	public ModelAndView cancelUpdatePost(@ModelAttribute("finalCOnfirmPostForm") @Valid PostForm postForm,
			BindingResult result) {
		ModelAndView updatePostView = new ModelAndView("updatePost");
		updatePostView.addObject("oldPostForm", postForm);
		return updatePostView;

	}

	/**
	 * <h2>deletePost</h2>
	 * <p>
	 * Delete Post By Id
	 * </p>
	 *
	 * @param postId
	 * @param request
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/deletePost", method = RequestMethod.GET)
	public ModelAndView deletePost(@RequestParam("id") Integer postId, HttpServletRequest request)
			throws FileNotFoundException, IOException {
		this.postService.doPostDelete(postId);
		ModelAndView deletePost = new ModelAndView("redirect:/postList");
		deletePost.addObject("errorMsg", messageSource.getMessage("M_SC_0013", null, null));
		return deletePost;
	}

	/**
	 * <h2>uploadPostCSV</h2>
	 * <p>
	 * Upload Post File
	 * </p>
	 *
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/uploadCSV", method = RequestMethod.GET)
	public ModelAndView uploadPostView() {
		ModelAndView uploadView = new ModelAndView("uploadCSV");
		return uploadView;
	}

	/**
	 * <h2>uploadPostView</h2>
	 * <p>
	 * Upload Post CSV File
	 * </p>
	 *
	 * @param request
	 * @param uploadFile
	 * @return
	 * @throws Exception
	 * @return ModelAndView
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadCSV", method = RequestMethod.POST)
	public ModelAndView uploadPostView(@RequestParam("fileUpload") MultipartFile fileUpload, HttpServletRequest request)
			throws IOException {
		ModelAndView uploadView = new ModelAndView("uploadCSV");
		int loginUserId = (int) request.getSession().getAttribute("loginUserId");
		if (fileUpload.getSize() == 0) {
			uploadView.addObject("UploadErrorMsg", messageSource.getMessage("M_SC_0006", null, null));
			return uploadView;
		}
		List<String> errorUpload = this.postService.doUploadCSV(fileUpload, loginUserId);
		if (errorUpload.size() > 0) {
			uploadView = new ModelAndView("uploadCSV");
			uploadView.addObject("UploadErrorMsg", errorUpload);
		} else {
			uploadView = new ModelAndView("redirect:/postList");
		}
		return uploadView;
	}

	/**
	 * <h2>downloadExcel</h2>
	 * <p>
	 * Download Excel
	 * </p>
	 *
	 * @param postForm
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws JRException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/downloadExcel", params = "downloadExcel", method = RequestMethod.POST)
	public ModelAndView downloadExcel(@RequestParam("searchInput") String search_input, PostForm postForm,
			HttpServletRequest request, HttpServletResponse response) throws IOException, JRException {
		int loginUserId = (int) request.getSession().getAttribute("loginUserId");
		List<PostDTO> postListview = this.postService.doGetPostList(loginUserId);
		try {
			this.postService.doGenerateDownloadExcelFile(postListview);
		} catch (IOException | ParseException e) {
			Log.error(e);
		}
		ModelAndView postView = new ModelAndView();
		postView.setViewName("redirect:/postList");
		session.setAttribute("completeMsg", messageSource.getMessage("M_SC_0021", null, null));
		return postView;
	}
}
