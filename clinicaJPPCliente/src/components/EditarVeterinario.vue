<template>
    <div>
      <h1>{{ isEditing ? 'Editar Veterinario' : 'Agregar Veterinario' }}</h1>
      <form @submit.prevent="handleSubmit">
        <div>
          <label for="nombre">Nombre:</label>
          <input type="text" id="nombre" v-model="veterinario.nombre" required />
        </div>
        <div>
          <label for="apellido">Apellido:</label>
          <input type="text" id="apellido" v-model="veterinario.apellido" required />
        </div>
        <div>
          <label for="telefono">Telefono:</label>
          <input type="text" id="telefono" v-model="veterinario.telefono" required />
        </div>
        <div>
          <label for="correo">Correo:</label>
          <input type="email" id="correo" v-model="veterinario.correo" required />
        </div>
        <button type="submit">{{ isEditing ? 'Guardar Cambios' : 'Agregar Veterinario' }}</button>
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