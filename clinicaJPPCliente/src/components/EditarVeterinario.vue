<template>
  <div class="container">
    <h1>{{ isEditing ? 'Editar Veterinario' : 'Agregar Veterinario' }}</h1>
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" v-model="veterinario.nombre" required />
      </div>
      <div class="form-group">
        <label for="dni">DNI:</label>
        <input type="text" id="dni" v-model="veterinario.dni" required />
      </div>
      <div class="form-group">
        <label for="direccion">Dirección:</label>
        <input type="text" id="direccion" v-model="veterinario.direccion" required />
      </div>
      <div class="form-group">
        <label for="telefono">Telefono:</label>
        <input type="text" id="telefono" v-model="veterinario.telefono" required />
      </div>
      <div class="form-group">
        <label for="especialidad">Especialidad:</label>
        <input type="text" id="especialidad" v-model="veterinario.especialidad" required />
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
const veterinario = ref({
  dni: '',
  nombre: '',
  direccion: '',
  telefono: '',
  especialidad: ''
});
const isEditing = ref(false);

onMounted(async () => {
  const dni = route.params.dni;
  if (dni) {
    isEditing.value = true;
    try {
      const response = await axios.get(`/api/clinica/veterinarios/${dni}`);
      veterinario.value = response.data;
    } catch (error) {
      console.error('Error al cargar el veterinario:', error);
    }
  }
});

const handleSubmit = async () => {
  try {
    if (isEditing.value) {
      await axios.put(`/api/clinica/actualizarVeterinario`, veterinario.value);
    } else {
      await axios.post('/api/clinica/agregarVeterinarios', veterinario.value);
    }
    router.push({ name: 'lista-veterinarios' });
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