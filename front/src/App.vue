<template>
  <div id="app">
      <the-header></the-header>
      <router-view></router-view>
      <the-footer></the-footer>
  </div>
</template>
  
  
  <script>
  import TheHeader from "@/components/TheHeader";
  import TheFooter from '@/components/TheFooter';
  
  
  export default {
    components: {
      TheHeader,
      TheFooter,
    },
  };
  </script>
  
  
  <style></style>