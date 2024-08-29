<template>
  <div id="app">
    <div class="header">
      <Header />
    </div>
    <div class="CarouselClinica">
      <CarouselClinica :banners="imagenesBanner" />
    </div>
    <Main />
    <Footer />
  </div>
</template>

<script>
import Header from './components/Header.vue';
import CarouselClinica from './components/CarouselClinica.vue';
import Main from './components/Main.vue';
import Footer from './components/Footer.vue';

export default {
  name: 'App',
  components: {
    Header,
    CarouselClinica,
    Main,
    Footer
  }
};
</script>

<style scoped>
#app {
  font-family: Arial, Helvetica, sans-serif;
  color: #2c3e50;
  text-align: center;
  line-height: 1.6;
}

.header {
  width: 100%;
  height: auto;
}

.CarouselClinica {
  margin: auto;
  width: 80%;
}

.main-content {
  margin: auto;
  width: 80%;
  padding: 20px;
  background-color: #f9f9f9;
  text-align: left;
}

.footer {
  background-color: #333;
  color: white;
  padding: 20px;
  text-align: center;
}

.footer a {
  color: #4CAF50;
  text-decoration: none;
}
</style>
