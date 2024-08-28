<template>
  <div class="container">
    <h1>Lista de Veterinarios</h1>
    <ul class="veterinarios-list">
      <li v-for="veterinario in veterinarios" :key="veterinario.id" class="veterinario-item">
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
    const response = await axios.get('/api/clinica/veterinarios');
    veterinarios.value = response.data;
  } catch (error) {
    console.error('Error al cargar los veterinarios:', error);
  }
};

onMounted(() => {
  fetchVeterinarios();
});
</script>


<style scoped>
.container {
  max-width: 800px;
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

.veterinarios-list {
  list-style-type: none;
  padding: 0;
}

.veterinario-item {
  background-color: #fff;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 15px;
  margin-bottom: 10px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.veterinario-item p {
  margin: 5px 0;
}

.veterinario-item strong {
  color: #42b983;
}
</style>