<%@ page import="com.example.yelpcamp.entity.User" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@include file="../partials/header.jsp" %>

<% User user = (User)session.getAttribute("user"); String usernameBlock = "";%>
<div class="container mt-4">
    <% if (user != null) {
        usernameBlock = "<div>\n" +
                "        Signed in as: \n" + user.getUsername() +
                "    </div>";
    }
    %>
    <%= usernameBlock %>

    <%--    <p>--%>
<%--        User: <security:authentication property="principal.username"/>--%>
<%--        <br>--%>
<%--        <br>--%>
<%--        Roles: <security:authentication property="principal.authorities"/>--%>
<%--    </p>--%>
<%--    <hr>--%>
        <header class="jumbotron">
        <div class="container">
            <h1>Welcome to YelpCamp!</h1>
            <p>View our hand-picked campgrounds from all over!</p>
            <p>
                <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/campgrounds/new">Add New Campground</a>
            </p>
        </div>
    </header>
    <div class="row text-center" style="display: flex; flex-wrap: wrap">
        <jstl:forEach var="tempCampground" items="${campgrounds}">
            <jstl:url var="moreInfoLink" value="/campgrounds/show">
                <jstl:param name="campgroundId" value="${tempCampground.id}"/>
            </jstl:url>

            <div class="col-md-3 col-sm-6">
                <div>
                    <img class="img-thumbnail" src="${pageContext.request.contextPath}/${tempCampground.image}">
                    <div class="caption">
                        <h4>${tempCampground.name}</h4>
                    </div>
                    <p>
                        <a href="${moreInfoLink}" class="btn btn-primary">More Info</a>
                    </p>
                </div>
            </div>
        </jstl:forEach>
    </div>
    <a href="${pageContext.request.contextPath}/campgrounds">Go Back</a>
</div>

<%@include file="../partials/footer.jsp" %>