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
            <c:url var="addAction" value="/changePassword"></c:url>
            <form:form action="${addAction}" modelAttribute="UserForm"
              method="post" id="form">
              <input type="hidden" value="${UserForm.id }" name="id" />
              <div class="card card-primary card-outline">
                <div class="card-body box-profile">
                  <h4 class="text-center forms-header">
                    <b>Change User Password</b>
                  </h4>
                  <c:if test="${errorMsg != null }">
                    <div class="alert alert-danger">
                      <strong>${errorMsg }</strong>
                    </div>
                  </c:if>
                  <div class="form-group">
                    <label>Old Password</label>
                    <form:input path="oldPassword" type="password"
                      class="form-control"
                      placeholder="Enter Old Password" />
                    <form:errors path="oldPassword" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label>New Password</label>
                    <form:input path="newPassword" type="password"
                      class="form-control"
                      placeholder="Enter New Password" />
                    <form:errors path="newPassword" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label>Confirm Password</label>
                    <form:input path="confirmPassword" type="password"
                      class="form-control"
                      placeholder="Enter Confirm Password" />
                    <form:errors path="confirmPassword"
                      class="text-danger" />
                  </div>
                  <button type="submit" class="btn btn-info"
                    name="change">Change</button>
                  <button type="submit" class="btn btn-secondary"
                    name="cancel">Cancel</button>
                </div>
              </div>
            </form:form>
          </div>
        </div>
      </div>
    </div>
  </section>
</div>