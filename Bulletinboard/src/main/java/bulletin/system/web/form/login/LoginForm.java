package bulletin.system.web.form.login;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import bulletin.system.persistence.entity.user.User;

/**
 * <h2>LoginForm Class</h2>
 * <p>
 * Process for Displaying LoginForm
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
public class LoginForm {
	@Email
	@NotEmpty
	String email;

	@NotEmpty
	String password;

	/**
	 * <h2>getEmail</h2>
	 * <p>
	 * Getter Method For User Email
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
	 * <h2>Constructor for LoginForm</h2>
	 * <p>
	 * Constructor for LoginForm
	 * </p>
	 */
	public LoginForm() {

	}

	/**
	 * <h2>Constructor for LoginForm</h2>
	 * <p>
	 * Constructor for LoginForm
	 * </p>
	 * 
	 * @param user
	 */
	public LoginForm(User user) {
		super();
		this.email = user.getEmail();
		this.password = user.getPassword();
	}
}
