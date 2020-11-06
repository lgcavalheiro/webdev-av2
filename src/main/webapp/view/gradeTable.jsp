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
                <td><%= request.getParameter("examAv1") %></td>
                <td><%= request.getParameter("examAv2") %></td>
                <td><%= request.getParameter("examAv3") %></rd>
            </tr>
            <tr>
                <th>APS</th>
                <td><%= request.getParameter("assignmentAv1") %></td>
                <td colspan="2"><%= request.getParameter("assignmentAv2") %></td>
            </tr>
            <tr>
                <th>Total</th>
                <td colspan="3"><%= request.getParameter("finalGrade") %></td>
            </tr>
            <tr>
                <th>Situação</th>
                <td colspan="3">
                    <%= request.getParameter("isApproved").equalsIgnoreCase("true") ? "Aprovado" : "Reprovado" %>
                </td>
            </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="4"><i>Última atualização em <%= request.getParameter("updateTimestamp") %></i></td>
        </tr>
        </foot>
    </table>
</div>
