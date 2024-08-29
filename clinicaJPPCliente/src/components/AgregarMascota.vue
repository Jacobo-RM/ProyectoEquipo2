<template>
    <div class="container">
      <h1>Agregar Mascota</h1>
      <form @submit.prevent="agregarMascota">
        <div class="form-group">
          <label for="nombre">Nombre:</label>
          <input type="text" id="nombre" v-model="mascota.nombre" required />
        </div>
        <div class="form-group">
          <label for="especie">Especie:</label>
          <input type="text" id="especie" v-model="mascota.especie" required />
        </div>
        <div class="form-group">
          <label for="raza">Raza:</label>
          <input type="text" id="raza" v-model="mascota.raza" />
        </div>
        <div class="form-group">
          <label for="edad">Edad:</label>
          <input type="number" id="edad" v-model="mascota.edad" required />
        </div>
        <div class="form-group">
          <label for="cliente">Cliente DNI:</label>
          <input type="text" id="cliente" v-model="mascota.clienteDni" required />
        </div>
        <div class="form-group">
          <label for="veterinario">Veterinario DNI:</label>
          <input type="text" id="veterinario" v-model="mascota.veterinarioDni" />
        </div>
        <button type="submit" class="btn">Agregar Mascota</button>
      </form>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import { useRouter } from 'vue-router';
  import axios from 'axios';
  
  const router = useRouter();
  const mascota = ref({
    nombre: '',
    especie: '',
    raza: '',
    edad: 0,
    clienteDni: '',
    veterinarioDni: ''
  });
  
  const agregarMascota = async () => {
    try {
      await axios.post('/clinica/agregarMascotas', mascota.value);
      router.push({ name: 'editar-mascota' });
    } catch (error) {
      console.error('Error al agregar la mascota:', error);
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
  