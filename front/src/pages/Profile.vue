<script setup>
import {mdiAccountOff} from '@mdi/js'
import {useStore} from "vuex";
import {computed, onMounted} from "vue"
import MainPanePost from '../components/MainPanePost.vue'

let store = useStore();

const disconnect = function () {
  store.dispatch("disconnect")
}

onMounted(() => {
  store.dispatch("getPublications", JSON.parse(sessionStorage.getItem("user")).identifiant)
})

const user = computed(() => {
  return JSON.parse(sessionStorage.getItem("user"))
})

const publis = computed(() => {
  return JSON.parse(sessionStorage.getItem("userpubli"))
})

const age = computed(() => {
  let actualDate = new Date().getFullYear()
  let userBirthYear = new Date(user.value.profil.dateNaissance).getFullYear()
  return actualDate - userBirthYear
})

</script>

<template>
  <div id="profile">
    <div class="content">
      <div id="heading">
        <div id="person">
          <img src="user.png" alt="photo de profil" id="pfp"/>
          <h1>{{user.profil.prenom}} {{user.profil.nom}}</h1>
        </div>
        <div id="deco" @click="disconnect()">
          <MdiSvg :path="mdiAccountOff" :size="30"/> Déconnexion
        </div>
      </div>
      <div id="information">
        <span><b>Numéro étudiant:</b> {{user.identifiant}}</span>
        <span><b>Âge:</b> {{age}} ans</span>
        <span><b>Promotion:</b> M2 TIIL-A</span>
      </div>
      <h2>Vos publications:</h2>
      <div class="publications">
        <MainPanePost v-for="publi in publis" :key="publi.id" :publisher="user.profil.prenom + ' ' + user.profil.nom" :text="publi.texte" :commentaires="publi.commentaires"/>
      </div>
    </div>
  </div>
</template>

<style scoped>
  #profile {
    color: var(--font-color);
    width: 55%;
  }

  .content {
    display: flex;
    gap: 20px;
    flex-direction: column;
  }

  #heading{
    background: var(--bg-color);
    gap: 20px;
    border-radius: 10px;
    width: 100%;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    padding: 15px;
  }

  #heading h1 {
    font-size: 3em;
    justify-self: flex-start;
  }

  #person {
    display: flex;
    flex-direction: row;
    align-items:center;
    gap: 20px;
  }

  #information {
    background: var(--bg-color);
    border-radius: 10px;
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    padding: 15px;
    font-size: 1.5em;
    align-items: flex-start;
    gap: 8px;
  }

  #pfp {
    border-radius: 50%;
    width: 150px;
    height: auto;
  }

  #deco {
    cursor:pointer;
    justify-self: flex-end;
    border-radius: 10px;
    width: 20%;
    border: 3px solid black;
    background: red;
    padding: 5px;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    font-size: 1.5em;
    transition: all ease-in-out .2s;
  }

  #deco:hover {
    box-shadow: 0 0 6px red;
  }

  .publications {
    width: 100%;
    background: var(--bg-color);
    border-radius: 15px;
    padding: 15px;
    display: flex;
    flex-direction: column;
    gap: 20px;
  }
</style>