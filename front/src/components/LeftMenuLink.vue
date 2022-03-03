<script setup>
import {computed} from "vue";

const props = defineProps({
  icon: String,
  title: String,
  linkTo: String,
  subText: String
})

const isActualRoute = computed(() => {
  return window.location.href.includes(props.linkTo)
})
</script>

<template>
  <div :class="'left-menu-link' + (isActualRoute?' selected':'')">
    <MdiSvg :path="icon" :size="40"/>
    <div class="infos">
      <router-link class="link" :to="linkTo">{{title}}</router-link>
      <div>{{subText}}</div>
    </div>
  </div>
</template>

<style scoped>
.left-menu-link {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  border-bottom: 2px solid var(--bg-color);
  gap: 10px;
  color: var(--font-color);
}

.selected{
  background: var(--bg-color);
  border-radius: 0 0 10px 10px;
}

.link {
  font-weight: bold;
  text-decoration: none;
  font-size: 1.5em;
  color: var(--secondary-color);
  -moz-user-select: none; /* Firefox */
  -webkit-user-select: none; /* Chrome, Safari, Opéra depuis la version 15 */
  -ms-user-select: none; /* Internet explorer depuis la version 10 et Edge */
  user-select: none;
}

.infos {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
}
</style>