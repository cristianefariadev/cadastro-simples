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
					<i class="fa fa-archive"></i> PRODUTO
					<hr>
				</h3>
				<div class="panel-body">
					<form method="POST" action="ProdutoController"
						name="adicionarProduto">
						<div class="row">
							<div class="col-md-2">
								<div class="form-group">
									<label for="id">Código:</label> <input class="form-control"
										type="text" readonly="readonly" id="id" name="id"
										value="<c:out value="${inserir.id}"/>" />
								</div>
							</div>
							<div class="col-md-8">
								<div class="form-group">
									<label for="descricao ">Descrição:</label> <input
										class="form-control" type="text" id="descricao"
										name="descricao" value="<c:out value="${inserir.descricao}"/>"
										required />
								</div>
							</div>

							<div class="col-md-2">
								<div class="form-group ">
									<label for="preco ">Preço:</label> <input class="form-control"
										type="text" id="preco" name="preco"
										value="<c:out value="${inserir.preco}"/>" required />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="marca">Marca:</label> <input class="form-control"
										type="text" id="marca" name="marca"
										value="<c:out value="${inserir.marca}"/>" required />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="modelo">Modelo:</label> <input class="form-control"
										type="text" id="modelo" name="modelo"
										value="<c:out value="${inserir.modelo}"/>" required />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="categoria">Categoria:</label> <input
										class="form-control" type="text" id="categoria"
										name="categoria" value="<c:out value="${inserir.categoria}"/>"
										required />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="subCategoria ">Sub-categoria:</label> <input
										class="form-control" type="text" id="subCategoria"
										name="subCategoria"
										value="<c:out value="${inserir.subCategoria}"/>" required />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="text-right">
								<button type="reset" class="btn btn-default">LIMPAR</button>
								<button type="submit" class="btn btn-primary">SALVAR</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>


		<div class="panel-body">
			<div class="scroll">
				<table class="table table-striped  text-center" id="tabela">
					<thead>
						<tr id="titulo">
							<th>Código</th>
							<th>Descrição</th>
							<th>Categoria</th>
							<th>Sub-Categoria</th>
							<th>Marca</th>
							<th>Modelo</th>
							<th>Preço</th>
							<th colspan=2></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lista}" var="listagem">
							<tr>
								<td><c:out value="${listagem.id}" /></td>
								<td><c:out value="${listagem.descricao}" /></td>
								<td><c:out value="${listagem.categoria}" /></td>
								<td><c:out value="${listagem.subCategoria}" /></td>
								<td><c:out value="${listagem.marca}" /></td>
								<td><c:out value="${listagem.modelo}" /></td>
								<td><c:out value="${listagem.preco}" /></td>
								<td><a class="btn btn-warning"
									href="ProdutoController?action=editar&id=<c:out value="${listagem.id}"/>">Alterar</a></td>
								<td><a class="btn btn-danger"
									href="ProdutoController?action=deletar&id=<c:out value="${listagem.id}"/>">Apagar</a></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>