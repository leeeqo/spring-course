<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>

<h2>Уважаемый сотрудник, пожалуйста, заполните свои данные</h2>

<br>
<br>

<!--<form action="showDetails" method="get">
    <input type="text" name="employeeName"
           placeholder="Введите ваше имя"/>

    <input type="submit">-->

<form:form action="showDetails" modelAttribute="employee">

    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surName"/>
    <br><br>
    Salary <form:input path="salary"/>
    <br><br>
    Department <form:select path="department">
        <form:option value="Information echnology" label="IT"/>
        <form:option value="Management" label="Management"/>
        <!-- Avoid hardcode: using public Map<String, String> departments in Employee Class, lesson 4.9 -->
    </form:select>
    <br><br>
    CarBrand:
    BMW <form:radiobutton path="carBrand" value="BMW"/>
    Audi <form:radiobutton path="carBrand" value="Audi"/>
        <!-- Avoid hardcode: using public Map<String, String> carBrands in Employee Class + radiobuttons, items, lesson 4.10 -->
    <br><br>
    Foreign languages:
    EN <form:checkbox path="languages" value="English"/>
    FR <form:checkbox path="languages" value="French"/>
    SP <form:checkbox path="languages" value="Spanish"/>
    EST <form:checkbox path="languages" value="Estonian"/>
        <!-- Avoid hardcode: using public Map<String, String> languageList in Employee Class + checkboxes, items, lesson 4.10 -->


    <input type="submit", value="Ok">

</form:form>

</body>

</html>

</html>