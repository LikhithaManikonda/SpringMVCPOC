<%@page contentType="text/html" pageEncoding="UTF-8"%><%@ taglib
    prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!DOCTsYPE html>
<html>
   <head>
      <title>Practice Spring MVC</title>
   </head>
   <body>
<form:form method="get" action="/PracticeSpringMVC/generateCreditCardNumber" >  
  <input type="submit" value="GenerateCreditCard">
</form:form>
   </body>
</html>