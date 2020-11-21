<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav id="teacher-nav">
  <span id="user-info"> Olá professor(a) ${teacher.getName()} - ${teacher.getId()} </span>
  <div id="teacher-navigation">
    <a class="btn" href="${pageContext.request.contextPath}/home"
      >Home <i class="fas fa-home"></i
    ></a>
    <a class="btn" href="${pageContext.request.contextPath}/logout"
      >Sair <i class="fas fa-sign-out-alt"></i
    ></a>
  </div>
</nav>
