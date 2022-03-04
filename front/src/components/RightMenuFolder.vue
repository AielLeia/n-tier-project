<script setup>
import {mdiChevronRight} from '@mdi/js'
import Conversation from './RightMenuFolderConversation.vue'
import {ref} from "vue";

const deployed = ref(false);

const props = defineProps({
  icon: String,
  title: String,
  subText: String,
  elements: Array,
})

const deploy = function () {
  deployed.value = !deployed.value;
}

</script>

<template>
  <div class="folder">
    <div class="heading">
      <MdiSvg :path="icon" :size="40"/>
      <div class="infos">
        <div class="title">{{ title }}</div>
        <div>{{ subText }}</div>
      </div>
      <div @click="deploy()" :class="'chevron' + (deployed?' open':'')">
        <MdiSvg :path="mdiChevronRight" :size="40"/>
      </div>
    </div>
    <transition name="dropdown">
      <div class="content" v-if="deployed">
        <Conversation v-for="conversation in elements" :key="conversation.id" :conversation="conversation"/>
      </div>
    </transition>
  </div>
</template>

<style scoped>
.folder {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  border-bottom: 2px solid var(--bg-color);
  color: var(--font-color);
}

.heading {
  display: flex;
  flex-direction: row;
}

.title {
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

.chevron {
  margin-right: 0;
  align-self: center;
  cursor: pointer;
  transition: all ease-in-out .2s;
}

.open {
  transform: rotate(90deg);
}

.content {
  padding-left: 20px;
  transition: all .4s ease-in-out;
  transform-origin: top;
}

.dropdown-enter, .dropdown-leave-to{
  transform: scaleY(0);
  opacity: 0;
}
</style>