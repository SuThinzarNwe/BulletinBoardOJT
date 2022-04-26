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
						<c:url var="addAction" value="/createPostConfirm"></c:url>
						<form:form class="form-detail" action="${addAction}"
							modelAttribute="createPost" method="POST" id="form">
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<h4 class="text-center forms-header">
										<b>Post Creation</b>
									</h4>
									<c:if test="${errorMsg != null }">
										<div class="alert alert-danger">
											<strong>${errorMsg }</strong>
										</div>
									</c:if>
									<div class="form-group">
										<label for="title">Title</label>
										<form:input path="title" value="${rollBackPostForm.title }"
											class="form-control" placeholder="Enter Title" />
										<form:errors path="title" class="text-danger" />
									</div>
									<div class="form-group">
										<label for="description">Description</label>
										<form:input path="description"
											value="${rollBackPostForm.description }" class="form-control"
											placeholder="Enter Description" />
										<form:errors path="description" class="text-danger" />
									</div>
									<button type="submit" class="btn btn-info" name="confirmPost">Confirm</button>
									<button type="submit" class="btn btn-secondary" name="back">Back</button>
									<button type="reset" class="btn btn-danger" name="clearPost">Reset</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>
