<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 5/15/2020
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../partials/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-8 d-flex justify-content-between align-items-stretch p-2" style="background-color: red">
            <div class="mx-5">
                <img id="profile_image" src="${pageContext.request.contextPath}/static/images/kvatch.png" alt="">
                <p>This is Location</p>
                <p>This is Name</p>
            </div>
            <div class="mx-5">
                <p>This is About Me</p>
            </div>
        </div>
        <div class="col-4" style="background-color: orchid">
            <p>These are campgrounds</p>
        </div>
    </div>
    <div class="row">
        <div class="col-12" style="background-color: #0f6674">
            <p>These are comments</p>
        </div>
    </div>
</div>


<%@ include file="../partials/footer.jsp" %>
