<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form role="form" method="post" action="subtaskcreate.htm" commandName="story">
<button type="submit" class="btn btn-primary"> Create A Subtask </button>
<p></p>
<table class="table table-striped">
<tr>
	<td>Title</td>
	<td>Description</td>
	<td>Comments</td>
	<td>CreatedBy</td>
	<td>Assigned To</td>
	<td>Created Date</td>
	<td>Status</td>
	</tr>
<c:forEach items="${story.tasks}" var="subtask">  
	<tr>
	<td>${subtask.subtaskTitle}</td>
	<td>${subtask.subtaskDescription}</td>
	<td>${subtask.comments}</td>
	<td>${subtask.createdBy}</td>
	<td>${subtask.assignedTo}</td>
	<td>${subtask.createdDate}</td>
	<td>${subtask.status.statusName}</td>
	</tr>
	  
     
</c:forEach>
</table>

	
</form:form>

