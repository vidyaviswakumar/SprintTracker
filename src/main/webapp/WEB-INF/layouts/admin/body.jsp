<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form:form mathod="post" action="authorized.htm">
<table class="table table-responsive">
<tr> 
	<td>First Name</td>
	<td>Last Name</td>
	<td>Email Id</td>
	<td>Select Values</td>
	</tr>
	
	<c:forEach items="${unAuth}" var="person">
	
	<tr> 
	<td>${person.firstName}</td>
	<td>${person.lastName}</td>
	<td>${person.emailId}</td>
	<td><input type="radio" name="person" value="${person.personId}" /></td>
	</tr>
	</c:forEach>

	
</table>
<button type="submit" id="authorize" class="btn btn-primary" >Authorize Selected Users</button>
</form:form>