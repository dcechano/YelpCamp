<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 5/11/2020
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/header.jsp"%>

<jstl:url var="editLink" value="/campgrounds/edit">
    <jstl:param name="campgroundId" value="${campground.id}"/>
</jstl:url>

<div class="container mx-auto my-3">
    <spring:form modelAttribute="campground" action="${editLink}" method="post">
        <div class="card border-info">
            <h3 class="h3 text-center card-header badge-info">Edit Comment</h3>
            <div class="my-3">
                <spring:hidden path="id"/>
                <div class="form-group col-5 m-auto">
                    <label for="campground_name">Comment Text</label>
                    <spring:textarea id="campground_name" path="name" cssClass="form-control"/>
                </div>
                <div class="form-group col-5 m-auto">
                    <label for="description">Comment Text</label>
                    <spring:textarea id="description" path="description" cssClass="form-control"/>
                </div>
                <div class="form-group col-5 m-auto">
                    <label for="image">Comment Text</label>
                    <spring:textarea id="image" path="image" cssClass="form-control"/>
                </div>
                <div class="form-group col-5 m-auto">
                    <label for="campground_name">Comment Text</label>
                    <spring:textarea id="price" path="price" cssClass="form-control"/>
                </div>
                <input class="btn btn-primary form-control mt-3" type="submit" value="Submit">
            </div>
        </div>
    </spring:form>
</div>


<%@ include file="../partials/footer.jsp"%>
