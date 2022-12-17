<template>
  <div id="app" ref="bodyPage">
    <transition name="fade" mode="out-in">
      <keep-alive>
        <router-view></router-view>
      </keep-alive>
    </transition>
  </div>
</template>

<script>

export default {
  name: 'app',
  data:function(){
    return {
    }
  },
}
</script>

<style>
html, body {
  padding: 0;
  margin: 0;
  width: 100%;
}

#app {
  width: 100%;
  padding: 0;
  margin: 0;
}
</style>
