package bulletin.system.web.form.post;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import bulletin.system.persistence.entity.post.Post;

/**
 * <h2>PostForm Class</h2>
 * <p>
 * Process for Displaying PostForm
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
public class PostForm {
	/**
	 * <h2>serialVersionUID</h2>
	 * <p>
	 * serialVersionUID
	 * </p>
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	/**
	 * <h2>id</h2>
	 * <p>
	 * id
	 * </p>
	 */
	private Integer id;

	/**
	 * <h2>title</h2>
	 * <p>
	 * title
	 * </p>
	 */
	@NotEmpty
	private String title;
	/**
	 * <h2>description</h2>
	 * <p>
	 * description
	 * </p>
	 */
	@NotEmpty
	private String description;
	/**
	 * <h2>status</h2>
	 * <p>
	 * status
	 * </p>
	 */
	private Integer status;
	/**
	 * <h2>createdUserId</h2>
	 * <p>
	 * createdUserId
	 * </p>
	 */
	private Integer createdUserId;
	/**
	 * <h2>updatedUserId</h2>
	 * <p>
	 * updatedUserId
	 * </p>
	 */
	private Integer updatedUserId;

	/**
	 * <h2>createdUserName</h2>
	 * <p>
	 * createdUserName
	 * </p>
	 */
	private String createdUserName;

	/**
	 * <h2>deletedUserId</h2>
	 * <p>
	 * deletedUserId
	 * </p>
	 */
	private Integer deletedUserId;
	/**
	 * <h2>createdAt</h2>
	 * <p>
	 * createdAt
	 * </p>
	 */
	private Date createdAt;
	/**
	 * <h2>updatedAt</h2>
	 * <p>
	 * updatedAt
	 * </p>
	 */
	private Date updatedAt;
	/**
	 * <h2>deletedAt</h2>
	 * <p>
	 * deletedAt
	 * </p>
	 */
	private Date deletedAt;

	/**
	 * <h2>Constructor for PostForm</h2>
	 * <p>
	 * Constructor for PostForm
	 * </p>
	 */

	/**
	 * <h2>getId</h2>
	 * <p>
	 * Getter Method For Post ID
	 * </p>
	 *
	 * @return
	 * @return Integer
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * <h2>setId</h2>
	 * <p>
	 * Setter Method For Post ID
	 * </p>
	 *
	 * @param id
	 * @return void
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * <h2>getTitle</h2>
	 * <p>
	 * Getter Method For Post Title
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <h2>setTitle</h2>
	 * <p>
	 * Setter Method For Post Title
	 * </p>
	 *
	 * @param title
	 * @return void
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * <h2>getDescription</h2>
	 * <p>
	 * Setter Method For Post Description
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <h2>setDescription</h2>
	 * <p>
	 * Setter Method For Post Description
	 * </p>
	 *
	 * @param description
	 * @return void
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * <h2>getStatus</h2>
	 * <p>
	 * Getter Method For Post Status
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * <h2>setStatus</h2>
	 * <p>
	 * Setter Method For Post Status
	 * </p>
	 *
	 * @param status
	 * @return void
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * <h2>getCreatedUserId</h2>
	 * <p>
	 * Getter Method For Post CreatedUser ID
	 * </p>
	 *
	 * @return
	 * @return Integer
	 */
	public Integer getCreatedUserId() {
		return createdUserId;
	}

	/**
	 * <h2>setCreatedUserId</h2>
	 * <p>
	 * Setter Method For Post CreatedUser ID
	 * </p>
	 *
	 * @param createdUserId
	 * @return void
	 */
	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}

	/**
	 * <h2>getUpdatedUserId</h2>
	 * <p>
	 * Getter Method For Post UpdatedUser ID
	 * </p>
	 *
	 * @return
	 * @return Integer
	 */
	public Integer getUpdatedUserId() {
		return updatedUserId;
	}

	/**
	 * <h2>setUpdatedUserId</h2>
	 * <p>
	 * Setter Method For Post Updated User ID
	 * </p>
	 *
	 * @param updatedUserId
	 * @return void
	 */
	public void setUpdatedUserId(Integer updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	/**
	 * <h2>getDeletedUserId</h2>
	 * <p>
	 * 
	 * <Getter Method For Post Deleted User Id
	 * </p>
	 *
	 * @return
	 * @return Integer
	 */
	public Integer getDeletedUserId() {
		return deletedUserId;
	}

	/**
	 * <h2>setDeletedUserId</h2>
	 * <p>
	 * Getter Method For Post Deleted User ID
	 * </p>
	 *
	 * @param deletedUserId
	 * @return void
	 */
	public void setDeletedUserId(Integer deletedUserId) {
		this.deletedUserId = deletedUserId;
	}

	/**
	 * <h2>getCreatedAt</h2>
	 * <p>
	 * Getter Method For Post CreatedAt
	 * </p>
	 *
	 * @return
	 * @return Date
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * <h2>setCreatedAt</h2>
	 * <p>
	 * Setter Method For Post CreatedAt
	 * </p>
	 *
	 * @param createdAt
	 * @return void
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * <h2>createdUserName</h2>
	 * <p>
	 * getCreatedUserName
	 * </p>
	 * 
	 * @return String
	 */
	public String getCreatedUserName() {
		return createdUserName;
	}

	/**
	 * <h2>createdUserName</h2>
	 * <p>
	 * setCreatedUserName
	 * </p>
	 * 
	 * @param createdUserName
	 */
	public void setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;
	}

	/**
	 * <h2>getUpdatedAt</h2>
	 * <p>
	 * Getter Method For Post UpdateAt
	 * </p>
	 *
	 * @return
	 * @return Date
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * <h2>setUpdatedAt</h2>
	 * <p>
	 * Setter Method For Post UpdatedAt
	 * </p>
	 *
	 * @param updatedAt
	 * @return void
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * <h2>getDeletedAt</h2>
	 * <p>
	 * Getter Method For Post DeletedAt
	 * </p>
	 *
	 * @return
	 * @return Date
	 */
	public Date getDeletedAt() {
		return deletedAt;
	}

	/**
	 * <h2>setDeletedAt</h2>
	 * <p>
	 * Setter Method For Post DeletedAt
	 * </p>
	 *
	 * @param deletedAt
	 * @return void
	 */
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public PostForm() {
		super();
	}

	/**
	 * <h2>Constructor for PostForm</h2>
	 * <p>
	 * Constructor for PostForm
	 * </p>
	 * 
	 * @param post
	 */
	public PostForm(Post post) {
		super();
		this.id = post.getId();
		this.title = post.getTitle();
		this.description = post.getDescription();
		this.status = post.getStatus();
		this.createdUserId = post.getCreatedUserId();
		this.updatedUserId = post.getUpdatedUserId();
		this.deletedUserId = post.getDeletedUserId();
		this.createdAt = post.getCreatedAt();
		this.updatedAt = post.getUpdatedAt();
	}
}
