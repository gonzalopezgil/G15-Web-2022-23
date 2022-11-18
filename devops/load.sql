--------------------RESPONSABLES--------------------
INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('anselmo.vallejo.arias', '95utEMui@t', 'Anselmo', 'Vallejo Arias', '61836147A', 'anselmo.vallejo.arias@uah.es');
INSERT INTO responsables (f_alta, f_baja) VALUES ('2020-12-07', 'NULL');

--------------------ALUMNOS--------------------
INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('vanesa.peña.meléndez', 'iu2N%xi_8&', 'Vanesa', 'Peña Meléndez', '05077988W', 'vanesa.peña.meléndez@edu.uah.es');
INSERT INTO alumnos(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de computadores y sistemas', '0', '1999-03-21', '+34 715 258 406', '350');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('concha.alvarado.ramón', 'J3hWZwiz!9', 'Concha', 'Alvarado Ramón', '23712919B', 'concha.alvarado.ramón@edu.uah.es');
INSERT INTO alumnos(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería informática', '6', '1997-08-07', '+34 939 49 61 24', '350');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('ismael.pepito.aragonés.barberá', '*bM0F7qZ8T', 'Ismael', 'Pepito Aragonés Barberá', '86155895B', 'ismael.pepito.aragonés.barberá@edu.uah.es');
INSERT INTO alumnos(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de telecomunicaciones y software', '9', '2002-06-01', '+34 740 002 932', '300');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('lorenzo.peiró.valls', 'lSFG4Lg6w@', 'Lorenzo', 'Peiró Valls', '67421134S', 'lorenzo.peiró.valls@edu.uah.es');
INSERT INTO alumnos(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de telecomunicaciones y software', '0', '2002-04-24', '+34714573545', '300');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('rufino.lledó.reguera', '@5ZpRZSRGd', 'Rufino', 'Lledó Reguera', '76844843A', 'rufino.lledó.reguera@edu.uah.es');
INSERT INTO alumnos(id, grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de telecomunicaciones y software', '8', '2002-06-20', '+34998 463 573', '300');

--------------------EMPRESAS--------------------
INSERT INTO empresas (id, nombre, sufijo_correo, telefono, direccion, ciudad, codigo_postal, descripcion) VALUES ('0','Anaya Ltd', 'anaya-ltd.es', '+34 745141725', 'Alameda de Concha Alsina 2 Apt. 67 ', 'Cuenca,', '13030', 'Explicabo delectus quod laborum rem. Beatae nobis magni excepturi suscipit amet.
Maiores illo adipisci. Minima autem corporis. Unde fuga quo quos officia.');

INSERT INTO empresas (id, nombre, sufijo_correo, telefono, direccion, ciudad, codigo_postal, descripcion) VALUES ('1','Reyes, Rojas and Andrade', 'reyes-rojas-and-andrade.es', '+34878 114 732', 'Cuesta de Rogelio Abril 15 Apt. 76 ', 'Guadalajara,', '30064', 'Commodi minima distinctio magnam excepturi.
Repudiandae ducimus dolorum. Corporis suscipit aut voluptatum doloribus itaque temporibus. Voluptatem quisquam officia fuga cupiditate at.');

--------------------TUTORES--------------------
INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('loida.pedrero.montesinos', '!hKIATtHS1', 'Loida', 'Pedrero Montesinos', '97100356Z', 'loida.pedrero.montesinos@anaya-ltd.es');
INSERT INTO tutores (f_alta, f_baja,id_empresa) VALUES ('2021-01-21', 'NULL','0');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('borja.cuéllar.carvajal', '&oqOf9Xb(c', 'Borja', 'Cuéllar Carvajal', '76935488M', 'borja.cuéllar.carvajal@reyes-rojas-and-andrade.es');
INSERT INTO tutores (f_alta, f_baja,id_empresa) VALUES ('2022-09-09', 'NULL','1');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('francisco.jose.tejada.arias', 'Y2YMKyPz!j', 'Francisco', 'Jose Tejada Arias', '83661135S', 'francisco.jose.tejada.arias@reyes-rojas-and-andrade.es');
INSERT INTO tutores (f_alta, f_baja,id_empresa) VALUES ('2022-07-13', '2022-10-21','1');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('teresa.ponce.yáñez', '!_CrCheBV2', 'Teresa', 'Ponce Yáñez', '68163269D', 'teresa.ponce.yáñez@anaya-ltd.es');
INSERT INTO tutores (f_alta, f_baja,id_empresa) VALUES ('2022-03-30', '2022-10-18','0');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('albert.tirado.españa', 's8UAAf4Z$1', 'Albert', 'Tirado España', '20877026H', 'albert.tirado.españa@reyes-rojas-and-andrade.es');
INSERT INTO tutores (f_alta, f_baja,id_empresa) VALUES ('2022-04-06', '2022-08-21','1');

--------------------OFERTAS--------------------
INSERT INTO ofertas (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas) VALUES ('0', 'Empleado de control de abastecimientos e inventario', 'Machine Learning Engineer', '1', 'Cuesta de Rogelio Abril 15 Apt. 76 ', 'Necessitatibus perferendis veritatis doloribus nisi rerum voluptatibus suscipit. Vitae odit nam voluptatum impedit.', 'Suscipit nisi nobis voluptates maxime. Quasi velit ducimus blanditiis consectetur quibusdam. Eius exercitationem perferendis non asperiores soluta dolores.', '9-19 5 days a week', '5', '413', '2');

INSERT INTO ofertas (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas) VALUES ('1', 'Decorador de interior', 'Database Manager', '0', 'Alameda de Concha Alsina 2 Apt. 67 ', 'Dolorem consequatur voluptates quas aliquid quia corrupti. Voluptatem laboriosam magni voluptatem neque quibusdam.
Eius aspernatur labore dolores ratione. Nesciunt a nobis vero ut assumenda harum ad.', 'Sequi maiores ad assumenda iste amet. Molestiae nulla porro.
Reiciendis voluptate maiores debitis consectetur ab ab. Nihil veritatis eos nobis asperiores repudiandae quaerat iste.', '8-19 5 days a week', '10', '401', '9');

INSERT INTO ofertas (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas) VALUES ('2', 'Operario de la conservación de frutas, legumbres y verduras', 'Database Developer', '0', 'Alameda de Concha Alsina 2 Apt. 67 ', 'Voluptatem voluptate aut alias maxime fuga. Praesentium veritatis maiores officiis provident ab. Vel quis praesentium adipisci porro omnis repellendus praesentium.', 'Atque quo voluptates quae id. Eaque harum expedita tenetur nobis quia nihil.
Expedita molestias modi id voluptatibus.
Eum ducimus tenetur. Modi maiores doloremque deleniti possimus eos.', '9-19 5 days a week', '8', '790', '2');

INSERT INTO ofertas (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas) VALUES ('3', 'Agrimensor', 'Data Warehouse Engineer', '0', 'Alameda de Concha Alsina 2 Apt. 67 ', 'Quidem repellat doloribus voluptates eveniet dolorum. Doloremque perferendis possimus optio eum.
Architecto architecto in.', 'Dolore sint libero animi velit tempora culpa. Quos debitis qui corrupti qui corporis unde. Quos placeat nostrum quidem itaque et.
Dignissimos neque harum. Nulla porro in. Ullam illum animi alias.', '9-18 5 days a week', '9', '837', '7');

INSERT INTO ofertas (id, puesto, categoria, id_empresa, direccion, requisitos, descripcion, horario, semanas, sueldo, plazas) VALUES ('4', 'Operador de máquinas lavarropas', 'Data Security Analyst', '1', 'Cuesta de Rogelio Abril 15 Apt. 76 ', 'Asperiores amet itaque iusto eius. Ab unde occaecati.
Magni quia nihil aut. Aut ipsam autem id.
Quam perspiciatis doloribus eos. Minima nulla quia ab temporibus et nulla excepturi.', 'Totam unde qui inventore quaerat animi.
Neque deserunt qui. Atque et quam optio.
Modi cum ab molestias consequatur. Iste officia architecto a id. Molestias dolorem provident quis molestiae ad dolore.', '8-19 5 days a week', '5', '1089', '7');

--------------------OFERTA_SELECCIONADA--------------------
INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('0', '2', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('0', '3', '2');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('0', '1', '3');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('1', '2', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('1', '3', '2');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('2', '3', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('2', '0', '2');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('2', '1', '3');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('2', '4', '4');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('2', '2', '5');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('3', '2', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('3', '3', '2');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('3', '4', '3');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('3', '0', '4');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('4', '2', '1');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('4', '4', '2');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('4', '3', '3');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('4', '1', '4');

INSERT INTO oferta_seleccionada (id_alumno, id_oferta, preferencia) VALUES ('4', '0', '5');

--------------------PRACTICA--------------------
INSERT INTO practica(id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES ('2', '2', '5.8', 'Praesentium saepe dicta sequi expedita quasi similique. Aut id deserunt pariatur voluptatum soluta.', '2021-03-15', '2022-06-21');

INSERT INTO practica(id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES ('4', '2', '0.4', 'Natus sapiente dicta saepe nihil saepe eveniet. Vero quisquam numquam vitae alias qui.', '2021-04-28', '2022-09-18');

INSERT INTO practica(id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES ('1', '2', '5.2', 'Itaque ea natus est magni mollitia. Accusamus autem praesentium labore quis illum hic. Cumque voluptate sit necessitatibus corrupti voluptatum.
Veniam eos totam alias.', '2021-09-10', '2021-12-20');

INSERT INTO practica(id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES ('0', '2', '1.6', 'Itaque facere nisi dolorem facere.
Repellat consectetur ullam voluptatibus non. Assumenda possimus recusandae voluptate vero. Ut dolores soluta dolores.', '2021-05-12', '2021-11-22');

INSERT INTO practica(id_alumno, id_oferta, nota, informe, f_inicio, f_fin) VALUES ('3', '2', '0.7', 'Molestias quod eos quos laborum fuga. Esse veritatis omnis.
Sequi eveniet doloribus nisi nostrum. Libero illum cum doloremque eum repellat itaque. Veritatis similique nulla iure.', '2021-08-14', 'NULL');