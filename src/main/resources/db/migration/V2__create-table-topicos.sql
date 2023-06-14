create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
      mensaje varchar(100) not null unique,
      fecha_de_creacion date not null ,
      estatus varchar(100) not null,
      autor varchar(100) not null,
      curso varchar(100) not null,
      complemento varchar(100) not null,
      numero varchar(20) not null,
      ciudad varchar(100) not null,
      primary key(id)
  );