<template>
  <div>
    <nav>
      <router-link to="/clientes">Lista de Clientes</router-link>
      <router-link to="/veterinarios">Lista de Veterinarios</router-link>
    </nav>
    <RouterView />
  </div>
</template>

<script>
export default {
  name: 'TabsComponent'
}
</script>

<style>
nav {
  display: flex;
  gap: 10px;
}

router-link {
  padding: 10px;
  text-decoration: none;
  color: #42b983;
}

router-link-active {
  font-weight: bold;
  color: #35495e;
}
</style>