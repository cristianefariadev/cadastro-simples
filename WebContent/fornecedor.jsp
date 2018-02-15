<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html >
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
					<i class="fa fa-users"></i> FORNECEDOR
					<hr>
				</h3>
				<div class="panel-body">
					<form method="POST" action="FornecedorController"
						name="adicionarFornecedor">
						<div class="row">
							<div class="col-md-2">
								<div class="form-group">
									<label for="id">Código:</label> <input type="number"
										readonly="readonly" class="form-control" id="id" name="id"
										value="<c:out value="${inserir.id}"/>" />
								</div>
							</div>

							<div class="col-md-10">
								<div class="form-group">
									<label for="razaoSocial">Razão Social:</label> <input
										type="text" class="form-control" id="razaoSocial"
										name="razaoSocial"
										value="<c:out value="${inserir.razaoSocial}"/>" required />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="nomeFantasia">Nome Fantasia:</label> <input
										type="text" class="form-control" id="nomeFantasia"
										name="nomeFantasia"
										value="<c:out value="${inserir.nomeFantasia}"/>" required />
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<label for="inscricaoEstadual">Inscrição Estadual:</label> <input
										type="number" class="form-control" id="inscricaoEstadual"
										name="inscricaoEstadual"
										value="<c:out value="${inserir.inscricaoEstadual}"/>" required />
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="cnpj">CNPJ:</label> <input type="text"
										class="form-control" id="cnpj" name="cnpj"
										value="<c:out value="${inserir.cnpj}"/>" required minlength="14"/>
								</div>
							</div>
						</div>
						<div class="row">

							<div class="col-md-4">
								<div class="form-group">
									<label for="responsavelLegal">Responsável Legal:</label> <input
										type="text" class="form-control" id="responsavelLegal"
										name="responsavelLegal"
										value="<c:out value="${inserir.responsavelLegal}"/>" required />
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label for="telefone">Telefone:</label> <input type="text"
										class="form-control" id="telefone" name="telefone"
										value="<c:out value="${inserir.telefone}"/>" required />
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
						</div>
						<div class="row">
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
									<label for="Estado">Estado:</label> <input type="text"
										class="form-control" id="estado" name="estado"
										value="<c:out value="${inserir.estado}"/>" required />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="observacao">Observação:</label>
									<textarea class="form-control" rows="5" id="observacao"
										name="observacao">
									<c:out value="${inserir.observacao}" />
									</textarea>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="text-right">
								<button type="reset" class="btn btn-default">CANCELAR</button>
								<button type="submit" class="btn btn-primary">SALVAR</button>
							</div>
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
							<th>Razão Social</th>
							<th>CNPJ</th>
							<th>Telefone</th>
							<th>Cidade</th>
							<th colspan="2"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lista}" var="listagem">
							<tr>
								<td><c:out value="${listagem.id}" /></td>
								<td><c:out value="${listagem.razaoSocial}" /></td>
								<td><c:out value="${listagem.cnpj}" /></td>
								<td><c:out value="${listagem.telefone}" /></td>
								<td><c:out value="${listagem.cidade}" /></td>
								<td><a class="btn btn-warning"
									href="FornecedorController?action=editar&id=<c:out value="${listagem.id}"/>">Alterar</a></td>
								<td><a class="btn btn-danger"
									href="FornecedorController?action=deletar&id=<c:out value="${listagem.id}"/>">Apagar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="js/endereco.js"></script>
	<script src="js/jquery_mask/dist/jquery.mask.min.js"></script>
	<script>
		$('#cnpj').mask('000.000.00/0000-00');
		$('#telefone').mask('(00) 0000-0000');
		$('#cep').mask('00 000-000');
	</script>
	<jsp:include page="footer.jsp" />
</body>
</html>