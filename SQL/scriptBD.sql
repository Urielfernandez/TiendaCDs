
--#######################################################################
--#	CREAMOS LA BASE DE DATOS tiendacds CON LAS TABLAS CORRESPONDIENTES

CREATE DATABASE tiendacds;

USE tiendacds;

CREATE TABLE usuarios
(
	id integer(11) auto_increment primary key,
	nombre varchar(45) not null,
	apellidos varchar(45) not null,
	email varchar(45) not null
);


CREATE USER 'dawa'@'localhost' IDENTIFIED BY 'Dawaproyecto1';

GRANT ALL PRIVILEGES ON tiendacds . * TO 'dawa'@'localhost';

FLUSH PRIVILEGES;

INSERT INTO altadaw (nombre, apellidos, email)
VALUES ("Manuel", "Gonzalez Costa", "email1@email.com");
