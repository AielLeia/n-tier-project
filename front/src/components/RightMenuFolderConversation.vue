<script setup>
const props = defineProps({
  conversation: Object
})
</script>

<template>
  <div class="conversation">
    <img class="pfp" :src="conversation.photo"/>
    <div class="infos">
      <div class="name">{{conversation.name}}</div>
      <div class="last-message">{{conversation.lastMessage}}</div>
    </div>
  </div>
</template>

<style scoped>
.conversation {
  display: flex;
  flex-direction: row;
  align-items: center;
  border-top: 2px solid var(--bg-color);
  gap:10px;
}

.pfp {
  border: 3px solid var(--secondary-color);
  border-radius: 90px;
  height: 25px;
  width: auto;
}

.infos {
  display: flex;
  flex-direction: column;
}

.name {
  font-weight: bold;
}

.last-message {
  color: var(--placeholder-color);
}
</style>