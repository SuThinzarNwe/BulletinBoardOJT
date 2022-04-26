package bulletin.system.persistence.entity.user;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import bulletin.system.web.form.user.UserForm;

/**
 * <h2>User Class</h2>
 * <p>
 * Process for Displaying User
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
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
	 * <h2>name</h2>
	 * <p>
	 * name
	 * </p>
	 */
	private String name;
	/**
	 * <h2>email</h2>
	 * <p>
	 * email
	 * </p>
	 */
	private String email;
	/**
	 * <h2>password</h2>
	 * <p>
	 * password
	 * </p>
	 */
	private String password;
	/**
	 * <h2>profile</h2>
	 * <p>
	 * profile
	 * </p>
	 */
	private String profile;
	/**
	 * <h2>type</h2>
	 * <p>
	 * type
	 * </p>
	 */
	private String type;
	/**
	 * <h2>phone</h2>
	 * <p>
	 * phone
	 * </p>
	 */
	private String phone;
	/**
	 * <h2>address</h2>
	 * <p>
	 * address
	 * </p>
	 */
	private String address;
	/**
	 * <h2>dob</h2>
	 * <p>
	 * date of birth
	 * </p>
	 */
	private String dob;
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
	 * <h2>getId</h2>
	 * <p>
	 * Getter Method For User ID
	 * </p>
	 *
	 * @return
	 * @return int
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	/**
	 * <h2>setId</h2>
	 * <p>
	 * Setter Method For User ID
	 * </p>
	 *
	 * @param id
	 * @return void
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * <h2>getName</h2>
	 * <p>
	 * Getter Method For User Name
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	@Column(name = "name")
	public String getName() {
		return name;
	}

	/**
	 * <h2>setName</h2>
	 * <p>
	 * Setter Method For User Name
	 * </p>
	 *
	 * @param name
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <h2>getEmail</h2>
	 * <p>
	 * Getter Method For User Email
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	@Email(message = "Invalid Email")
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	/**
	 * <h2>setEmail</h2>
	 * <p>
	 * Setter Method For User Email
	 * </p>
	 *
	 * @param email
	 * @return void
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * <h2>getPassword</h2>
	 * <p>
	 * Getter Method For User Password
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	/**
	 * <h2>setPassword</h2>
	 * <p>
	 * Setter Method For User Password
	 * </p>
	 *
	 * @param password
	 * @return void
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * <h2>getProfile</h2>
	 * <p>
	 * Getter Method For User Profile
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	@Column(name = "profile")
	public String getProfile() {
		return profile;
	}

	/**
	 * <h2>setProfile</h2>
	 * <p>
	 * Setter Method For User Profile
	 * </p>
	 *
	 * @param profile
	 * @return void
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}

	/**
	 * <h2>getType</h2>
	 * <p>
	 * Getter Method For UserType
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	@Column(name = "type")
	public String getType() {
		return type;
	}

	/**
	 * <h2>setType</h2>
	 * <p>
	 * Setter Method For User Type
	 * </p>
	 *
	 * @param type
	 * @return void
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * <h2>getPhone</h2>
	 * <p>
	 * Getter Method FOr User Phone
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	/**
	 * <h2>setPhone</h2>
	 * <p>
	 * Setter Method For User Phone
	 * </p>
	 *
	 * @param phone
	 * @return void
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * <h2>getAddress</h2>
	 * <p>
	 * Getter Method For User Address
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	/**
	 * <h2>setAddress</h2>
	 * <p>
	 * Setter Method For User Address
	 * </p>
	 *
	 * @param address
	 * @return void
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * <h2>getDob</h2>
	 * <p>
	 * Getter Method For User Date of Birth
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	@Column(name = "dob")
	public String getDob() {
		return dob;
	}

	/**
	 * <h2>setDob</h2>
	 * <p>
	 * Setter Method For User Date of Birth
	 * </p>
	 *
	 * @param dob
	 * @return void
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * <h2>getCreatedUserId</h2>
	 * <p>
	 * Getter Method For Created User ID
	 * </p>
	 *
	 * @return
	 * @return int
	 */
	@Column(name = "created_user_id")
	public Integer getCreatedUserId() {
		return createdUserId;
	}

	/**
	 * <h2>setCreatedUserId</h2>
	 * <p>
	 * Setter Method For Created User ID
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
	 * Getter Method For Updated User Id
	 * </p>
	 *
	 * @return
	 * @return int
	 */
	@Column(name = "updated_user_id")
	public Integer getUpdatedUserId() {
		return updatedUserId;
	}

	/**
	 * <h2>setUpdatedUserId</h2>
	 * <p>
	 * Setter Method For Updated User Id
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
	 * Getter Method For Deleted User Id
	 * </p>
	 *
	 * @return
	 * @return int
	 */
	@Column(name = "deleted_user_id")
	public Integer getDeletedUserId() {
		return deletedUserId;
	}

	/**
	 * <h2>setDeletedUserId</h2>
	 * <p>
	 * Setter Method For Deleted User Id
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
	 * Getter Method For User Create At
	 * </p>
	 *
	 * @return
	 * @return Date
	 */
	@Column(name = "created_at")
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * <h2>setCreatedAt</h2>
	 * <p>
	 * Setter Method For User Create At
	 * </p>
	 *
	 * @param createdAt
	 * @return void
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * <h2>getUpdatedAt</h2>
	 * <p>
	 * Getter Method For Updated Create At
	 * </p>
	 *
	 * @return
	 * @return Date
	 */

	@Column(name = "updated_at")
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * <h2>setUpdatedAt</h2>
	 * <p>
	 * Setter Method For User Updated At
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
	 * Getter Method For User deleted At
	 * </p>
	 *
	 * @return
	 * @return Date
	 */
	@Column(name = "deleted_at")
	public Date getDeletedAt() {
		return deletedAt;
	}

	/**
	 * <h2>setDeletedAt</h2>
	 * <p>
	 * Getter Method For User Delete At
	 * </p>
	 *
	 * @param deletedAt
	 * @return void
	 */
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	/**
	 * <h2>Constructor for User</h2>
	 * <p>
	 * Constructor for User
	 * </p>
	 */
	public User() {
		super();
	}

	/**
	 * <h2>Constructor for User</h2>
	 * <p>
	 * Constructor for User
	 * </p>
	 * 
	 * @param userForm
	 */
	public User(UserForm userForm) {
		this.id = userForm.getId();
		this.name = userForm.getName();
		this.email = userForm.getEmail();
		this.password = userForm.getPassword();
		this.profile = userForm.getProfile();
		this.type = userForm.getType();
		this.phone = userForm.getPhone();
		this.address = userForm.getAddress();
		this.dob = userForm.getDob();
		this.createdUserId = userForm.getCreatedUserId();
		this.updatedUserId = userForm.getUpdatedUserId();
		this.deletedUserId = userForm.getDeletedUserId();
		this.createdAt = userForm.getCreatedAt();
		this.updatedAt = userForm.getUpdatedAt();
		this.deletedAt = userForm.getDeletedAt();
	}
}
