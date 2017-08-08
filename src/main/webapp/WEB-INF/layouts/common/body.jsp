<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Find below the list of Sprints</h2>
<c:forEach items="${sprintList}" var="sprint">    
    <a class="btn btn-primary btn-lg" href="sprint.htm?sprint=${sprint.sprintId}">${sprint.sprintName}</a> 
</c:forEach>

