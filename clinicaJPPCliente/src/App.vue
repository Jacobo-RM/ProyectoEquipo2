<template>
  <body>
    <RouterView />
  </body>
</template>

<style scoped>
header {
  display: flex;
  flex-direction: column;
  align-items: center;
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav ul {
  list-style-type: none;
  padding: 0;
  display: flex;
  justify-content: center;
  gap: 15px;
}

nav li {
  margin: 0;
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