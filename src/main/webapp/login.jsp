<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 11/09/2023
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <title>Login</title>
</head>

<link href="modals.css" rel="stylesheet">
</head>
<body>

<div class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5" tabindex="-1" role="dialog" id="modalSignin">
    <div class="modal-dialog" role="document">
        <div class="modal-content rounded-4 shadow">
            <div class="modal-header p-5 pb-4 border-bottom-0">
                <h1 class="fw-bold mb-0 fs-2">Login</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body p-5 pt-0">

                <form action="/login" method="post">
                    <span>${requestScope.message}</span>
                    <div class="form-floating mb-3">
                        <%--@declare id="username"--%><input type="email" class="form-control rounded-3" id="username" placeholder="name@example.com">
                        <label for="username">Email address</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="password" class="form-control rounded-3" id="password" placeholder="Password">
                        <label for="password">password</label>
                    </div>
                    <button class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" type="submit">Acessar</button>
                    <small class="text-body-secondary">Esqueceu a senha?</small>

                </form>
            </div>
        </div>
    </div>
</div>

<div class="b-example-divider"></div>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
