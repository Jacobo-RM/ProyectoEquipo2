-- Insertar clínicas
INSERT INTO Clinica (nombre, direccion) VALUES
('Clinica Veterinaria Salud Animal', 'Calle de los Mascotas, 123'),
('Centro Veterinario Bienestar', 'Avenida de los Animales, 456');

-- Insertar datos en la tabla Persona
INSERT INTO Persona (dni, nombre, direccion, telefono, tipo) VALUES 
('12345678A', 'Juan Pérez', 'Calle Falsa 123', '123456789', 'Cliente'),
('23456789B', 'Ana García', 'Avenida Siempre Viva 456', '987654321', 'Cliente'),
('34567890C', 'Carlos Martínez', 'Calle Luna 789', '123123123', 'Veterinario'),
('45678901D', 'Laura Fernández', 'Calle Sol 101', '456456456', 'Veterinario');


-- Insertar datos en la tabla Cliente
INSERT INTO Cliente (dni, numero_visitas) VALUES 
('12345678A', 5),
('23456789B', 3);

-- Insertar veterinarios
INSERT INTO Veterinario (dni, especialidad) VALUES
('34567890C', 'Cirugía'),
('45678901D', 'Dermatología');


-- Insertar mascotas
-- Asumimos que las claves de cliente y veterinario están alineadas con la estructura de la tabla
INSERT INTO Mascota (id, nombre, especie, raza, edad, cliente_dni, veterinario_dni) VALUES
(1, 'Rex', 'Perro', 'Pastor Alemán', 4, '12345678A', '34567890C'),
(2, 'Mimi', 'Gato', 'Siamés', 2, '23456789B', '45678901D');
