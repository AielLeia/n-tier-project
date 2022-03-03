<script setup>
import Post from "./MainPanePost.vue"
</script>

<template>
  <div class="main">
    <Post/>
    <Post/>
    <Post/>
    <Post/>
    <Post/>
  </div>
</template>

<style scoped>
  .main {
    width: 60%;
    background: var(--bg-color);
    border-radius: 15px;
    padding: 20px;
    display: flex;
    flex-direction: column;
    gap: 20px;
  }
</style>