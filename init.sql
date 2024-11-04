CREATE DATABASE IF NOT EXISTS javaweb;
USE javaweb;

-- Crear la tabla `cafeteria`
CREATE TABLE IF NOT EXISTS cafeteria (
                                         id_cafeteria bigint unsigned NOT NULL AUTO_INCREMENT,
                                         nombreMenu VARCHAR(100) NOT NULL,
                                         descripcionMenu TEXT NOT NULL,
                                         precio DECIMAL(10, 2) NOT NULL,
                                         tipoMenu VARCHAR(50) NOT NULL,
                                         PRIMARY KEY (`id_cafeteria`),
                                         UNIQUE KEY `id_bus` (`id_cafeteria`)
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Crear la tabla `buses`
CREATE TABLE IF NOT EXISTS buses (
                                     `id_bus` bigint unsigned NOT NULL AUTO_INCREMENT,
                                     `ruta` varchar(100) DEFAULT NULL,
                                     `paradas` varchar(250) DEFAULT NULL,
                                     `horario` varchar(32) DEFAULT NULL,
                                     PRIMARY KEY (`id_bus`),
                                     UNIQUE KEY `id_bus` (`id_bus`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `buses` VALUES
                        (1, 'ruta 1-Quitumbe', 'La Bolivia, Universidades, Tejar, La mascota', '6:50 AM - 8:00 PM'),
                        (2, 'ruta 2-Cochabamba', 'La Bolivia, Universidad Central, Hospital, Ferroviaria', '6:50 AM - 8:00 PM'),
                        (3, 'Ruta 3-Guajalo', 'Redondel, La plaza', '6:50 AM - 8:00 PM'),
                        (4, 'ruta 4-Nueva Ruta', 'Parada1, Parada2, Parada3', '6:50 AM - 8:00 PM');

-- Insertar datos de ejemplo en la tabla `cafeteria`
INSERT INTO `cafeteria` VALUES
    (1,'Desayuno Continental', 'Incluye jugo de naranja, huevos fritos y café con pan.', 2.50, 'Desayuno'),
    (2,'Ensalada César', 'Lechuga, pollo a la parrilla, aderezo César y crutones.', 3.50, 'Almuerzo'),
    (3,'Limonada', 'Bebida refrescante de limón natural.', 1.00, 'Bebida');

