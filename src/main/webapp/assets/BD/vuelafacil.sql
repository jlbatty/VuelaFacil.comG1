-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-09-2021 a las 04:16:09
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
-- Estructura de tabla para la tabla `asiento`
--

CREATE TABLE `asiento` (
  `idAsiento` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `categoria` varchar(10) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asientosreservados`
--

CREATE TABLE `asientosreservados` (
  `idAsientoReservado` int(11) NOT NULL,
  `idAsientoAsoc` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `idVueloAsoc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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
  `capacidadEconomica` int(11) NOT NULL,
  `totalDisponible` int(11) NOT NULL,
  `ejecutivaDisponible` int(11) NOT NULL,
  `economicaDisponible` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `numeroDocumento` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `tipoDocumento` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `nombres` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `correoElectronico` varchar(250) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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
  `tarifa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifas`
--

CREATE TABLE `tarifas` (
  `codigoTarifa` int(11) NOT NULL,
  `nombreTarifa` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `precioTarifa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelo`
--

CREATE TABLE `vuelo` (
  `idVuelo` int(11) NOT NULL,
  `fechaVuelo` datetime NOT NULL,
  `tiempoEstimado` time NOT NULL,
  `distancia` float NOT NULL,
  `codigoReservaAsoc` int(11) NOT NULL,
  `matriculaAvion` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `codigoRutaAsoc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asiento`
--
ALTER TABLE `asiento`
  ADD PRIMARY KEY (`idAsiento`);

--
-- Indices de la tabla `asientosreservados`
--
ALTER TABLE `asientosreservados`
  ADD PRIMARY KEY (`idAsientoReservado`),
  ADD KEY `idAsientoAsoc` (`idAsientoAsoc`),
  ADD KEY `idVueloAsoc` (`idVueloAsoc`);

--
-- Indices de la tabla `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`matricula`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`numeroDocumento`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`codigoReserva`),
  ADD KEY `codigoReserva_2` (`codigoReserva`),
  ADD KEY `documentoCliente` (`documentoCliente`),
  ADD KEY `tarifa` (`tarifa`);

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
  ADD KEY `codigoReservaAsoc` (`codigoReservaAsoc`),
  ADD KEY `matriculaAvion` (`matriculaAvion`),
  ADD KEY `codigoRutaAsoc` (`codigoRutaAsoc`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asientosreservados`
--
ALTER TABLE `asientosreservados`
  MODIFY `idAsientoReservado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `codigoReserva` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rutas`
--
ALTER TABLE `rutas`
  MODIFY `codigoRuta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tarifas`
--
ALTER TABLE `tarifas`
  MODIFY `codigoTarifa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  MODIFY `idVuelo` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asientosreservados`
--
ALTER TABLE `asientosreservados`
  ADD CONSTRAINT `asientosreservados_ibfk_1` FOREIGN KEY (`idVueloAsoc`) REFERENCES `vuelo` (`idVuelo`) ON DELETE NO ACTION,
  ADD CONSTRAINT `asientosreservados_ibfk_2` FOREIGN KEY (`idAsientoAsoc`) REFERENCES `asiento` (`idAsiento`) ON DELETE NO ACTION;

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`tarifa`) REFERENCES `tarifas` (`codigoTarifa`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`documentoCliente`) REFERENCES `cliente` (`numeroDocumento`) ON DELETE NO ACTION;

--
-- Filtros para la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD CONSTRAINT `vuelo_ibfk_1` FOREIGN KEY (`codigoReservaAsoc`) REFERENCES `reserva` (`codigoReserva`) ON DELETE NO ACTION,
  ADD CONSTRAINT `vuelo_ibfk_2` FOREIGN KEY (`matriculaAvion`) REFERENCES `avion` (`matricula`) ON DELETE NO ACTION,
  ADD CONSTRAINT `vuelo_ibfk_3` FOREIGN KEY (`codigoRutaAsoc`) REFERENCES `rutas` (`codigoRuta`) ON DELETE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
