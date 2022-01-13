<script setup>
import LeftMenu from "../components/LeftMenu.vue"
import {ref} from "vue";
import MainPane from "../components/MainPane.vue";
import NavBar from "../components/NavBar.vue"
import {useStore} from "vuex";

let store = useStore();

const menuExpanded = ref(false)

const expandMenu = () => {
  menuExpanded.value = !menuExpanded.value
}
</script>

<template>
  <div class="home">
    <NavBar @expandMenu="expandMenu"/>
    <transition name="slide">
      <LeftMenu v-if="menuExpanded"/>
    </transition>
    <MainPane/>
  </div>
</template>


<style scoped>
  .home {
    display: flex;
    flex-direction: row;
    justify-content: center;
    margin-top: 100px;
    height: 100vh;
  }


  .slide-leave-active,
  .slide-enter-active {
    transition: 1s;
  }
  .slide-enter {
    transform: translate(100%, 0);
  }
  .slide-leave-to {
    transform: translate(-100%, 0);
  }
</style>