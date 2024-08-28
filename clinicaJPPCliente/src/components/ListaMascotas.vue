<template>
    <div>
      <h1>Lista de Mascotas</h1>
      <ul>
        <li v-for="mascota in mascotas" :key="mascota.id">
          {{ mascota.nombre }} - {{ mascota.especie }} - {{ mascota.raza }} - {{ mascota.edad }} años
        </li>
      </ul>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import { useRoute } from 'vue-router';
  
  const mascotas = ref([]);
  const route = useRoute();
  
  const fetchMascotas = async () => {
    try {
      let url = '/api/mascotas';
      if (route.query.clienteDni) {
        url = `/api/mascotas/cliente/${route.query.clienteDni}`;
      } else if (route.query.veterinarioDni) {
        url = `/api/mascotas/veterinario/${route.query.veterinarioDni}`;
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
  </script>