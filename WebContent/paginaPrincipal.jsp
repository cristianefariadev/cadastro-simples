<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="importacao.jsp" />
</head>
<body>
	<jsp:include page="menu.jsp" />

	<div class="container">

		<div class="row">
			<div class=" text-center cont">
				<div class="col-md-12">
					<img alt="logo" src="imagem/logo2.png">
					<h3>Desenvolvido por Cristiane Faria</h3>
				</div>

				<div class="col-md-6">


					<div class="col-md-12">
						<H4>SOFTWARE PARA FORMULÁRIO</H4>
						<br>
						<p>
							Desenvolvido com o intuito de aprendizado nas tecnologias:<br>
							<br> JAVA EE<br> TOMCAT<br> SERVLET<br> JSP<br>
							Persistência JDBC<br> POSTEGRE<br> HTML5<br> CSS3<br>
							BOOSTRAP<br> JAVASCRIPT<br> JQUERY<br>
						</p>

					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="formularioLogin">
					<h4>
						<i class="fa fa-code"></i> Acesse sua conta
					</h4>
					<form method="POST" action="Login">
						<div class="form-group">
							<input class="form-control" type="text" Name="usuario"
								value="${param.usuario}" placeholder="USUÁRIO"> <br>
							<input class="form-control" type="password" Name="senha"
								placeholder="SENHA">

							<p>
								<a href="#"> Faça seu cadastro </a><span>|</span> <a href="#">
									Esqueceu a senha?</a>
							</p>

						</div>
						<div class="text-right">
							<input class="btn btn-primary" name="botao" type="submit"
								value="Acessar">
						</div>

					</form>
					<c:if test="${mensagens.existeErros}">
						<div id="erro">
							<ul>
								<c:forEach var="erro" items="${mensagens.erros}">
									<li>${erro}</li>
								</c:forEach>
							</ul>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>