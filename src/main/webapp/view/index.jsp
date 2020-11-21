<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="SEAL - Login">
    <h1>Sistema de Ensino Assíncrono Livre</h1>
    <img src="view/asset/seal.svg" id="logo"></img>
    <div class="form-container">
        <form action="home" method="post" name="loginForm">
            <div id="user-type-radio">
                <label for="aluno">Aluno</label>
                <input type="radio" name="userType" id="aluno" value="student" checked>
                
                <label for="professor">Professor</label>
                <input type="radio" name="userType" id="professor" value="teacher">
            </div>

            <label for="id">Id de acesso <i class="fa fa-user" aria-hidden="true"></i></label> 
            <input type="text" name="id" id="id" required>

            <label for="password">Senha de acesso <i class="fa fa-unlock" aria-hidden="true"></i></label> 
            <input type="password" name="password" id="password" required>

            <input type="submit" value="Acessar">
        </form>
    </div>
</t:wrapper>
