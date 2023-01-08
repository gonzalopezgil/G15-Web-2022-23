CREATE TABLE `usuario` (
  `id_usuario` bigint PRIMARY KEY AUTO_INCREMENT,
  `nombre_usuario` varchar(255) UNIQUE,
  `contrasena` varchar(255),
  `nombre` varchar(255),
  `apellidos` varchar(255),
  `DNI` varchar(255) UNIQUE,
  `correo` varchar(255) UNIQUE
);

CREATE TABLE `alumno` (
  `id_usuario` bigint PRIMARY KEY,
  `grado` varchar(255),
  `f_nacimiento` date,
  `telefono` varchar(255),
  `nota_exp` double,
  `horas_totales` int
);

CREATE TABLE `tutor` (
  `id_usuario` bigint PRIMARY KEY,
  `f_alta` date NOT NULL,
  `f_baja` date,
  `id_empresa` bigint
);

CREATE TABLE `responsable` (
  `id_usuario` bigint PRIMARY KEY,
  `f_alta` date NOT NULL,
  `f_baja` date
);

CREATE TABLE `empresa` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255),
  `sufijo_correo` varchar(255),
  `telefono` varchar(20),
  `direccion` varchar(255),
  `ciudad` varchar(100),
  `codigo_postal` int,
  `descripcion` varchar(255)
);

CREATE TABLE `oferta` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `puesto` varchar(255),
  `categoria` varchar(255),
  `id_empresa` bigint,
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
  `id_practica` bigint PRIMARY KEY AUTO_INCREMENT,
  `id_alumno` bigint,
  `id_oferta` bigint,
  `nota` double,
  `informe` varchar(255),
  `f_inicio` date NOT NULL,
  `f_fin` date
);

CREATE TABLE `solicitud_practicas` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `id_alumno` bigint,
  `id_oferta` bigint,
  `preferencia` int
);

ALTER TABLE `alumno` ADD FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `tutor` ADD FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `responsable` ADD FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `oferta` ADD FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `tutor` ADD FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `practica` ADD FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `practica` ADD FOREIGN KEY (`id_oferta`) REFERENCES `oferta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `solicitud_practicas` ADD FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_usuario`)  ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `solicitud_practicas` ADD FOREIGN KEY (`id_oferta`) REFERENCES `oferta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;