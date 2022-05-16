<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h2 align="center" style="color: brown">INFORMATION</h2>
<form:form action="savePerson" modelAttribute="person" method="get">
    <p align="center">
            <form:hidden path="id"/>
        <br>

        <b>
            Name: <form:input path="name"/>
            <br>
        </b>
        <b>
            Age: <form:input path="age"/>
            <br>
        </b>
        <br>

    <p align="center">
        <input type="submit" value="ok">
    </p>

</form:form>
</body>
</html>
