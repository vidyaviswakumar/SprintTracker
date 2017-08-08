<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Sprint Tracker</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
		<script type="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script>
			$(document).ready(function(){
				$("#logIn").click(function(){
					var name=$("#name").val();
					var pwd=$("#password").val();
					$.ajax({
						method: "POST",
						url: "ajax.htm",
						data: { username: name, password: pwd },
						success: function(data){
							if(data=="error"){
								alert(" Login error");
							}
						},
						
						error: function(data){
							
						}
					});
				});
			});
		</script>
    </head>
    <body>
        <div class="container">
		<form:form role="form" method="post" action="loginUser.htm" commandName="user">
			<div class="row">
				<div class="col-md-3">
				</div>
				<div class="col-md-6">
			<label>UserName: </label>
			<form:input id="name" path="username" class="form-control" />
			<label>Password: </label>
			<form:input id="password" path="password" type="password" class="form-control" />
			<a href="register.htm" >Click here to register</a>
			<button type="submit" id="logIn" class="btn btn-primary"> Log In </button>
			</div>
			</div>
		</form:form>		
	</div>
    </body>
</html>