<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="content-wrapper">
  <section class="content">
    <div class="row">
      <div class="col-12">
        <div class="forms-mr">
          <div class="col-sm-6 col-md-6 form-detail">
            <c:url var="addAction" value="/detailPost"></c:url>
            <form:form class="form-detail" action="${addAction}"
              modelAttribute="detailPost" method="POST" id="form">
              <input type="hidden" name="id" value="${detailPost.id }" />
              <div class="card card-primary card-outline">
                <div class="card-body box-profile">
                  <h3 class="profile-username text-center">
                    <b>${detailPost.title }</b>
                  </h3>
                  <ul class="list-group list-group-unbordered mb-3">
                    <li class="list-group-item text-center"><a>${detailPost.description }</a></li>
                    <li class="list-group-item"><b>Status</b> <c:if
                        test="${detailPost.status == 0 }">
                        <a class="float-right">OFF</a>
                      </c:if> <c:if test="${detailPost.status == 1 }">
                        <a class="float-right">ON</a>
                      </c:if></li>
                    <li class="list-group-item"><b>Created User</b>
                      <a class="float-right">${detailPost.createdUserName }</a></li>
                    <li class="list-group-item"><b>Created At</b> <a
                      class="float-right"><fmt:formatDate
                          pattern="yyyy-MM-dd"
                          value="${detailPost.createdAt }" /> </a></li>
                  </ul>
                  <a
                    href="${pageContext.request.contextPath}/updatePost?id=${detailPost.id }"
                    class="btn btn-info btn-block"><b>Edit Post</b></a>
                </div>
              </div>
            </form:form>
          </div>
        </div>
      </div>
    </div>
  </section>
</div>
