<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 5/9/2020
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../partials/header.jsp"%>
    <div class="container mx-auto my-3">
        <spring:form modelAttribute="newCampground" action="${pageContext.request.contextPath}/campgrounds/new" method="post">
            <div class="card border-info">
                <h3 class="h3 text-center card-header badge-info">New Campground</h3>
                <div class="my-3">
                    <div class="form-group col-5 m-auto">
                        <label for="campground_name">Campground Name</label>
                        <spring:input id="campground_name" path="name" cssClass="form-control"/>
                    </div>
                    <div class="form-group col-5 m-auto">
                        <label for="description">Description</label>
                        <spring:textarea id="description" path="description" cssClass="form-control"/>
                    </div>
                    <div class="form-group col-5 m-auto">
                        <label for="image">Image URL</label>
                        <spring:input id="image" path="image" cssClass="form-control"/>
                    </div>
                    <div class="form-group col-5 m-auto">
                        <label for="price">Price per night</label>
                        <spring:input id="price" path="price" cssClass="form-control"/>
                    </div>
                    <div class="form-group col-5 m-auto">
                        <input class="btn btn-primary form-control mt-3" type="submit" value="Create Campground">
                    </div>
                </div>
            </div>
        </spring:form>
    </div>

<%@ include file="../partials/footer.jsp"%>