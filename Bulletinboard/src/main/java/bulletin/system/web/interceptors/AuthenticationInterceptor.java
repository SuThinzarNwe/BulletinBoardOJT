package bulletin.system.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * <h2>AuthenticationInterceptor Class</h2>
 * <p>
 * Process for Displaying AuthenticationInterceptor
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	/**
	 * <h2>preHandle</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getSession().getAttribute("LOGIN_USER") == null) {
			response.sendRedirect(request.getContextPath() + "/showLogin");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * <h2>encoder</h2>
	 * <p>
	 * PasswordEncoder with BCryptPassworEncoder
	 * </p>
	 *
	 * @return
	 * @return PasswordEncoder
	 */
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}