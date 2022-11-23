--------------------RESPONSABLES--------------------
INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('adelardo.llopis.polo', 'iz5DwjiW^$', 'Adelardo', 'Llopis Polo', '88013965A', 'adelardo.llopis.polo@uah.es');
INSERT INTO responsable (f_alta, f_baja) VALUES ('2022-06-28', 'NULL');

INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('samuel.medina.cazorla', 'd570YaTfh*', 'Samuel', 'Medina Cazorla', '59931727Y', 'samuel.medina.cazorla@uah.es');
INSERT INTO responsable (f_alta, f_baja) VALUES ('2022-11-15', '2022-11-16');

--------------------ALUMNOS--------------------
INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('amparo.de.peñas', '@0#C1(MTFg', 'Amparo', 'de Peñas', '43803888C', 'amparo.de.peñas@edu.uah.es');
INSERT INTO alumno(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de telecomunicaciones', '2', '2001-08-12', '+34 703274995', '300');

INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('otilia.gámez.león', '*3G%$WFtsx', 'Otilia', 'Gámez León', '92751116M', 'otilia.gámez.león@edu.uah.es');
INSERT INTO alumno(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de computadores y software', '1', '2002-11-02', '+34711559038', '300');

INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('modesto.berrocal.garay', '@FNFaA4qN5', 'Modesto', 'Berrocal Garay', '68671907W', 'modesto.berrocal.garay@edu.uah.es');
INSERT INTO alumno(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería informática', '6', '2004-10-10', '+34708 231 774', '300');

INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('julieta.franch.farré', 'di6UcWA0l+', 'Julieta', 'Franch Farré', '20354376C', 'julieta.franch.farré@edu.uah.es');
INSERT INTO alumno(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de sistemas', '4', '2004-02-29', '+34 725 83 55 84', '300');

INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('elpidio.donoso.company', 'xr8LlB_k+G', 'Elpidio', 'Donoso Company', '83323788D', 'elpidio.donoso.company@edu.uah.es');
INSERT INTO alumno(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de computadores y software', '4', '2001-08-22', '+34 854 53 01 65', '300');

INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('efraín.bermejo.tomas', '@RKi_rilX3', 'Efraín', 'Bermejo Tomas', '74003215W', 'efraín.bermejo.tomas@edu.uah.es');
INSERT INTO alumno(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de computadores y sistemas', '1', '1999-12-17', '+34 670921440', '350');

INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('raúl.valenciano', '#S(F0Vu+@a', 'Raúl', 'Valenciano', '97756091L', 'raúl.valenciano@edu.uah.es');
INSERT INTO alumno(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de telecomunicaciones', '8', '1997-04-10', '+34 719 14 26 31', '300');

INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('macarena.prats.piña', 'z2b(t7Ay(K', 'Macarena', 'Prats Piña', '35631433V', 'macarena.prats.piña@edu.uah.es');
INSERT INTO alumno(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de sistemas', '0', '2002-01-13', '+34711545776', '350');

INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('fidela.fuertes.nadal', '%EVCzrSUI7', 'Fidela', 'Fuertes Nadal', '40204854A', 'fidela.fuertes.nadal@edu.uah.es');
INSERT INTO alumno(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de computadores', '8', '2004-08-22', '+34 647 299 945', '300');

INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('sebastian.del.moya', '#40mVv)l*8', 'Sebastian', 'del Moya', '67604461D', 'sebastian.del.moya@edu.uah.es');
INSERT INTO alumno(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería informática', '2', '2001-12-25', '+34 864626839', '300');

--------------------EMPRESAS--------------------
INSERT INTO empresa (id, nombre, sufijo_correo, telefono, direccion, ciudad, codigo_postal, descripcion) VALUES ('0','Villaverde-Cruz', 'villaverde-cruz.es', '+34 739 253 590', 'Avenida Encarnacion Torres 7', 'Lugo,', '20242', 'Temporibus ducimus vero dolorum laudantium temporibus placeat nostrum. Temporibus dolores magnam soluta.');

INSERT INTO empresa (id, nombre, sufijo_correo, telefono, direccion, ciudad, codigo_postal, descripcion) VALUES ('1','Pont, Ramón and Gomis', 'pont-ramón-and-gomis.es', '+34670531556', 'Plaza de Quique Portillo 14', 'Sevilla,', '01447', 'Eaque iste officiis deleniti ducimus sapiente sapiente. Voluptatum quam ex quod nostrum voluptate possimus. Tenetur quae delectus facilis consequatur.');

--------------------TUTORES--------------------
INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('susanita.xiomara.nadal.cortina', '8iKann8P!N', 'Susanita', 'Xiomara Nadal Cortina', '56394871K', 'susanita.xiomara.nadal.cortina@villaverde-cruz.es');
INSERT INTO tutor (f_alta, f_baja,id_empresa) VALUES ('2021-09-02', 'NULL','0');

INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('tomasa.dalmau.montero', '@F!6XyHriH', 'Tomasa', 'Dalmau Montero', '80796208Z', 'tomasa.dalmau.montero@pont-ramón-and-gomis.es');
INSERT INTO tutor (f_alta, f_baja,id_empresa) VALUES ('2021-10-04', 'NULL','1');

INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('jacinto.escobar-abad', '#Kx1U4nO3H', 'Jacinto', 'Escobar-Abad', '18796567R', 'jacinto.escobar-abad@pont-ramón-and-gomis.es');
INSERT INTO tutor (f_alta, f_baja,id_empresa) VALUES ('2021-03-27', '2021-04-17','1');

INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('cayetano.de.mena', 'AfX)aEp#!0', 'Cayetano', 'de Mena', '07712361R', 'cayetano.de.mena@villaverde-cruz.es');
INSERT INTO tutor (f_alta, f_baja,id_empresa) VALUES ('2022-09-10', '2022-09-19','0');

INSERT INTO usuario (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('rosendo.baena.aramburu', '!I6Y9Am!pV', 'Rosendo', 'Baena Aramburu', '04041734J', 'rosendo.baena.aramburu@pont-ramón-and-gomis.es');
INSERT INTO tutor (f_alta, f_baja,id_empresa) VALUES ('2021-05-03', '2022-05-31','1');

--------------------OFERTAS--------------------
INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas) VALUES ('0', 'Técnico de prótesis médicas y dentales', 'Database Administrator', '0', 'Avenida Encarnacion Torres 7', 'Explicabo officia ipsa quo optio. Molestias maxime repudiandae ab sed vitae cumque.
Non quo amet id impedit. Incidunt sequi laboriosam distinctio. Magni id deserunt nemo.', 'Vel non dolor provident qui quia. Nisi recusandae totam fugit esse accusamus. Maxime unde minima vitae eveniet neque. A numquam recusandae in sit.', '8-18 5 days a week', '5', '353', '6');

INSERT INTO oferta (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas) VALUES ('1', 'Director de servicios de tecnología de la información y las comunicaciones', 'Data Warehouse Engineer', '0', 'Avenida Encarnacion Torres 7', 'Amet deserunt quasi adipisci. Molestiae voluptate eveniet quis explicabo pariatur ipsa.
Aut doloremque ducimus culpa natus. In quis perferendis voluptas qui.', 'Dolor cum provident recusandae esse quae modi.
Quo illum possimus. Quas at eveniet ducimus reprehenderit at excepturi. Quia explicabo sequi fugiat ratione.', '9-19 5 days a week', '11', '612', '8');

--------------------OFERTA_SELECCIONADA--------------------
INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('0', '1', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('0', '0', '2');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('1', '0', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('2', '0', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('3', '0', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('3', '1', '2');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('4', '0', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('4', '1', '2');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('5', '1', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('6', '1', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('6', '0', '2');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('7', '0', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('8', '0', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('8', '1', '2');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('9', '0', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('9', '1', '2');

--------------------PRACTICA--------------------
INSERT INTO practica(id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES ('6', '1', '7.5', 'Iusto molestias vitae. Cumque veritatis ad incidunt hic.', '2020-12-27', '2022-01-29');

INSERT INTO practica(id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES ('8', '1', '9.6', 'Totam beatae placeat neque animi. Quasi recusandae dignissimos molestiae consequuntur labore quis. Ipsam veritatis corporis accusantium dolore quod reprehenderit officiis.', '2021-02-06', 'NULL');

