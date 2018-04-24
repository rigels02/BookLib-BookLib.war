<%-- 
    Document   : addbook
    Created on : Apr 23, 2018, 7:15:30 PM
    Author     : raitis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add book</h1>
        <form  action="lib"name="book" method="POST">
            Title:<input type="text" name="title" value="${book.title}" /><br>
            Author:<input type="text" name="author" value="${book.author}" /><br>
            Pages:<input type="number" name="pages" value="${book.pages}" /><br>
            <input type="submit" value="Submit" />
            
        </form>
    </body>
</html>
