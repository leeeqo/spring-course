<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<center>

<h2>All employees:</h2>

    <table class="table_with_text_on_center">

        <tr>
            <th>Name</th>
            <th>Surame</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Operations</th>
        </tr>

        <c:forEach var="emp" items="${allEmps}">

            <c:url var="updateButton" value="/updateEmployee">
                <c:param name="empId" value="${emp.id}"></c:param>
            </c:url>
            <c:url var="deleteButton" value="/deleteEmployee">
                <c:param name="empId" value="${emp.id}"></c:param>
            </c:url>

            <tr>
                <td>${emp.name}</td>
                <td>${emp.surname}</td>
                <td>${emp.department}</td>
                <td>${emp.salary}</td>
                <td>
                    <input type="button" value="Update"
                           onClick="window.location.href = '${updateButton}'"/>
                <!--</td>
                <td>-->
                    <input type="button" value="Delete"
                           onClick="window.location.href = '${deleteButton}'"/>
                </td>
            </tr>

        </c:forEach>

    </table>

    <br>

    <input type="button" value="Add"
           onclick="window.location.href = 'addEmployee'"/>

</center>

</body>

</html>