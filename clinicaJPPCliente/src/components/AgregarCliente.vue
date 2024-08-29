<template>
    <div class="container">
      <h1>Agregar Cliente</h1>
      <form @submit.prevent="agregarCliente">
        <div class="form-group">
          <label for="dni">DNI:</label>
          <input type="text" id="dni" v-model="cliente.dni" required />
        </div>
        <div class="form-group">
          <label for="nombre">Nombre:</label>
          <input type="text" id="nombre" v-model="cliente.nombre" required />
        </div>
        <div class="form-group">
          <label for="direccion">Dirección:</label>
          <input type="text" id="direccion" v-model="cliente.direccion" required />
        </div>
        <div class="form-group">
          <label for="telefono">Teléfono:</label>
          <input type="text" id="telefono" v-model="cliente.telefono" required />
        </div>
        <div class="form-group">
          <label for="numeroVisitas">Número de Visitas:</label>
          <input type="number" id="numeroVisitas" v-model="cliente.numeroVisitas" required />
        </div>
        <button type="submit" class="btn">Agregar Cliente</button>
      </form>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import { useRouter } from 'vue-router';
  import axios from 'axios';
  
  const router = useRouter();
  const cliente = ref({
    dni: '',
    nombre: '',
    direccion: '',
    telefono: '',
    numeroVisitas: 0
  });
  
  const agregarCliente = async () => {
    try {
      await axios.post('/clinica/agregarCliente', cliente.value);
      router.push({ name: 'lista-clientes' });  // Redirige a la lista de clientes después de agregar uno nuevo
    } catch (error) {
      console.error('Error al agregar el cliente:', error);
    }
  };
  </script>
  
  <style scoped>
  .container {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
  
  h1 {
    text-align: center;
    color: #333;
    margin-bottom: 20px;
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  label {
    display: block;
    margin-bottom: 5px;
    color: #555;
  }
  
  input {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
    border: 1px solid #ddd;
    border-radius: 4px;
  }
  
  input:focus {
    border-color: #42b983;
    outline: none;
  }
  
  .btn {
    display: block;
    width: 100%;
    padding: 10px;
    background-color: #42b983;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
  }
  
  .btn:hover {
    background-color: #36a372;
  }
  </style>
  