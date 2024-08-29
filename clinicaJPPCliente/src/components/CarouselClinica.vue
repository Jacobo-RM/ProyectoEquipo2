<template>
  <carousel 
    ref="carousel"
    :items-to-show="1" 
    :items-to-scroll="1" 
    :loop="true" 
    :pagination-enabled="true" 
    :navigation-enabled="true"
  >
    <slide v-for="banner in banners" :key="banner.id">
      <img v-if="banner.image" :src="banner.image" :alt="banner.alt" class="imagenBannerSlide">
    </slide>
  </carousel>
</template>

<script>
import 'vue3-carousel/dist/carousel.css';
import { Carousel, Slide } from 'vue3-carousel';
import imagen1 from '../assets/imagen1.jpg';
import imagen2 from '../assets/imagen2.jpg';
import imagen3 from '../assets/imagen3.jpg';
import imagen4 from '../assets/imagen4.jpg';

export default {
  name: 'CarouselClinica',
  components: {
    Carousel,
    Slide
  },
  data() {
    return {
      banners: [
        { id: 1, image: imagen1, alt: "imagen1" },
        { id: 2, image: imagen2, alt: "imagen2" },
        { id: 3, image: imagen3, alt: "imagen3" },
        { id: 4, image: imagen4, alt: "imagen4" },

      ],
      autoplayInterval: null,
    };
  },
  mounted() {
    this.startAutoplay();
  },
  beforeDestroy() {
    this.stopAutoplay();
  },
  methods: {
    startAutoplay() {
      this.autoplayInterval = setInterval(() => {
        const carousel = this.$refs.carousel;

        if (carousel.currentSlide === this.banners.length - 1) {
          carousel.slideTo(0); 
        } else {
          carousel.next();
        }
      }, 7000);
    },
    stopAutoplay() {
      clearInterval(this.autoplayInterval);
    }
  }
};
</script>

<style scoped>
.imagenBannerSlide {
  width: 70%;
  height: 70%;
  border: 2px solid black;
}
</style>
