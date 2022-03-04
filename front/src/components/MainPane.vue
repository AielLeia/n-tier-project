<script setup>
import Post from "./MainPanePost.vue"
import {useStore} from "vuex";
import {onMounted} from "vue";

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

</script>

<template>
  <div class="main">
    <Post publisher="Ismaël Mohamed-BOUH" text="Bonjour, je suis nouveau à l'UBO." :commentaires="getComs(0)"/>
    <Post publisher="Evan Leuzel" text="Petit Lost Ark pendant Papi ?"/>
    <Post publisher="Titouan Larnicol-Primot"
          text="Bonjour, je suis actuellement à la recherche d'une alternance pour mon redoublement de M2. L'année dernière j'ai eu l'occasion de travailler à SopraSteria qui n'a pas souhaité continuer l'aventure avec moi. Contactez-moi par DM si intéressés."/>
    <Post publisher="Ali Hadj-Said" text="Je t'aime, Ismaël"/>
    <Post publisher="Tibo RB" text="Salut"/>
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