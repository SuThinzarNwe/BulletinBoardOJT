package bulletin.system.persistence.entity.post;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import bulletin.system.web.form.post.PostForm;

/**
 * <h2>Post Class</h2>
 * <p>
 * Process for Displaying Post
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */

/**
 * Entity for Post
 */
@Entity
@Table(name = "post")
public class Post implements Serializable {
	/**
	 * <h2>serialVersionUID</h2>
	 * <p>
	 * serialVersionUID
	 * </p>
	 */
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
	private String title;
	/**
	 * <h2>description</h2>
	 * <p>
	 * description
	 * </p>
	 */
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
	 * <h2>${id}</h2>
	 * <p>
	 * ${Getter Method For Post Id}
	 * </p>
	 * 
	 * @return ${Integer}
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	/**
	 * <h2>${id}</h2>
	 * <p>
	 * ${Setter Method For Post Id}
	 * </p>
	 * 
	 * @param ${id}
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * <h2>${title}</h2>
	 * <p>
	 * ${Getter Method For Post title}
	 * </p>
	 * 
	 * @return ${String}
	 */
	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	/**
	 * <h2>${title}</h2>
	 * <p>
	 * ${Setter Method For Post title}
	 * </p>
	 * 
	 * @param ${title}
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * <h2>${description}</h2>
	 * <p>
	 * ${Getter Method For Post description}
	 * </p>
	 * 
	 * @return ${String}
	 */
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * <h2>${description}</h2>
	 * <p>
	 * ${Setter Method For Post description}
	 * </p>
	 * 
	 * @param ${description}
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * <h2>${status}</h2>
	 * <p>
	 * ${Getter Method For Post status}
	 * </p>
	 * 
	 * @return ${String}
	 */
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}

	/**
	 * <h2>${status}</h2>
	 * <p>
	 * ${Setter Method For Post status}
	 * </p>
	 * 
	 * @param ${status}
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * <h2>${createdUserId}</h2>
	 * <p>
	 * ${Getter Method For Post createdUserId}
	 * </p>
	 * 
	 * @return ${Integer}
	 */
	@Column(name = "created_user_id")
	public Integer getCreatedUserId() {
		return createdUserId;
	}

	/**
	 * <h2>${createdUserId}</h2>
	 * <p>
	 * ${Setter Method For Post createdUserId}
	 * </p>
	 * 
	 * @param ${createdUserId}
	 */
	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}

	/**
	 * <h2>${updatedUserId}</h2>
	 * <p>
	 * ${Getter Method For Post updatedUserId}
	 * </p>
	 * 
	 * @return ${Integer}
	 */
	@Column(name = "updated_user_id")
	public Integer getUpdatedUserId() {
		return updatedUserId;
	}

	/**
	 * <h2>${updatedUserId}</h2>
	 * <p>
	 * ${Setter Method For Post updatedUserId}
	 * </p>
	 * 
	 * @param ${updatedUserId}
	 */
	public void setUpdatedUserId(Integer updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	/**
	 * <h2>${deletedUserId}</h2>
	 * <p>
	 * ${Getter Method For Post deletedUserId}
	 * </p>
	 * 
	 * @return ${Integer}
	 */
	@Column(name = "deleted_user_id")
	public Integer getDeletedUserId() {
		return deletedUserId;
	}

	/**
	 * <h2>${deletedUserId}</h2>
	 * <p>
	 * ${Setter Method For Post deletedUserId}
	 * </p>
	 * 
	 * @param ${deletedUserId}
	 */
	public void setDeletedUserId(Integer deletedUserId) {
		this.deletedUserId = deletedUserId;
	}

	/**
	 * <h2>${createdAt}</h2>
	 * <p>
	 * ${Getter Method For Post createdAt}
	 * </p>
	 * 
	 * @return ${Date}
	 */
	@Column(name = "created_at")
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * <h2>${createdAt}</h2>
	 * <p>
	 * ${Setter Method For Post createdAt}
	 * </p>
	 * 
	 * @param ${createdAt}
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * <h2>${updatedAt}</h2>
	 * <p>
	 * ${Getter Method For Post updatedAt}
	 * </p>
	 * 
	 * @return ${Date}
	 */
	@Column(name = "updated_at")
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * <h2>${updatedAt}</h2>
	 * <p>
	 * ${Setter Method For Post updatedAt}
	 * </p>
	 * 
	 * @param ${updatedAt}
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * <h2>${deletedAt}</h2>
	 * <p>
	 * ${Getter Method For Post deletedAt}
	 * </p>
	 * 
	 * @return ${Date}
	 */
	@Column(name = "deleted_at")
	public Date getDeletedAt() {
		return deletedAt;
	}

	/**
	 * <h2>${deletedAt}</h2>
	 * <p>
	 * ${Setter Method For Post deletedAt}
	 * </p>
	 * 
	 * @param ${deletedAt}
	 */
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	/**
	 * <h2>Constructor for ${Post}</h2>
	 * <p>
	 * Constructor for ${Post}
	 * </p>
	 */
	public Post() {
		super();
	}

	/**
	 * <h2>Constructor for Post</h2>
	 * <p>
	 * Constructor for Post
	 * </p>
	 * 
	 * @param postForm
	 */
	public Post(PostForm postForm) {
		this.id = postForm.getId();
		this.title = postForm.getTitle();
		this.description = postForm.getDescription();
		this.status = postForm.getStatus();
		this.createdUserId = postForm.getCreatedUserId();
		this.updatedUserId = postForm.getUpdatedUserId();
		this.deletedUserId = postForm.getDeletedUserId();
		this.createdAt = postForm.getCreatedAt();
		this.updatedAt = postForm.getUpdatedAt();
		this.deletedAt = postForm.getDeletedAt();
	}
}
