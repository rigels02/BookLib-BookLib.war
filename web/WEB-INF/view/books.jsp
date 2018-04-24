<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : books
    Created on : Apr 23, 2018, 7:01:36 PM
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
        <h1>Books list</h1>
    <c:if test="${books.isEmpty()}">
        No books in db
    </c:if>
     <c:if test="${ !books.isEmpty()}">
         <table border="1">
             <thead>
                 <tr>
                     <th>ID</th>
                     <th>title</th>
                     <th>author</th>
                     <th>pages</th>
                 </tr>
             </thead>
             <tbody><c:forEach var="book" items="${books}">
                     <tr>
                     <td>${book.id}</td>
                     <td>${book.title}</td>
                     <td>${book.author}</td>
                     <td>${book.pages}</td>
                 </tr>
                 </c:forEach>
                 
             </tbody>
         </table>

    </c:if>    
    </body>
</html>
