<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SEAL - Criar novo aluno</title>
  </head>
  <body>
    <fieldset>
      <legend>Cadastrar novo aluno</legend>
      <form action="createStudent" method="post" name="createStudent">
        <label for="studentId">
          Id do aluno (10 caracteres, apenas números):
          <input type="text" name="studentId" id="studentId" pattern="[0-9]{10}" required />
        </label>
        <label for="studentName">
          Nome do aluno:
          <input type="text" name="studentName" name="studentName" required />
        </label>
        <input type="hidden" name="courseId" value="${courseId}" />
        <input type="submit" value="Cadastrar aluno" />
      </form>
    </fieldset>
  </body>
</html>
