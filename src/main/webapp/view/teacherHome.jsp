<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home - Professor</title>
    <link rel="stylesheet" href="view/teacherHome.css" />
    <link rel="shortcut icon" href="view/favicon.ico" type="image/x-icon" />
  </head>
  <body>
    <nav>
      <span id="user-info"> Olá professor(a) ${teacher.getName()} - ${teacher.getId()} </span>
      <div id="navigation-professor">
        <button>Notas dos alunos</button>
        <button>Dashboard</button>
      </div>
      <a href="${pageContext.request.contextPath}/logout">Sair &DoubleRightArrow;</a>
    </nav>

    <div id="course-list">
      <ul>
        <c:forEach items="${teacher.getCourses()}" var="el">
          <li>
            <a
              href="/courseOverview?courseId=${el.getId()}&classNumber=${el.getClassNumber()}&name=${el.getName()}"
              >${el.getClassNumber()} - ${el.getName()}</a
            >
          </li>
        </c:forEach>
      </ul>
    </div>

    <!-- <div id="grades-wrapper">
      <button id="modal-btn">Cadastrar aluno</button>
      <div id="grades"></div>
    </div> -->
    <!-- <div id="dashboard" hidden>
      <div id="grade-table"></div>
      <div class="chart-wrapper">
        <canvas id="deviation"></canvas>
      </div>
      <div class="chart-wrapper">
        <canvas id="boxplot-chart"></canvas>
      </div>
      <div class="chart-wrapper">
        <canvas id="histogram"></canvas>
      </div>
    </div> -->
    <div id="modal" hidden>
      <div id="modal-content">
        <span class="close-btn">&times;</span>
        <div></div>
      </div>
    </div>
  </body>
</html>
