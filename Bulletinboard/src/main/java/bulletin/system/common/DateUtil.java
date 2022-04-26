package bulletin.system.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/**
 * <h2>DateUtil Class</h2>
 * <p>
 * Process for Displaying DateUtil
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
public class DateUtil {
	/**
	 * <h2>formatDMY</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param date
	 * @return
	 * @return String
	 */
	public static String formatDMY(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return (String) sdf.format(date);
	}

	/**
	 * <h2>parseDMY</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param date
	 * @return
	 * @return Date
	 */
	public static Date parseDMY(String date) {
		try {
			return DateUtils.parseDate(date, new String[] { "dd/MM/yyyy" });
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * <h2>formatDmyToYmd</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param date
	 * @return
	 * @return String
	 */
	public static String formatDmyToYmd(String date) {
		if (date == null || date.isEmpty()) {
			return "";
		}
		SimpleDateFormat formatFrom = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatTo = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatTo.format(formatFrom.parse(date));
		} catch (ParseException e) {
			return "";
		}
	}
}
