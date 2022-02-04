<script setup>
import { mdiMenu } from '@mdi/js'
import {ref} from "vue";

const theme = ref("noir")

const emit = defineEmits(['expandMenu'])

const switchTheme = (evt) => {
  if (evt.target.checked) {
    document.documentElement.setAttribute('data-theme', 'dark');
    theme.value = "jaune"
  }
  else {
    document.documentElement.setAttribute('data-theme', 'light');
    theme.value = "noir"
  }
}
const expandMenu = () => {
  emit("expandMenu")
}
</script>

<template>
  <div class="navbar">
    <div class="btn-menu" @click="expandMenu">
      <MdiSvg :path="mdiMenu" :size="48"/>
    </div>
    <div class="title">
      <img class="logo-ubo" :src="`/ubo-${theme}.png`">
      <h1>UBO Live</h1>
    </div>
    <div class="theme-switch-wrapper">
      <label class="theme-switch" for="checkbox">
        <input type="checkbox" id="checkbox" @change="switchTheme"/>
        <div class="slider round"></div>
      </label>
    </div>
  </div>
</template>

<style scoped>
  .navbar {
    display: flex;
    flex-direction: row;
    background: var(--theme-color);
    justify-content: space-between;
    align-items: center;
    width: 100%;
    height: 10%;
    position: fixed;
    top: 0;
    left: 0;
    z-index: 999;
  }

  .navbar .btn-menu {
    color: var(--font-color);
    cursor: pointer;
    padding-left: 10px;
  }

  .navbar .title {
    color: var(--font-color);
    display: flex;
    flex-direction: row;
    align-items: center;
    gap: 10px;
    -moz-user-select: none; /* Firefox */
    -webkit-user-select: none; /* Chrome, Safari, Opéra depuis la version 15 */
    -ms-user-select: none; /* Internet explorer depuis la version 10 et Edge */
    user-select: none;
  }

  .navbar .title .logo-ubo {
    height: 50px;
    width: auto;
  }
  /*
  Theme switch
   */
  .navbar .theme-switch-wrapper {
    display: flex;
    align-items: center;
    padding-right: 10px;
  }
  em {
    margin-left: 10px;
    font-size: 1rem;
  }
  .theme-switch {
    display: inline-block;
    height: 34px;
    position: relative;
    width: 60px;
  }
  .theme-switch input {
    display:none;
  }
  .slider {
    background-color: var(--secondary-color);
    bottom: 0;
    cursor: pointer;
    left: 0;
    position: absolute;
    right: 0;
    top: 0;
    transition: .4s;
  }
  .slider:before {
    background-color: #fff;
    bottom: 4px;
    content: "";
    height: 26px;
    left: 4px;
    position: absolute;
    transition: .4s;
    width: 26px;
  }

  input:checked + .slider {
    background-color: var(--secondary-color);
  }

  input:checked + .slider:before {
    transform: translateX(26px);
  }

  .slider.round {
    border-radius: 5px;
  }

  .slider.round:before {
    border-radius: 5px;
  }
</style>