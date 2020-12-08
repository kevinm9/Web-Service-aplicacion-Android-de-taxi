-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 04-01-2020 a las 02:29:47
-- Versión del servidor: 10.3.16-MariaDB
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_mensaje`
--

CREATE TABLE `tbl_mensaje` (
  `id_mensaje` int(10) NOT NULL,
  `remitente` int(10) NOT NULL,
  `destinatario` int(10) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp(),
  `asunto` varchar(30) COLLATE utf8_bin NOT NULL,
  `contenido` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_ruta`
--

CREATE TABLE `tbl_ruta` (
  `id_ruta` int(10) NOT NULL,
  `lugar_desde` varchar(30) COLLATE utf8_bin NOT NULL,
  `lugar_hasta` varchar(30) COLLATE utf8_bin NOT NULL,
  `precio` varchar(10) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `tbl_ruta`
--

INSERT INTO `tbl_ruta` (`id_ruta`, `lugar_desde`, `lugar_hasta`, `precio`) VALUES
(1, 'san eduardo', 'portete', '5'),
(10, 'Babahoyo', 'Durán', '7'),
(15, 'Babahoyo', 'Gye', '30'),
(19, 'Centro ', 'Mapasingue ', '$5'),
(20, 'Bastión Popular ', 'Guasmo Sur', '15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuario`
--

CREATE TABLE `tbl_usuario` (
  `id_usuario` int(10) NOT NULL,
  `cedula` varchar(10) COLLATE utf8_bin NOT NULL,
  `nombres` varchar(50) COLLATE utf8_bin NOT NULL,
  `apellidos` varchar(50) COLLATE utf8_bin NOT NULL,
  `correo` varchar(50) COLLATE utf8_bin NOT NULL,
  `celular` varchar(10) COLLATE utf8_bin NOT NULL,
  `user` varchar(20) COLLATE utf8_bin NOT NULL,
  `clave` varchar(8) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `tbl_usuario`
--

INSERT INTO `tbl_usuario` (`id_usuario`, `cedula`, `nombres`, `apellidos`, `correo`, `celular`, `user`, `clave`) VALUES
(2, '952726461', 'Gabriel', 'Chora', 'agabriel98@hotmail.com', '959796432', 'Aser', '1235'),
(86, '098567', 'Erick', 'Barrera ', 'Jdkfn', '0986588', 'Ebarrera', '1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_vehiculo`
--

CREATE TABLE `tbl_vehiculo` (
  `id_vehiculo` int(10) NOT NULL,
  `id_usuario` int(10) NOT NULL,
  `matricula` varchar(10) COLLATE utf8_bin NOT NULL,
  `modelo` varchar(50) COLLATE utf8_bin NOT NULL,
  `anio` varchar(4) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `tbl_vehiculo`
--

INSERT INTO `tbl_vehiculo` (`id_vehiculo`, `id_usuario`, `matricula`, `modelo`, `anio`) VALUES
(34, 86, 'Asd123', 'Chevrolet ', '2013'),
(36, 2, 'ABC258', 'Mazda', '2015');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_viaje`
--

CREATE TABLE `tbl_viaje` (
  `id_viaje` int(10) NOT NULL,
  `id_chofer` int(10) NOT NULL,
  `id_pasajero` int(10) NOT NULL,
  `id_ruta` int(10) NOT NULL,
  `fecha` varchar(25) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `tbl_viaje`
--

INSERT INTO `tbl_viaje` (`id_viaje`, `id_chofer`, `id_pasajero`, `id_ruta`, `fecha`) VALUES
(48, 86, 86, 1, '2019-09-13 14:56:56'),
(49, 86, 2, 10, '2019-09-13 15:11:47'),
(53, 2, 86, 15, '2019-09-13 15:14:01'),
(55, 86, 2, 15, '2019-09-13 21:23:04');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_mensaje`
--
ALTER TABLE `tbl_mensaje`
  ADD PRIMARY KEY (`id_mensaje`),
  ADD KEY `tbl_mensaje_ibfk_1` (`remitente`),
  ADD KEY `tbl_mensaje_ibfk_2` (`destinatario`);

--
-- Indices de la tabla `tbl_ruta`
--
ALTER TABLE `tbl_ruta`
  ADD PRIMARY KEY (`id_ruta`);

--
-- Indices de la tabla `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`id_usuario`,`cedula`),
  ADD UNIQUE KEY `nombre_usuario` (`user`),
  ADD UNIQUE KEY `correo` (`correo`),
  ADD UNIQUE KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `tbl_vehiculo`
--
ALTER TABLE `tbl_vehiculo`
  ADD PRIMARY KEY (`id_vehiculo`,`matricula`),
  ADD UNIQUE KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `tbl_viaje`
--
ALTER TABLE `tbl_viaje`
  ADD PRIMARY KEY (`id_viaje`),
  ADD KEY `id_pasajero` (`id_pasajero`),
  ADD KEY `id_ruta` (`id_ruta`),
  ADD KEY `id_vehiculo` (`id_chofer`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_mensaje`
--
ALTER TABLE `tbl_mensaje`
  MODIFY `id_mensaje` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_ruta`
--
ALTER TABLE `tbl_ruta`
  MODIFY `id_ruta` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  MODIFY `id_usuario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87;

--
-- AUTO_INCREMENT de la tabla `tbl_vehiculo`
--
ALTER TABLE `tbl_vehiculo`
  MODIFY `id_vehiculo` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `tbl_viaje`
--
ALTER TABLE `tbl_viaje`
  MODIFY `id_viaje` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_mensaje`
--
ALTER TABLE `tbl_mensaje`
  ADD CONSTRAINT `tbl_mensaje_ibfk_1` FOREIGN KEY (`remitente`) REFERENCES `tbl_usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_mensaje_ibfk_2` FOREIGN KEY (`destinatario`) REFERENCES `tbl_usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_vehiculo`
--
ALTER TABLE `tbl_vehiculo`
  ADD CONSTRAINT `tbl_vehiculo_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `tbl_usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_viaje`
--
ALTER TABLE `tbl_viaje`
  ADD CONSTRAINT `tbl_viaje_ibfk_1` FOREIGN KEY (`id_pasajero`) REFERENCES `tbl_usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_viaje_ibfk_2` FOREIGN KEY (`id_ruta`) REFERENCES `tbl_ruta` (`id_ruta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_viaje_ibfk_3` FOREIGN KEY (`id_chofer`) REFERENCES `tbl_vehiculo` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
