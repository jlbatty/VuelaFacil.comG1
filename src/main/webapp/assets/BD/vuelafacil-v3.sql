-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-10-2021 a las 01:23:37
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vuelafacil`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `avion`
--

CREATE TABLE `avion` (
  `matricula` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `marca` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `modelo` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `capacidadTotal` int(11) NOT NULL,
  `capacidadEjecutiva` int(11) NOT NULL,
  `capacidadEconomica` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `avion`
--

INSERT INTO `avion` (`matricula`, `marca`, `modelo`, `capacidadTotal`, `capacidadEjecutiva`, `capacidadEconomica`) VALUES
('HK-5001', 'Boeing Inc.', '787', 250, 50, 200),
('HK-5002', 'Airbus S.A.S', 'A330', 252, 30, 222),
('HK-5003', 'Airbus S.A.S', 'A330', 252, 30, 222),
('HK-5004', 'Airbus S.A.S', 'A321', 194, 12, 182),
('HK-5005', 'Airbus S.A.S', 'A321', 194, 12, 182);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `numerodocumento` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `tipoDocumento` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `nombres` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `correoElectronico` varchar(250) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`numerodocumento`, `tipoDocumento`, `nombres`, `apellidos`, `telefono`, `correoElectronico`) VALUES
('1098456789', 'CC', 'Ramiro', 'Camacho Anguita', '3171234567', 'ramicamacho@email.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `codigoReserva` int(11) NOT NULL,
  `solo_Ida` tinyint(1) NOT NULL,
  `cantidadPasajeros` int(11) NOT NULL,
  `adultos` int(11) NOT NULL,
  `infantes` int(11) NOT NULL,
  `documentoCliente` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `tarifa` int(11) NOT NULL,
  `codigoVueloAsoc` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`codigoReserva`, `solo_Ida`, `cantidadPasajeros`, `adultos`, `infantes`, `documentoCliente`, `tarifa`, `codigoVueloAsoc`) VALUES
(1, 1, 1, 1, 0, '1098456789', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutas`
--

