create table cliente (
    id int primary key auto_increment,
    nome varchar(255) not null,
    cpf varchar(11),
    data_nascimento date
);

create table contato (
    id int  primary key auto_increment,
    tipo_contato varchar(20) not null,
    codigo varchar(255) not null,
    cliente_id int not null,
        foreign key (cliente_id) references cliente(id)
);

create table endereco (
    id int primary key auto_increment,
    logradouro varchar(255) not null,
    numero varchar(10) not null,
    complemento clob,
    cep varchar(8),
    bairro varchar(100) not null,
    cidade varchar(100) not null,
    uf char(2) not null,
    cliente_id int not null,
        foreign key (cliente_id) references cliente(id)
);
