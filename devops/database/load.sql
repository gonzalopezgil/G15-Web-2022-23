--------------------RESPONSABLES--------------------
INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (1,'néstor.villaverde.busquets', 'NK8@W1gh_$', 'Néstor', 'Villaverde Busquets', '94056323P', 'néstor.villaverde.busquets@uah.es');
INSERT INTO responsable (id_usuario, f_alta, f_baja) VALUES (1,'2022-08-19', NULL);

--------------------ALUMNOS--------------------
INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (2,'lilia.encarnita.reig.blazquez', 'Z(8LLFa&LF', 'Lilia', 'Encarnita Reig Blazquez', '44889561R', 'lilia.encarnita.reig.blazquez@edu.uah.es');
INSERT INTO alumno (id_usuario, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (2,'Ingeniería de software', 5, '1999-10-10', '+34867098382', 300);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (3,'jessica.bueno.saldaña', 'gtIsPiJd!6', 'Jessica', 'Bueno Saldaña', '54911088Z', 'jessica.bueno.saldaña@edu.uah.es');
INSERT INTO alumno (id_usuario, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (3,'Ingeniería de sistemas', 0, '2002-01-17', '+34732 132 523', 300);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (4,'josé.victoriano.raya.barrera', '5^z6DuG@(Q', 'José', 'Victoriano Raya Barrera', '36688207X', 'josé.victoriano.raya.barrera@edu.uah.es');
INSERT INTO alumno (id_usuario, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (4,'Ingeniería de sistemas y software', 9, '2004-05-29', '+34731 225 125', 300);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (5,'agustina.escrivá.mateo', '*(7%Fcv)78', 'Agustina', 'Escrivá Mateo', '18406121A', 'agustina.escrivá.mateo@edu.uah.es');
INSERT INTO alumno (id_usuario, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (5,'Ingeniería de sistemas y software', 6, '1998-05-03', '+34725 290 955', 300);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (6,'filomena.alfaro.pla', 'U&!1(6VhsQ', 'Filomena', 'Alfaro Pla', '25384256F', 'filomena.alfaro.pla@edu.uah.es');
INSERT INTO alumno (id_usuario, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (6,'Ingeniería de sistemas y software', 5, '2000-03-31', '+34 746 11 24 44', 300);

--------------------EMPRESAS--------------------
INSERT INTO empresa (id, nombre, sufijo_correo, telefono, direccion, ciudad, codigo_postal, descripcion) VALUES (1,'Vicente, Ros and Carro', 'vicente-ros-and-carro.es', '+34 730 80 97 49', 'Camino de Gaspar Pavón 686', 'Pontevedra', '04146', 'Possimus natus minus nobis ut commodi velit. Necessitatibus totam quisquam sint aliquid itaque atque.
Neque sed deleniti minima impedit repudiandae. Quibusdam reprehenderit repellendus quam.');

INSERT INTO empresa (id, nombre, sufijo_correo, telefono, direccion, ciudad, codigo_postal, descripcion) VALUES (2,'Agullo-Cobos', 'agullo-cobos.es', '+34 984 165 099', 'Ronda de Julia Puga 35 Puerta 3 ', 'Barcelona', '35222', 'Quae quibusdam voluptatibus ea autem. Illo qui sed repellendus fugit totam quidem.
Vitae temporibus itaque. Ratione sunt sequi ad omnis fugit. Reiciendis fuga tenetur quaerat magnam quis.');

--------------------TUTORES--------------------
INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (7,'joaquina.barrena.pardo', '*h5CnmjSpB', 'Joaquina', 'Barrena Pardo', '79926095Z', 'joaquina.barrena.pardo@vicente-ros-and-carro.es');
INSERT INTO tutor (id_usuario, f_alta, f_baja,id_empresa) VALUES (7, '2022-03-24', NULL, 1);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (8,'eliseo.roca.agustí', '^&%I60Kpc&', 'Eliseo', 'Roca Agustí', '36818521Y', 'eliseo.roca.agustí@agullo-cobos.es');
INSERT INTO tutor (id_usuario, f_alta, f_baja,id_empresa) VALUES (8, '2022-02-05', NULL, 2);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (9,'florentina.bernal.julián', 'm7NhMoZs^L', 'Florentina', 'Bernal Julián', '10281437T', 'florentina.bernal.julián@vicente-ros-and-carro.es');
INSERT INTO tutor (id_usuario, f_alta, f_baja,id_empresa) VALUES (9, '2022-05-19', '2022-09-11', 1);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (10,'juan.de.cazorla', 'D@5p3T0uB)', 'Juan', 'de Cazorla', '14279481T', 'juan.de.cazorla@vicente-ros-and-carro.es');
INSERT INTO tutor (id_usuario, f_alta, f_baja,id_empresa) VALUES (10, '2021-06-27', '2022-07-23', 1);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (11,'alfredo.piquer.parra', '8!7QEpA5#B', 'Alfredo', 'Piquer Parra', '80142860G', 'alfredo.piquer.parra@vicente-ros-and-carro.es');
INSERT INTO tutor (id_usuario, f_alta, f_baja,id_empresa) VALUES (11, '2021-02-22', '2021-04-02', 1);

--------------------OFERTAS--------------------
INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas, f_inicio) VALUES (1, 'Empleado de agencia de viajes', 'Database Administrator', 2, 'Ronda de Julia Puga 35 Puerta 3 ', 'Adipisci quibusdam quibusdam maxime quasi nostrum repudiandae hic. Esse eius soluta molestias debitis doloremque molestiae. Labore saepe similique quaerat nulla.', 'Nobis perferendis iure saepe. Labore laudantium neque magni hic. Eius repellat dolore nostrum porro sint blanditiis.', '9-18 5 days a week', 11, 1033, 4, '2023-01-07');

INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas, f_inicio) VALUES (2, 'Agente de aduanas', 'Database Architect', 2, 'Ronda de Julia Puga 35 Puerta 3 ', 'Modi natus explicabo cum adipisci asperiores provident laborum. Itaque soluta optio autem error expedita voluptatibus. Sapiente quo nesciunt laboriosam dicta velit vitae.', 'Deleniti a maxime suscipit odio modi.
In neque iure repudiandae rem reiciendis velit. Porro dolor tempore molestias deserunt.
Cum ea unde ut veniam totam est. A repudiandae eius perferendis.', '8-19 5 days a week', 6, 450, 6, '2023-01-07');

INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas, f_inicio) VALUES (3, 'Tenedor de libros', 'Data Security Analyst', 2, 'Ronda de Julia Puga 35 Puerta 3 ', 'Quidem dicta sed velit ullam voluptatem. Adipisci accusantium quos quae temporibus.
Delectus laudantium ea. Libero rem sint quae. Quod nam sed sunt beatae.', 'Id esse error magni ipsum. Labore saepe facere.
Quos est molestiae iusto enim ducimus. Animi hic ipsa quae repudiandae nemo possimus. Repudiandae repellendus libero quaerat.', '8-19 5 days a week', 11, 928, 2, '2023-01-07');

INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas, f_inicio) VALUES (4, 'Dinamitero', 'Database Architect', 1, 'Camino de Gaspar Pavón 686', 'Accusantium omnis sunt officiis quia. Perspiciatis impedit mollitia quisquam doloribus aliquid. Porro rem animi cupiditate labore ullam ullam.', 'Architecto eaque accusamus beatae vitae quasi. Quae temporibus excepturi rerum magnam modi sapiente.
Occaecati similique debitis. Mollitia fugit nisi placeat.', '9-18 5 days a week', 9, 623, 5, '2023-01-07');

INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas, f_inicio) VALUES (5, 'Tenedor de libros', 'Data Architect', 1, 'Camino de Gaspar Pavón 686', 'Veniam deleniti suscipit vitae perspiciatis nam recusandae.', 'Odit vero veritatis mollitia corporis aut. Minus mollitia odio aperiam eos numquam temporibus nobis. Deleniti assumenda illum cupiditate tempora hic error.', '9-19 5 days a week', 4, 655, 7, '2023-01-07');

--------------------OFERTA_SELECCIONADA--------------------
INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (2, 5, 1);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (2, 4, 2);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (2, 1, 3);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (2, 2, 4);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (2, 3, 5);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (3, 2, 1);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (3, 5, 2);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (3, 1, 3);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (3, 4, 4);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (3, 3, 5);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (4, 2, 1);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (4, 5, 2);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (4, 4, 3);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (4, 1, 4);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (5, 2, 1);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (5, 5, 2);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (5, 4, 3);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (5, 3, 4);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (5, 1, 5);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (6, 5, 1);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (6, 4, 2);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (6, 1, 3);

--------------------PRACTICA--------------------
INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (4, 5, 8.0, 'Illum animi nihil nemo veritatis odit quia. Exercitationem quam quia eligendi.
Est quis molestiae suscipit nesciunt. Vero porro debitis quo nihil culpa blanditiis.', '2022-01-15', NULL);

INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (5, 5, 1.4, 'Eveniet optio laborum. Aliquid in minima. Cumque animi quasi at ea ducimus.', '2022-05-06', '2022-05-25');

INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (2, 5, 2.8, 'Eaque autem aperiam ad nemo aspernatur. Dolor beatae occaecati modi est. Modi voluptatibus debitis sed unde fuga.
Sint ea asperiores molestiae. Libero adipisci vero nulla consequuntur minima alias.', '2021-06-27', NULL);

INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (6, 5, 1.4, 'Debitis nesciunt ex deleniti. Corrupti animi illum.
Asperiores optio illo aperiam nemo quibusdam. Ipsum minima in at praesentium. Voluptatibus nobis labore dignissimos autem numquam tempora.', '2022-12-21', NULL);

INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (3, 5, 0.8, 'Ut inventore laudantium voluptate. Molestias animi tempora animi laborum similique.
Iure et ipsa totam tempora.
Animi quisquam asperiores suscipit molestias. Unde praesentium sapiente.', '2021-12-28', NULL);

