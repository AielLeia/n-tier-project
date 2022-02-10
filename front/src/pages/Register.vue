<script setup>

import {computed, ref} from "vue";

const numEtudiant = ref("")
const mail = ref("")
const password = ref("")
const passwordCheck = ref("")
const date = ref(new Date())


const validationPossible = computed(()=> {
  return (numEtudiant.value.length === 8 &&
      mail.value !== "" &&
      password.value.length >= 8 &&
      password.value === passwordCheck.value &&
      date.value.valueOf() > 0 &&
      date.value.valueOf() < new Date().valueOf())
})
</script>

<template>
  <div id="register">
    <div class="card">
      <h1>Inscription</h1>
      <div class="form">
        <label for="num">Numéro étudiant
          <input id="num" type="number" placeholder="Contient 8 chiffres" v-model="numEtudiant"/></label>
        <label for="email">Adresse email
          <input id="email" type="email" placeholder="Adresse étudiant" v-model="mail"/></label>
        <label for="pw">Mot de passe
          <input id="pw" type="password" placeholder="Au moins 8 caractères" v-model="password"/></label>
        <label for="pwc">Confirmer le mot de passe
          <input id="pwc" type="password" placeholder="Doit être identique" v-model="passwordCheck"/></label>
        <label for="date">Date de naissance
          <input id="date" type="date" v-model="date"/></label>
      </div>
      <div @click="submitForm" :class="validationPossible ? 'enabled':'disabled'">Valider</div>
      <router-link to="/login">Déjà inscrit ?</router-link>
    </div>
  </div>
</template>

<style scoped>
#register {
  padding-top: 10%;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}

.card {
  padding: 30px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  gap: 15px;
  align-items: center;
  border-radius: 10px;
  width: 40%;
  background: var(--theme-color);
  color: var(--font-color);
  box-shadow: 0px 0px 10px gray;
}

.form {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  gap: 20px;
}

label {
  display: flex;
  flex-direction: column;
}

input {
  border-radius: 10px;
  padding: 10px;
  border: 4px solid var(--outline-color);
  font-size: 15pt;
  font-family: "Nunito sans";
  outline: none;
}

.enabled, .disabled {
  text-align: center;
  border-radius: 10px;
  padding: 10px;
  font-size: 15pt;
  transition: all linear .2s;
  font-family: "Nunito sans";
  border: 4px solid;
  width: 40%;
}

.enabled {
  cursor: pointer;
  background: var(--primary-color);
  border-color: var(--secondary-color);
}

.enabled:hover {
  box-shadow: 0px 0px 5px var(--secondary-color);
  transform: scale(1.01);
}

</style>