<template>
    <div class="container">
      <h1>Lista de Mascotas</h1>
      <ul class="mascotas-list">
        <li v-for="mascota in mascotas" :key="mascota.id" class="mascota-item">
          <p><strong>Nombre:</strong> {{ mascota.nombre }}</p>
          <p><strong>Especie:</strong> {{ mascota.especie }}</p>
          <p><strong>Raza:</strong> {{ mascota.raza }}</p>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import { ref, onMounted } from 'vue';
  import { useRoute } from 'vue-router';
  
  export default {
    name: 'ListaMascotas',
    setup() {
      const mascotas = ref([]);
      const route = useRoute();
      
      const fetchMascotas = async () => {
        try {
          let url = '/api/clinica/mascotas';
          if (route.query.clienteDni) {
            url = `/api/clinica/mascotas/cliente/${route.query.clienteDni}`;
          } else if (route.query.veterinarioDni) {
            url = `/api/clinica/mascotas/veterinario/${route.query.veterinarioDni}`;
          }
      
          const response = await fetch(url);
          mascotas.value = await response.json();
        } catch (error) {
          console.error('Error fetching mascotas:', error);
        }
      };
      
      onMounted(() => {
        fetchMascotas();
      });
  
      return {
        mascotas
      };
    }
  };
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
  
  .mascotas-list {
    list-style-type: none;
    padding: 0;
  }
  
  .mascota-item {
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 15px;
    margin-bottom: 10px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  
  .mascota-item p {
    margin: 5px 0;
  }
  
  .mascota-item strong {
    color: #42b983;
  }
  </style>