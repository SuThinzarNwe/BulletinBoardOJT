<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<section class="content">
		<div class="row">
			<div class="col-12">
				<div class="forms-mr">
					<div class="col-sm-6 col-md-6 form-detail">
						<c:url var="addAction" value="/updatePostConfirm"></c:url>
						<form:form class="form-create" action="${addAction}"
							modelAttribute="editedPostForm" method="POST" id="form">
							<input type="hidden" name="id" value="${oldPostForm.id }" />
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<h4 class="text-center forms-header">
										<b>Post Edition</b>
									</h4>
									<c:if test="${errorMsg != null }">
										<div class="alert alert-danger">
											<strong>${errorMsg }</strong>
										</div>
									</c:if>
									<div class="form-group">
										<label for="title">Title</label> <input class="form-control"
											type="text" name="title" value="${oldPostForm.title }" />
										<form:errors path="title" class="text-danger" />
									</div>
									<div class="form-group">
										<label for="description">Description</label> <input
											class="form-control" name="description"
											value="${oldPostForm.description }">
										<form:errors path="description" class="text-danger" />
									</div>
									<div class="input-post-sec02 clearFix">
										<label for="status">Status</label> <label
											class="switch clearFix"> <c:if
												test="${oldPostForm.status == '1' }">
												<input id="status-checked" class="status-check"
													type="checkbox" name="status"
													value="${oldPostForm.status }" checked>
											</c:if> <c:if test="${oldPostForm.status != '1' }">
												<input id="status-checked" class="status-check"
													type="checkbox" name="status"
													value="${oldPostForm.status }">
											</c:if> <span class="slider round"></span> <span
											class="slider round"></span>
										</label>
									</div>
									<c:if
										test="${(oldPostForm.status != 1 && LOGIN_USER.type == 0)||LOGIN_USER.type == 1}">
										<button type="submit" class="btn btn-info" name="update">Update</button>
									</c:if>
									<button type="submit" class="btn btn-secondary" name="cancel">Back</button>
									<button type="reset" class="btn btn-danger">Reset</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>