<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Create a Sprint by entering the sprint name</h2>
<form:form role="form" method="post" action="successSprint.htm" commandName="sprint">
	<label class="form-control">Name: </label>
	<form:input type="text" path="sprintName" class="form-control" required="required" />
	<div>
	<button type="submit" class="btn btn-primary">Create</button>
	</div>
</form:form>