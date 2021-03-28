<%@include file="partials/header.jsp" %>

<div class="container mx-auto my-3" style="width: 50%">
    <spring:form action="${pageContext.request.contextPath}/registration/processRegistrationForm" method="post"
                    modelAttribute="newUser">
        <div class="card border-info">
            <h3 class="h3 text-center card-header badge-info">Register New User</h3>
            <div class="my-3">
                <div class="form-group col-5 m-auto">
                    <label for="username">Username</label>
                    <spring:input id="username" class="form-control" type="text" name="username" path="username"/>
                </div>
                <div class="form-group col-5 m-auto">
                    <label for="password">Password</label>
                    <spring:input id="password" class="form-control" type="password" name="password" path="password"/>
                </div>
                <div class="form-group col-5 m-auto">
                    <label for="email">Email</label>
                    <spring:input id="email" class="form-control" type="email" name="email" path="email"/>
                </div>
                <input class="btn btn-primary form-control mt-3" type="submit" value="Login">
            </div>
        </div>
    </spring:form>
</div>

<%@include file="partials/footer.jsp" %>

