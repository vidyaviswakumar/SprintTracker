   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form role="form" method="post" action="sprint.htm" commandName="story">
			<div class="row">
				<div class="col-md-3">
			<label>Story Title: </label>
			<form:input path="storyTitle" class="form-control" required="required" />
			<label>Story Description: </label>
			<form:input path="storyDescription" class="form-control" required="required"/>
			<label>Status:</label>
			<form:select path="statusName" required="required">
                 <c:forEach var="categ" items="${status}">
                     <form:option value="${categ.statusName}"/>
                  </c:forEach>
            </form:select>
            <p></p>           
            <label>assignedTo</label>
            <form:select path="username">
                 <c:forEach var="categ" items="${user}">
                     <form:option value="${categ.username}"/>
                  </c:forEach>
            </form:select>
			<p></p>
			<label>Comments: </label>
			<form:input path="comments" class="form-control" required="required"/>
			<label>Created Date: </label>
			<form:input path="createdDate" type="date" class="form-control" required="required"/>
			<label>points</label>
			<form:input path="points" class="form-control" required="required"/>
			<input type="hidden" name="sprintId" value="${sprintId}" />
			<p></p>
			<button type="submit" class="btn btn-primary"> Create Story</button>
			</div>
			</div>
		</form:form>