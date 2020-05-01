
--#######################################################################
--#	CREAMOS LA BASE DE DATOS tiendacds CON LAS TABLAS CORRESPONDIENTES

CREATE DATABASE tiendacds;

USE tiendacds;

-- Tabla cds

CREATE TABLE cds (
  titulo varchar(100) NOT NULL,
  artista varchar(100) NOT NULL,
  pais varchar(100) NOT NULL,
  precio varchar(100) NOT NULL,
  anho varchar(4) NOT NULL,
  PRIMARY KEY (titulo)
);


-- Tabla inventario

CREATE TABLE inventario (
  cd varchar(100) NOT NULL,
  cantidad_stock int NOT NULL,
  PRIMARY KEY (cd),
  FOREIGN KEY (cd) REFERENCES cds(titulo) on update cascade on delete cascade
);

-- Tabla usuarios

CREATE TABLE usuarios (
  email varchar(100) NOT NULL,
  nombre varchar(100) NOT NULL,
  contrasenha varchar(100) NOT NULL,
  tipo varchar(100) NOT NULL,
  membresia varchar(100) NOT NULL,
  PRIMARY KEY (email)
);


-- Tabla pedidos

CREATE TABLE pedidos (
  id int NOT NULL AUTO_INCREMENT,
  usuario varchar(100) NOT NULL,
  total_compra float NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (usuario) REFERENCES usuarios(email) on update cascade on delete cascade
);

-- Tabla opiniones

CREATE TABLE opiniones (
    nota float NOT NULL,
    opinion varchar(300) NOT NULL,
    cd varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    PRIMARY KEY(cd,email),
    FOREIGN KEY (cd) REFERENCES cds(titulo) on update cascade on delete cascade,
    FOREIGN KEY (email) REFERENCES usuarios(email) on update cascade on delete cascade
);


-- Tabla items_pedido

CREATE TABLE items_pedido (
  pedido int NOT NULL,
  cd varchar(100) NOT NULL,
  cantidad int NOT NULL,
  fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (pedido,cd),
  FOREIGN KEY (cd) REFERENCES cds(titulo) on update cascade on delete cascade,
  FOREIGN KEY (pedido) REFERENCES pedidos(id) on update cascade on delete cascade
);

CREATE USER 'dawa'@'localhost' IDENTIFIED BY 'Dawaproyecto1';

GRANT ALL PRIVILEGES ON tiendacds . * TO 'dawa'@'localhost';

FLUSH PRIVILEGES;

