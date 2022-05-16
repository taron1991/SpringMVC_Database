<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<table align="center">
    <tr>
        <th>Name</th>
        <th>Id</th>
        <th>Age</th>
    </tr>

    <c:forEach var="person" items="${persons}">

        <c:url var="updateButton" value="/pc/updatePerson">
            <c:param name="person_id" value="${person.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/pc/deletePerson">
            <c:param name="id" value="${person.id}"/>
        </c:url>

        <tr>
            <th>${person.name}</th>
            <th>${person.id}</th>
            <th>${person.age}</th>
            <td>
                <input type="button" value="Update" onclick="window.location.href = '${updateButton}'"/>
                <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>

    </c:forEach>


</table>

<br>

<p align="center"> <input type="button" style="color: aqua" value="addPerson" onclick="window.location.href='/pc/createPerson'">

</p>

</body>
</html>
