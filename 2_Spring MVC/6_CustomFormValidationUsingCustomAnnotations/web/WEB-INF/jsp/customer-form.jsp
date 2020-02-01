<%-- 
    Document   : student-form
    Created on : 28 Nov, 2018, 8:26:13 AM
    Author     : SilverDoe
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%><!-- Taglibrary Required for form tag-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            .error{color:red}
        </style>
    </head>
    
<!--    When the form is loaded methods customer.getFirstName() and customer.getLastName() of the customer class is called and 
        when the form is submitted methods customer.setFirstName() and customer.setLastName() of the customer class is called-->
    <body>
        <form:form action="processForm" modelAttribute="customer"><!-- modelAttribute will be the key of the customer object-->
            
            First name : <form:input path="firstName"/> <!--path will be appended with set and thus calling the respective method-->
            <br><br>                                    
            Last name(*) : <form:input path="lastName"/>
            <form:errors path="lastName" cssClass="error"/>
            <br><br>
            Free Passes : <form:input path="freePasses"/>
            <form:errors path="freePasses" cssClass="error"/>
            <br><br>
            Postal Code : <form:input path="postalCode"/>
            <form:errors path="postalCode" cssClass="error"/>
            <br><br>
            Course Code : <form:input path="courseCode"/>
            <form:errors path="courseCode" cssClass="error"/>
            <br><br>
            <input type="submit" value="Submit"/>
            
        </form:form>
    </body>
</html>
