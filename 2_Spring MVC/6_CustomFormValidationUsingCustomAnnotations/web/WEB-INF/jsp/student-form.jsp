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
    
<!--    When the form is loaded methods student.getFirstName() and student.getLastName() of the student class is called and 
        when the form is submitted methods student.setFirstName() and student.setLastName() of the student class is called-->
    <body>
        <form:form action="processForm" modelAttribute="student"><!-- modelAttribute will be the key of the student object-->
            
            First name : <form:input path="firstName"/> <!--path will be appended with set and thus calling the respective method-->
            <br><br>                                    
            Last name(*) : <form:input path="lastName"/>
            <form:errors path="LastName" cssClass="error"/>
            <br><br>
            <input type="submit" value="Submit"/>
            
        </form:form>
    </body>
</html>
