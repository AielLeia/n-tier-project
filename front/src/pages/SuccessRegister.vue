<script setup>
import {onMounted} from "vue";
import router from '../router/main'


const redirect = onMounted(() => {
  setTimeout(() => {
    router.push({name: "Login"}).catch(error => console.error(error))
  }, 3000)
})
</script>

<template>
<div>
  <h1>Enregistrement réussi !</h1>
  <p>Vous allez être redirigé vers la page de connexion</p>
</div>
</template>



<style scoped>

</style>