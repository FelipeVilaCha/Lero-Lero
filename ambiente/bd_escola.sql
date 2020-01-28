create table cursos (
    id int(10) unsigned NOT NULL PRIMARY KEY,
    nome varchar(50) NOT NULL,
    requisito varchar(255),
    ementa varchar(255),
    carga_horaria smallint(5) unsigned,
    preco double unsigned
);

create table instrutores (
    id int(11) unsigned NOT NULL PRIMARY KEY,
    nome varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    valor_hora int(10) unsigned,
    login varchar(20) NOT NULL,
    senha varchar(255) NOT NULL
);

create table matriculas (
    id int(10) unsigned NOT NULL PRIMARY KEY,
    turmas_id int(10) unsigned NOT NULL,
    alunos_id int(11) NOT NULL,
    data_matricula date,
    nota decimal(11,0)
);

create table administrador (
    id int(11) NOT NULL PRIMARY KEY,
    nome varchar(50) NOT NULL,
    login varchar(20) NOT NULL,
    senha varchar(255) NOT NULL
);

create table turmas (
    id int(10) unsigned NOT NULL PRIMARY KEY,
    instrutores_id int(11) NOT NULL,
    cursos_id int(10) unsigned NOT NULL,
    data_inicio date,
    data_final date,
    carga_horaria smallint(5) unsigned
);

create table alunos (
    id int(11) NOT NULL PRIMARY KEY,
    cpf char(11) NOT NULL,
    nome varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    celular char(14) NOT NULL,
    login varchar(20) NOT NULL,
    senha varchar(255) NOT NULL,
    endereco varchar(50),
    cidade varchar(30),
    bairro varchar(30),
    cep varchar(9)
);
