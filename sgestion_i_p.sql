-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-06-2024 a las 19:46:23
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
  `telefono` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `direccion`, `tipo_entidad`, `whatsapp`, `ciudad`, `pais`, `correo`, `metodoPago`, `telefono`) VALUES
(1, 'leocarlos ospina', 'calle 21 # 27-10', 'cliente', '+57null', 'lorica', 'colombia', 'leocarlos10', 'ncli', '091203921039'),
(2, 'braulio Ospina', 'calle 21 # 27-10', 'cliente', '+573113746268', 'lorica', 'colombia', 'braulio@gmail.com', 'nequi', '3113746267'),
(3, 'monica', 'calle 21# 27-10', 'cliente', '3126685930', 'lorica', 'colombia', 'mocaal@hotmail.com', 'nequi', '3126681930'),
(4, 'caleb', 'calle 20', 'cliente', '23242442', 'lorica', 'colombia', 'calebgamecraft@gmail.com', 'ncli', '24324234'),
(5, 'nadie', 'nadiew', 'cliente', '3432423', 'lorica', 'colombia', 'naide@gmail.com', 'necli', '311146637');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id` varchar(11) NOT NULL,
  `tipo_E_sistema` varchar(50) DEFAULT NULL,
  `C_unidades` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `id_producto` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `estado` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `tipo_E_sistema`, `C_unidades`, `fecha`, `id_producto`, `id_cliente`, `estado`) VALUES
('1', 'pedido', 2, '2024-06-30', 47, 1, 'En Proceso');

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
(41, 'sombrero', 35000, 'producto', 'null', 'sombrero 20', 'sombrero', 20, 'imagen15.jpg'),
(45, 'manillas', 50000, 'producto', 'manillas realizadas en fibra de caña flecha', 'manillas 20', 'Otros', 10, 'imagen19.jpg'),
(46, 'bolso wuayu', 20000, 'producto', 'bolso realizado en fibra de caña flecha', 'bolso 20', 'Bolso', 20, 'imagen20.jpg'),
(47, 'bolso 2', 10000, 'producto', 'bolso negro con blanco exclusivo', 'bolso 20', 'Bolso', 6, 'imagen21.jpg');

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
  ADD KEY `fk_id_producto` (`id_producto`),
  ADD KEY `fk_id_cliente` (`id_cliente`);

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
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

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
  ADD CONSTRAINT `fk_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `fk_id_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
