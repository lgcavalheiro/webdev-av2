<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="SEAL - Cadastrar aluno">
  <jsp:include page="fragment/teacherHeader.jsp"></jsp:include>
  <fieldset id="create-student-fieldset">
    <legend>Cadastrar novo aluno</legend>
    <form action="createStudent" method="post" name="createStudent">
      <label for="studentId">Id do aluno (10 caracteres, apenas números):</label>
      <input type="text" name="studentId" id="studentId" pattern="[0-9]{10}" required />
      <label for="studentName">Nome do aluno:</label>
      <input type="text" name="studentName" name="studentName" required />
      <input type="hidden" name="courseId" value="${courseId}" />
      <input type="submit" value="Cadastrar aluno" />
    </form>
  </fieldset>
</t:wrapper>
