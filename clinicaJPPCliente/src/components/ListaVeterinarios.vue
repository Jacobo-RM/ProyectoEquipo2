<template>
    <div>
      <h1>Lista de Veterinarios</h1>
      <ul>
        <li v-for="veterinario in veterinarios" :key="veterinario.id">
          <p><strong>Nombre:</strong> {{ veterinario.nombre }}</p>
          <p><strong>Apellido:</strong> {{ veterinario.apellido }}</p>
          <p><strong>Telefono:</strong> {{ veterinario.telefono }}</p>
          <p><strong>Correo:</strong> {{ veterinario.correo }}</p>
        </li>
      </ul>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  
  const veterinarios = ref([]);
  
  const fetchVeterinarios = async () => {
    try {
      const response = await axios.get('URL_DE_TU_API/veterinarios');
      veterinarios.value = response.data;
    } catch (error) {
      console.error('Error al cargar los veterinarios:', error);
    }
  };
  
  onMounted(() => {
    fetchVeterinarios();
  });
  
  </script>