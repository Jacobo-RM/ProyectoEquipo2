<template>
  <div class="container">
    <h1>Lista de Veterinarios</h1>
    <ul class="veterinarios-list">
      <li v-for="veterinario in veterinarios" :key="veterinario.dni" class="veterinario-item">
        <p><strong>Nombre:</strong> {{ veterinario.nombre }}</p>
        <p><strong>Direccion:</strong> {{ veterinario.direccion }}</p>
        <p><strong>DNI:</strong> {{ veterinario.dni }}</p>
        <p><strong>Telefono:</strong> {{ veterinario.telefono }}</p>
        <p><strong>Especialidad:</strong> {{ veterinario.especialidad }}</p>
        <button @click="verMascotas(veterinario.dni)">Mascotas</button>
        <button @click="irAEditarVeterinario(veterinario.dni)">Actualizar</button>
        <button @click="eliminarVeterinario(veterinario.dni)">Eliminar</button>
      </li>
    </ul>
    <button @click="irAAgregarVeterinario" class="agregar-button">Agregar Nuevo Veterinario</button>
    <div v-if="mensaje" class="mensaje">{{ mensaje }}</div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const veterinarios = ref([]);
const mensaje = ref('');
const router = useRouter();

const fetchVeterinarios = async () => {
  try {
    const response = await axios.get('/api/clinica/veterinarios');
    veterinarios.value = response.data;
  } catch (error) {
    console.error('Error al obtener los veterinarios:', error);
  }
};

const irAEditarVeterinario = (dniVeterinario) => {
  router.push({ name: 'editar-veterinario', params: { dni: dniVeterinario } });
};

const irAAgregarVeterinario = () => {
  router.push({ name: 'editar-veterinario' });
};

const verMascotas = (dniVeterinario) => {
  router.push({ name: 'ver-mascotas', params: { dni: dniVeterinario } });
};

const eliminarVeterinario = async (dniVeterinario) => {
  try {
    await axios.delete(`/api/clinica/eliminarVeterinario/${dniVeterinario}`);
    veterinarios.value = veterinarios.value.filter(v => v.dni !== dniVeterinario);
    mensaje.value = 'Veterinario eliminado con éxito';
  } catch (error) {
    mensaje.value = 'Error al eliminar el veterinario';
    console.error('Error al eliminar el veterinario:', error);
  }
};

onMounted(() => {
  fetchVeterinarios();
});
</script>

<style>
.agregar-button {
  margin-bottom: 10px;
}

.mensaje {
  color: green;
  margin-bottom: 10px;
}
</style>

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

button {
  margin: 5px;
  padding: 10px 15px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #ddd;
}

.agregar-button {
  display: block;
  width: 100%;
  margin-top: 20px;
  background-color: #42b983;
  color: white;
}

.mensaje {
  margin-top: 20px;
  padding: 10px;
  background-color: #e0f7fa;
  border: 1px solid #4caf50;
  border-radius: 5px;
  color: #00796b;
  text-align: center;
}
</style>