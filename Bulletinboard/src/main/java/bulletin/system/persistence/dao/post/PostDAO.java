package bulletin.system.persistence.dao.post;

import java.util.Date;
import java.util.List;

import bulletin.system.bl.dto.post.PostDTO;
import bulletin.system.persistence.entity.post.Post;
import bulletin.system.persistence.entity.user.User;
import bulletin.system.web.form.post.SearchPostForm;

/**
 * <h2>PostDAO Class</h2>
 * <p>
 * Process for Displaying PostDAO
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
public interface PostDAO {
	/**
	 * <h2>dbgetPostList</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param user
	 * @return
	 * @return List<Post>
	 */
	public List<Post> dbgetPostList(User user);

	/**
	 * <h2>dbGetAllPosts</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return List<PostDTO>
	 */
	public List<PostDTO> dbGetAllPosts();

	/**
	 * <h2>dbGetAllPosts</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param searchPostForm SearchPostForm
	 * @return
	 * @return List<PostDTO>
	 */
	public List<PostDTO> dbGetAllPosts(SearchPostForm searchPostForm);

	/**
	 * <h2>dbGetPostById</h2>
	 * <p>
	 * Get Post By Id
	 * </p>
	 *
	 * @param postId
	 * @return
	 * @return Post
	 */
	public Post dbGetPostById(Integer postId);

	/**
	 * <h2>dbGetPostByTitle</h2>
	 * <p>
	 * Get Post By Title
	 * </p>
	 *
	 * @param title
	 * @return
	 * @return Post
	 */
	public Post dbGetPostByTitle(String title);

	/**
	 * <h2>dbAddPost</h2>
	 * <p>
	 * Add Post When Add Button Click
	 * </p>
	 *
	 * @param post
	 * @param currentUserId
	 * @param date
	 * @return void
	 */
	public void dbAddPost(Post post, int currentUserId, Date date);

	/**
	 * <h2>dbUpdatePostExist</h2>
	 * <p>
	 * Update Post title is Exist or Not Exist
	 * </p>
	 *
	 * @param title
	 * @return
	 * @return List<Post>
	 */
	public List<Post> dbUpdatePostExist(String title);

	/**
	 * <h2>dbUpdatePost</h2>
	 * <p>
	 * Update Post
	 * </p>
	 *
	 * @param updatePostById
	 * @return void
	 */

	public void dbUpdatePost(Post updatePostById);

	/**
	 * <h2>dbPostUploadData</h2>
	 * <p>
	 * Upload Data For Post
	 * </p>
	 *
	 * @param postData
	 * @return void
	 */
	public void dbPostUploadData(Post postData);
}
