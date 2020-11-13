<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
isErrorPage="true"%> <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="SEAL - Erro de Login">
  <h3>Erro ao fazer login</h3>
  <p>Verifique suas credenciais e tente novamente.</p>
  <a href="${pageContext.request.contextPath}/">Voltar para a tela de login</a>
</t:wrapper>
