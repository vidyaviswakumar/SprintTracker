<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>List of stories </h2>
<form:form role="form" method="post" action="storycreate.htm" commandName="story">
<p></p>
<table class="table table-striped">
<tr>
	<td>Title</td>
	<td>Description</td>
	<td>Comments</td>
	<td>CreatedBy</td>
	<td>Assigned To</td>
	<td>Status</td>
	<td>Created Date</td>
	<td>Points</td>
	
	</tr>
<c:forEach items="${sprint.stories}" var="story">    
    
    <tr>
	<td><a href="story.htm?story=${story.storyId}">${story.storyTitle}</a></td>
	<td>${story.storyDescription}</td>
	<td>${story.comments}</td>
	<td>${story.createdBy}</td>
	<td>${story.assignedTo}</td>
	<td>${story.status.statusName}</td>
	<td>${story.createdDate}</td>
	<td>${story.points}</td>
	</tr>
</c:forEach>
		
	</table>
<input type="hidden" name="storyId" value="${story.storyId}" />
	
</form:form>

