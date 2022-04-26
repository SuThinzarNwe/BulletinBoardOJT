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
						<c:url var="addAction" value="/editPost"></c:url>
						<form:form class="form-create" action="${addAction}"
							modelAttribute="finalConfirmPostForm" method="post" id="form">
							<input type="hidden" name="id" value="${updatePostForm.id }" />
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<h4 class="text-center forms-header">
										<b>Edited Post Confirm</b>
									</h4>
									<c:if test="${errorMsg != null }">
										<div class="alert alert-danger">
											<strong>${errorMsg }</strong>
										</div>
									</c:if>
									<ul class="list-group list-group-unbordered mb-3">
										<li class="list-group-item"><b>Title</b> <a
											class="float-right">${updatePostForm.title } <input
												type="hidden" name="title" value="${updatePostForm.title }"
												class="form-control" /></a></li>
										<li class="list-group-item"><b>Description</b> <a
											class="float-right">${updatePostForm.description } <input
												type="hidden" name="description"
												value="${updatePostForm.description }" class="form-control" />
										</a></li>
									</ul>
									<input type="hidden" name="status"
										value="${updatePostForm.status }" class="form-control" />
									<button type="submit" class="btn btn-info" name="update">Update</button>
									<button type="submit" class="btn btn-secondary" name="cancel">Cancel</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>