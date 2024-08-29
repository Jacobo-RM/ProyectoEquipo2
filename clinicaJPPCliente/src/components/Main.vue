<template>
    <main class="main-content">
      <section class="about-us">
        <h2>Sobre Nosotros</h2>
        <p>
          En la Clínica Veterinaria PPJ, nos apasiona el cuidado de los animales. Desde nuestra fundación,
          hemos trabajado incansablemente para proporcionar servicios de alta calidad que garanticen la salud
          y el bienestar de tus mascotas. Nos enorgullece contar con un equipo multidisciplinario de profesionales
          que aman lo que hacen y utilizan la última tecnología en medicina veterinaria.
        </p>
        <p>
          Además de nuestros servicios veterinarios, ofrecemos asesoramiento a los propietarios sobre los mejores cuidados
          para sus mascotas, desde la nutrición adecuada hasta la prevención de enfermedades comunes.
        </p>
      </section>
  
      <section class="services">
        <h2>Nuestros Servicios</h2>
        <div class="services-list">
          <div class="service-item">
            <h3>Consulta General</h3>
            <p>
              Evaluamos la salud general de tu mascota y proporcionamos recomendaciones personalizadas para mantenerla
              en óptimas condiciones.
            </p>
          </div>
          <div class="service-item">
            <h3>Vacunación</h3>
            <p>
              Protege a tu mascota de enfermedades prevenibles con nuestro programa de vacunación completo.
            </p>
          </div>
          <div class="service-item">
            <h3>Cirugía</h3>
            <p>
              Contamos con un quirófano equipado para realizar procedimientos quirúrgicos seguros y eficientes.
            </p>
          </div>
          <div class="service-item">
            <h3>Urgencias 24h</h3>
            <p>
              Estamos disponibles las 24 horas del día para atender emergencias y garantizar que tu mascota reciba atención inmediata.
            </p>
          </div>
          <div class="service-item">
            <h3>Medicina Preventiva</h3>
            <p>
              Ofrecemos planes de salud preventivos que incluyen chequeos regulares, desparasitación y tratamientos preventivos.
            </p>
          </div>
        </div>
      </section>
  
      <section class="testimonials">
        <h2>Testimonios</h2>
        <div class="testimonial-item">
          <p>
            "La mejor clínica veterinaria que he visitado. El personal es increíblemente atento y se nota que aman a los animales.
            Mi perro recibió la mejor atención posible. ¡Altamente recomendable!"
          </p>
          <span>- Ana García, propietaria de Max</span>
        </div>
        <div class="testimonial-item">
          <p>
            "El servicio de urgencias es excepcional. Mi gato fue atendido rápidamente en medio de la noche y ahora está saludable
            y feliz gracias a la Clínica PPJ."
          </p>
          <span>- Carlos Rodríguez, propietario de Luna</span>
        </div>
      </section>
  
      <section class="contact">
        <h2>Contacto</h2>
        <p>Para más información o para agendar una cita, no dudes en contactarnos:</p>
        <address>
          <strong>Dirección:</strong> Parque Científico Tecnológico de Cantabria, C. Isabel Torres, 3, 39011 Santander, Cantabria<br>
          <strong>Teléfono:</strong> 942 74 60 99<br>
          <strong>Email:</strong> info@clinicaveterinariappj.com
        </address>
      </section>
    </main>
  </template>
  
  <script>
  export default {
    name: 'Main'
  };
  </script>
  
  <style scoped>
  .main-content {
    padding: 40px;
    background-color: #f9f9f9;
    text-align: left;
  }
  
  .main-content section {
    margin-bottom: 40px;
  }
  
  .main-content h2 {
    color: #4CAF50;
    margin-bottom: 15px;
    font-size: 24px;
    border-bottom: 2px solid #4CAF50;
    padding-bottom: 10px;
  }
  
  .main-content p, .main-content address {
    margin: 10px 0;
    line-height: 1.6;
  }
  
  .main-content .about-us p {
    font-size: 18px;
    margin-bottom: 15px;
  }
  
  .services-list {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
    gap: 20px;
  }
  
  .service-item {
    background-color: #ffffff;
    border: 1px solid #ddd;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  }
  
  .service-item h3 {
    color: #333;
    margin-bottom: 10px;
  }
  
  .testimonials {
    background-color: #f1f1f1;
    padding: 20px;
    border-radius: 8px;
  }
  
  .testimonial-item {
    margin-bottom: 20px;
    padding: 15px;
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 8px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  }
  
  .testimonial-item p {
    font-style: italic;
    font-size: 16px;
  }
  
  .testimonial-item span {
    display: block;
    margin-top: 10px;
    text-align: right;
    font-weight: bold;
    color: #4CAF50;
  }
  
  .contact {
    background-color: #ffffff;
    padding: 20px;
    border: 1px solid #ddd;
    border-radius: 8px;
  }
  
  .contact address {
    font-style: normal;
  }
  </style>
  