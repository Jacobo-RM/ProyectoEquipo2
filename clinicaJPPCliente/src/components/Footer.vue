<template>
    <footer class="footer">
      <p>&copy; 2024 Clínica Veterinaria Los Robles. Todos los derechos reservados.</p>
      <p>
        <a href="#">Política de Privacidad</a> |
        <a href="#">Términos y Condiciones</a> |
        <a href="#">Contacto</a>
      </p>
    </footer>
  </template>
  
  <script>
  export default {
    name: 'Footer'
  };
  </script>
  
  <style scoped>
  .footer {
    background-color: #333;
    color: white;
    padding: 20px;
    text-align: center;
  }
  
  .footer p {
    margin: 5px 0;
  }
  
  .footer a {
    color: #4CAF50;
    text-decoration: none;
  }
  
  .footer a:hover {
    text-decoration: underline;
  }
  </style>
  