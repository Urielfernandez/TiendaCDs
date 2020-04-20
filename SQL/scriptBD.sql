
-------------------------------------------------------------
--	CREAMOS LA BASE DE DATOS bd_alumnos CON LA TABLA altadaw

CREATE DATABASE bd_alumnos;

USE bd_alumnos;

CREATE TABLE altadaw
(
	id integer(11) auto_increment primary key,
	nombre varchar(45) not null,
	apellidos varchar(45) not null,
	email varchar(45) not null
);


CREATE USER 'daw'@'localhost' IDENTIFIED BY 'Daw1234567890';

GRANT ALL PRIVILEGES ON bd_alumnos . * TO 'daw'@'localhost';

FLUSH PRIVILEGES;

INSERT INTO altadaw (nombre, apellidos, email)
VALUES ("Manuel", "Gonzalez Costa", "email1@email.com");




#######################################################################
#	CREAMOS LA BASE DE DATOS gonzalezcosta CON LA TABLA usuario

CREATE DATABASE gonzalezcosta;

USE gonzalezcosta;

CREATE TABLE usuario
(
	id integer(11) primary key,
	nombre varchar(45) not null,
	apellido1 varchar(45) not null,
    apellido2 varchar(45),
	email varchar(45) not null,
    passwd varchar(45) not null,
    telefono varchar(20),
    sexo varchar(10),
    pais varchar(45),
    provincia varchar(45),
    ciudad varchar(45),
    direccion varchar (100)
);

CREATE USER 'gonzalezCosta'@'localhost' IDENTIFIED BY 'Daw1234567890';

GRANT ALL PRIVILEGES ON gonzalezcosta . * TO 'gonzalezCosta'@'localhost';

FLUSH PRIVILEGES;

insert into gonzalezcosta.usuario (id, nombre, apellido1, apellido2, email, passwd, telefono, sexo, pais, provincia, ciudad, direccion)
values ("1","usuario1", "apellido1", "apellido2", "usuario1@email.com", "pass1", "981111111", "h", "Pais1", "Provincia1", "Ciudad1", "Direccion1")

