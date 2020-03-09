<%@page contentType="text/html" pageEncoding="UTF-8"%><%@ taglib
    prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!DOCTsYPE html>
<html>
   <head>
      <title>Practice Spring MVC</title>
   </head>
   <body>
  <!-- <h3>Corporate Bank Application</h3> --> 
<form:form method="post" action="/PracticeSpringMVC/registerSuccess" modelAttribute="user">
  User name:<br>
    <form:input path="userName" /><br>
  Password:<br>
  <form:input path="password"/><br>
  Phone Number:<br>
  <form:input path="phoneNumber"/><br>
  <input type="submit" value="Register">
</form:form>

   </body>
</html>