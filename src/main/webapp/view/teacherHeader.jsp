<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav>
  <span id="user-info"> Olá professor(a) ${teacher.getName()} - ${teacher.getId()} </span>
  <div id="navigation-professor">
    <a class="btn" href="${pageContext.request.contextPath}/createStudent">Criar novo aluno</a>
    <a class="btn" href="${pageContext.request.contextPath}/home">Home</a>
    <a class="btn" href="${pageContext.request.contextPath}/logout">Sair &DoubleRightArrow;</a>
  </div>
</nav>
