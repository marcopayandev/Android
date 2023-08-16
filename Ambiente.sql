-- phpMyAdmin SQL Dump
-- version 5.2.0
-- httpswww.phpmyadmin.net
--
-- Servidor 127.0.0.1
-- Tiempo de generación 16-08-2023 a las 032100
-- Versión del servidor 10.4.24-MariaDB
-- Versión de PHP 8.1.6

SET SQL_MODE = NO_AUTO_VALUE_ON_ZERO;
START TRANSACTION;
SET time_zone = +0000;


!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT ;
!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS ;
!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION ;
!40101 SET NAMES utf8mb4 ;

--
-- Base de datos `backend`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prospecto`
--

CREATE TABLE `prospecto` (
  `id` int(11) NOT NULL,
  `apellidom` varchar(255) DEFAULT NULL,
  `apellidop` varchar(255) DEFAULT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `colonia` varchar(255) DEFAULT NULL,
  `cp` varchar(11) NOT NULL,
  `estatus` int(11) NOT NULL,
  `idarchivos` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numero` varchar(11) NOT NULL,
  `rfc` varchar(255) DEFAULT NULL,
  `telefono` varchar(13) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prospecto`
--

INSERT INTO `prospecto` (`id`, `apellidom`, `apellidop`, `calle`, `colonia`, `cp`, `estatus`, `idarchivos`, `nombre`, `numero`, `rfc`, `telefono`, `descripcion`) VALUES
(4, 'rayos', 'payan', 'Nevado de toluca', 'Villa bonita', '81470', 3, 1, 'marco', '102', 'parm960430gu1', '6731192437', 'as4d546');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `prospecto`
--
ALTER TABLE `prospecto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `prospecto`
--
ALTER TABLE `prospecto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT ;
!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS ;
!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION ;
