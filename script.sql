create database formulario

CREATE TABLE public.fornecedor
(
  razao_social text,
  nome_fantasia text,
  cnpj text,
  inscricao_estadual text,
  responsavel_legal text,
  email text,
  logradouro text,
  bairro text,
  cep text,
  cidade text,
  estado text,
  observacao text,
  id integer NOT NULL DEFAULT nextval('fornecedor_id_seq'::regclass),
  telefone text,
  CONSTRAINT pk_fornecedor PRIMARY KEY (id)
)

CREATE TABLE public.pessoa
(
  id integer NOT NULL DEFAULT nextval('pessoa_id_seq'::regclass),
  nome text,
  cpf text,
  rg text,
  data_nascimento date,
  celular text,
  email text,
  logradouro text,
  bairro text,
  cep text,
  cidade text,
  estado text,
  senha text,
  CONSTRAINT pk_pessoa PRIMARY KEY (id)
)

CREATE TABLE public.produto
(
  id integer NOT NULL DEFAULT nextval('produto_id_seq'::regclass),
  descricao text,
  categoria text,
  sub_categoria text,
  marca text,
  modelo text,
  preco numeric,
  CONSTRAINT pk_produto PRIMARY KEY (id)
)
