<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring Mvc WebFlow Demo</title>
	</head>
	<body>
		<div class="content">
				<!-- here the href's value will be used to decide the 
					 controller to be executed on click of this link.
					 here "home" is mapped in spring mvc controller-->
				<a href="home.obj">Home</a>
				<br /><br />
				<h2 align="center"><!-- display the name just entered -->
				Welcome ${userBean.name }</h2>
				<p>Your Address : <b>${userBean.address}</b> <br>and Company : <b>${userBean.company}</b><br>				
				<br/>
		</div>
	</body>
</html>