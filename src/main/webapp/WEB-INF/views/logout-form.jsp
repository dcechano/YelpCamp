<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="partials/header.jsp" %>

<div class="container mx-auto my-3" style="width: 50%">
    <spring:form action="${pageContext.request.contextPath}/logout" method="post">
        <div class="card my-3">
            <h3 class="h3 card-header bg-info">Logout?</h3>
            <div class="row justify-content-around card-body">
                <div class="col-5">
                    <input class="btn-primary btn" type="submit" value="Logout">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/campgrounds">Nevermind</a>
                </div>
            </div>
        </div>
    </spring:form>
</div>


<%@ include file="partials/footer.jsp" %>
