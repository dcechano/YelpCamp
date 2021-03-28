<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 5/10/2020
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/header.jsp"%>
<div class="container mx-auto my-3">
    <jstl:url var="editLink" value="/comments/edit">
        <jstl:param name="campgroundId" value="${campgroundId}"/>
    </jstl:url>
    <spring:form modelAttribute="editComment" action="${editLink}" method="post">
        <div class="card border-info">
            <h3 class="h3 text-center card-header badge-info">Edit Comment</h3>
            <div class="my-3">

                <spring:hidden path="id"/>

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
