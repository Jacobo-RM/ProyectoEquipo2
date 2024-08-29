<template>
    <div>
      <h2>Editar Cliente</h2>
      <form @submit.prevent="actualizarCliente">
        <div>
          <label for="nombre">Nombre:</label>
          <input type="text" v-model="cliente.nombre" id="nombre" required />
        </div>
        <div>
          <label for="direccion">Dirección:</label>
          <input type="text" v-model="cliente.direccion" id="direccion" required />
        </div>
        <div>
          <label for="telefono">Teléfono:</label>
          <input type="text" v-model="cliente.telefono" id="telefono" required />
        </div>
        <div>
          <label for="numeroVisitas">Número de Visitas:</label>
          <input type="number" v-model="cliente.numeroVisitas" id="numeroVisitas" required />
        </div>
        <button type="submit">Guardar Cambios</button>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'EditarCliente',
    props: {
      dni: {
        type: Number,
        required: true
      }
    },
    data() {
      return {
        cliente: {}
      };
    },
    created() {
      this.fetchCliente();
    },
    methods: {
      async fetchCliente() {
        try {
          const response = await axios.get(`/api/clinica/clientes/${this.dni}`);
          this.cliente = response.data;
        } catch (error) {
          console.error('Error fetching cliente:', error);
        }
      },
      async actualizarCliente() {
        try {
          const response = await axios.put(`/api/clinica/clientes/${this.cliente.dni}`, this.cliente);
          console.log('Cliente actualizado:', response.data);
          this.$router.push({ name: 'lista-clientes' });
        } catch (error) {
          console.error('Error actualizando cliente:', error);
        }
      }
    }
  };
  </script>