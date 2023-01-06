CREATE TABLE `usuario` (
  `id_usuario` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_usuario` varchar(255) UNIQUE,
  `contrasena` varchar(255),
  `nombre` varchar(255),
  `apellidos` varchar(255),
  `DNI` varchar(255) UNIQUE,
  `correo` varchar(255) UNIQUE
);

CREATE TABLE `alumno` (
  `id_alumno` int PRIMARY KEY,
  `grado` varchar(255),
  `f_nacimiento` date,
  `telefono` varchar(255),
  `nota_exp` double,
  `horas_totales` int
);

CREATE TABLE `tutor` (
  `id_tutor` int PRIMARY KEY,
  `f_alta` date NOT NULL,
  `f_baja` date,
  `id_empresa` int
);

CREATE TABLE `responsable` (
  `id_responsable` int PRIMARY KEY,
  `f_alta` date NOT NULL,
  `f_baja` date
);

CREATE TABLE `empresa` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255),
  `sufijo_correo` varchar(255),
  `telefono` varchar(20),
  `direccion` varchar(255),
  `ciudad` varchar(100),
  `codigo_postal` int,
  `descripcion` varchar(255)
);

CREATE TABLE `oferta` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `puesto` varchar(255),
  `categoria` varchar(255),
  `id_empresa` int,
  `direccion` varchar(255),
  `requisitos` varchar(255),
  `descripcion` varchar(255),
  `horario` varchar(255),
  `semanas` int,
  `sueldo` double,
  `plazas` int,
  `f_inicio` date NOT NULL
);

CREATE TABLE `practica` (
  `id_practica` int PRIMARY KEY AUTO_INCREMENT,
  `id_alumno` int,
  `id_oferta` int,
  `nota` double,
  `informe` varchar(255),
  `f_inicio` date NOT NULL,
  `f_fin` date
);

CREATE TABLE `solicitud_practicas` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `id_alumno` int,
  `id_oferta` int,
  `preferencia` int
);

ALTER TABLE `alumno` ADD FOREIGN KEY (`id_alumno`) REFERENCES `usuario` (`id_usuario`);

ALTER TABLE `tutor` ADD FOREIGN KEY (`id_tutor`) REFERENCES `usuario` (`id_usuario`);

ALTER TABLE `responsable` ADD FOREIGN KEY (`id_responsable`) REFERENCES `usuario` (`id_usuario`);

ALTER TABLE `oferta` ADD FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`);

ALTER TABLE `tutor` ADD FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`);

ALTER TABLE `practica` ADD FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`);

ALTER TABLE `practica` ADD FOREIGN KEY (`id_oferta`) REFERENCES `oferta` (`id`);

ALTER TABLE `solicitud_practicas` ADD FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`);

ALTER TABLE `solicitud_practicas` ADD FOREIGN KEY (`id_oferta`) REFERENCES `oferta` (`id`);