CREATE TABLE `rutas` (
  `codigoRuta` int(11) NOT NULL,
  `salida` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `IATAsalida` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `destino` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `IATAdestino` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `tiempoAprox` time NOT NULL,
  `distancia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `rutas`
--

INSERT INTO `rutas` (`codigoRuta`, `salida`, `IATAsalida`, `destino`, `IATAdestino`, `tiempoAprox`, `distancia`) VALUES
(1, 'Bucaramanga, Colombia - Palonegro', 'BGA', 'Bogotá, Colombia - El Dorado', 'BOG', '00:49:00', 287.12),
(2, 'Bogotá, Colombia - El Dorado', 'BOG', 'Bucaramanga, Colombia - Palonegro', 'BGA', '00:49:00', 287.12),
(3, 'Bogotá, Colombia - El Dorado', 'BOG', 'Barranquilla, Colombia - Ernesto Cortissoz', 'BAQ', '01:25:00', 702.38),
(4, 'Barranquilla, Colombia - Ernesto Cortissoz', 'BAQ', 'Bogotá, Colombia - El Dorado', 'BOG', '01:25:00', 702.38),
(5, 'Bogotá, Colombia - El Dorado', 'BOG', 'Cartagena, Colombia - Rafael Nuñez', 'CTG', '01:21:00', 648.85),
(6, 'Cartagena, Colombia - Rafael Nuñez', 'CTG', 'Bogotá, Colombia - El Dorado', 'BOG', '01:21:00', 648.85),
(7, 'Bogotá, Colombia - El Dorado', 'BOG', 'Cali, Colombia - Alfonso Bonilla Aragón', 'CLO', '00:51:00', 306.86),
(8, 'Cali, Colombia - Alfonso Bonilla Aragón', 'CLO', 'Bogotá, Colombia - El Dorado', 'BOG', '00:51:00', 306.86),
(9, 'Bogotá, Colombia - El Dorado', 'BOG', 'Medellín, Colombia - José María Córdova', 'MDE', '00:45:00', 238.57),
(10, 'Medellín, Colombia - José María Córdova', 'MDE', 'Bogotá, Colombia - El Dorado', 'BOG', '00:45:00', 238.57),
(11, 'Bucaramanga, Colombia - Palonegro', 'BGA', 'Medellín, Colombia - José María Córdova', 'MDE', '00:20:00', 270),
(12, 'Bucaramanga, Colombia - Palonegro', 'BGA', 'Cali, Colombia - Alfonso Bonilla Aragón', 'CLO', '00:39:00', 533),
(13, 'Cali, Colombia - Alfonso Bonilla Aragón', 'CLO', 'Bucaramanga, Colombia - Palonegro', 'BGA', '00:39:00', 533),
(14, 'Cali, Colombia - Alfonso Bonilla Aragón', 'CLO', 'Medellín, Colombia - José María Córdova', 'MDE', '00:23:00', 311),
(15, 'Medellín, Colombia - José María Córdova', 'MDE', 'Bucaramanga, Colombia - Palonegro', 'BGA', '00:20:00', 270),
(16, 'Medellín, Colombia - José María Córdova', 'MDE', 'Cali, Colombia - Alfonso Bonilla Aragón', 'CLO', '00:23:00', 311);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifas`
--

CREATE TABLE `tarifas` (
  `codigoTarifa` int(11) NOT NULL,
  `nombreTarifa` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `precioTarifa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tarifas`
--

INSERT INTO `tarifas` (`codigoTarifa`, `nombreTarifa`, `precioTarifa`) VALUES
(1, 'Económica', 384),
(2, 'Ejecutiva', 960);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelo`
--

CREATE TABLE `vuelo` (
  `idVuelo` int(11) NOT NULL,
  `fechaVuelo` datetime NOT NULL,
  `matriculaAvion` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `codigoRutaAsoc` int(11) NOT NULL,
  `ejecutivaDisponible` int(11) NOT NULL,
  `economicaDisponible` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `vuelo`
--

INSERT INTO `vuelo` (`idVuelo`, `fechaVuelo`, `matriculaAvion`, `codigoRutaAsoc`, `ejecutivaDisponible`, `economicaDisponible`) VALUES
(2, '2021-10-01 08:00:00', 'HK-5001', 1, 50, 200),
(3, '2021-10-02 23:20:00', 'HK-5002', 5, 30, 222),
(4, '2021-10-02 08:00:00', 'HK-5002', 6, 30, 222),
(5, '2021-10-02 09:00:00', 'HK-5003', 5, 30, 222),
(6, '2021-10-02 11:00:00', 'HK-5002', 5, 30, 222),
(7, '2021-10-02 14:07:13', 'HK-5003', 5, 30, 222),
(8, '2021-10-02 17:28:04', 'HK-5001', 5, 50, 200),
(9, '2021-10-03 06:28:32', 'HK-5002', 5, 30, 222),
(10, '2021-10-03 10:29:19', 'HK-5002', 5, 30, 222),
(11, '2021-10-03 16:30:05', 'HK-5003', 5, 30, 222),
(12, '2021-10-03 08:17:53', 'HK-5005', 9, 12, 182);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`matricula`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`numerodocumento`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`codigoReserva`),
  ADD KEY `codigoReserva_2` (`codigoReserva`),
  ADD KEY `documentoCliente` (`documentoCliente`),
  ADD KEY `tarifa` (`tarifa`),
  ADD KEY `idVuelo` (`codigoVueloAsoc`);

--
-- Indices de la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD PRIMARY KEY (`codigoRuta`);

--
-- Indices de la tabla `tarifas`
--
ALTER TABLE `tarifas`
  ADD PRIMARY KEY (`codigoTarifa`);

--
-- Indices de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD PRIMARY KEY (`idVuelo`),
  ADD KEY `matriculaAvion` (`matriculaAvion`),
  ADD KEY `codigoRutaAsoc` (`codigoRutaAsoc`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `codigoReserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `rutas`
--
ALTER TABLE `rutas`
  MODIFY `codigoRuta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `tarifas`
--
ALTER TABLE `tarifas`
  MODIFY `codigoTarifa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  MODIFY `idVuelo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `idVuelo` FOREIGN KEY (`codigoVueloAsoc`) REFERENCES `vuelo` (`idVuelo`),
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`tarifa`) REFERENCES `tarifas` (`codigoTarifa`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`documentoCliente`) REFERENCES `cliente` (`numerodocumento`) ON DELETE NO ACTION;

--
-- Filtros para la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD CONSTRAINT `vuelo_ibfk_2` FOREIGN KEY (`matriculaAvion`) REFERENCES `avion` (`matricula`) ON DELETE NO ACTION,
  ADD CONSTRAINT `vuelo_ibfk_3` FOREIGN KEY (`codigoRutaAsoc`) REFERENCES `rutas` (`codigoRuta`) ON DELETE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
