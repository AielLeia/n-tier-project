<script setup>
import { computed, onMounted } from "vue";
import titles from "../post-data.json"

const props = defineProps({
  query: String
})

const filteredTitles = computed(() => {
  return titles.filter((s) =>
    s.Name.toLowerCase().includes(props.query.toLowerCase())
  )
})

onMounted(() => {
  console.log("mounted")
})
</script>

<template>
  <div class="root">
    <p>Showing {{ filteredTitles.length }} results for "{{ query }}"</p>
    <ul>
      <li v-for="title in filteredTitles" :key="title.Page">
        {{ title.Name }}
      </li>
    </ul>
  </div>
</template>



<style scoped>

</style>