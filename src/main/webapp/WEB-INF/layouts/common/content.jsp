
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>You want to create a sprint?</h2>
<form:form role="form" method="post" action="insert.htm" commandName="sprint">
		<button type="submit" class="btn btn-primary"> Create A Sprint </button>
</form:form>	
		
	