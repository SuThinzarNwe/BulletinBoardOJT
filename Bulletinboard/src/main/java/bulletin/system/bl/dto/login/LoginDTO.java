package bulletin.system.bl.dto.login;

import java.io.Serializable;

import bulletin.system.persistence.entity.user.User;

/**
 * <h2>LoginDto Class</h2>
 * <p>
 * Process for Displaying LoginDto
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
public class LoginDTO implements Serializable {
	private static final long serialVersionUID = 1L;

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
	 * <h2>type</h2>
	 * <p>
	 * type
	 * </p>
	 */
	private String type;

	/**
	 * <h2>id</h2>
	 * <p>
	 * id
	 * </p>
	 */
	private int id;

	/**
	 * <h2>getEmail</h2>
	 * <p>
	 * Getter method for User Email
	 * </p>
	 *
	 * @return
	 * @return String
	 */
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
	 * <h2>getType</h2>
	 * <p>
	 * Getter Method For User Type
	 * </p>
	 *
	 * @return
	 * @return String
	 */
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
	 * <h2>getId</h2>
	 * <p>
	 * Getter Method For User ID
	 * </p>
	 *
	 * @return
	 * @return int
	 */
	public int getId() {
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
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * <h2>Constructor for LoginDTO</h2>
	 * <p>
	 * Constructor for LoginDTO
	 * </p>
	 */
	public LoginDTO() {

	}

	/**
	 * <h2>Constructor for LoginDTO</h2>
	 * <p>
	 * Constructor for LoginDTO
	 * </p>
	 * 
	 * @param user
	 */
	public LoginDTO(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
	}
}
