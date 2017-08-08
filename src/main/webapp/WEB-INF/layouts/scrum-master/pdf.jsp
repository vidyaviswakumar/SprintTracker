<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Do you want to see the report? </h2>
<form:form role="form" method="post" action="report.htm" commandName="story">
<button type="submit" class="btn btn-primary">View Report</button>
</form:form>