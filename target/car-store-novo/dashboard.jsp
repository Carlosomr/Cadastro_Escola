<!DOCTYPE html>
<html lang = "pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/cadastro.css" >
    <title>Dashboard</title>
</head>
<body>
<div>
    <c:if test="${sessionScope.loggedUser != null}">
        <span>${sessionScope.loggedUser}</span>
        <a href="/logout">Logout</a></div>
    </c:if>
    <h1>Lista de Cadastros</h1>
    <table>
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Cpf</th>
            <th>Rg</th>
            <th>Nascimento</th>
            <th>Email</th>
            <th>Telefone</th>
            <th>Logradouro</th>
            <th>Complemento</th>
            <c:if test="${sessionScope.loggedUser != null}">
                <th>Actions</th>
            </c:if>
        </tr>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td>${car.id}</td>
                <td>${car.name}</td>
                <td>${car.cpf}</td>
                <td>${car.rg}</td>
                <td>${car.nascimento}</td>
                <td>${car.email}</td>
                <td>${car.telefone}</td>
                <td>${car.logradouro}</td>
                <td>${car.complemento}</td>
                    <td>
                        <c:if test="${sessionScope.loggedUser != null}">
                        <form action="/delete-car" method="post">
                            <input type="hidden" id="id" name="id" value="${car.id}">
                            <button type="submit">Delete</button>
                            <span> | </span>
                            <a href="index.jsp?id=${car.id}&name=${car.name}">Update</a>
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>