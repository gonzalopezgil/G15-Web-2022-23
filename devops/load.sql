--------------------RESPONSABLES--------------------
INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('carmelita.fernández.gonzalez', 'D3TMHLnw@3', 'Carmelita', 'Fernández Gonzalez', '13485826Y', 'carmelita.fernández.gonzalez@uah.es');
INSERT INTO responsables (f_alta, f_baja) VALUES ('2022-04-17', 'NULL');

--------------------ALUMNOS--------------------
INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('jordán.coll.caparrós', '%4FE2AigkF', 'Jordán', 'Coll Caparrós', '53597979K', 'jordán.coll.caparrós@edu.uah.es');
INSERT INTO alumnos(grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de software', '6', '2002-03-06', '+34 690 73 61 18', '350');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('graciela.aranda-solís', '$s1GTPNvDJ', 'Graciela', 'Aranda-Solís', '84843959H', 'graciela.aranda-solís@edu.uah.es');
INSERT INTO alumnos(grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de telecomunicaciones y software', '0', '1998-06-02', '+34 991 444 985', '350');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('albina.eli.romeu.ochoa', 'W5xJQQXi+P', 'Albina', 'Eli Romeu Ochoa', '28424606X', 'albina.eli.romeu.ochoa@edu.uah.es');
INSERT INTO alumnos(grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería informática', '1', '2000-12-28', '+34 644237617', '300');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('iris.berrocal.martí', 'X9BhtEIE(U', 'Iris', 'Berrocal Martí', '46382239W', 'iris.berrocal.martí@edu.uah.es');
INSERT INTO alumnos(grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de computadores', '4', '2000-03-31', '+34 725 36 61 19', '350');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('cosme.borrás.falcó', '&y0QFaFDdv', 'Cosme', 'Borrás Falcó', '06803827J', 'cosme.borrás.falcó@edu.uah.es');
INSERT INTO alumnos(grado, nota_exp, f_nacimiento, telefono, horas_totales) VALUES ('Ingeniería de computadores y software', '8', '1999-04-24', '+34734 678 537', '350');

--------------------EMPRESAS--------------------
INSERT INTO empresas (id, nombre, sufijo_correo, telefono, direccion, ciudad, codigo_postal, descripcion) VALUES ('0','Mariscal, Roldán and Borrell', 'mariscal-roldán-and-borrell.es', '+34 707861509', 'Vial Alba Mármol 77 Puerta 3 ', 'Ciudad,', '43458', 'Repellendus ut voluptate natus. Vitae quibusdam tempore.
Neque ipsum rerum odit enim dolores aspernatur corporis. Atque soluta culpa totam rem.');

INSERT INTO empresas (id, nombre, sufijo_correo, telefono, direccion, ciudad, codigo_postal, descripcion) VALUES ('1','Arévalo Ltd', 'arévalo-ltd.es', '+34745 516 826', 'C. de Hipólito Tamarit 99', 'Guipúzcoa,', '22666', 'Accusantium odit ab nulla facere. Sunt quo reprehenderit ratione quae ullam voluptatum occaecati.');

--------------------TUTORES--------------------
INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('odalis.gárate', '$2ZjETbb5e', 'Odalis', 'Gárate', '47278726H', 'odalis.gárate@mariscal-roldán-and-borrell.es');
INSERT INTO tutores (f_alta, f_baja,id_empresa) VALUES ('2022-05-28', 'NULL','0');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('hugo.palomo.planas', 'D0PUNckg%F', 'Hugo', 'Palomo Planas', '61686325A', 'hugo.palomo.planas@arévalo-ltd.es');
INSERT INTO tutores (f_alta, f_baja,id_empresa) VALUES ('2022-06-11', 'NULL','1');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('josé.antonio.ballester.asensio', 'fXK2oRNg#2', 'José', 'Antonio Ballester Asensio', '78026688Q', 'josé.antonio.ballester.asensio@mariscal-roldán-and-borrell.es');
INSERT INTO tutores (f_alta, f_baja,id_empresa) VALUES ('2022-02-01', '2022-11-13','0');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('vanesa.de.briones', 'D5VLmAn*$s', 'Vanesa', 'de Briones', '79334915A', 'vanesa.de.briones@mariscal-roldán-and-borrell.es');
INSERT INTO tutores (f_alta, f_baja,id_empresa) VALUES ('2021-04-18', '2022-03-24','0');

INSERT INTO usuarios (nombre_usuario, contrasena, nombre, apellidos, DNI, correo) VALUES ('manuelita.rivera.macías', '+G&6DAu_!T', 'Manuelita', 'Rivera Macías', '06849967S', 'manuelita.rivera.macías@arévalo-ltd.es');
INSERT INTO tutores (f_alta, f_baja,id_empresa) VALUES ('2021-10-26', '2022-08-25','1');

