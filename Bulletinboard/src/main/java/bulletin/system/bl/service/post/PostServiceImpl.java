package bulletin.system.bl.service.post;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import bulletin.system.bl.dto.post.PostDTO;
import bulletin.system.persistence.dao.post.PostDAO;
import bulletin.system.persistence.dao.user.UserDAO;
import bulletin.system.persistence.entity.post.Post;
import bulletin.system.persistence.entity.user.User;
import bulletin.system.web.form.post.PostForm;
import bulletin.system.web.form.post.SearchPostForm;
import net.sf.jasperreports.engine.JRException;

/**
 * <h2>PostServiceImpl Class</h2>
 * <p>
 * Process for Displaying PostServiceImpl
 * </p>
 * 
 * @author SuThinzarNwe
 *
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
@Primary
public class PostServiceImpl implements PostService {
	/**
	 * <h2>userDAO</h2>
	 * <p>
	 * userDAO
	 * </p>
	 */
	@Autowired
	private UserDAO userDAO;
	/**
	 * <h2>postDAO</h2>
	 * <p>
	 * postDAO
	 * </p>
	 */
	@Autowired
	private PostDAO postDAO;
	/**
	 * <h2>messageSource</h2>
	 * <p>
	 * messageSource
	 * </p>
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * <h2>doGetPostList</h2>
	 * <p>
	 * Get Post List By PostCreatedUser ID
	 * </p>
	 * 
	 * @param postCreatedUserId
	 * @return
	 */
	@Override
	public List<PostDTO> doGetPostList(int postCreatedUserId) {
		User user = this.userDAO.dbGetUserbyID(postCreatedUserId);
		List<Post> postList = this.postDAO.dbgetPostList(user);
		List<PostDTO> postListDTO = new ArrayList<>();
		for (Post post : postList) {
			PostDTO resPostDTO = new PostDTO(post);
			String name = this.userDAO.dbGetUserNamebyID(postCreatedUserId);
			resPostDTO.setCreatedUserName(name);
			postListDTO.add(resPostDTO);
		}
		return postListDTO;
	}

	/**
	 * <h2>dogetPostById</h2>
	 * <p>
	 * Get Post By Post Id
	 * </p>
	 * 
	 * @param postId
	 * @return
	 */
	@Override
	public PostForm dogetPostById(Integer postId) {
		Post resultPost = this.postDAO.dbGetPostById(postId);
		PostForm resultPostform = resultPost != null ? new PostForm(resultPost) : null;
		if (resultPostform == null || resultPostform.equals(null)) {
			throw new NullPointerException();
		}
		return resultPostform;

	}

	/**
	 * <h2>doGetAllPosts</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<PostDTO> doGetAllPosts() {
		return this.postDAO.dbGetAllPosts();
	}

	/**
	 * <h2>doGetAllPosts</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param searchPostForm SearchPostForm
	 * @return
	 */
	@Override
	public List<PostDTO> doGetAllPosts(SearchPostForm searchPostForm) {
		List<PostDTO> posts = this.postDAO.dbGetAllPosts(searchPostForm);
		return posts.isEmpty() ? this.postDAO.dbGetAllPosts() : posts;
	}

	/**
	 * <h2>doAddPost</h2>
	 * <p>
	 * Add Post
	 * </p>
	 * 
	 * @param postForm
	 * @param currentUserId
	 */
	@Override
	public void doAddPost(PostForm postForm, int currentUserId) {
		Post post = new Post(postForm);
		post.setStatus(1);
		post.setCreatedAt(new Date());
		post.setCreatedUserId(currentUserId);
		this.postDAO.dbAddPost(post, currentUserId, new Date());
	}

	/**
	 * <h2>doInsertTitleExist</h2>
	 * <p>
	 * Insert Title Is Exit or Not
	 * </p>
	 * 
	 * @param title
	 * @return
	 */
	@Override
	public boolean doInsertTitleExist(String title) {
		Post resultPost = this.postDAO.dbGetPostByTitle(title);
		if (resultPost != null) {
			return true;
		}
		return false;
	}

	/**
	 * <h2>doUpdateTitleExist</h2>
	 * <p>
	 * Test Update Title is Exist or Not
	 * </p>
	 * 
	 * @param title
	 * @param id
	 * @return
	 */
	@Override
	public boolean doUpdateTitleExist(String title, Integer postId) {
		List<Post> postList = this.postDAO.dbUpdatePostExist(title);
		Post postById = this.postDAO.dbGetPostById(postId);
		int duplicateCount = (int) postList.stream().filter(post -> post.getTitle() == postById.getTitle()).count();
		if (duplicateCount > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <h2>doUpdatePost</h2>
	 * <p>
	 * Post Update
	 * </p>
	 * 
	 * @param postForm
	 * @param loginUserForm
	 */
	@Override
	public void doUpdatePost(@Valid PostForm postForm, int currentUser) {
		Post updatePostById = this.postDAO.dbGetPostById(postForm.getId());
		@SuppressWarnings("unused")
		Post postTitle = this.postDAO.dbGetPostByTitle(postForm.getTitle());
		if (updatePostById != null) {
			updatePostById.setTitle(postForm.getTitle());
			updatePostById.setDescription(postForm.getDescription());
			updatePostById.setStatus(postForm.getStatus());
			updatePostById.setUpdatedAt(new Date());
			updatePostById.setCreatedUserId(currentUser);
			this.postDAO.dbUpdatePost(updatePostById);
		}
	}

	/**
	 * <h2>doPostDelete</h2>
	 * <p>
	 * Post Delete By ID
	 * </p>
	 * 
	 * @param postId
	 */
	@Override
	public void doPostDelete(Integer postId) {
		Post postDeletedUser = this.postDAO.dbGetPostById(postId);
		postDeletedUser.setDeletedAt(new Date());

	}

	/**
	 * <h2>doUploadCSV</h2>
	 * <p>
	 * To upload File
	 * </p>
	 *
	 * @param fileUpload    MultipartFile
	 * @param currentUserId int
	 * @return
	 * @throws IOException
	 * @return List<String>
	 */
	@SuppressWarnings("null")
	@Override
	public List<String> doUploadCSV(MultipartFile fileUpload, int currentUserId) throws IOException {
		BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileUpload.getInputStream()));
		List<String> uploadError = new ArrayList<>();
		int row = 0;
		String[] col;
		String errorMsgs;
		List<Post> postList = new ArrayList<Post>();
		String line = fileReader.readLine();
		while (line != null) {
			row++;
			Post post = new Post();
			col = line.split(",");
			if (col != null || col.length <= 1) {
				if (col.length == 1 && col[0].equals("")) {
					errorMsgs = messageSource.getMessage("M_SC_0026", null, null);
					uploadError.add(errorMsgs);
					return uploadError;
				}
				if (col.length == 2 || col.length == 1) {
					errorMsgs = messageSource.getMessage("M_SC_0024", null, null);
					uploadError.add(errorMsgs + row);
					return uploadError;
				}
				if (col.length >= 3) {
					Post isTitleExit = this.postDAO.dbGetPostByTitle(col[0]);
					if (isTitleExit != null) {
						errorMsgs = messageSource.getMessage("M_SC_0005", null, null);
						uploadError.add(errorMsgs + row);
						return uploadError;
					}
					if (col[0].equals("") || col[0].equals(null) || col[0].isEmpty()) {
						errorMsgs = messageSource.getMessage("M_SC_0006", null, null);
						uploadError.add(errorMsgs + row);
						return uploadError;
					}

					if (col[2].length() > 1) {
						errorMsgs = messageSource.getMessage("M_SC_0025", null, null);
						uploadError.add(errorMsgs + row);
						return uploadError;
					}
					if (col[1].equals(null) || col[1].equals("")) {
						errorMsgs = messageSource.getMessage("M_SC_0024", null, null);
						uploadError.add(errorMsgs + row);
						return uploadError;
					}
					if (!col[0].equals("") && !col[0].equals(null) && !col[0].isEmpty() && isTitleExit == null
							&& col[2].length() == 1) {
						post.setTitle(col[0]);
						post.setDescription(col[1]);
						post.setStatus((!col[2].equals("0") && !col[2].equals("1")) ? Integer.parseInt("1")
								: Integer.parseInt(col[2]));
						post.setCreatedUserId(currentUserId);
						post.setUpdatedUserId(currentUserId);
						post.setCreatedAt(new Date());
						post.setUpdatedAt(new Date());
						postList.add(post);
					}
				}
				line = fileReader.readLine();
			}
		}
		fileReader.close();
		for (Post postData : postList) {
			this.postDAO.dbPostUploadData(postData);
		}
		return uploadError;
	}

	/**
	 * <h2>doGenerateDownloadExcelFile</h2>
	 * <p>
	 * Generate Download Excel File
	 * </p>
	 * 
	 * @param postList
	 * @param baos
	 * @param fileName
	 * @param parameter
	 * @param reportPath
	 * @return
	 * @throws ParseException
	 * @throws JRException
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("resource")
	@Override
	public void doGenerateDownloadExcelFile(List<PostDTO> postList) throws IOException, ParseException {
		Workbook workbook = new XSSFWorkbook();
		CreationHelper createHelper = workbook.getCreationHelper();
		Sheet sheet = workbook.createSheet("PostList");
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		Row headerRow = sheet.createRow(0);
		String[] columnHeaders = { "Title", "Description", "Status", "Created User", "Created At" };
		for (int i = 0; i < columnHeaders.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columnHeaders[i]);
			cell.setCellStyle(headerCellStyle);
		}
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
		final String OLD_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
		final String NEW_FORMAT = "dd/MM/yyyy";
		int rowNumber = 1;
		DateFormat inputFormat = new SimpleDateFormat(OLD_FORMAT);
		DateFormat outputFormat = new SimpleDateFormat(NEW_FORMAT);
		String date;
		for (PostDTO post : postList) {
			Row row = sheet.createRow(rowNumber++);
			row.createCell(0).setCellValue(post.getTitle());
			row.createCell(1).setCellValue(post.getDescription());
			row.createCell(2).setCellValue("ON");
			if (post.getStatus() == 0) {
				row.createCell(2).setCellValue("OFF");
			}
			row.createCell(3).setCellValue(post.getCreatedUserName());
			Date old_date = inputFormat.parse(post.getCreatedAt().toString());
			date = outputFormat.format(old_date);
			row.createCell(4).setCellValue(date);
		}
		for (int i = 0; i < columnHeaders.length; i++) {
			sheet.autoSizeColumn(i);
		}
		FileOutputStream fileOut;
		fileOut = new FileOutputStream(
				System.getProperty("user.home") + "/Downloads/PostList" + System.currentTimeMillis() + ".xlsx");
		workbook.write(fileOut);
		fileOut.close();
	}
}
