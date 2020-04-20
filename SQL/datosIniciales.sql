-- Insertar titulo, artista, pais y precio

INSERT INTO cds VALUES("Yuan", "The Guo Brothers", "China", 14.95);
INSERT INTO cds VALUES("Drums of Passion", "Babatunde Olatunji", "Nigeria", 16.95);
INSERT INTO cds VALUES("Kaira", "Tounami Diabate", "Mali", 16.95);
INSERT INTO cds VALUES("The Lion is Loose", "Eliades Ochoa", "Cuba", 13.95);
INSERT INTO cds VALUES("Dance the Devil Away", "Outback", "Australia", 14.95);
INSERT INTO cds VALUES("Record of Changes", "Samulnori", "Korea", 12.95);
INSERT INTO cds VALUES("Djelika", "Tounami Diabate", "Mali", 14.95);
INSERT INTO cds VALUES("Rapture", "Nusrat Fateh Ali Khan", "Pakistan", 12.95);
INSERT INTO cds VALUES("Cesaria Evora", "Cesaria Evora", "Cape Verde", 16.95);
INSERT INTO cds VALUES("DAA", "GSTIC", "Spain", 50.00);


-- Insertamos 20 unidades de cada CD

INSERT INTO inventario SELECT titulo, 100 FROM cds;