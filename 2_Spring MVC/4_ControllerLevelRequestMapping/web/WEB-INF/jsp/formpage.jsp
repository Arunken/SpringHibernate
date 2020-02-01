<%-- 
    Document   : formpage
    Created on : 23 Nov, 2018, 6:59:43 PM
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
        <form action="${pageContext.request.contextPath}/cm/respage" method="get">
            <input type="text" name="uname" placeholder="what's your name?"/>
            <input type="submit"/>
        </form>
    </body>
</html>
