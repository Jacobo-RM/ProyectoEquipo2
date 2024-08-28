-- Eliminar tablas si existen
DROP TABLE IF EXISTS Mascota;
DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS Veterinario;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS Clinica;

-- Crear tabla Clinica
CREATE TABLE Clinica (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL
);

-- Crear tabla Persona
CREATE TABLE Persona (
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    tipo VARCHAR(50) NOT NULL CHECK (tipo IN ('Cliente', 'Veterinario'))
);

-- Crear tabla Cliente
CREATE TABLE Cliente (
    dni VARCHAR(9) PRIMARY KEY,
    numero_visitas INT,
    FOREIGN KEY (dni) REFERENCES Persona(dni) ON DELETE CASCADE
);

-- Crear tabla Veterinario
CREATE TABLE Veterinario (
    dni VARCHAR(9) PRIMARY KEY,
    especialidad VARCHAR(255),
    FOREIGN KEY (dni) REFERENCES Persona(dni) ON DELETE CASCADE
);

-- Crear tabla Mascota
CREATE TABLE Mascota (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    especie VARCHAR(255) NOT NULL,
    raza VARCHAR(255),
    edad INT,
    cliente_dni VARCHAR(9) NOT NULL,
    veterinario_dni VARCHAR(9),
    FOREIGN KEY (cliente_dni) REFERENCES Cliente(dni) ON DELETE CASCADE,
    FOREIGN KEY (veterinario_dni) REFERENCES Veterinario(dni) ON DELETE CASCADE
);
