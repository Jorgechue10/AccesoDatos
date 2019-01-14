-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 14-01-2019 a las 15:02:36
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
-- Base de datos: `jorgedam`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`jorgedam`@`%` PROCEDURE `actualizaDept` (`cod` INT(2), `localidad` VARCHAR(13))  BEGIN
	UPDATE DEPT SET LOC=localidad WHERE DEPTNO = cod;
	END$$

CREATE DEFINER=`jorgedam`@`%` PROCEDURE `consultaDepar` (IN `NUM` INT(2), OUT `NAME` VARCHAR(14), OUT `LOCAL` VARCHAR(13))  BEGIN 
SELECT DNAME, LOC into NAME, LOCAL from DEPT where DEPTNO=NUM;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `BONUS`
--

CREATE TABLE `BONUS` (
  `ENAME` varchar(10) NOT NULL,
  `JOB` varchar(9) DEFAULT NULL,
  `SAL` int(11) DEFAULT NULL,
  `COMM` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DEPT`
--

CREATE TABLE `DEPT` (
  `DEPTNO` int(2) NOT NULL,
  `DNAME` varchar(14) DEFAULT NULL,
  `LOC` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `DEPT`
--

INSERT INTO `DEPT` (`DEPTNO`, `DNAME`, `LOC`) VALUES
(1, '1', '1'),
(2, '2', 'Tarazona'),
(3, '3', '3'),
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DUMMY`
--

CREATE TABLE `DUMMY` (
  `DUMMY` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `DUMMY`
--

INSERT INTO `DUMMY` (`DUMMY`) VALUES
(0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `EMP`
--

CREATE TABLE `EMP` (
  `EMPNO` int(4) NOT NULL,
  `ENAME` varchar(10) DEFAULT NULL,
  `JOB` varchar(9) DEFAULT NULL,
  `MGR` int(4) DEFAULT NULL,
  `HIREDATE` date DEFAULT NULL,
  `SAL` decimal(7,2) DEFAULT NULL,
  `COMM` decimal(7,2) DEFAULT NULL,
  `DEPTNO` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `EMP`
--

INSERT INTO `EMP` (`EMPNO`, `ENAME`, `JOB`, `MGR`, `HIREDATE`, `SAL`, `COMM`, `DEPTNO`) VALUES
(7369, 'SMITH', 'CLERK', 7902, '1980-12-17', '800.00', NULL, 20),
(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', '1600.00', '300.00', 30),
(7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', '1250.00', '500.00', 30),
(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', '2975.00', NULL, 20),
(7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', '1250.00', '1400.00', 30),
(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', '2850.00', NULL, 30),
(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', '2450.00', NULL, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', '3000.00', NULL, 20),
(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', '5000.00', NULL, 10),
(7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', '1500.00', '0.00', 30),
(7876, 'ADAMS', 'CLERK', 7788, '1983-01-12', '1100.00', NULL, 20),
(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', '950.00', NULL, 30),
(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', '3000.00', NULL, 20),
(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', '1300.00', NULL, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `SALGRADE`
--

CREATE TABLE `SALGRADE` (
  `GRADE` int(11) NOT NULL,
  `LOSAL` int(11) DEFAULT NULL,
  `HISAL` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `SALGRADE`
--

INSERT INTO `SALGRADE` (`GRADE`, `LOSAL`, `HISAL`) VALUES
(1, 700, 1200),
(2, 1201, 1400),
(3, 1401, 2000),
(4, 2001, 3000),
(5, 3001, 9999);

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
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `BONUS`
--
ALTER TABLE `BONUS`
  ADD PRIMARY KEY (`ENAME`);

--
-- Indices de la tabla `DEPT`
--
ALTER TABLE `DEPT`
  ADD PRIMARY KEY (`DEPTNO`);

--
-- Indices de la tabla `DUMMY`
--
ALTER TABLE `DUMMY`
  ADD PRIMARY KEY (`DUMMY`);

--
-- Indices de la tabla `EMP`
--
ALTER TABLE `EMP`
  ADD PRIMARY KEY (`EMPNO`),
  ADD KEY `DEPTNO` (`DEPTNO`);

--
-- Indices de la tabla `SALGRADE`
--
ALTER TABLE `SALGRADE`
  ADD PRIMARY KEY (`GRADE`);

--
-- Indices de la tabla `USUARIO`
--
ALTER TABLE `USUARIO`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `EMP`
--
ALTER TABLE `EMP`
  ADD CONSTRAINT `EMP_ibfk_1` FOREIGN KEY (`DEPTNO`) REFERENCES `DEPT` (`deptno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
