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
			<div class="col-md-12">
				<h3 class="text-left">
					<i class="fa fa-user"></i> CLIENTE
					<hr>
				</h3>
				<div class="panel-body">
					<form method="POST" action="PessoaController"
						name="adicionarCliente">

						<div class="row">
							<div class="col-md-2">
								<div class="form-group">
									<label for="id">Código:</label> <input type="text"
										readonly="readonly" class="form-control" id="id" name="id"
										value="<c:out value="${inserir.id}"/>" />
								</div>
							</div>
							<div class="col-md-7">
								<div class="form-group">
									<label for="cliente">Nome:</label> <input type="text"
										class="form-control" id="nome" name="nome"
										value="<c:out value="${inserir.nome}"/>" required />
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label for="dataNascimento">Data de Nascimento:</label> <input
										type="text" class="form-control" id="dataNascimento"
										name="dataNascimento"
										value="<fmt:formatDate pattern="dd/MM/yyyy" value="${inserir.dataNascimento}" />"
										required minlength="8"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label for="cpf">CPF:</label> <input type="text"
										class="form-control" id="cpf" name="cpf"
										value="<c:out value="${inserir.cpf}"/>" required
										minlength="11" />
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label for="rg">RG:</label> <input type="text"
										class="form-control" id="rg" name="rg"
										value="<c:out value="${inserir.rg}"/>" required />
								</div>
							</div>

							<div class="col-md-2">
								<div class="form-group">
									<label for="celular">Celular:</label> <input type="text"
										class="form-control" id="celular" name="celular"
										value="<c:out value="${inserir.celular}"/>" required />
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="email">E-mail:</label> <input type="email"
										class="form-control" id="email" name="email"
										value="<c:out value="${inserir.email}"/>" required />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label for="logradouro">Endereço:</label> <input type="text"
										class="form-control" id="endereco" name="logradouro"
										value="<c:out value="${inserir.logradouro}"/>" required />
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label for="bairro">Bairro:</label> <input type="text"
										class="form-control" id="bairro" name="bairro"
										value="<c:out value="${inserir.bairro}"/>" required />
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="cep">CEP:</label> <input type="text"
										class="form-control" id="cep" name="cep"
										value="<c:out value="${inserir.cep}"/>" required />
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="cidade">Cidade:</label> <input type="text"
										class="form-control" id="cidade" name="cidade"
										value="<c:out value="${inserir.cidade}"/>" required />
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="estado">Estado:</label> <input type="text"
										class="form-control" id="estado" name="estado"
										value="<c:out value="${inserir.estado}"/>" required />
								</div>
							</div>
						</div>
						<div class="text-right">
							<input type="reset" class="btn btn-default" value="LIMPAR" /> <input
								type="submit" class="btn btn-primary" value="SALVAR" />
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="panel-body">
			<div class="scroll">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Código</th>
							<th>Nome</th>
							<th>CPF</th>
							<th>Data de Nascimento</th>
							<th>Celular</th>
							<th>E-mail</th>
							<th>Cidade</th>
							<th colspan="2"></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${lista}" var="listagem">
							<tr>
								<td><c:out value="${listagem.id}" /></td>
								<td><c:out value="${listagem.nome}" /></td>
								<td><c:out value="${listagem.cpf}" /></td>
								<td><fmt:formatDate value="${listagem.dataNascimento}"
										pattern="dd/MM/yyyy" /></td>
								<td><c:out value="${listagem.celular}" /></td>
								<td><c:out value="${listagem.email}" /></td>
								<td><c:out value="${listagem.cidade}" /></td>
								<td><a class="btn btn-warning"
									href="PessoaController?action=editar&id=<c:out value="${listagem.id}"/>">Alterar</a></td>
								<td><a class="btn btn-danger"
									href="PessoaController?action=deletar&id=<c:out value="${listagem.id}"/>">Apagar</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="js/jquery_mask/dist/jquery.mask.min.js"></script>
	<script src="js/endereco.js"></script>
	<script>
		$('#cpf').mask('000.000.000-00');
		$('#dataNascimento').mask('00/00/0000');
		$('#celular').mask('(00) 0 0000-0000');
		$('#cep').mask('00.000-000');
	</script>

	<jsp:include page="footer.jsp" />
</body>
</html>