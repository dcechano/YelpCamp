<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../partials/header.jsp" %>

<jstl:url var="editCampLink" value="/campgrounds/edit">
    <jstl:param name="campgroundId" value="${campground.id}"/>
</jstl:url>
<jstl:url var="deleteCampLink" value="/campgrounds/delete">
    <jstl:param name="campgroundId" value="${campground.id}"/>
</jstl:url>

<div class="container">
    <div class="col-md-9">
        <div class="card">
            <img class="card-img-top" src="${pageContext.request.contextPath}/${campground.image}" alt="">
            <div class="card-body d-flex flex-column">
                <div class="flex-row">
                    <h4 class="float-right">$${campground.price}.00/night</h4>
                    <h4 class="card-title float-left"><a>${campground.name}</a></h4>
                </div>
                <p class="card-text">${campground.description}</p>
                <div class="d-flex d-inline">
                    <a class="btn btn-sm btn-primary" href="${editCampLink}">Edit</a>
                    <a class="btn btn-sm btn-warning ml-2" href="${deleteCampLink}">Delete</a>
                </div>
                <em id="author-label">Submitted by ${campground.author.username}</em>
            </div>
        </div>

        <%-- COMMENT SECTION --%>
        <div class="card">
            <div class="card-body d-flex flex-column">
                <div class="text-right">
                    <jstl:url var="newCommentLink" value="/comments/new">
                        <jstl:param name="campgroundId" value="${campground.id}"/>
                    </jstl:url>
                    <a class="btn btn-success" href="${newCommentLink}">Add New Comment</a>
                </div>
                <hr>
                <div class="row">
                    <jstl:forEach var="comment" items="${comments}">

                        <jstl:url var="editLink" value="/comments/edit">
                            <jstl:param name="commentId" value="${comment.id}"/>
                            <jstl:param name="campgroundId" value="${campground.id}"/>
                        </jstl:url>

                        <jstl:url var="deleteLink" value="/comments/delete">
                            <jstl:param name="commentId" value="${comment.id}"/>
                        </jstl:url>

                        <div class="col-md-12">
                            <strong>${comment.author.username}</strong>
                            <span>10 days ago</span>
                            <p>
                                ${comment.text}
                            </p>
                        </div>
                        <hr>
                        <div class="d-flex d-inline col-md-12">
                            <a class="btn btn-primary btn-sm" href="${editLink}">Edit</a>
                            <a class="btn btn-sm btn-warning ml-2" href="${deleteLink}">Delete</a>
                        </div>
                    </jstl:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../partials/footer.jsp" %>
