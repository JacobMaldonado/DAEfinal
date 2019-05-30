-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-05-2019 a las 07:57:03
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.3

create database proyectodae;
use proyectodae;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectodae`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `usuario` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(10) NOT NULL,
  `nombre_libro` varchar(100) NOT NULL,
  `descripcion_producto` varchar(100) NOT NULL,
  `unidad_producto` varchar(20) NOT NULL,
  `cantidad_producto` int(8) NOT NULL,
  `ubicacion_almacen` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre_libro`, `descripcion_producto`, `unidad_producto`, `cantidad_producto`, `ubicacion_almacen`) VALUES
(3, 'El principito', 'libro de pasta blanda', 'A10', 15, 'Planta alta'),
(5, 'Planet mart', 'libro de pasta blanda', 'A13', 12, 'Planta alta regionC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(10) NOT NULL,
  `nombre_usuario` varchar(100) NOT NULL,
  `apellido_usuario` varchar(100) NOT NULL,
  `tipo_usuario` varchar(20) NOT NULL,
  `password_usuario` varchar(20) NOT NULL,
  `correo_usuario` varchar(100) NOT NULL,
  `telefono_usuario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre_usuario`, `apellido_usuario`, `tipo_usuario`, `password_usuario`, `correo_usuario`, `telefono_usuario`) VALUES
(2, 'Cesar Omar', 'Cienega', 'Empleado', '223', 'cesar.@gmail.com', '4777860610'),
(3, 'Alfonso', 'Ruiz', 'Empleado', '23', 'b@gmail.com', '4772839210'),
(4, 'Rafael', 'Quintero', 'Cliente', '12', 'b@gmail.com', '4772839210'),
(6, 'Ricardo', 'Ledesma', 'Cliente', '12', 'cesar.mno.cga@gmail.com', '777860610'),
(7, 'Armando', 'Rojas', 'Cliente', '12', 'b@gmail.com', '4772839210'),
(9, 'Manuel', 'Gallardo', 'Empleado', '34', 'g@gmail.com', '345');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
