-- Insertar una clínica
INSERT INTO Clinica (nombre, direccion) VALUES ('Clinica Veterinaria Central', 'Calle Principal 123');

-- Insertar personas (Clientes y Veterinarios)
INSERT INTO Persona (nombre, direccion, telefono, tipo) VALUES ('Juan Perez', 'Calle Secundaria 456', '123456789', 'Cliente');
INSERT INTO Persona (nombre, direccion, telefono, tipo) VALUES ('Maria Lopez', 'Avenida Siempre Viva 789', '987654321', 'Cliente');
INSERT INTO Persona (nombre, direccion, telefono, tipo) VALUES ('Dr. Ana Gomez', 'Calle Tercera 101', '555123456', 'Veterinario');
INSERT INTO Persona (nombre, direccion, telefono, tipo) VALUES ('Dr. Carlos Ruiz', 'Boulevard Central 202', '555654321', 'Veterinario');

-- Insertar clientes
INSERT INTO Cliente (persona_id) VALUES ((SELECT id FROM Persona WHERE nombre = 'Juan Perez' AND tipo = 'Cliente'));
INSERT INTO Cliente (persona_id) VALUES ((SELECT id FROM Persona WHERE nombre = 'Maria Lopez' AND tipo = 'Cliente'));

-- Insertar veterinarios
INSERT INTO Veterinario (persona_id, especialidad) VALUES ((SELECT id FROM Persona WHERE nombre = 'Dr. Ana Gomez' AND tipo = 'Veterinario'), 'Cirugía');
INSERT INTO Veterinario (persona_id, especialidad) VALUES ((SELECT id FROM Persona WHERE nombre = 'Dr. Carlos Ruiz' AND tipo = 'Veterinario'), 'Dermatología');

-- Insertar mascotas
INSERT INTO Mascota (nombre, especie, raza, edad, cliente_id, veterinario_id) VALUES ('Firulais', 'Perro', 'Labrador', 3, (SELECT id FROM Cliente WHERE persona_id = (SELECT id FROM Persona WHERE nombre = 'Juan Perez' AND tipo = 'Cliente')), (SELECT id FROM Veterinario WHERE persona_id = (SELECT id FROM Persona WHERE nombre = 'Dr. Ana Gomez' AND tipo = 'Veterinario')));
INSERT INTO Mascota (nombre, especie, raza, edad, cliente_id, veterinario_id) VALUES ('Michi', 'Gato', 'Siames', 2, (SELECT id FROM Cliente WHERE persona_id = (SELECT id FROM Persona WHERE nombre = 'Maria Lopez' AND tipo = 'Cliente')), (SELECT id FROM Veterinario WHERE persona_id = (SELECT id FROM Persona WHERE nombre = 'Dr. Carlos Ruiz' AND tipo = 'Veterinario')));