-- Insertar titulo, artista, pais y precio

INSERT INTO cds VALUES("Yuan", "The Guo Brothers", "China", 14.95, "1990");
INSERT INTO cds VALUES("Drums of Passion", "Babatunde Olatunji", "Nigeria", 16.95, "2013");
INSERT INTO cds VALUES("Kaira", "Tounami Diabate", "Mali", 16.95, "2015");
INSERT INTO cds VALUES("The Lion is Loose", "Eliades Ochoa", "Cuba", 13.95, "1999");
INSERT INTO cds VALUES("Dance the Devil Away", "Outback", "Australia", 14.95, "1997");
INSERT INTO cds VALUES("Record of Changes", "Samulnori", "Korea", 12.95, "1992");
INSERT INTO cds VALUES("Djelika", "Tounami Diabate", "Mali", 14.95, "2020");
INSERT INTO cds VALUES("Rapture", "Nusrat Fateh Ali Khan", "Pakistan", 12.95, "2018");
INSERT INTO cds VALUES("Cesaria Evora", "Cesaria Evora", "Cape Verde", 16.95, "2013");
INSERT INTO cds VALUES("DAA", "GSTIC", "Spain", 50.00, "2015");

-- Insertamos 20 unidades de cada CD

INSERT INTO inventario SELECT titulo, 100 FROM cds;


-- Insertar usuarios de prueba
INSERT INTO usuarios VALUES("usuario@gmail.com", "usuario", "1234", "usuario", "Basico");
INSERT INTO usuarios VALUES("usuarioVIP@gmail.com", "usuarioVIP", "1234", "usuario", "VIP");
INSERT INTO usuarios VALUES("administradorBasico@gmail.com", "administradorBasico", "1234", "administrador", "Basico");
INSERT INTO usuarios VALUES("administradorVIP@gmail.com", "administradorVIP", "1234", "administrador", "VIP");
INSERT INTO usuarios VALUES("chandecurros@gmail.com", "Manuel", "1234", "usuario", "Basico");


-- Insertar un pedido para generar un usuario VIP
INSERT INTO pedidos (usuario,total_compra) VALUES('chandecurros@gmail.com','137');
