<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SEAL - Sistema de Ensino Assíncrono Livre</title>
    <link rel="stylesheet" href="view/index.css">
    <link rel="shortcut icon" href="view/favicon.ico" type="image/x-icon">
</head>

<body>
    <h1>Sistema de Ensino Assíncrono Livre</h1>
    <img src="view/seal.svg" id="logo"></img>
    <div class="form-container">
        <form action="home" method="post" name="loginForm">
            <div id="user-type-radio">
                <label for="aluno">Aluno</label>
                <input type="radio" name="userType" id="aluno" value="student" checked>
                
                <label for="professor">Professor</label>
                <input type="radio" name="userType" id="professor" value="teacher">
            </div>

            <label for="id">Id de acesso</label>
            <input type="text" name="id" id="id" required>

            <label for="password">Senha de acesso</label>
            <input type="password" name="password" id="password" required>

            <input type="submit" value="Acessar">
        </form>
    </div>
</body>

</html>