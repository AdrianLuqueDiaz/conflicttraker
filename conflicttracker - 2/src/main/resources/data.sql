-- Países
INSERT INTO COUNTRY (id, nombre, codigo) VALUES (1, 'España', 'ESP');
INSERT INTO COUNTRY (id, nombre, codigo) VALUES (2, 'Ucrania', 'UKR');
INSERT INTO COUNTRY (id, nombre, codigo) VALUES (3, 'Rusia', 'RUS');
INSERT INTO COUNTRY (id, nombre, codigo) VALUES (4, 'Francia', 'FRA');

-- Conflictos
INSERT INTO CONFLICT (id, nombre, fecha_inicio, estado, descripcion) VALUES 
(1, 'Guerra de Ucrania', '2022-02-24', 'ACTIVO', 'Conflicto entre Rusia y Ucrania.'),
(2, 'Guerra Civil Española', '1936-07-17', 'FINALIZADO', 'Conflicto histórico en España.');

-- Relación Conflicto-País
INSERT INTO CONFLICT_COUNTRY (conflict_id, country_id) VALUES (1,2);
INSERT INTO CONFLICT_COUNTRY (conflict_id, country_id) VALUES (1,3);
INSERT INTO CONFLICT_COUNTRY (conflict_id, country_id) VALUES (2,1);
INSERT INTO CONFLICT_COUNTRY (conflict_id, country_id) VALUES (2,4);

-- Facciones
INSERT INTO FACTION (id, nombre, conflict_id) VALUES (1, 'Ejército Ruso', 1);
INSERT INTO FACTION (id, nombre, conflict_id) VALUES (2, 'Ejército Ucraniano', 1);

-- Relación Facción-País
INSERT INTO FACTION_COUNTRY (faction_id, country_id) VALUES (1,3);
INSERT INTO FACTION_COUNTRY (faction_id, country_id) VALUES (2,2);

-- Eventos
INSERT INTO EVENT (id, fecha, ubicacion, descripcion, conflict_id) VALUES 
(1, '2022-03-01', 'Kiev', 'Batalla inicial en Kiev.', 1),
(2, '1936-07-18', 'Madrid', 'Inicio de la Guerra Civil Española.', 2);
