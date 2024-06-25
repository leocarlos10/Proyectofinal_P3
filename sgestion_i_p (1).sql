-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-06-2024 a las 23:50:08
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sgestion_i_p`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `tipo_entidad` varchar(50) DEFAULT NULL,
  `whatsapp` varchar(20) DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `pais` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `metodoPago` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `id_pedido` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `direccion`, `tipo_entidad`, `whatsapp`, `ciudad`, `pais`, `correo`, `metodoPago`, `telefono`, `id_pedido`) VALUES
(7, 'leocarlos ospina causil', 'calle 21 # 27-10', NULL, '+573113746267', 'lorica', 'colombia', 'leocarlosospinacausil10@gmail.com', 'nequi', '3113746267', '1'),
(8, 'braulio jose ospina causil', 'calle 21 #27-10', NULL, '+57311111111111', 'lorica', 'colombia ', 'braulio@gmail.com', 'nequi', '3113746267', '2'),
(9, 'caleb seña', 'calle 21 #27-10', NULL, '+573113746267', 'Lorica', 'colombia', 'leocarlosospinacausil10@gmail.com', 'nequi', '3113746267', '3'),
(10, 'jose', 'calle 23 #21-19', NULL, '+57311376590', 'lorica', 'colombia', 'jose@gmail.com', 'nequi', '321121232', '4');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id` varchar(11) NOT NULL,
  `tipo_E_sistema` varchar(50) DEFAULT NULL,
  `C_unidades` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `id_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `tipo_E_sistema`, `C_unidades`, `fecha`, `id_producto`) VALUES
('1', 'pedido', 1, '2024-06-24', 33),
('2', 'pedido', 2, '2024-06-25', 33),
('3', 'pedido', 1, '2024-06-25', 33),
('4', 'pedido', 1, '2024-06-24', 33);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` int(11) NOT NULL,
  `tipo_E_sistema` varchar(50) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `coleccion` varchar(100) DEFAULT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  `cantidadUnidades` int(11) NOT NULL,
  `nombre_imagenes` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `precio`, `tipo_E_sistema`, `descripcion`, `coleccion`, `categoria`, `cantidadUnidades`, `nombre_imagenes`) VALUES
(33, 'sombrero', 45000, 'producto', 'sombrero fino', 'sombrero vueltiao 20', 'sombrero', 10, 'imagen7.jpg'),
(34, 'bolso', 10000, 'producto', 'bolso exclusivo	', 'bolso 19', 'Bolso', 20, 'imagen8.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `tipo_entidad` varchar(50) DEFAULT NULL,
  `documento` varchar(50) DEFAULT NULL,
  `tipo_producto` varchar(100) DEFAULT NULL,
  `precio_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id`, `nombre`, `direccion`, `tipo_entidad`, `documento`, `tipo_producto`, `precio_producto`) VALUES
(3, 'señora matilde', 'tuchin', 'Proveedor', '1063135807', 'sombrero fino', 45000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_producto` (`id_producto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_id_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
