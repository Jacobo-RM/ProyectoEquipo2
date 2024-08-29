<template>

  <div>
    <h1>Lista de Clientes</h1>
    <table>
      <thead>
        <tr>
          <th>DNI</th>
          <th>Nombre</th>
          <th>Dirección</th>
          <th>Teléfono</th>
          <th>Número de Visitas</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="cliente in clientes" :key="cliente.dni" @click="editarCliente(cliente.dni)">
          <td>{{ cliente.dni }}</td>
          <td>{{ cliente.nombre }}</td>
          <td>{{ cliente.direccion }}</td>
          <td>{{ cliente.telefono }}</td>
          <td>{{ cliente.numeroVisitas }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'ListaClientes',
  data() {
    return {
      clientes: []
    };
  },
  created() {
    this.fetchClientes();
  },
  methods: {
    async fetchClientes() {
      try {
        const response = await axios.get('/api/clinica/clientes');
        this.clientes = response.data;
      } catch (error) {
        console.error('Error fetching clientes:', error);
      }
    },
    editarCliente(dni) {
      this.$router.push({ name: 'editar-cliente', params: { dni } });
    }
  }
};
</script>
  
  <style>
  table {
    width: 100%;
    border-collapse: collapse;
    margin: 20px 0;
  }
  
  th, td {
    padding: 10px;
    border: 1px solid #ddd;
    text-align: left;
  }
  
  th {
    background-color: #f4f4f4;
  }
  
  tr:nth-child(even) {
    background-color: #f9f9f9;
  }
  
  tr:hover {
    background-color: #e0e0e0;
    cursor: pointer;
  }
  </style>
