-- Cambiar a la base de datos `javaweb`
USE `javaweb`;

-- Crear la tabla `cafeteria`
CREATE TABLE IF NOT EXISTS cafeteria (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         nombreMenu VARCHAR(100) NOT NULL,
                                         descripcionMenu TEXT NOT NULL,
                                         precio DECIMAL(10, 2) NOT NULL,
                                         tipoMenu VARCHAR(50) NOT NULL
);

-- Insertar datos de ejemplo en la tabla `cafeteria`
INSERT INTO cafeteria (nombreMenu, descripcionMenu, precio, tipoMenu)
VALUES
    ('Desayuno Continental', 'Incluye jugo de naranja, huevos fritos y café con pan.', 2.50, 'Desayuno'),
    ('Ensalada César', 'Lechuga, pollo a la parrilla, aderezo César y crutones.', 3.50, 'Almuerzo'),
    ('Limonada', 'Bebida refrescante de limón natural.', 1.00, 'Bebida');

-- Crear la tabla `buses`
CREATE TABLE IF NOT EXISTS buses (
                                     id_bus BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                     ruta VARCHAR(100) DEFAULT NULL,
                                     paradas VARCHAR(250) DEFAULT NULL,
                                     horario VARCHAR(32) DEFAULT NULL,
                                     PRIMARY KEY (id_bus),
                                     UNIQUE KEY id_bus (id_bus)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
