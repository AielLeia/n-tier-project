<script setup>
import {computed, ref} from "vue";
import {useStore} from "vuex";

let store = useStore();

const numEtudiant = ref("")
const mail = ref("")
const firstName = ref("")
const name = ref("")
const password = ref("")
const passwordCheck = ref("")
const birthDay = ref(null)

const numValid = function () {
  return numEtudiant.value.length > 8;
}

const mailValid = function () {
  if(mail.value.includes("@")) {
    let s = mail.value.split("@")
    return s[0].length > 4 && s[1].includes(".univ-brest.fr")
  }
  return false
}
const fnValid = function () {
  return firstName.value.length > 1;
}

const nValid = function () {
  return name.value.length > 1;
}

const pwValid = function () {
  return password.value.length > 8;
}

const pwcValid = function () {
  return passwordCheck.value.length > 8 && passwordCheck.value === password.value;
}

const dateValid = function () {
  if(birthDay.value != null){
    let diff = new Date().valueOf() - new Date(birthDay.value).valueOf()
    return diff > 473040000000 // 15 ans
  }
  return false
}

const validationPossible = function() {
  return numValid() && mailValid() && fnValid() && nValid() && pwValid() && pwcValid() && dateValid()
}

const submitForm = function() {
  if(validationPossible()) {
    let d = new Date(birthDay.value)
    let day = d.getDate() + ""
    if(day.length < 2) {
      day = "0" + day
    }
    let month = (d.getMonth()+1) + ""
    if(month.length < 2) {
      month = "0" + day
    }
    let parsedDate = day + "/" + month + "/" + d.getFullYear()
    store.dispatch("register", {
      identifiant: numEtudiant.value,
      motsDePasse: password.value,
      profil: {
        nom: name.value,
        prenom: firstName.value,
        email: mail.value,
        dateNaissance: parsedDate
      }});
  }
}
</script>

<template>
  <div id="register">
    <div class="card">
      <h1>Inscription</h1>
      <div class="form">
        <label for="num">Numéro étudiant
          <input id="num" :class="numValid() ? 'valid':''" type="text" placeholder="'e' suivi de 8 chiffres" v-model="numEtudiant"/></label>
        <label for="email">Adresse email
          <input id="email" :class="mailValid() ? 'valid':''" type="email" placeholder="Adresse étudiant" v-model="mail"/></label>
        <label for="firstName">Prénom
          <input id="firstName" :class="fnValid() ? 'valid':''" type="text" placeholder="Prénom" v-model="firstName"/></label>
        <label for="name">Nom
          <input id="name" :class="nValid() ? 'valid':''" type="text" placeholder="Nom" v-model="name"/></label>
        <label for="pw">Mot de passe
          <input id="pw" :class="pwValid() ? 'valid':''" type="password" placeholder="Au moins 8 caractères" v-model="password"/></label>
        <label for="pwc">Confirmer le mot de passe
          <input id="pwc" :class="pwcValid() ? 'valid':''" type="password" placeholder="Doit être identique" v-model="passwordCheck"/></label>
        <label for="date">Date de naissance
          <input id="date" :class="dateValid() ? 'valid':''" type="date" v-model="birthDay"/></label>
      </div>
      <button :class="validationPossible() ? 'enabled':'disabled'" @click="submitForm()">Valider</button>
      <router-link to="/account">Déjà inscrit ?</router-link>
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

.valid {
  border-color: var(--secondary-color);
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

.disabled {
  background: #e0e0e0;
  border-color: #e0e0e0;
  color: #a1a1a1;
}

</style>