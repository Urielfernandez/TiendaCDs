-- Tabla cds

CREATE TABLE cds (
  titulo varchar(100) NOT NULL,
  artista varchar(100) NOT NULL,
  pais varchar(100) NOT NULL,
  precio varchar(100) NOT NULL,
  PRIMARY KEY (titulo)
);


-- Tabla inventario

CREATE TABLE inventario (
  cd varchar(100) NOT NULL,
  cantidad_stock float NOT NULL,
  PRIMARY KEY (cd),
  FOREIGN KEY (cd) REFERENCES cds(titulo)
);

-- Tabla usuarios

CREATE TABLE usuarios (
  email varchar(100) NOT NULL,
  nombre varchar(100) NOT NULL,
  PRIMARY KEY (email)
);


-- Tabla pedidos

CREATE TABLE pedidos (
  id int NOT NULL AUTO_INCREMENT,
  usuario varchar(100) NOT NULL,
  total_compra float NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (usuario) REFERENCES usuarios(email)
);


-- Tabla items_pedido

CREATE TABLE items_pedido (
  pedido int NOT NULL,
  cd varchar(100) NOT NULL,
  cantidad int NOT NULL,
  PRIMARY KEY (pedido,cd),
  KEY cd_idx (cd),
  FOREIGN KEY (cd) REFERENCES cds(titulo),
  FOREIGN KEY (pedido) REFERENCES pedidos(id)
);