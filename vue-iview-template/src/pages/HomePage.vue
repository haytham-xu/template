<!-- Example for src/pages/HomePage.vue -->
<template>
  <div class="super">
    <Header />
    <div>Body</div>
    <Footer />
  </div>
  </template>
  
  <script>
  import Header from '@/components/Header.vue';
  import Footer from '@/components/Footer.vue';
  
  export default {
    components: {
      Header,
      Footer,
    },
    methods: {
      navigateTo(route) {
        this.$router.push(route);
      },
    },
  };
  </script>

<style scoped>
.super {
		width: 100%;
    padding: 0px;
    margin: 0px;
	}
#navEasyTable {
  background-color: rgb(26, 95, 255);
  width: 220px;
  height: 65px;
  position: relative;
  top: 200px;
  left: 80px;
}

</style>
