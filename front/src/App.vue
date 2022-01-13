<script setup>
// This starter template is using Vue 3 <script setup> SFCs
// Check out https://v3.vuejs.org/api/sfc-script-setup.html#sfc-script-setup
</script>

<template>
  <router-view/>
</template>

<style>
@import url('https://fonts.googleapis.com/css2?family=Nunito+Sans:ital,wght@0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap');
html {
  font-family: "Nunito sans";
}

:root {
  --primary-color: #ffe601;
  --secondary-color: #c7c7c7;
  --font-color: #220C10;
  --bg-color: #ffe601;
  --heading-color: #292922;
}

[data-theme="dark"] {
  --primary-color: #ffffff;
  --secondary-color: #6e6e6e;
  --font-color: #fff;
  --bg-color: #000000;
  --heading-color: #818cab;
}
</style>
