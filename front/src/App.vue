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
  background: var(--bg-bg-color);
}

:root {
  --primary-color: #ffe601;
  --secondary-color: #f9a51b;
  --font-color: #000000;
  --theme-color: #ffe601;
  --heading-color: #000000;
  --outline-color: #000000;
  --bg-color: #e1e1e1;
  --bg-bg-color: #fafafa;
  --text-area-color: #eaeaea;
  --placeholder-color: #919191;
}

[data-theme="dark"] {
  --primary-color: #1cbfdf;
  --secondary-color: #198ccd;
  --font-color: #fff;
  --theme-color: #000000;
  --heading-color: #ffe601;
  --outline-color: #ffe601;
  --bg-color: #414141;
  --bg-bg-color: #282828;
  --text-area-color: #545454;
  --placeholder-color: #d5d5d5;
}
</style>
