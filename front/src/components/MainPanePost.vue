<script setup>
import {ref} from 'vue'
import {onMounted} from "vue";
import {mdiChevronDown} from "@mdi/js"

const showComments = ref(false)

const props = defineProps({
  publisher: String,
  text: String,
  commentaires: {
    type: Array,
    default: []
  }
})

const switchComments = function () {
  if (props.commentaires.length > 0)
    showComments.value = !showComments.value
}

</script>

<template>
  <div class="post">
    <div id="heading">
      <img src="user.png" alt="photo de profil" id="pfp"/>
      <h1>{{ publisher }}</h1>
    </div>
    <div class="content">
      {{ text }}
      <div id="showComments" @click="switchComments">{{ commentaires.length }} commentaires
        <MdiSvg :style="'transition: all ease-in-out .3s;' + (showComments?'':'transform:rotate(-90deg);')" :size="30" :path="mdiChevronDown"></MdiSvg>
      </div>
      <div v-if="commentaires.length > 0 && showComments" class="commentaires">
        <div v-for="com in commentaires" :key="com.id">
          <b>{{ com.compte.profil.prenom }} {{ com.compte.profil.nom }}</b>
          <div>{{ com.texte }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.post {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  padding: 10px;
  border-radius: 10px;
  border: 3px solid var(--outline-color);
  color: var(--font-color);
  font-size: 1em;
}

#heading {
  display: flex;
  gap: 20px;
  flex-direction: row;
  align-items: center;
  justify-content: flex-start;
  width: 100%;
  border-bottom: 1px solid var(--outline-color);
}

#pfp {
  border-radius: 50%;
  width: 50px;
  height: auto;
}

#showComments {
  font-weight: bold;
  margin-top: 40px;
  display: flex;
  flex-direcion: row;
  align-items: center;
  cursor: pointer;
}

.content {
  -moz-user-select: none; /* Firefox */
  -webkit-user-select: none; /* Chrome, Safari, Opéra depuis la version 15 */
  -ms-user-select: none; /* Internet explorer depuis la version 10 et Edge */
  user-select: none;
  width: 100%;
  text-align: left;
  padding: 20px;
}

.commentaires {
  display: flex;
  flex-direction: column;
  gap: 10px;
  padding-top: 20px;
  border-top: 1px solid var(--outline-color);
  padding-left: 20px;
}
</style>