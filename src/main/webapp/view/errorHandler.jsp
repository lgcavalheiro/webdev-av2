<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
isErrorPage="true"%> <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="SEAL - Erro">
  <h1>Deu erro! Oops! :(</h1>
  <p>${pageContext.exception.message}</p>
  <a href="${pageContext.request.contextPath}/">Voltar ao index.</a>
</t:wrapper>
