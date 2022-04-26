package bulletin.system.bl.service.post;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import bulletin.system.bl.dto.post.PostDTO;
import bulletin.system.web.form.post.PostForm;
import bulletin.system.web.form.post.SearchPostForm;
import net.sf.jasperreports.engine.JRException;

/**
 * <h2>PostService Class</h2>
 * <p>
 * Process for Displaying PostService
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
public interface PostService {
	/**
	 * <h2>doGetPostList</h2>
	 * <p>
	 * Get Post List By Post Id
	 * </p>
	 *
	 * @param postCreatedUserId
	 * @return
	 * @return List<PostDTO>
	 */

	public List<PostDTO> doGetPostList(int postCreatedUserId);

	/**
	 * <h2>doGetAllPosts</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return List<PostDTO>
	 */
	public List<PostDTO> doGetAllPosts();

	/**
	 * <h2>doGetAllPosts</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param searchPostForm SearchPostForm
	 * @return
	 * @return List<PostDTO>
	 */
	public List<PostDTO> doGetAllPosts(SearchPostForm searchPostForm);

	/**
	 * <h2>dogetPostById</h2>
	 * <p>
	 * Get Post By Id
	 * </p>
	 *
	 * @param postId
	 * @return
	 * @return PostForm
	 */
	public PostForm dogetPostById(Integer postId);

	/**
	 * <h2>doAddPost</h2>
	 * <p>
	 * Add POst When Add Button Click
	 * </p>
	 *
	 * @param postForm
	 * @param loginUserID
	 * @return void
	 */
	public void doAddPost(@Valid PostForm postForm, int loginUserID);

	/**
	 * <h2>doInsertTitleExist</h2>
	 * <p>
	 * Insert Title Exist or Not
	 * </p>
	 *
	 * @param title
	 * @return
	 * @return boolean
	 */
	public boolean doInsertTitleExist(String title);

	/**
	 * <h2>doUpdateTitleExist</h2>
	 * <p>
	 * Test Post Title is Exit
	 * </p>
	 *
	 * @param title
	 * @param id
	 * @return
	 * @return Boolean
	 */
	public boolean doUpdateTitleExist(String title, Integer id);

	/**
	 * <h2>doUpdatePost</h2>
	 * <p>
	 * Update Post Form
	 * </p>
	 *
	 * @param postForm
	 * @param loginUserForm
	 * @return void
	 */
	public void doUpdatePost(@Valid PostForm postForm, int loginUserForm);

	/**
	 * <h2>doPostDelete</h2>
	 * <p>
	 * Delete Post By Id
	 * </p>
	 *
	 * @param postId
	 * @return void
	 */
	public void doPostDelete(Integer postId);

	/**
	 * <h2>doUploadCSV</h2>
	 * <p>
	 * Post Upload With CSV File
	 * </p>
	 *
	 * @param uploadFile
	 * @param loginUserId
	 * @return
	 * @return List<String>
	 * @throws IOException
	 */
	public List<String> doUploadCSV(MultipartFile uploadFile, int loginUserId) throws IOException;

	/**
	 * <h2>doGenerateDownloadExcelFile</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param searchPostList
	 * @param baos
	 * @return
	 * @return String
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doGenerateDownloadExcelFile(List<PostDTO> searchPostList)
			throws JRException, IOException, ParseException;
}
