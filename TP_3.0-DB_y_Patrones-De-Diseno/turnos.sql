-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-10-2022 a las 04:33:32
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `turnos`
--
CREATE DATABASE IF NOT EXISTS `turnos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `turnos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `id` int(11) NOT NULL,
  `matricula` int(11) NOT NULL,
  `especialidad` varchar(30) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `nacimiento` date NOT NULL,
  `direccion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `id` int(11) NOT NULL,
  `nroSocio` int(11) NOT NULL,
  `cobertura` varchar(30) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `nacimiento` date NOT NULL,
  `direccion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE `turno` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `especialidad` varchar(30) NOT NULL,
  `paciente` int(11) NOT NULL,
  `medico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_turno_paciente` (`paciente`),
  ADD KEY `fk_turno_medico` (`medico`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `medico`
--
ALTER TABLE `medico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `turno`
--
ALTER TABLE `turno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `turno`
--
ALTER TABLE `turno`
  ADD CONSTRAINT `fk_turno_medico` FOREIGN KEY (`medico`) REFERENCES `medico` (`id`),
  ADD CONSTRAINT `fk_turno_paciente` FOREIGN KEY (`paciente`) REFERENCES `paciente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
