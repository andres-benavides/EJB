-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-10-2015 a las 14:03:39
-- Versión del servidor: 5.6.14
-- Versión de PHP: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `proyectoestampate`
--
CREATE DATABASE IF NOT EXISTS `proyectoestampate` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `proyectoestampate`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE IF NOT EXISTS `administrador` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(30) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id_admin`, `usuario`, `password`) VALUES
(1, 'root', '1nt3r4ct1v3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artista`
--

CREATE TABLE IF NOT EXISTS `artista` (
  `id_artista` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `direccion` varchar(30) DEFAULT NULL,
  `cedula` varchar(10) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `usuario` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_artista`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Volcado de datos para la tabla `artista`
--

INSERT INTO `artista` (`id_artista`, `nombre`, `apellido`, `direccion`, `cedula`, `celular`, `usuario`, `password`) VALUES
(1, 'breinner', 'buitrago', 'calle 50', '1014785276', '2147483647', 'bbuitrago', 'ee2b7aa8129fcb0bba7e2ca8c4e6d2'),
(2, 'wilson', 'naranjo', 'calle 20', '1014250094', '2147483647', 'wnaranjo', 'b9f9610e7505eb5a99cf0a81e966d4'),
(11, 'Don Artista', 'Maximo', 'carrera 139 # 139-24', '1015426224', '3125270304', 'admin', '123'),
(12, 'Laura', 'valencia', 'cra 139 # 139-24', '5', '10', 'admin4', '71421'),
(13, 'Estaban', 'ruin', 'carrera 139 No 139 24', '14', '9', 'admin5', '666'),
(14, 'hernando', 'Benavides', 'carrera 139 # 139-24', '1242354', '455', 'admins', 's'),
(15, 'Pedrito', 'Cesarito', 'calle falsa 123', '1015426224', '3125270304', 'don pedris', 'juantaco'),
(16, 'fabian', 'valencia', 'cra 139 # 139-24', '1242354', '3127732443', 'SuperUser', '0000'),
(17, 'EJB', 'EJB', 'cra 139 # 139-24', '1', '1', 'locx', '23rdfd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `camiseta`
--

CREATE TABLE IF NOT EXISTS `camiseta` (
  `id_camiseta` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `id_estampa_camiseta` int(11) NOT NULL,
  `id_precio_camiseta` int(11) NOT NULL,
  `id_talla` int(11) NOT NULL,
  `id_color` int(11) NOT NULL,
  `id_material` int(11) NOT NULL,
  `id_lugar_estampa_camiseta` int(11) NOT NULL,
  `id_texto_camiseta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_camiseta`),
  KEY `CAMISETA_FK_1` (`id_estampa_camiseta`),
  KEY `CAMISETA_FK_2` (`id_precio_camiseta`),
  KEY `CAMISETA_FK_3` (`id_talla`),
  KEY `CAMISETA_FK_4` (`id_color`),
  KEY `CAMISETA_FK_5` (`id_material`),
  KEY `CAMISETA_FK_6` (`id_lugar_estampa_camiseta`),
  KEY `CAMISETA_FK_7` (`id_texto_camiseta`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `camiseta`
--

INSERT INTO `camiseta` (`id_camiseta`, `cantidad`, `id_estampa_camiseta`, `id_precio_camiseta`, `id_talla`, `id_color`, `id_material`, `id_lugar_estampa_camiseta`, `id_texto_camiseta`) VALUES
(1, 5, 1, 1, 1, 1, 1, 1, 1),
(2, 6, 2, 2, 2, 2, 2, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `color_camiseta`
--

CREATE TABLE IF NOT EXISTS `color_camiseta` (
  `id_color` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(30) NOT NULL,
  PRIMARY KEY (`id_color`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `color_camiseta`
--

INSERT INTO `color_camiseta` (`id_color`, `color`) VALUES
(1, 'Blanco'),
(2, 'Negro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprador`
--

CREATE TABLE IF NOT EXISTS `comprador` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `direccion` varchar(30) DEFAULT NULL,
  `cedula` varchar(10) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Volcado de datos para la tabla `comprador`
--

INSERT INTO `comprador` (`id_cliente`, `nombre`, `apellido`, `direccion`, `cedula`, `celular`, `usuario`, `password`) VALUES
(1, 'breinner', 'buitrago', 'calle 50', '1014785276', '2147483647', 'bbuitrago', 'ee2b7aa8129fcb0bba7e2ca8c4e6d2'),
(2, 'wilson', 'naranjo', 'calle 20', '1014250094', '2147483647', 'wnaranjo', 'b9f9610e7505eb5a99cf0a81e966d4'),
(12, 'Andres', 'Bermudez', 'cra 139 # 139-24', '1015426224', '3125270304', 'admin', '123'),
(13, 'fabian', 'valencia', 'cra 139 # 139-24', '1015426224', '312542262', 'admin1', '123'),
(14, 'Christopher', 'Foca', 'otra calle cerca', '1015426224', '3141341344', 'batman', '71421');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estampa_camiseta`
--

CREATE TABLE IF NOT EXISTS `estampa_camiseta` (
  `id_estampa_camiseta` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) NOT NULL,
  `imagenes` varchar(30) NOT NULL,
  `ubicacion` varchar(30) NOT NULL,
  `precio` varchar(100) NOT NULL,
  `id_artista` int(11) NOT NULL,
  `id_tema_estampa` int(11) NOT NULL,
  `id_tamano_estampa` int(11) NOT NULL,
  `id_lugar_estampa` int(11) NOT NULL,
  PRIMARY KEY (`id_estampa_camiseta`),
  KEY `ESTAMPA_CAMISETA_FK_1` (`id_tema_estampa`),
  KEY `ESTAMPA_CAMISETA_FK_2` (`id_tamano_estampa`),
  KEY `ESTAMPA_CAMISETA_FK_4` (`id_artista`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=49 ;

--
-- Volcado de datos para la tabla `estampa_camiseta`
--

INSERT INTO `estampa_camiseta` (`id_estampa_camiseta`, `descripcion`, `imagenes`, `ubicacion`, `precio`, `id_artista`, `id_tema_estampa`, `id_tamano_estampa`, `id_lugar_estampa`) VALUES
(1, 'Esta es la primera', 'IMAGEN', 'detras', '300000', 1, 1, 1, 1),
(2, 'Esta es la segunda', 'IMAGEN', 'delante', '500000', 1, 2, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE IF NOT EXISTS `factura` (
  `id_factura` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(30) NOT NULL,
  `precio_total` varchar(100) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_factura_detalle` int(11) NOT NULL,
  `id_forma_pago` int(11) NOT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `FACTURA_FK_1` (`id_forma_pago`),
  KEY `FACTURA_FK_2` (`id_factura_detalle`),
  KEY `FACTURA_FK_3` (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`id_factura`, `fecha`, `precio_total`, `id_cliente`, `id_factura_detalle`, `id_forma_pago`) VALUES
(1, '19-08-2015', '300000', 1, 1, 1),
(2, '19-08-2011', '500000', 2, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_detalle`
--

CREATE TABLE IF NOT EXISTS `factura_detalle` (
  `id_factura_detalle` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(30) NOT NULL,
  `id_camiseta` int(11) NOT NULL,
  `id_precio_camiseta` int(11) NOT NULL,
  `id_talla` int(11) NOT NULL,
  `id_color` int(11) NOT NULL,
  `id_material` int(11) NOT NULL,
  `id_stock` int(11) NOT NULL,
  `id_estampa_camiseta` int(11) NOT NULL,
  `id_tema_estampa` int(11) NOT NULL,
  `id_tamano_estampa` int(11) NOT NULL,
  `id_lugar_estampa_camiseta` int(11) NOT NULL,
  `id_texto_camiseta` int(11) NOT NULL,
  `id_precio_estampa` int(11) NOT NULL,
  `id_precio_texto` int(11) NOT NULL,
  `id_tamano_texto` int(11) NOT NULL,
  `id_forma_pago` int(11) NOT NULL,
  `id_factura` int(11) NOT NULL,
  `precio_total` varchar(100) NOT NULL,
  PRIMARY KEY (`id_factura_detalle`),
  KEY `FACTURA_DETALLE_FK_1` (`id_camiseta`),
  KEY `FACTURA_DETALLE_FK_2` (`id_precio_camiseta`),
  KEY `FACTURA_DETALLE_FK_3` (`id_talla`),
  KEY `FACTURA_DETALLE_FK_4` (`id_color`),
  KEY `FACTURA_DETALLE_FK_5` (`id_material`),
  KEY `FACTURA_DETALLE_FK_6` (`id_stock`),
  KEY `FACTURA_DETALLE_FK_7` (`id_estampa_camiseta`),
  KEY `FACTURA_DETALLE_FK_8` (`id_tema_estampa`),
  KEY `FACTURA_DETALLE_FK_9` (`id_tamano_estampa`),
  KEY `FACTURA_DETALLE_FK_10` (`id_lugar_estampa_camiseta`),
  KEY `FACTURA_DETALLE_FK_11` (`id_texto_camiseta`),
  KEY `FACTURA_DETALLE_FK_12` (`id_precio_texto`),
  KEY `FACTURA_DETALLE_FK_13` (`id_tamano_texto`),
  KEY `FACTURA_DETALLE_FK_14` (`id_forma_pago`),
  KEY `FACTURA_DETALLE_FK_15` (`id_factura`),
  KEY `FACTURA_DETALLE_FK_16` (`id_precio_estampa`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `factura_detalle`
--

INSERT INTO `factura_detalle` (`id_factura_detalle`, `fecha`, `id_camiseta`, `id_precio_camiseta`, `id_talla`, `id_color`, `id_material`, `id_stock`, `id_estampa_camiseta`, `id_tema_estampa`, `id_tamano_estampa`, `id_lugar_estampa_camiseta`, `id_texto_camiseta`, `id_precio_estampa`, `id_precio_texto`, `id_tamano_texto`, `id_forma_pago`, `id_factura`, `precio_total`) VALUES
(1, '19-08-2015', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, '3000'),
(2, '19-08-2011', 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, '4000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `forma_pago`
--

CREATE TABLE IF NOT EXISTS `forma_pago` (
  `id_forma_pago` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_forma_pago` varchar(30) NOT NULL,
  PRIMARY KEY (`id_forma_pago`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `forma_pago`
--

INSERT INTO `forma_pago` (`id_forma_pago`, `descripcion_forma_pago`) VALUES
(1, ''),
(2, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugar_estampa_camiseta`
--

CREATE TABLE IF NOT EXISTS `lugar_estampa_camiseta` (
  `id_lugar_estampa_camiseta` int(11) NOT NULL AUTO_INCREMENT,
  `especificacion_lugar` varchar(30) NOT NULL,
  PRIMARY KEY (`id_lugar_estampa_camiseta`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `lugar_estampa_camiseta`
--

INSERT INTO `lugar_estampa_camiseta` (`id_lugar_estampa_camiseta`, `especificacion_lugar`) VALUES
(1, 'adelante'),
(2, 'atras');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material_camiseta`
--

CREATE TABLE IF NOT EXISTS `material_camiseta` (
  `id_material` int(11) NOT NULL AUTO_INCREMENT,
  `material` varchar(30) NOT NULL,
  PRIMARY KEY (`id_material`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `material_camiseta`
--

INSERT INTO `material_camiseta` (`id_material`, `material`) VALUES
(1, 'Seda'),
(2, 'Algodon');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precio_camiseta`
--

CREATE TABLE IF NOT EXISTS `precio_camiseta` (
  `id_precio_camiseta` int(11) NOT NULL AUTO_INCREMENT,
  `precio` varchar(100) NOT NULL,
  PRIMARY KEY (`id_precio_camiseta`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `precio_camiseta`
--

INSERT INTO `precio_camiseta` (`id_precio_camiseta`, `precio`) VALUES
(1, '500'),
(2, '600'),
(3, '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precio_estampa`
--

CREATE TABLE IF NOT EXISTS `precio_estampa` (
  `id_precio_estampa` int(11) NOT NULL AUTO_INCREMENT,
  `precio` varchar(100) NOT NULL,
  PRIMARY KEY (`id_precio_estampa`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `precio_estampa`
--

INSERT INTO `precio_estampa` (`id_precio_estampa`, `precio`) VALUES
(1, '500'),
(2, '600');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precio_texto`
--

CREATE TABLE IF NOT EXISTS `precio_texto` (
  `id_precio_texto` int(11) NOT NULL AUTO_INCREMENT,
  `precio` varchar(100) NOT NULL,
  PRIMARY KEY (`id_precio_texto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `precio_texto`
--

INSERT INTO `precio_texto` (`id_precio_texto`, `precio`) VALUES
(1, '500'),
(2, '600'),
(3, '456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rating_estampa`
--

CREATE TABLE IF NOT EXISTS `rating_estampa` (
  `id_rating_estampa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`id_rating_estampa`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `rating_estampa`
--

INSERT INTO `rating_estampa` (`id_rating_estampa`, `nombre`) VALUES
(1, 'Excelente'),
(2, 'Bueno'),
(3, 'Malo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock`
--

CREATE TABLE IF NOT EXISTS `stock` (
  `id_stock` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`id_stock`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `stock`
--

INSERT INTO `stock` (`id_stock`, `cantidad`) VALUES
(1, 100),
(2, 300);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `talla_camiseta`
--

CREATE TABLE IF NOT EXISTS `talla_camiseta` (
  `id_talla` int(11) NOT NULL AUTO_INCREMENT,
  `talla` varchar(10) NOT NULL,
  PRIMARY KEY (`id_talla`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `talla_camiseta`
--

INSERT INTO `talla_camiseta` (`id_talla`, `talla`) VALUES
(1, 'M'),
(2, 'L');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tamano_estampa`
--

CREATE TABLE IF NOT EXISTS `tamano_estampa` (
  `id_tamano_estampa` int(11) NOT NULL AUTO_INCREMENT,
  `especificacion_tamano` varchar(30) NOT NULL,
  `id_precio_estampa` int(11) NOT NULL,
  PRIMARY KEY (`id_tamano_estampa`),
  KEY `TAMANO_ESTAMPA_FK_1` (`id_precio_estampa`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tamano_estampa`
--

INSERT INTO `tamano_estampa` (`id_tamano_estampa`, `especificacion_tamano`, `id_precio_estampa`) VALUES
(1, '40*40', 1),
(2, '30*30', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tamano_texto`
--

CREATE TABLE IF NOT EXISTS `tamano_texto` (
  `id_tamano_texto` int(11) NOT NULL AUTO_INCREMENT,
  `especificacion_tamano` varchar(30) NOT NULL,
  `id_precio_texto` int(11) NOT NULL,
  PRIMARY KEY (`id_tamano_texto`),
  KEY `TAMANO_TEXTO_FK_1` (`id_precio_texto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tamano_texto`
--

INSERT INTO `tamano_texto` (`id_tamano_texto`, `especificacion_tamano`, `id_precio_texto`) VALUES
(1, '40*40', 1),
(2, '30*30', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tema_estampa`
--

CREATE TABLE IF NOT EXISTS `tema_estampa` (
  `id_tema_estampa` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_tema` varchar(30) NOT NULL,
  PRIMARY KEY (`id_tema_estampa`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tema_estampa`
--

INSERT INTO `tema_estampa` (`id_tema_estampa`, `tipo_tema`) VALUES
(1, 'deportes'),
(2, 'estudio');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `texto_camiseta`
--

CREATE TABLE IF NOT EXISTS `texto_camiseta` (
  `id_texto_camiseta` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_texto` varchar(30) NOT NULL,
  `id_tamano_texto` int(11) NOT NULL,
  PRIMARY KEY (`id_texto_camiseta`),
  KEY `TEXTO_CAMISETA_FK_2` (`id_tamano_texto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `texto_camiseta`
--

INSERT INTO `texto_camiseta` (`id_texto_camiseta`, `descripcion_texto`, `id_tamano_texto`) VALUES
(1, 'Hola como estas', 1),
(2, 'haciendo lo de arquitectura', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `voto_estampa`
--

CREATE TABLE IF NOT EXISTS `voto_estampa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_estampa` int(11) NOT NULL,
  `id_rating` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_estampa` (`id_estampa`),
  KEY `id_rating` (`id_rating`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `camiseta`
--
ALTER TABLE `camiseta`
  ADD CONSTRAINT `CAMISETA_FK_1` FOREIGN KEY (`id_estampa_camiseta`) REFERENCES `estampa_camiseta` (`id_estampa_camiseta`),
  ADD CONSTRAINT `CAMISETA_FK_2` FOREIGN KEY (`id_precio_camiseta`) REFERENCES `precio_camiseta` (`id_precio_camiseta`),
  ADD CONSTRAINT `CAMISETA_FK_3` FOREIGN KEY (`id_talla`) REFERENCES `talla_camiseta` (`id_talla`),
  ADD CONSTRAINT `CAMISETA_FK_4` FOREIGN KEY (`id_color`) REFERENCES `color_camiseta` (`id_color`),
  ADD CONSTRAINT `CAMISETA_FK_5` FOREIGN KEY (`id_material`) REFERENCES `material_camiseta` (`id_material`),
  ADD CONSTRAINT `CAMISETA_FK_6` FOREIGN KEY (`id_lugar_estampa_camiseta`) REFERENCES `lugar_estampa_camiseta` (`id_lugar_estampa_camiseta`),
  ADD CONSTRAINT `CAMISETA_FK_7` FOREIGN KEY (`id_texto_camiseta`) REFERENCES `texto_camiseta` (`id_texto_camiseta`);

--
-- Filtros para la tabla `estampa_camiseta`
--
ALTER TABLE `estampa_camiseta`
  ADD CONSTRAINT `ESTAMPA_CAMISETA_FK_1` FOREIGN KEY (`id_tema_estampa`) REFERENCES `tema_estampa` (`id_tema_estampa`),
  ADD CONSTRAINT `ESTAMPA_CAMISETA_FK_2` FOREIGN KEY (`id_tamano_estampa`) REFERENCES `tamano_estampa` (`id_tamano_estampa`),
  ADD CONSTRAINT `ESTAMPA_CAMISETA_FK_4` FOREIGN KEY (`id_artista`) REFERENCES `artista` (`id_artista`);

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `FACTURA_FK_1` FOREIGN KEY (`id_forma_pago`) REFERENCES `forma_pago` (`id_forma_pago`),
  ADD CONSTRAINT `FACTURA_FK_2` FOREIGN KEY (`id_factura_detalle`) REFERENCES `factura_detalle` (`id_factura_detalle`),
  ADD CONSTRAINT `FACTURA_FK_3` FOREIGN KEY (`id_cliente`) REFERENCES `comprador` (`id_cliente`);

--
-- Filtros para la tabla `factura_detalle`
--
ALTER TABLE `factura_detalle`
  ADD CONSTRAINT `FACTURA_DETALLE_FK_1` FOREIGN KEY (`id_camiseta`) REFERENCES `camiseta` (`id_camiseta`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_10` FOREIGN KEY (`id_lugar_estampa_camiseta`) REFERENCES `lugar_estampa_camiseta` (`id_lugar_estampa_camiseta`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_11` FOREIGN KEY (`id_texto_camiseta`) REFERENCES `texto_camiseta` (`id_texto_camiseta`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_12` FOREIGN KEY (`id_precio_texto`) REFERENCES `precio_texto` (`id_precio_texto`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_13` FOREIGN KEY (`id_tamano_texto`) REFERENCES `tamano_texto` (`id_tamano_texto`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_14` FOREIGN KEY (`id_forma_pago`) REFERENCES `forma_pago` (`id_forma_pago`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_15` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id_factura`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_16` FOREIGN KEY (`id_precio_estampa`) REFERENCES `precio_estampa` (`id_precio_estampa`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_2` FOREIGN KEY (`id_precio_camiseta`) REFERENCES `precio_camiseta` (`id_precio_camiseta`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_3` FOREIGN KEY (`id_talla`) REFERENCES `talla_camiseta` (`id_talla`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_4` FOREIGN KEY (`id_color`) REFERENCES `color_camiseta` (`id_color`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_5` FOREIGN KEY (`id_material`) REFERENCES `material_camiseta` (`id_material`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_6` FOREIGN KEY (`id_stock`) REFERENCES `stock` (`id_stock`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_7` FOREIGN KEY (`id_estampa_camiseta`) REFERENCES `estampa_camiseta` (`id_estampa_camiseta`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_8` FOREIGN KEY (`id_tema_estampa`) REFERENCES `tema_estampa` (`id_tema_estampa`),
  ADD CONSTRAINT `FACTURA_DETALLE_FK_9` FOREIGN KEY (`id_tamano_estampa`) REFERENCES `tamano_estampa` (`id_tamano_estampa`);

--
-- Filtros para la tabla `tamano_estampa`
--
ALTER TABLE `tamano_estampa`
  ADD CONSTRAINT `TAMANO_ESTAMPA_FK_1` FOREIGN KEY (`id_precio_estampa`) REFERENCES `precio_estampa` (`id_precio_estampa`);

--
-- Filtros para la tabla `tamano_texto`
--
ALTER TABLE `tamano_texto`
  ADD CONSTRAINT `TAMANO_TEXTO_FK_1` FOREIGN KEY (`id_precio_texto`) REFERENCES `precio_texto` (`id_precio_texto`);

--
-- Filtros para la tabla `texto_camiseta`
--
ALTER TABLE `texto_camiseta`
  ADD CONSTRAINT `TEXTO_CAMISETA_FK_2` FOREIGN KEY (`id_tamano_texto`) REFERENCES `tamano_texto` (`id_tamano_texto`);

--
-- Filtros para la tabla `voto_estampa`
--
ALTER TABLE `voto_estampa`
  ADD CONSTRAINT `voto_estampa_ibfk_2` FOREIGN KEY (`id_rating`) REFERENCES `rating_estampa` (`id_rating_estampa`),
  ADD CONSTRAINT `voto_estampa_ibfk_1` FOREIGN KEY (`id_estampa`) REFERENCES `estampa_camiseta` (`id_estampa_camiseta`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
