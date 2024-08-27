CREATE TABLE Clinica (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL
);

CREATE TABLE Persona (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    tipo VARCHAR(50) NOT NULL CHECK (tipo IN ('Cliente', 'Veterinario'))
);

CREATE TABLE Cliente (
    id SERIAL PRIMARY KEY,
    persona_id INT NOT NULL,
    FOREIGN KEY (persona_id) REFERENCES Persona(id)
);

CREATE TABLE Veterinario (
    id SERIAL PRIMARY KEY,
    persona_id INT NOT NULL,
    especialidad VARCHAR(255),
    FOREIGN KEY (persona_id) REFERENCES Persona(id)
);

CREATE TABLE Mascota (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    especie VARCHAR(255) NOT NULL,
    raza VARCHAR(255),
    edad INT,
    cliente_id INT NOT NULL,
    veterinario_id INT,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id),
    FOREIGN KEY (veterinario_id) REFERENCES Veterinario(id)
);