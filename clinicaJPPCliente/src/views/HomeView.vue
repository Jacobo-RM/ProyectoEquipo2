<template>
  <div>

    <h1>Bienvenido a la Clínica Veterinaria</h1>
    <nav>
      <ul>
        <li><router-link to="/">Inicio</router-link></li>
        <li><router-link to="/clientes">Lista de Clientes</router-link></li>
        <li><router-link to="/veterinarios">Lista de Veterinarios</router-link></li>
        <li><router-link to="/mascotas">Lista de Mascotas</router-link></li>
        <li><router-link to="/editar-cliente">Agregar/Editar Cliente</router-link></li>
        <li><router-link to="/editar-veterinario">Agregar/Editar Veterinario</router-link></li>
        <li><router-link to="/editar-mascota">Agregar/Editar Mascota</router-link></li>
      </ul>
    </nav>
  </div>
</template>

<script setup>
</script>

<style scoped>
nav ul {
  list-style-type: none;
  padding: 0;
}

nav li {
  display: inline;
  margin-right: 10px;
}

nav a:hover {
  text-decoration: underline;

}
</style>