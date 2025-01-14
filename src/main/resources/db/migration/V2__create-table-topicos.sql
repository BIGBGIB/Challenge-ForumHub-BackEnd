create table clientes(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensagem varchar(100) not null,
    data datetime not null,
    curso varchar(100) not null,
    autor varchar(100) not null,
    ativo tinyint not null,

    primary key(id)

);
