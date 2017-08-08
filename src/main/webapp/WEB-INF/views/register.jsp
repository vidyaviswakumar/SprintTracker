<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
		<script type="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    	<script>
    	$(document).ready(function(){
    		$("#reg").click(function(){
    			var val=$("#email").val();
    			$("input").each(function(){
    				
    		        value= $(this).val();
    		        value=value.replace(/[^\\@.dA-Za-z ]/g, "");
    		        $(this).val(value);
    		        
    		    });
    		});
    	});
    		
    	</script>
</head>
<body>
<form:form role="form" method="post" action="home.htm" commandName="user">
			<div class="row">
				<div class="col-md-3">
				</div>
				<div class="col-md-6">
			<label>UserName: </label>
			<form:input type="text" path="username" id="uname" class="form-control" required="required" />
			<label>Password: </label> 
			<form:input path="password" type="password" id="pwd" class="form-control" required="required" />
			<label>Roles</label>
			<form:select path="roleName">
                 <c:forEach var="categ" items="${roles}">
                     <form:option value="${categ}"/>
                  </c:forEach>
            </form:select>
			<p></p>
			<label>Email: </label>
			<form:input type="email" path="emailId" id="email" class="form-control" required="required" />
			<label>First Name: </label>
			<form:input type="text" path="firstName" class="form-control" id="fname" required="required" />
			<label>Last Name: </label>
			<form:input type="text" path="lastName" class="form-control" id="lname" required="required" />
			
			<button type="submit" id="reg" class="btn btn-primary"> Register </button>
			</div>
			</div>
		</form:form>	
</body>
</html>