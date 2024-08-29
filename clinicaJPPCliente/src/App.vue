<template>
  <div id="app">
    <div class="header">
      <Header />
    </div>
    <Modal v-if="showModal" :isVisible="isModalVisible" @close="closeModal">
      <router-view />
    </Modal>
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
import Modal from './components/Modal.vue';

export default {
  name: 'App',
  components: {
    Header,
    Modal,
    CarouselClinica,
    Main,
    Footer
  },
  data() {
    return {
      isModalVisible: false
    };
  },
  computed: {
    showModal() {
      return this.$route.path !== '/';
    }
  },
  watch: {
    $route() {
      this.isModalVisible = true;
    }
  },
  methods: {
    closeModal() {
      this.isModalVisible = false;
    }
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
