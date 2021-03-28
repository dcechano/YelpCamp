<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 5/9/2020
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../partials/header.jsp"%>

<jstl:url var="newLink" value="/comments/new">
    <jstl:param name="campgroundId" value="${campgroundId}"/>
</jstl:url>

<div class="container mx-auto my-3">
    <spring:form modelAttribute="newComment" action="${newLink}" method="post">
        <div class="card border-info">
            <h3 class="h3 text-center card-header badge-info">New Comment</h3>
            <div class="my-3">
                <div class="form-group col-5 m-auto">
                    <label for="comment_text">Comment Text</label>
                    <spring:textarea id="comment_text" path="text" cssClass="form-control" rows="5"/>
                    <input class="btn btn-primary form-control mt-3" type="submit" value="Submit">
                </div>
            </div>
        </div>
    </spring:form>
</div>
<%@ include file="../partials/footer.jsp"%>