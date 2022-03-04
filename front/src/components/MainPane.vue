<script setup>
import Post from "./MainPanePost.vue"
import {useStore} from "vuex";
import {computed, onMounted} from "vue";

let store = useStore()


const getComs = function (id) {
  var coms = [
    [
      {
        texte: "Bonjour Ismaël",
        compte: {
          profil: {
            prenom: "Evan",
            nom: "Leuzel"
          }
        }
      }, {
      texte: "Salut, ça va ?",
      compte: {
        profil: {
          prenom: "Maxime",
          nom: "Troadec"
        }
      }
    }],
  ]

  return coms[id]
}

const publis = computed(() => {
  return JSON.parse(sessionStorage.getItem("publi"))
})

onMounted(() => {
  store.dispatch("getPublications")
})

</script>

<template>
  <div class="main">
    <Post v-for="publi in publis" :key="publi.id" :publisher="publi.compte.profil.prenom + ' ' + publi.compte.profil.nom" :text="publi.texte" :commentaires="publi.commentaires"/>
    <Post publisher="Titouan Larnicol-Primot"
          text="Bonjour, je suis actuellement à la recherche d'une alternance pour mon redoublement de M2. L'année dernière j'ai eu l'occasion de travailler à SopraSteria qui n'a pas souhaité continuer l'aventure avec moi. Contactez-moi par DM si intéressés."/>
  </div>
</template>

<style scoped>
.main {
  width: 60%;
  background: var(--bg-color);
  border-radius: 15px;
  padding: 20px;
  display: flex;
  flex-direction: column;
  gap: 20px;
}
</style>