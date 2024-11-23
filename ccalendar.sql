-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-11-2024 a las 19:38:09
-- Versión del servidor: 10.10.2-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ccalendar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `attachments`
--

CREATE TABLE `attachments` (
  `idattachments` int(11) NOT NULL,
  `url` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `attachments`
--

INSERT INTO `attachments` (`idattachments`, `url`) VALUES
(12, 'https://example.com/attachment2'),
(15, 'https://example.com/attachment5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `event`
--

CREATE TABLE `event` (
  `idevent` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `hora` time NOT NULL,
  `day` date NOT NULL,
  `iduser` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `event`
--

INSERT INTO `event` (`idevent`, `title`, `hora`, `day`, `iduser`) VALUES
(14, 'Lanzamiento de producto', '09:30:00', '2024-12-01', 'user456'),
(17, 'Cena de gala', '20:00:00', '2024-12-05', 'user654');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `event_has_attachments`
--

CREATE TABLE `event_has_attachments` (
  `event_idevent` int(11) NOT NULL,
  `attachments_idattachments` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `event_has_attachments`
--

INSERT INTO `event_has_attachments` (`event_idevent`, `attachments_idattachments`) VALUES
(14, 12),
(17, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `event_has_notification`
--

CREATE TABLE `event_has_notification` (
  `event_idevent` int(11) NOT NULL,
  `notification_idnotification` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `event_has_notification`
--

INSERT INTO `event_has_notification` (`event_idevent`, `notification_idnotification`) VALUES
(14, 1),
(17, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notification`
--

CREATE TABLE `notification` (
  `idnotification` int(11) NOT NULL,
  `type` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `notification`
--

INSERT INTO `notification` (`idnotification`, `type`) VALUES
(1, '1 hora antes'),
(2, '40 minutos antes'),
(3, '5 minutos antes');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `attachments`
--
ALTER TABLE `attachments`
  ADD PRIMARY KEY (`idattachments`);

--
-- Indices de la tabla `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`idevent`);

--
-- Indices de la tabla `event_has_attachments`
--
ALTER TABLE `event_has_attachments`
  ADD PRIMARY KEY (`event_idevent`,`attachments_idattachments`),
  ADD KEY `fk_event_has_attachments_attachments1_idx` (`attachments_idattachments`),
  ADD KEY `fk_event_has_attachments_event1_idx` (`event_idevent`);

--
-- Indices de la tabla `event_has_notification`
--
ALTER TABLE `event_has_notification`
  ADD PRIMARY KEY (`event_idevent`,`notification_idnotification`),
  ADD KEY `fk_event_has_notification_notification1_idx` (`notification_idnotification`),
  ADD KEY `fk_event_has_notification_event_idx` (`event_idevent`);

--
-- Indices de la tabla `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`idnotification`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `attachments`
--
ALTER TABLE `attachments`
  MODIFY `idattachments` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `event`
--
ALTER TABLE `event`
  MODIFY `idevent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `notification`
--
ALTER TABLE `notification`
  MODIFY `idnotification` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `event_has_attachments`
--
ALTER TABLE `event_has_attachments`
  ADD CONSTRAINT `fk_event_has_attachments_attachments1` FOREIGN KEY (`attachments_idattachments`) REFERENCES `attachments` (`idattachments`),
  ADD CONSTRAINT `fk_event_has_attachments_event1` FOREIGN KEY (`event_idevent`) REFERENCES `event` (`idevent`) ON DELETE CASCADE;

--
-- Filtros para la tabla `event_has_notification`
--
ALTER TABLE `event_has_notification`
  ADD CONSTRAINT `fk_event_has_notification_event` FOREIGN KEY (`event_idevent`) REFERENCES `event` (`idevent`),
  ADD CONSTRAINT `fk_event_has_notification_notification1` FOREIGN KEY (`notification_idnotification`) REFERENCES `notification` (`idnotification`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
