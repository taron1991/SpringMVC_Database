<%--
  Created by IntelliJ IDEA.
  User: taron
  Date: 17.05.2022
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>

    <c:forEach var="lang" items="${sig}">
        <li> ${lang} </li>
    </c:forEach>
</ul>
</body>
</html>
