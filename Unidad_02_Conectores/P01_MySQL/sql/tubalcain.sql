-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 14-01-2019 a las 15:04:39
-- Versión del servidor: 8.0.13
-- Versión de PHP: 7.2.10-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tubalcain`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`tubalcain_dam`@`%` PROCEDURE `datos_dep` (`d` INT, OUT `nombre` VARCHAR(15), OUT `localidad` VARCHAR(15))  BEGIN
	SET nombre = 'NO EXISTE';
	SET localidad = 'NO EXISTE';
	SELECT dnombre, loc INTO nombre, localidad FROM departamentos
	WHERE dpto_no = d;
END$$

CREATE DEFINER=`tubalcain_dam`@`%` PROCEDURE `datos_dep_alex` (`d` INT, OUT `nombre` VARCHAR(15), OUT `localidad` VARCHAR(15))  BEGIN
	SET nombre = 'NO EXISTE';
	SET localidad = 'NO EXISTE';
	SELECT dnombre, loc INTO nombre, localidad FROM departamentos
	WHERE dpto_no = d;
END$$

CREATE DEFINER=`tubalcain_dam`@`%` PROCEDURE `datos_dep_jorge` (`d` INT, OUT `nombre` VARCHAR(15), OUT `localidad` VARCHAR(15))  BEGIN
	SET nombre = 'NO EXISTE';
	SET localidad = 'NO EXISTE';
	SELECT dnombre, loc INTO nombre, localidad FROM departamentos
	WHERE dpto_no = d;
END$$

CREATE DEFINER=`tubalcain_dam`@`%` PROCEDURE `datos_dep_oscar` (`d` INT, OUT `nombre` VARCHAR(15), OUT `localidad` VARCHAR(15))  BEGIN
	SET nombre = 'NO EXISTE';
	SET localidad = 'NO EXISTE';
	SELECT dnombre, loc INTO nombre, localidad FROM departamentos
	WHERE dpto_no = d;
END$$

CREATE DEFINER=`tubalcain_dam`@`%` PROCEDURE `datos_dep_toni` (`d` INT, OUT `nombre` VARCHAR(15), OUT `localidad` VARCHAR(15))  BEGIN
	SET nombre = 'NO EXISTE';
	SET localidad = 'NO EXISTE';
	SELECT dnombre, loc INTO nombre, localidad FROM departamentos
	WHERE dpto_no = d;
END$$

CREATE DEFINER=`tubalcain_dam`@`%` PROCEDURE `subida_sal_alex` (`d` INT, `subida` INT)  BEGIN
UPDATE empleados SET salario = salario + subida WHERE dpto_no = d;
COMMIT;
END$$

CREATE DEFINER=`tubalcain_dam`@`%` PROCEDURE `subida_sal_jorge` (`d` INT, `subida` INT)  BEGIN
UPDATE empleados SET salario = salario + subida WHERE dpto_no = d;
COMMIT;
END$$

CREATE DEFINER=`tubalcain_dam`@`%` PROCEDURE `subida_sal_oscar` (`d` INT, `subida` INT)  BEGIN
UPDATE empleados SET salario = salario + subida WHERE dpto_no = d;
COMMIT;
END$$

CREATE DEFINER=`tubalcain_dam`@`%` PROCEDURE `subida_sal_toni` (`d` INT, `subida` INT)  BEGIN
UPDATE empleados SET salario = salario + subida WHERE dpto_no = d;
COMMIT;
END$$

--
-- Funciones
--
CREATE DEFINER=`tubalcain_dam`@`%` FUNCTION `nombre_dep_alex` (`d` INT) RETURNS VARCHAR(15) CHARSET utf8mb4 BEGIN
	DECLARE nombre VARCHAR(15);
	SET nombre = 'NO EXISTE';
	SELECT dnombre INTO nombre FROM departamentos
	WHERE dpto_no = d;
	RETURN NOMBRE;
END$$

CREATE DEFINER=`tubalcain_dam`@`%` FUNCTION `nombre_dep_fran` (`d` INT) RETURNS VARCHAR(15) CHARSET utf8mb4 BEGIN
	DECLARE nombre VARCHAR(15);
	SET nombre = 'NO EXISTE';
	SELECT dnombre INTO nombre FROM departamentos
	WHERE dpto_no = d;
	RETURN NOMBRE;
END$$

CREATE DEFINER=`tubalcain_dam`@`%` FUNCTION `nombre_dep_jorge` (`d` INT) RETURNS VARCHAR(15) CHARSET utf8mb4 BEGIN
	DECLARE nombre VARCHAR(15);
	SET nombre = 'NO EXISTE';
	SELECT dnombre INTO nombre FROM departamentos
	WHERE dpto_no = d;
	RETURN NOMBRE;
END$$

CREATE DEFINER=`tubalcain_dam`@`%` FUNCTION `nombre_dep_oscar` (`d` INT) RETURNS VARCHAR(15) CHARSET utf8mb4 BEGIN
	DECLARE nombre VARCHAR(15);
	SET nombre = 'NO EXISTE';
	SELECT dnombre INTO nombre FROM departamentos
	WHERE dpto_no = d;
	RETURN NOMBRE;
END$$

CREATE DEFINER=`tubalcain_dam`@`%` FUNCTION `nombre_dep_toni` (`d` INT) RETURNS VARCHAR(15) CHARSET utf8mb4 BEGIN
	DECLARE nombre VARCHAR(15);
	SET nombre = 'NO EXISTE';
	SELECT dnombre INTO nombre FROM departamentos
	WHERE dpto_no = d;
	RETURN NOMBRE;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE `departamentos` (
  `dnombre` varchar(15) NOT NULL,
  `dpto_no` int(11) NOT NULL,
  `loc` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`dnombre`, `dpto_no`, `loc`) VALUES
('Taller', 87, 'Monteagudo'),
('informatica', 10, 'tarazona'),
('Marketing', 15, 'Malon'),
('RRHH', 7, 'Novallas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellidos` varchar(25) DEFAULT NULL,
  `salario` int(11) DEFAULT NULL,
  `dpto_no` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`dni`, `nombre`, `apellidos`, `salario`, `dpto_no`) VALUES
