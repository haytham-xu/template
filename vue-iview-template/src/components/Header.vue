<!-- src/components/Header.vue -->
<template>
    <div>
      <!-- @click="navigateTo('/web')" -->
      Header
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