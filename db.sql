
-- Tabla Cliente
CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(200),
    tipo_entidad VARCHAR(50),
    whatsapp VARCHAR(20),
    ciudad VARCHAR(100),
    pais VARCHAR(100),
    correo VARCHAR(100),
    metodoPago VARCHAR(50),
    telefono VARCHAR(20)
);

-- Tabla Pedido
CREATE TABLE Pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio INT NOT NULL,
    tipo_E_sistema VARCHAR(50),
    C_unidades INT NOT NULL,
    fecha DATE
);

-- Tabla Proveedor
CREATE TABLE Proveedor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(200),
    tipo_entidad VARCHAR(50),
    documento VARCHAR(50),
    tipo_producto VARCHAR(100),
    precio_producto INT NOT NULL
);

-- Tabla Producto
CREATE TABLE Producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio INT NOT NULL,
    tipo_E_sistema VARCHAR(50),
    descripcion TEXT,
    coleccion VARCHAR(100),
    categoria VARCHAR(100)
);




-- Cliente
INSERT INTO Cliente (nombre, direccion, tipo_entidad, whatsapp, ciudad, pais, correo, metodoPago, telefono)
VALUES
('Juan Pérez', 'Calle Principal 123', 'Persona Natural', '+123456789', 'Ciudad de Ejemplo', 'País de Ejemplo', 'juan@example.com', 'Tarjeta de Crédito', '+987654321');

-- Pedido

INSERT INTO Pedido (nombre, precio, tipo_E_sistema, C_unidades, fecha)
VALUES
('Producto A', 50, 'Sistema X', 2, '2024-05-28');

-- Proveedor

INSERT INTO Proveedor (nombre, direccion, tipo_entidad, documento, tipo_producto, precio_producto)
VALUES
('Proveedor XYZ', 'Avenida Principal 456', 'Persona Jurídica', '123456789', 'Tipo de Producto A', 100);

-- Producto
INSERT INTO Producto (nombre, precio, tipo_E_sistema, descripcion, coleccion, categoria)
VALUES
('Producto 1', 75, 'Sistema Y', 'Descripción del producto 1', 'Colección Primavera 2024', 'Categoría A');


