<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SEAL - Home Aluno</title>
    <link rel="shortcut icon" href="view/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="view/home-aluno.scss" />
  </head>
  <body>
    <nav>
      <span id="user-info">Olá aluno(a) ${name} - ${id}</span>
      <a href="/">Sair &DoubleRightArrow;</a>
    </nav>
    <div id="container"></div>
  </body>
</html>