('0000000A', 'Felipe Juan', 'de Borbon', 1100, 5),
('12345678L', 'Armando', 'Bronca Segura', -897900, 0),
('69696969', 'Alfredo', 'Reyes', 1000600, 3),
('74693189K', 'pepe', 'el cejas', 1408010250, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `REGISTRATION`
--

CREATE TABLE `REGISTRATION` (
  `id` int(11) NOT NULL,
  `first` varchar(255) DEFAULT NULL,
  `last` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `REGISTRATION`
--

INSERT INTO `REGISTRATION` (`id`, `first`, `last`, `age`) VALUES
(1, 'Benito', 'Camela', 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `USUARIO`
--

CREATE TABLE `USUARIO` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `USUARIO`
--

INSERT INTO `USUARIO` (`id`, `nombre`, `apellido`, `edad`) VALUES
(1, 'Benito', 'Camela', 25),
(2, 'Joseba', 'Jartangas', 69),
(4, 'Jony', 'Melavo', 25),
(7, 'Aquiles', 'Castro', 22),
(8, 'Dolores', 'Fuertes de Barriga', 41),
(17, 'Armando', 'Guerra', 45),
(24, 'Tomas', 'Sardinas', 50),
(37, 'Alberto', 'Cadiscos', 37),
(40, 'Aitor', 'Tazo', 28),
(47, 'Esther', 'Colero del Pueblo', 57),
(54, 'Armando', 'Juerga', 71),
(57, 'Leandro ', 'Gado', 25),
(79, 'Pere', 'Gil', 35),
(90, 'Castro', 'Mascota', 41),
(100, 'Aitor', 'Tilla', 50),
(129, 'Tomas', 'Albino', 26),
(625, 'Tomas', 'Turbado', 100);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `REGISTRATION`
--
ALTER TABLE `REGISTRATION`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `USUARIO`
--
ALTER TABLE `USUARIO`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
