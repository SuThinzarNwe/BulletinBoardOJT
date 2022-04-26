package bulletin.system.web.form.user;

/**
 * <h2>SearchUserForm Class</h2>
 * <p>
 * Process for Displaying SearchUserForm
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
public class SearchUserForm {

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
	 * <h2>createdFrom</h2>
	 * <p>
	 * fromDate
	 * </p>
	 */
	private String createdFrom;

	/**
	 * <h2>createdTo</h2>
	 * <p>
	 * toDate
	 * </p>
	 */
	private String createdTo;

	/**
	 * <h2>getName</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * <h2>setName</h2>
	 * <p>
	 * 
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
	 * 
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
	 * 
	 * </p>
	 *
	 * @param email
	 * @return void
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the cratedFrom
	 */
	public String getCreatedFrom() {
		return createdFrom;
	}

	/**
	 * @param cratedFrom the cratedFrom to set
	 */
	public void setCreatedFrom(String createdFrom) {
		this.createdFrom = createdFrom;
	}

	/**
	 * @return the createdTo
	 */
	public String getCreatedTo() {
		return createdTo;
	}

	/**
	 * @param createdTo the createdTo to set
	 */
	public void setCreatedTo(String createdTo) {
		this.createdTo = createdTo;
	}

}
