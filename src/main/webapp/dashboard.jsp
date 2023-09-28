<!DOCTYPE html>
<html lang = "pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <title>Dashboard</title>
</head>
<body>
<div>
    <c:if test="${sessionScope.loggedUser != null}">
        <span>${sessionScope.loggedUser}</span>
        <a href="/logout">Logout</a></div>
    </c:if>
    <h1>Lista de Cadastros</h1>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Nome</th>
            <th scope="col">Cpf</th>
            <th scope="col">Rg</th>
            <th scope="col">Nascimento</th>
            <th scope="col">Email</th>
            <th scope="col">Telefone</th>
            <th scope="col">Logradouro</th>
            <th scope="col">Complemento</th>
        </thead>
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
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>