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
    dureza_madera VARCHAR(100),
    altura_promedio DECIMAL(6, 2),
    activo BOOLEAN,
    ruta_img VARCHAR(255) 
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

INSERT INTO arbol (nombre_comun, tipo_flor, dureza_madera, altura_promedio, activo, ruta_img) VALUES
('Roble', 'Sin flor visible', 85.5, 25.50, TRUE, 'nose.png'),

