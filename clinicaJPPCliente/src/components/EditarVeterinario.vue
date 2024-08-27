<template>
    <div class="container">
      <h1>{{ isEditing ? 'Editar Veterinario' : 'Agregar Veterinario' }}</h1>
      <form @submit.prevent="handleSubmit">
        <div class="form-group">
          <label for="nombre">Nombre:</label>
          <input type="text" id="nombre" v-model="veterinario.nombre" required />
        </div>
        <div class="form-group">
          <label for="apellido">Apellido:</label>
          <input type="text" id="apellido" v-model="veterinario.apellido" required />
        </div>
        <div class="form-group">
          <label for="telefono">Telefono:</label>
          <input type="text" id="telefono" v-model="veterinario.telefono" required />
        </div>
        <div class="form-group">
          <label for="correo">Correo:</label>
          <input type="email" id="correo" v-model="veterinario.correo" required />
        </div>
        <button type="submit" class="btn">{{ isEditing ? 'Guardar Cambios' : 'Agregar Veterinario' }}</button>
      </form>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import { useRoute, useRouter } from 'vue-router';
  import axios from 'axios';
  
  const route = useRoute();
  const router = useRouter();
  const isEditing = ref(false);
  const veterinario = ref({
    nombre: '',
    apellido: '',
    telefono: '',
    correo: ''
  });
  
  const fetchVeterinario = async (id) => {
    try {
      const response = await axios.get(`URL_DE_TU_API/veterinarios/${id}`);
      veterinario.value = response.data;
    } catch (error) {
      console.error('Error al cargar el veterinario:', error);
    }
  };
  
  onMounted(() => {
    if (route.query.id) {
      isEditing.value = true;
      fetchVeterinario(route.query.id);
    } else {
      isEditing.value = false;
    }
  });
  
  const handleSubmit = async () => {
    try {
      if (isEditing.value) {
        await axios.put(`URL_DE_TU_API/veterinarios/${route.query.id}`, veterinario.value);
      } else {
        await axios.post('URL_DE_TU_API/veterinarios', veterinario.value);
      }
      router.push('/veterinarios');
    } catch (error) {
      console.error('Error al guardar el veterinario:', error);
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