<%-- 
    Document   : helloform
    Created on : 23 Nov, 2018, 3:07:42 PM
    Author     : SilverDoe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form Page</h1><br/>
        <form action="processForm" method="get">
            <input type="text" name="uname"
                   placeholder="what's your name?"/>
            
            <input type="submit" name="Next"/>
            
        </form>
    </body>
</html>
