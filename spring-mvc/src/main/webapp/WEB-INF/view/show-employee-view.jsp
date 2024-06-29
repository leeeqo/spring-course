<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>

<h2>Name: ${employee.name}</h2>
<br><br>

<h2>Surname: ${employee.surName}</h2>
<br><br>

<h2>Salary: ${employee.salary}</h2>
<br><br>

<h2>Department: ${employee.department}</h2>
<br><br>

<h2>CarBrand: ${employee.carBrand}</h2>
<br><br>

<h2>Language(s):
    <ul>
        <c:forEach var="lang" items="${employee.languages}">

            <li>${lang}</li>

        </c:forEach>
    </ul>
</h2>

</body>
</html>