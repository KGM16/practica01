/*
========================================================================================================
    Profe, agregue aqui la creacion del usuario para que los compañeros solo copien y peguen el querry  
========================================================================================================
*/

-- Esto crear la tabla y la base, no modifiquen esto
CREATE SCHEMA practica;
USE practica;

-- crear las columnas, podemos ver si les parece o no
CREATE TABLE arbol (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_comun VARCHAR(100),
    tipo_flor VARCHAR(100),
    dureza_madera DECIMAL(5, 2),
    altura_promedio DECIMAL(6, 2),
    ruta_img VARCHAR(255) --dejo esto asi porque no se que tan larga puede ser la ruta
);

-- si quieren lo crear a pata o lo corren con esto
CREATE USER 'usuario_practica'@'localhost' IDENTIFIED BY 'la_Clave';
GRANT ALL PRIVILEGES ON practica.* TO 'usuario_practica'@'localhost';
FLUSH PRIVILEGES;

/*
========================================================================================================
                            Depues ponemos la ruta bien, no corran esto  
========================================================================================================
*/

INSERT INTO arbol (nombre_comun, tipo_flor, dureza_madera, altura_promedio, ruta_img) VALUES
('Roble', 'Sin flor visible', 85.5, 25.50, 'nose.png'),
('Pino', 'Conos', 65.0, 30.00, 'nose.png'),
('Arce', 'Flores pequeñas', 75.3, 15.25, 'nose.png'),
('Cedro', 'Sin flor visible', 90.1, 40.75, 'nose.png'),
('Abeto', 'Conos', 70.2, 35.50, 'nose.png');
