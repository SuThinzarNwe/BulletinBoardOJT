package bulletin.system.persistence.dao.user;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bulletin.system.bl.dto.user.UserDTO;
import bulletin.system.common.DateUtil;
import bulletin.system.persistence.entity.user.User;
import bulletin.system.web.form.user.SearchUserForm;

/**
 * <h2>UserDAOImpl Class</h2>
 * <p>
 * Process for Displaying UserDAOImpl
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
@SuppressWarnings("deprecation")
@Repository
public class UserDAOImpl implements UserDAO {
	/**
	 * <h2>SELECT_USER_LIST_SQL</h2>
	 * <p>
	 * SELECT_USER_LIST_SQL
	 * </p>
	 */
	private static String SELECT_USER_LIST_SQL = "SELECT u.id, u.name, u.email, cu.name AS createdUserName, u.phone, u.dob, u.address, u.created_at as createdAt, u.updated_at AS updatedAt FROM users u LEFT JOIN users cu ON cu.id = u.created_user_id WHERE u.deleted_at IS NULL ";
	/**
	 * <h2>SELECT_USER_HQL</h2>
	 * <p>
	 * SELECT_USER_HQL
	 * </p>
	 */
	private static String SELECT_USER_HQL = "SELECT u FROM User u  where u.deletedAt is NULL ";

	/**
	 * <h2>SELECT_USER_BY_ID_HQL</h2>
	 * <p>
	 * SELECT_USER_BY_ID_HQL
	 * </p>
	 */
	private static String SELECT_USER_BY_ID_HQL = "SELECT u FROM User u where u.id = :id ";

	/**
	 * <h2>SELECT_USERName_BY_ID_HQL</h2>
	 * <p>
	 * SELECT_USERName_BY_ID_HQL
	 * </p>
	 */
	private static String SELECT_USER_NAME_BY_ID_HQL = "SELECT u.name FROM User u where u.id = :id ";

	/**
	 * <h2>SELECT_USER_BY_EMAIL_HQL</h2>
	 * <p>
	 * SELECT_USER_BY_EMAIL_HQL
	 * </p>
	 */
	private static String SELECT_USER_BY_EMAIL_HQL = "SELECT u FROM User u WHERE u.email = :email ";
	/**
	 * <h2>UPDATE_USER_BY_PASSWORD_HQL</h2>
	 * <p>
	 * UPDATE_USER_BY_PASSWORD_HQL
	 * </p>
	 */
	private static String UPDATE_USER_BY_PASSWORD_HQL = "update User u set u.password = :newPassword where u.id = :userId";
	/**
	 * <h2>sessionFactory</h2>
	 * <p>
	 * sessionFactory
	 * </p>
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * <h2>dbInsertUser</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param user
	 * @param currentUserId
	 * @param currentDate
	 */
	@Override
	public void dbInsertUser(User user, int createUserId, Date currentDate) {
		this.sessionFactory.getCurrentSession().save(user);

	}

	/**
	 * <h2>dbGetUserList</h2>
	 * <p>
	 * get all user from the database
	 * </p>
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<User> dbGetUserList() {
		Query queryUserList = this.sessionFactory.getCurrentSession().createQuery(SELECT_USER_HQL);
		return queryUserList.list();
	}

	/**
	 * <h2>dbGetUserbyID</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public User dbGetUserbyID(Integer userId) {
		Query queryUserById = this.sessionFactory.getCurrentSession().createQuery(SELECT_USER_BY_ID_HQL);
		queryUserById.setParameter("id", userId);
		User resultUser = (User) queryUserById.uniqueResult();
		return resultUser;
	}

	/**
	 * <h2>dbGetAllUsers</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<UserDTO> dbGetAllUsers() {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(SELECT_USER_LIST_SQL);
		return query.setResultTransformer(Transformers.aliasToBean(UserDTO.class)).list();
	}

	/**
	 * <h2>dbGetAllUsers</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param searchUserForm
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<UserDTO> dbGetAllUsers(SearchUserForm searchUserForm) {
		StringBuilder sb = new StringBuilder(SELECT_USER_LIST_SQL);
		if (searchUserForm.getName() != null && !searchUserForm.getName().isEmpty()) {
			sb.append("AND u.name = :name ");
		}
		if (searchUserForm.getEmail() != null && !searchUserForm.getEmail().isEmpty()) {
			sb.append("AND u.email = :email ");
		}
		String fromDate = DateUtil.formatDmyToYmd(searchUserForm.getCreatedFrom());
		if (searchUserForm.getCreatedFrom() != null && !fromDate.isEmpty()) {
			sb.append("AND u.created_at >= :fromDate ");
		}
		String toDate = DateUtil.formatDmyToYmd(searchUserForm.getCreatedTo());
		if (searchUserForm.getCreatedTo() != null && !toDate.isEmpty()) {
			sb.append("AND u.created_at <= :toDate");
		}
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sb.toString());
		if (searchUserForm.getName() != null && !searchUserForm.getName().isEmpty()) {
			query.setParameter("name", searchUserForm.getName());
		}
		if (searchUserForm.getEmail() != null && !searchUserForm.getEmail().isEmpty()) {
			query.setParameter("email", searchUserForm.getEmail());
		}
		if (searchUserForm.getCreatedFrom() != null && !fromDate.isEmpty()) {
			query.setParameter("fromDate", fromDate);
		}
		if (searchUserForm.getCreatedTo() != null && !toDate.isEmpty()) {
			query.setParameter("toDate", toDate);
		}
		return query.setResultTransformer(Transformers.aliasToBean(UserDTO.class)).list();
	}

	/**
	 * <h2>dbGetUserNamebyID</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param createdUserId
	 * @return
	 */
	public String dbGetUserNamebyID(int createdUserId) {
		@SuppressWarnings("rawtypes")
		Query queryUserById = this.sessionFactory.getCurrentSession().createQuery(SELECT_USER_NAME_BY_ID_HQL);
		queryUserById.setParameter("id", createdUserId);
		String resultUser = (String) queryUserById.getSingleResult();
		return resultUser;
	}

	/**
	 * <h2>dbGetUserByEmail</h2>
	 * <p>
	 * Get Email From The Database
	 * </p>
	 * 
	 * @param email
	 * @return User
	 */
	@Override
	public User dbGetUserByEmail(String email) {
		@SuppressWarnings("rawtypes")
		Query queryUserByEmail = this.sessionFactory.getCurrentSession().createQuery(SELECT_USER_BY_EMAIL_HQL);
		queryUserByEmail.setParameter("email", email);
		User user = (User) queryUserByEmail.uniqueResult();

		return user;
	}

	/**
	 * <h2>dbUpdateUser</h2>
	 * <p>
	 * Update User To the Database
	 * </p>
	 * 
	 * @param updatedUser
	 */
	@Override
	public void dbUpdateUser(User updatedUser) {
		this.sessionFactory.getCurrentSession().update(updatedUser);
	}

	/**
	 * <h2>dbUpdateUserPassword</h2>
	 * <p>
	 * Update User Password
	 * </p>
	 * 
	 * @param newPassword
	 * @param userId
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public void dbUpdateUserPassword(String newPassword, Integer userId) {
		Query updateQuery = this.sessionFactory.getCurrentSession().createQuery(UPDATE_USER_BY_PASSWORD_HQL);
		updateQuery.setParameter("userId", userId);
		updateQuery.setParameter("newPassword", newPassword);
		updateQuery.executeUpdate();
	}

	/**
	 * <h2>dbUpdatedUserExistList</h2>
	 * <p>
	 * Update User Email Exit or Not Exit
	 * </p>
	 * 
	 * @param email
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<User> dbUpdatedUserExistList(String email) {
		@SuppressWarnings("rawtypes")
		Query queryUser = this.sessionFactory.getCurrentSession().createQuery(SELECT_USER_BY_EMAIL_HQL);
		queryUser.setParameter("email", email);
		List<User> userList = (List<User>) queryUser.list();
		return userList;
	}
}
