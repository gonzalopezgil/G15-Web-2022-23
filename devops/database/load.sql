--------------------RESPONSABLES--------------------
INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (1,'dani.telmo.alba.carrasco', '&pHS#BYf^3', 'Dani', 'Telmo Alba Carrasco', '69587614X', 'dani.telmo.alba.carrasco@uah.es');
INSERT INTO responsable (id_responsable, f_alta, f_baja) VALUES (1,'2022-09-03', NULL);

--------------------ALUMNOS--------------------
INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (2,'delfina.roldan.carpio', '7fjRT!8t*L', 'Delfina', 'Roldan Carpio', '08107613K', 'delfina.roldan.carpio@edu.uah.es');
INSERT INTO alumno (id_alumno, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (2,'Ingeniería de computadores y software', 8, '1999-11-06', '+34681 318 901', 300);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (3,'clemente.aliaga.santos', '))S9U5Hqx4', 'Clemente', 'Aliaga Santos', '09904235K', 'clemente.aliaga.santos@edu.uah.es');
INSERT INTO alumno (id_alumno, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (3,'Ingeniería de computadores y software', 1, '1997-08-09', '+34727 21 48 48', 350);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (4,'espiridión.del.miró', 'g2m)8jHl%_', 'Espiridión', 'del Miró', '96629430J', 'espiridión.del.miró@edu.uah.es');
INSERT INTO alumno (id_alumno, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (4,'Ingeniería de telecomunicaciones y sistemas', 4, '2002-05-13', '+34 730 173 746', 300);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (5,'delia.aroca', '071L0A2c#p', 'Delia', 'Aroca', '07865987X', 'delia.aroca@edu.uah.es');
INSERT INTO alumno (id_alumno, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (5,'Ingeniería de sistemas y software', 2, '2004-10-09', '+34 704796066', 350);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (6,'amalia.leal', '_5WJz$ATBf', 'Amalia', 'Leal', '40917830W', 'amalia.leal@edu.uah.es');
INSERT INTO alumno (id_alumno, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (6,'Ingeniería informática', 0, '2004-06-08', '+34 921 76 43 78', 350);

--------------------EMPRESAS--------------------
INSERT INTO empresa (id, nombre, sufijo_correo, telefono, direccion, ciudad, codigo_postal, descripcion) VALUES (1,'Gallo-Fonseca', 'gallo-fonseca.es', '+34 713 68 46 23', 'C. de Trini Flores 48', 'Valencia,', '13156', 'Dolorem odit necessitatibus cumque laudantium iusto at. Quo eius quos cumque aut quae optio. Repellat voluptatem quasi dolorem.');

INSERT INTO empresa (id, nombre, sufijo_correo, telefono, direccion, ciudad, codigo_postal, descripcion) VALUES (2,'Rosselló, Tomás and Romero', 'rosselló-tomás-and-romero.es', '+34739384575', 'Rambla Gastón Galán 56 Piso 4 ', 'Madrid,', '46901', 'Delectus nulla harum soluta. Blanditiis doloremque quo debitis voluptatibus. Ab cumque consequatur.');

--------------------TUTORES--------------------
INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (7,'emilio.del.noguera', 'gihUxd6i+7', 'Emilio', 'del Noguera', '22596447M', 'emilio.del.noguera@gallo-fonseca.es');
INSERT INTO tutor (id_tutor, f_alta, f_baja,id_empresa) VALUES (7, '2021-12-01', NULL, 1);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (8,'sabina.aramburu-alemán', '))aJ0oPbu9', 'Sabina', 'Aramburu-Alemán', '70808839G', 'sabina.aramburu-alemán@rosselló-tomás-and-romero.es');
INSERT INTO tutor (id_tutor, f_alta, f_baja,id_empresa) VALUES (8, '2022-05-17', NULL, 2);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (9,'bernardita.tirado.alba', 'c_N4Pmk^W7', 'Bernardita', 'Tirado Alba', '67225286N', 'bernardita.tirado.alba@rosselló-tomás-and-romero.es');
INSERT INTO tutor (id_tutor, f_alta, f_baja,id_empresa) VALUES (9, '2022-01-16', '2022-05-27', 2);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (10,'celso.bernardo.acosta.andres', 'Wn#S$8Bu+i', 'Celso', 'Bernardo Acosta Andres', '29992520Z', 'celso.bernardo.acosta.andres@gallo-fonseca.es');
INSERT INTO tutor (id_tutor, f_alta, f_baja,id_empresa) VALUES (10, '2022-07-18', '2022-11-10', 1);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (11,'melisa.garcés.pujol', 'h_5NsVoh(J', 'Melisa', 'Garcés Pujol', '03565641C', 'melisa.garcés.pujol@rosselló-tomás-and-romero.es');
INSERT INTO tutor (id_tutor, f_alta, f_baja,id_empresa) VALUES (11, '2022-07-26', '2022-10-15', 2);

--------------------OFERTAS--------------------
INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas) VALUES (1, 'Técnico en seguridad aeronáutica', 'Database Manager', 1, 'C. de Trini Flores 48', 'Consequatur quis officiis itaque eveniet. Pariatur dicta doloribus incidunt omnis quaerat numquam rem. Veritatis ullam hic beatae inventore quia.', 'Ipsam nam nihil aliquam. Deleniti quidem fugit vel nesciunt nulla natus.', '8-18 5 days a week', 11, 594, 9);

INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas) VALUES (2, 'Tasador', 'Database Developer', 2, 'Rambla Gastón Galán 56 Piso 4 ', 'Illo neque laboriosam ullam soluta beatae. At numquam hic reiciendis odio deserunt. Eum dicta repellat eveniet fugiat itaque ullam maiores. Temporibus perspiciatis ut earum at.', 'Tempora dignissimos a tenetur dolores ut delectus. Veniam modi nobis impedit ratione nisi. Nihil consequatur dolorem recusandae asperiores.', '8-19 5 days a week', 11, 1079, 3);

INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas) VALUES (3, 'Herramentista', 'Database Systems Engineer', 2, 'Rambla Gastón Galán 56 Piso 4 ', 'Quo alias aspernatur. In harum dolore facilis itaque quidem dolores. Animi suscipit libero fugiat quis dolore non praesentium.', 'Incidunt ea sit sit perspiciatis ducimus placeat. Officiis natus iste quidem. Quia quaerat soluta facere.
Dolorem odit ullam illum saepe cumque. Incidunt quos vero ipsa laborum.', '9-19 5 days a week', 7, 736, 6);

INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas) VALUES (4, 'Trabajador de cuidados personales a domicilio', 'Data Visualization Engineer', 2, 'Rambla Gastón Galán 56 Piso 4 ', 'Nihil quia consequatur iusto esse ipsum minima. Reprehenderit laboriosam enim libero nulla eius beatae.
Id non voluptatibus atque. Nesciunt amet laborum sapiente magnam eaque.', 'Laborum aliquid accusantium eius quia. Exercitationem iste placeat consequatur nihil. Repellendus eveniet aspernatur ipsum vitae.', '9-18 5 days a week', 5, 691, 3);

INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas) VALUES (5, 'Trabajador ambulante de servicios', 'Database Security Administrator', 1, 'C. de Trini Flores 48', 'Molestias veritatis neque molestias explicabo esse facere. Enim voluptate saepe molestiae enim cumque non dolor. Eum ut dolorum doloribus perferendis occaecati.', 'Sed provident iure quia aspernatur odit. Suscipit magni adipisci facere dignissimos. Fugiat doloremque quibusdam ab corrupti iure ullam.
Est sed accusamus. Quod pariatur deserunt.', '8-19 5 days a week', 4, 1016, 1);

--------------------OFERTA_SELECCIONADA--------------------
INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES (2, 4, 1);

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES (2, 5, 2);

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES (2, 1, 3);

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES (3, 4, 1);

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES (3, 5, 2);

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES (4, 2, 1);

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES (4, 5, 2);

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES (4, 3, 3);

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES (4, 1, 4);

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES (5, 2, 1);

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES (5, 1, 2);

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES (5, 4, 3);

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES (6, 2, 1);

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES (6, 4, 2);

--------------------PRACTICA--------------------
INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (2, 4, 1.2, 'Tenetur placeat ullam veritatis asperiores nihil. Aliquam eum aliquid excepturi voluptatem minus blanditiis. Aut sunt sint.
Libero illum fugit.', '2021-10-30', NULL);

INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (5, 4, 2.1, 'Suscipit inventore repudiandae tempore itaque perspiciatis. Architecto alias dignissimos mollitia iusto modi perspiciatis. Laborum qui quasi qui veniam magni odit.', '2022-05-01', '2022-06-28');

INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (3, 4, 3.1, 'Minima minus esse repellendus harum. Porro ea vel omnis eum consequuntur.', '2021-09-25', NULL);

INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (6, 4, 7.0, 'Qui voluptate sint. Tenetur ipsa voluptatem sequi.
Saepe aspernatur ipsum exercitationem. Commodi iure ut occaecati consequatur in cum. Facilis suscipit assumenda aperiam porro.
Minima magnam nisi.', '2021-04-26', '2022-05-02');

INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (2, 5, 2.4, 'Sed soluta aspernatur corrupti. Esse quia libero cumque asperiores. Impedit molestiae voluptates. Enim earum perspiciatis perferendis.', '2021-01-09', NULL);

