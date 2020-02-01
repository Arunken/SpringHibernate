<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <h1>This is the main page </h1><br><br>
        <a href="${pageContext.request.contextPath}/student/showForm">Student page</a>
        <br><br>
        <a href="${pageContext.request.contextPath}/customer/showForm">Customer page</a>
    </body>
</html>
