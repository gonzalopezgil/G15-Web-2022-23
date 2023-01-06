--------------------RESPONSABLES--------------------
INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (1,'marcia.calderón.querol', '%KYkVN)m73', 'Marcia', 'Calderón Querol', '99899277L', 'marcia.calderón.querol@uah.es');
INSERT INTO responsable (id_responsable, f_alta, f_baja) VALUES (1,'2022-05-14', NULL);

--------------------ALUMNOS--------------------
INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (2,'clotilde.barco-mancebo', '*4L0TKioN)', 'Clotilde', 'Barco-Mancebo', '70349448S', 'clotilde.barco-mancebo@edu.uah.es');
INSERT INTO alumno (id_alumno, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (2,'Ingeniería de software', 5, '1997-10-24', '+34 864497907', 300);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (3,'rafael.valera.viana', '$4_oX2Ow@Z', 'Rafael', 'Valera Viana', '12671450Z', 'rafael.valera.viana@edu.uah.es');
INSERT INTO alumno (id_alumno, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (3,'Ingeniería de computadores', 5, '1997-01-13', '+34 719643903', 350);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (4,'cristina.peñalver-revilla', '_+pS4pIhr1', 'Cristina', 'Peñalver-Revilla', '37937494Y', 'cristina.peñalver-revilla@edu.uah.es');
INSERT INTO alumno (id_alumno, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (4,'Ingeniería informática', 0, '2003-01-17', '+34702469459', 350);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (5,'nadia.gala.franch.fajardo', '#0cZ#jyRTO', 'Nadia', 'Gala Franch Fajardo', '54367343N', 'nadia.gala.franch.fajardo@edu.uah.es');
INSERT INTO alumno (id_alumno, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (5,'Ingeniería informática', 1, '2000-09-02', '+34 726 59 04 61', 300);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (6,'vasco.carnero.ródenas', '+2L*TWznFq', 'Vasco', 'Carnero Ródenas', '64362080F', 'vasco.carnero.ródenas@edu.uah.es');
INSERT INTO alumno (id_alumno, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES (6,'Ingeniería de sistemas y software', 8, '2002-01-16', '+34749 35 41 64', 300);

--------------------EMPRESAS--------------------
INSERT INTO empresa (id, nombre, sufijo_correo, telefono, direccion, ciudad, codigo_postal, descripcion) VALUES (1,'Sedano-Agudo', 'sedano-agudo.es', '+34720498920', 'Pasadizo de Concepción Conesa 6', 'Barcelona', '25583', 'Voluptate fuga perferendis nostrum. Tenetur minus quaerat adipisci quasi dicta unde.
Ducimus iure eligendi nostrum. Iure in hic ipsum maxime illum.');

INSERT INTO empresa (id, nombre, sufijo_correo, telefono, direccion, ciudad, codigo_postal, descripcion) VALUES (2,'Bellido LLC', 'bellido-llc.es', '+34705 623 443', 'Ronda de Matilde Perez 670 Apt. 55 ', 'Asturias', '05686', 'Libero est quia neque beatae totam.
Suscipit magni aspernatur laudantium. Asperiores est enim facilis possimus.');

--------------------TUTORES--------------------
INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (7,'antonio.del.giménez', 'StA8ZhaB$!', 'Antonio', 'del Giménez', '01354484Z', 'antonio.del.giménez@sedano-agudo.es');
INSERT INTO tutor (id_tutor, f_alta, f_baja,id_empresa) VALUES (7, '2022-10-05', NULL, 1);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (8,'javi.herberto.ródenas.bastida', 'H@3$QH$p!z', 'Javi', 'Herberto Ródenas Bastida', '93000458G', 'javi.herberto.ródenas.bastida@bellido-llc.es');
INSERT INTO tutor (id_tutor, f_alta, f_baja,id_empresa) VALUES (8, '2022-07-24', NULL, 2);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (9,'sebastián.abella.nevado', '@zZr!1JKe1', 'Sebastián', 'Abella Nevado', '39033213M', 'sebastián.abella.nevado@sedano-agudo.es');
INSERT INTO tutor (id_tutor, f_alta, f_baja,id_empresa) VALUES (9, '2023-01-05', '2023-01-05', 1);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (10,'trinidad.machado.coll', 'u&6jH28nld', 'Trinidad', 'Machado Coll', '52693952D', 'trinidad.machado.coll@sedano-agudo.es');
INSERT INTO tutor (id_tutor, f_alta, f_baja,id_empresa) VALUES (10, '2022-08-12', '2022-08-23', 1);

INSERT INTO usuario (id_usuario, nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES (11,'norberto.del.gil', '^5UDe&pu74', 'Norberto', 'del Gil', '21745882A', 'norberto.del.gil@sedano-agudo.es');
INSERT INTO tutor (id_tutor, f_alta, f_baja,id_empresa) VALUES (11, '2021-03-23', '2021-09-07', 1);

--------------------OFERTAS--------------------
INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas, f_inicio) VALUES (1, 'Coreógrafo', 'Machine Learning Engineer', 1, 'Pasadizo de Concepción Conesa 6', 'Explicabo culpa eius mollitia quod. Sit occaecati quae.
Repellat possimus facere. Facere veritatis id placeat magni doloribus.', 'Eaque iusto reiciendis tenetur quibusdam non deleniti. Sunt voluptatum corporis minus. Eligendi minus est rem recusandae quaerat deserunt.
Vel dolores occaecati. Consequuntur harum rem porro.', '8-19 5 days a week', 5, 1175, 7, '2023-01-06');

INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas, f_inicio) VALUES (2, 'Focumentalista', 'Database Architect', 2, 'Ronda de Matilde Perez 670 Apt. 55 ', 'Laborum vel odit impedit quas maiores. Quia voluptatem iure molestias asperiores neque debitis.', 'Veritatis error praesentium. Voluptatem eos ab amet harum debitis.
Fugiat doloremque tenetur. Eos corporis eligendi exercitationem. Nam fugit sequi iusto.', '8-19 5 days a week', 7, 1119, 1, '2023-01-06');

INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas, f_inicio) VALUES (3, 'Guía de turismo', 'Database Systems Engineer', 2, 'Ronda de Matilde Perez 670 Apt. 55 ', 'Quam reiciendis quia explicabo omnis animi reprehenderit. Placeat consectetur necessitatibus corporis libero sapiente.
Hic quo delectus reprehenderit. Commodi voluptatibus provident vel aut cumque.', 'Molestias architecto debitis excepturi consequuntur in cupiditate. Perferendis in in nihil distinctio ab dignissimos. Laborum mollitia amet libero dignissimos facere esse.', '9-19 5 days a week', 9, 1127, 7, '2023-01-06');

INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas, f_inicio) VALUES (4, 'Fisioterapeuta', 'Data Engineer', 2, 'Ronda de Matilde Perez 670 Apt. 55 ', 'At quia quod maiores. Aut exercitationem sed unde repellat.
Nihil architecto neque fugiat adipisci aperiam odit. Non dolorum nemo magnam quas.', 'Blanditiis accusamus facilis temporibus dolorum consequuntur. Aut ipsam accusantium odit voluptatem. Neque sed reprehenderit earum temporibus architecto.', '9-19 5 days a week', 4, 566, 7, '2023-01-06');

INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas, f_inicio) VALUES (5, 'Artesano', 'Database Architect', 2, 'Ronda de Matilde Perez 670 Apt. 55 ', 'Cum officia molestias totam at quos. Quo ab expedita in ad temporibus nesciunt. Delectus animi nostrum provident sed accusantium esse.', 'Eveniet voluptatum in possimus impedit blanditiis ducimus magni. Quia pariatur sequi consequuntur. Porro architecto numquam perferendis recusandae. Ipsam nostrum eos libero odio quasi.', '8-18 5 days a week', 6, 738, 8, '2023-01-06');

--------------------OFERTA_SELECCIONADA--------------------
INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (2, 1, 1);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (2, 4, 2);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (3, 1, 1);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (3, 3, 2);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (3, 4, 3);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (3, 5, 4);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (3, 2, 5);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (4, 2, 1);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (4, 4, 2);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (4, 3, 3);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (4, 5, 4);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (4, 1, 5);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (5, 3, 1);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (5, 2, 2);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (5, 1, 3);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (5, 4, 4);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (5, 5, 5);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (6, 1, 1);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (6, 3, 2);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (6, 2, 3);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (6, 5, 4);

INSERT INTO solicitud_practicas (id_alumno, id_oferta, preferencia) VALUES (6, 4, 5);

--------------------PRACTICA--------------------
INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (6, 1, 9.8, 'Cumque iusto possimus eveniet quod.
Commodi velit recusandae impedit ratione. Veniam distinctio numquam beatae. Eos qui porro odio.', '2022-08-08', '2022-09-10');

INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (2, 1, 3.2, 'Corrupti hic laboriosam deserunt modi illum veniam. Quis sit repellat. Maxime excepturi nisi hic perferendis minima assumenda.', '2021-07-02', NULL);

INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (3, 1, 0.5, 'Nostrum deserunt voluptate tempora possimus alias. Optio debitis ducimus incidunt voluptates. Nihil ex sapiente nostrum doloremque molestias earum laboriosam.', '2022-07-20', NULL);

INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (5, 1, 4.3, 'Maiores eligendi fugit aliquam. Officiis ab dolorum magnam maiores. Nobis velit in ipsam laborum officia fuga.', '2022-02-27', '2022-11-23');

INSERT INTO practica (id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES (4, 1, 9.0, 'Odio ad maxime illo esse.
Dicta aperiam autem sit laboriosam ratione ipsa molestias. Itaque nesciunt voluptatibus consequuntur autem perspiciatis quidem.', '2022-08-22', '2022-09-20');

