<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav id="student-nav">
  <span id="user-info"
    >Olá aluno(a) ${student.getName()} - ${student.getId()} - Graduação em
    ${student.getDegree().getName()}
  </span>
  <a class="btn" href="${pageContext.request.contextPath}/logout">Sair &DoubleRightArrow;</a>
</nav>
