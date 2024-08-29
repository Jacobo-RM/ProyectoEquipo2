<template>
  <header class="header-container">
    <img src="@/assets/logo.png" alt="Logo" />
    <nav>
      <ul>
        <li><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Services</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
    </nav>
  </header>
</template>

<script>
export default {
  name: 'Header'
};
</script>

<style scoped>
.header-container {
  width: 100%;
  padding: 1rem 0;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background-color: #f8f9fa;
}

nav ul {
  list-style: none;
  padding: 0;
  display: flex;
  flex-direction: row;
  gap: 1rem;
}

img {
  max-width: 150px;
  height: auto;
}

nav ul li {
  display: inline;
  margin: auto;
}

nav a {
  text-decoration: none;
  color: var(--color-text);
  font-weight: bold;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}
</style>