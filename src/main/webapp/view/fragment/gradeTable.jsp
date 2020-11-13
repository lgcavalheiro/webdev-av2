<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="grade-table">
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
                <td>${param.examAv1}</td>
                <td>${param.examAv2}</td>
                <td>${param.examAv3}</rd>
            </tr>
            <tr>
                <th>APS</th>
                <td>${param.assignmentAv1}</td>
                <td colspan="2">${param.assignmentAv2}</td>
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
</div>
