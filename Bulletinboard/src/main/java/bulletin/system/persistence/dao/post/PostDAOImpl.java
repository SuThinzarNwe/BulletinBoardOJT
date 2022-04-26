package bulletin.system.persistence.dao.post;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bulletin.system.bl.dto.post.PostDTO;
import bulletin.system.persistence.entity.post.Post;
import bulletin.system.persistence.entity.user.User;
import bulletin.system.web.form.post.SearchPostForm;

/**
 * <h2>PostDAOImpl Class</h2>
 * <p>
 * Process for Displaying PostDAOImpl
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
@SuppressWarnings("deprecation")
@Repository
public class PostDAOImpl implements PostDAO {
	/**
	 * <h2>TYPE_USER</h2>
	 * <p>
	 * TYPE_USER
	 * </p>
	 */
	public static final String TYPE_USER = "1";

	/**
	 * <h2>SELECT_POST_HQL</h2>
	 * <p>
	 * SELECT_POST_HQL
	 * </p>
	 */
	private static String SELECT_POST_HQL = "SELECT p FROM Post p where p.deletedAt is NULL ";

	/**
	 * <h2>SELECT_POST_LIST_SQL</h2>
	 * <p>
	 * SELECT_POST_LIST_SQL
	 * </p>
	 */
	private static String SELECT_POST_LIST_SQL = "SELECT p.id, p.title, p.description, u.name AS createdUserName, p.created_at as createdAt FROM posts p INNER JOIN users u ON p.created_user_id = u.id WHERE p.deleted_at IS NULL ";
	/**
	 * <h2>SELECT_POST_BY_ID_HQL</h2>
	 * <p>
	 * SELECT_POST_BY_ID_HQL
	 * </p>
	 */
	private static String SELECT_POST_BY_ID_HQL = "SELECT p FROM Post p where p.id = :id ";
	/**
	 * <h2>SELECT_POST_BY_TITLE</h2>
	 * <p>
	 * SELECT_POST_BY_TITLE
	 * </p>
	 */
	private static String SELECT_POST_BY_TITLE = "SELECT p FROM Post p WHERE p.title = :title ";
	/**
	 * <h2>sessionFactory</h2>
	 * <p>
	 * sessionFactory
	 * </p>
	 */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * <h2>dbGetAllPosts</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<PostDTO> dbGetAllPosts() {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(SELECT_POST_LIST_SQL);
		return query.setResultTransformer(Transformers.aliasToBean(PostDTO.class)).list();
	}

	/**
	 * <h2>dbGetAllPosts</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param searchPostForm
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<PostDTO> dbGetAllPosts(SearchPostForm searchPostForm) {
		StringBuilder sb = new StringBuilder(SELECT_POST_LIST_SQL);
		if (searchPostForm.getSearchPost() != null && !searchPostForm.getSearchPost().isEmpty()) {
			sb.append("AND (p.title = :title OR p.description = :description)");
		}
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sb.toString());
		if (searchPostForm.getSearchPost() != null && !searchPostForm.getSearchPost().isEmpty()) {
			query.setParameter("title", searchPostForm.getSearchPost());
			query.setParameter("description", searchPostForm.getSearchPost());
		}
		return query.setResultTransformer(Transformers.aliasToBean(PostDTO.class)).list();
	}

	/**
	 * <h2>dbGetPostById</h2>
	 * <p>
	 * Get Post By ID
	 * </p>
	 * 
	 * @param postId
	 * @return
	 */
	@Override
	public Post dbGetPostById(Integer postId) {
		@SuppressWarnings("rawtypes")
		Query queryPostById = this.sessionFactory.getCurrentSession().createQuery(SELECT_POST_BY_ID_HQL);
		queryPostById.setParameter("id", postId);
		Post resultPost = (Post) queryPostById.uniqueResult();
		return resultPost;
	}

	/**
	 * <h2>dbGetPostByTitle</h2>
	 * <p>
	 * Get POst BY Title
	 * </p>
	 * 
	 * @param title
	 * @return
	 */
	@Override
	public Post dbGetPostByTitle(String title) {
		@SuppressWarnings("rawtypes")
		Query queryPostByTitle = this.sessionFactory.getCurrentSession().createQuery(SELECT_POST_BY_TITLE);
		queryPostByTitle.setParameter("title", title);
		Post resultPost = (Post) queryPostByTitle.uniqueResult();
		return resultPost;
	}

	/**
	 * <h2>dbAddPost</h2>
	 * <p>
	 * Adding Post
	 * </p>
	 * 
	 * @param post
	 * @param currentUserId
	 * @param date
	 */
	@Override
	public void dbAddPost(Post post, int currentUserId, Date date) {
		this.sessionFactory.getCurrentSession().save(post);
	}

	/**
	 * <h2>dbgetPostList</h2>
	 * <p>
	 * Get Post List By User
	 * </p>
	 * 
	 * @param user
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public List<Post> dbgetPostList(User user) {
		StringBuffer bufferQuery = new StringBuffer(SELECT_POST_HQL);
		if ((user.getType()).equals("1")) {
			bufferQuery.append("and p.createdUserId = :createdUserId ");
		}
		Query queryPostList = this.sessionFactory.getCurrentSession().createQuery(bufferQuery.toString());
		if ((user.getType()).equals("1")) {
			queryPostList.setParameter("createdUserId", user.getId());
		}
		@SuppressWarnings("unchecked")
		List<Post> postList = (List<Post>) queryPostList.list();
		return postList;
	}

	/**
	 * <h2>dbUpdatePost</h2>
	 * <p>
	 * Update Post
	 * </p>
	 * 
	 * @param updatePost
	 */
	@Override
	public void dbUpdatePost(Post updatePost) {
		this.sessionFactory.getCurrentSession().update(updatePost);
	}

	/**
	 * <h2>dbUpdatePostExist</h2>
	 * <p>
	 * Update Post Title is exist or not
	 * </p>
	 * 
	 * @param title
	 * @return
	 */
	@Override
	public List<Post> dbUpdatePostExist(String title) {
		@SuppressWarnings("rawtypes")
		Query queryPost = this.sessionFactory.getCurrentSession().createQuery(SELECT_POST_BY_TITLE);
		queryPost.setParameter("title", title);
		@SuppressWarnings("unchecked")
		List<Post> postList = (List<Post>) queryPost.list();
		return postList;
	}

	/**
	 * <h2>dbPostUploadData</h2>
	 * <p>
	 * Upload Data
	 * </p>
	 * 
	 * @param postData
	 */
	@Override
	public void dbPostUploadData(Post postData) {
		this.sessionFactory.getCurrentSession().save(postData);

	}

}
