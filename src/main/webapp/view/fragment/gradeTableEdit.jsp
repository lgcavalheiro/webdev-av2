<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="grade-table">
  <fieldset>
    <legend>${param.studentName} - ${param.studentId}</legend>
    <form name="studentEditForm" method="POST">
      <table>
          <thead>
              <th></th>
              <th>AV1</th>
              <th>AV2</th>
              <th>AV3</th>
          </thead>
          <tbody>
              <tr>
                  <th>Trabalhos</th>
                  <td>
                    <input
                      type="number"
                      name="examAv1"
                      id="examAv1"
                      min="0"
                      max="7"
                      step="0.1"
                      value="${param.examAv1}"
                      required
                    />
                  </td>
                  <td>
                    <input
                      type="number"
                      name="examAv2"
                      id="examAv2"
                      min="0"
                      max="8"
                      step="0.1"
                      value="${param.examAv2}"
                      required
                    />
                  </td>
                  <td>
                    <input
                      type="number"
                      name="examAv3"
                      id="examAv3"
                      min="0"
                      max="10"
                      step="0.1"
                      value="${param.examAv3}"
                      required
                    />
                  </rd>
              </tr>
              <tr>
                  <th>APS</th>
                  <td>
                    <input
                      type="number"
                      name="assignmentAv1"
                      id="assignmentAv1"
                      min="0"
                      max="3"
                      step="0.1"
                      value="${param.assignmentAv1}"
                      required
                    />
                  </td>
                  <td colspan="2">
                    <input
                      type="number"
                      name="assignmentAv2"
                      id="assignmentAv2"
                      min="0"
                      max="2"
                      step="0.1"
                      value="${param.assignmentAv2}"
                      required
                    />
                  </td>
              </tr>
              <tr>
                  <th>Total</th>
                  <td colspan="3">${param.finalGrade}</td>
              </tr>
              <tr>
                  <th>Situação</th>
                  <td colspan="3">
                      ${param.isApproved ? "Aprovado" : "Reprovado"}
                  </td>
              </tr>
          </tbody>
          <tfoot>
          <tr>
              <td colspan="4"><i>Última atualização em ${param.updateTimestamp}</i></td>
          </tr>
          </foot>
      </table>
      <input type="hidden" name="courseId" value="${param.courseId}">
      <input type="hidden" name="studentId" value="${param.studentId}">

      <input type="submit" formaction="updateStudent" value="Atualizar ${param.studentName}" />
      <input type="submit" class="btn-delete" formaction="deleteStudent" value="Remover ${param.studentName} desta turma" />
    </form>
  </fieldset>
</div>