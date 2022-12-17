<!-- src/components/Footer.vue -->
<template>
    <div class="footer-container">
      Footer
    </div>
  </template>
  
  <script>
  export default {
    methods: {
      navigateTo(route) {
        this.$router.push(route);
      },
    },
  };
  </script>

<style scoped>

</style>