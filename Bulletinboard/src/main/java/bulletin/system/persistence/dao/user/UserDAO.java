package bulletin.system.persistence.dao.user;

import java.util.Date;
import java.util.List;

import bulletin.system.bl.dto.user.UserDTO;
import bulletin.system.persistence.entity.user.User;
import bulletin.system.web.form.user.SearchUserForm;

/**
 * <h2>UserDAO Class</h2>
 * <p>
 * Process for Displaying UserDAO
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
public interface UserDAO {

	/**
	 * <h2>dbInsertUser</h2>
	 * <p>
	 * Insert User From The Database
	 * </p>
	 *
	 * @param user
	 * @param currentUserId
	 * @param currentDate
	 * @return void
	 */
	public void dbInsertUser(User user, int currentUserId, Date currentDate);

	/**
	 * <h2>dbGetUserList</h2>
	 * <p>
	 * Get User From Database
	 * </p>
	 *
	 * @return
	 * @return List<User>
	 */
	public List<User> dbGetUserList();

	/**
	 * <h2>dbGetUserbyID</h2>
	 * <p>
	 * Get User By ID
	 * </p>
	 *
	 * @param userId
	 * @return
	 * @return User
	 */
	public User dbGetUserbyID(Integer userId);

	/**
	 * <h2>dbGetAllUsers</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return List<UserDTO>
	 */
	public List<UserDTO> dbGetAllUsers();

	/**
	 * <h2>dbGetAllUsers</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param searchUserForm SearchUserForm
	 * @return
	 * @return List<UserDTO>
	 */
	public List<UserDTO> dbGetAllUsers(SearchUserForm searchUserForm);

	/**
	 * <h2>dbGetUserNamebyID</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param userId
	 * @return
	 * @return User
	 */
	public String dbGetUserNamebyID(int postCreatedUserId);

	/**
	 * <h2>dbGetUserByEmail</h2>
	 * <p>
	 * Get Email From the Database
	 * </p>
	 *
	 * @param email
	 * @return
	 * @return User
	 */
	public User dbGetUserByEmail(String email);

	/**
	 * <h2>dbUpdateUser</h2>
	 * <p>
	 * Update User To the Database
	 * </p>
	 *
	 * @param updatedUser
	 * @return void
	 */
	public void dbUpdateUser(User updatedUser);

	/**
	 * <h2>dbUpdatedUserExistList</h2>
	 * <p>
	 * Update User Email Exit or Not Exit
	 * </p>
	 *
	 * @param email
	 * @return
	 * @return List<User>
	 */
	public List<User> dbUpdatedUserExistList(String email);

	/**
	 * <h2>dbUpdateUserPassword</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param newPassword
	 * @param userId
	 * @return void
	 */
	public void dbUpdateUserPassword(String newPassword, Integer userId);

}
