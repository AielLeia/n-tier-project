<script setup>
import LeftMenu from "../components/LeftMenu.vue"
import RightMenu from "../components/RightMenu.vue"
import {ref} from "vue";

import NavBar from "../components/NavBar.vue"
import {useStore} from "vuex";

let store = useStore();

const menuExpanded = ref(true)

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
    <RightMenu/>
    <RouterView/>
  </div>
</template>


<style scoped>
.home {
  display: flex;
  flex-direction: row;
  justify-content: center;
  margin-top: 7%;
}

#content {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 20px;
}

.slide-leave-active,
.slide-enter-active {
  transition: all .3s linear;
}

.slide-enter {
  transform: translate(100%, 0);
}

.slide-leave-to {
  transform: translate(-100%, 0);
}

</style>