-- BIBLIOTECA_JEE.GENEROS definition

CREATE TABLE `GENEROS` (
  `id` smallint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);


-- BIBLIOTECA_JEE.PAISES definition

CREATE TABLE `PAISES` (
  `id` smallint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
);


-- BIBLIOTECA_JEE.USUARIOS definition

CREATE TABLE `USUARIOS` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `fecha_registro` date NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
);


-- BIBLIOTECA_JEE.AUTORES definition

CREATE TABLE `AUTORES` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `id_pais` smallint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_pais` (`id_pais`),
  CONSTRAINT `FK_AUTORES_PAISES` FOREIGN KEY (`id_pais`) REFERENCES `PAISES` (`id`)
);


-- BIBLIOTECA_JEE.LIBROS definition

CREATE TABLE `LIBROS` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  `id_autor` int DEFAULT NULL,
  `id_genero` smallint DEFAULT NULL,
  `id_pais_publicacion` smallint DEFAULT NULL,
  `fecha_publicacion` date DEFAULT NULL,
  `isbn` varchar(20) DEFAULT NULL,
  `sinopsis` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `isbn` (`isbn`),
  KEY `id_autor` (`id_autor`),
  KEY `id_genero` (`id_genero`),
  KEY `id_pais_publicacion` (`id_pais_publicacion`),
  CONSTRAINT `FK_LIBROS_AURORES` FOREIGN KEY (`id_autor`) REFERENCES `AUTORES` (`id`),
  CONSTRAINT `FK_LIBROS_GENEROS` FOREIGN KEY (`id_genero`) REFERENCES `GENEROS` (`id`),
  CONSTRAINT `FK_LIBROS_PAISES` FOREIGN KEY (`id_pais_publicacion`) REFERENCES `PAISES` (`id`)
);


-- BIBLIOTECA_JEE.PRESTAMOS definition

CREATE TABLE `PRESTAMOS` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_libro` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  `fecha_prestamo` date NOT NULL,
  `fecha_devolucion` date DEFAULT NULL,
  `devuelto` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id_libro` (`id_libro`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK_PRESTAMOS_LIBROS` FOREIGN KEY (`id_libro`) REFERENCES `LIBROS` (`id`),
  CONSTRAINT `FK_PRESTAMOS_USUARIOS` FOREIGN KEY (`id_usuario`) REFERENCES `USUARIOS` (`id`)
);


-- BIBLIOTECA_JEE.INVENTARIO definition

CREATE TABLE `INVENTARIO` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_libro` int DEFAULT NULL,
  `cantidad_ejemplares` int DEFAULT '0',
  `estante` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_libro` (`id_libro`,`estante`),
  CONSTRAINT `FK_INVENTARIO_LIBROS` FOREIGN KEY (`id_libro`) REFERENCES `LIBROS` (`id`)
);