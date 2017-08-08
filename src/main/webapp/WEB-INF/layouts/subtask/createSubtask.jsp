   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form role="form" method="post" action="subtasks.htm" commandName="subtask">
			<div class="row">
				<div class="col-md-3">
			<label>Subtask Title: </label>
			<form:input path="subtaskTitle" class="form-control" required="required"/>
			<label>Subtask Description: </label>
			<form:input path="subtaskDescription" class="form-control" required="required"/>
			<label>Status:</label>
			<form:select path="statusName" required="required">
                 <c:forEach var="categ" items="${status}">
                     <form:option value="${categ.statusName}"/>
                  </c:forEach>
            </form:select>
            <p></p>
                       
            <label>Assigned To</label>
            <form:select path="username">
                 <c:forEach var="categ" items="${user}">
                     <form:option value="${categ.username}"/>
                  </c:forEach>
            </form:select>
            
            <p></p>
			<label>Comments: </label>
			<form:input path="comments" class="form-control" required="required" />
			<label>Created Date: </label>
			<form:input path="createdDate" type="date" class="form-control" required="required"/>
			<input type="hidden" name="sprintId" value="${storyId}" />
			<p></p>
			<button type="submit" class="btn btn-primary"> Create Subtask</button>
			</div>
			</div>
		</form:form>