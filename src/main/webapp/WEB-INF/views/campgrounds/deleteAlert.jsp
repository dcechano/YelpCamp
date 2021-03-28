<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 5/13/2020
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../partials/header.jsp"%>
<jstl:url var="deleteLink" value="/campgrounds/delete/confirmed">
    <jstl:param name="campgroundId" value="${campgroundId}"/>
</jstl:url>
    <div class="container mx-auto my-3">
        <div class="card border-info">
            <h3 class="h3 text-center card-header badge-info">Are you sure you want to delete this campground?</h3>
            <div class="row form-group col-5 m-auto my-3">
                <a href="${deleteLink}" class="btn btn-primary form-control mt-3">I'm sure</a>
                <a href="${pageContext.request.contextPath}/campgrounds/" class="btn btn-primary form-control my-3">Cancel</a>
            </div>
        </div>
        <blockquote>
            This is inside a blockquote!
        </blockquote>
    </div>
<%@ include file="../partials/footer.jsp"%>