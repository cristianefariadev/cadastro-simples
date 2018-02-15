var mensagensDeErro = {
	required : "Preencha este campo.",
}

$('form').validate({

	messages : {
		// cadastro cliente
		nome : mensagensDeErro,
		cpf : mensagensDeErro,
		telefone : mensagensDeErro,
		celular : mensagensDeErro,
		logradouro : mensagensDeErro,
		cep : mensagensDeErro,
		cidade : mensagensDeErro,
		estado : mensagensDeErro,
		sexo : mensagensDeErro,
		rg : mensagensDeErro,
		bairro : mensagensDeErro,
		// cadastro fornecedor
		razaoSocial : mensagensDeErro,
		inscricaoEstadual : mensagensDeErro,
		nomeFantasia : mensagensDeErro,
		responsavelLegal : mensagensDeErro,

		// cadastro produto

		
		email : {
			email : "Digite um email válido",
			required : mensagensDeErro
		},
		cpf : {
			minlength : "Digite um CPF válido",
			required : mensagensDeErro
		},
		cnpj : {
			minlength : "Digite um CNPJ válido",
			required : mensagensDeErro
		},
		dataNascimento : {
			minlength : "Digite uma data válido",
			required : mensagensDeErro
		},

	},
	highlight : function(element) {
		$(element).closest('.form-group').addClass('has-error');
	},
	unhighlight : function(element) {
		$(element).closest('.form-group').removeClass('has-error');
	},
	errorElement : 'span',
	errorClass : 'help-block',
	errorPlacement : function(error, element) {
		if (element.parent('.input-group').length) {
			error.insertAfter(element.parent());
		} else {
			error.insertAfter(element);
		}
	}
});
