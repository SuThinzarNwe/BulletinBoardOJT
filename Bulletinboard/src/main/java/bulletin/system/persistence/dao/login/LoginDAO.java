package bulletin.system.persistence.dao.login;

import bulletin.system.persistence.entity.user.User;

/**
 * <h2>LoginDAO Class</h2>
 * <p>
 * Process for Displaying LoginDAO
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
public interface LoginDAO {

	/**
	 * <h2>getUserByEmail</h2>
	 * <p>
	 * Get User By Email
	 * </p>
	 *
	 * @param email
	 * @return
	 * @return User
	 */
	public User dbGetUserByEmail(String email);

}
