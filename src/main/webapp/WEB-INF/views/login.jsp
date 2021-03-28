<%@include file="partials/header.jsp" %>

<div class="container mx-auto my-3" style="width: 50%">
    <spring:form action="${pageContext.request.contextPath}/authentication" method="post">
        <div class="card border-info">
            <h3 class="h3 text-center card-header badge-info">Login</h3>
            <jstl:if test="${param.logout != null}">
                <div class="alert alert-success text-center">You've been successfully logged out!</div>
            </jstl:if>

            <div class="my-3">
                <div class="form-group col-5 m-auto">
                    <label for="username">Username</label>
                    <input id="username" class="form-control" type="text" name="username"/>
                </div>
                <div class="form-group col-5 m-auto">
                    <label for="password">Password</label>
                    <input id="password" class="form-control" type="password" name="password"/>
                    <input class="btn btn-primary form-control mt-3" type="submit" value="Login">
                </div>
            </div>
        </div>
    </spring:form>
    <div>
        <a class="btn btn-primary my-2" href="${pageContext.request.contextPath}/registration/registrationForm">Sign up</a>
    </div>
</div>
<%@include file="partials/footer.jsp" %>
