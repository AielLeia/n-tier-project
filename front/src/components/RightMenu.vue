<script setup>
import RightMenuFolder from "./RightMenuFolder.vue";
import {mdiForum, mdiMessageText} from '@mdi/js'

const getGroups = function () {
  return [
    {
      id: 1,
      photo: "group.jpg",
      name: "M2 TIIL-A",
      lastMessage: ":bounceur:"
    },
    {
      id: 2,
      photo: "group.jpg",
      name: "Métaprogrammation",
      lastMessage: "Bon bah c'est 0"
    }
  ]
}

const getConversations = function () {
  return [
    {
      id: 1,
      photo: "user.png",
      name: "Maxime Troadec",
      lastMessage:"Oui c'est à rendre"
    },
    {
      id: 2,
      photo: "user.png",
      name: "Evan Leuzel",
      lastMessage: "Non c'est pas à rendre"
    },
    {
      id: 3,
      photo: "user.png",
      name: "Titouan Larnicol-Primot",
      lastMessage: "jsp balek"
    }
  ]
}
</script>

<template>
  <div class="right-menu">
    <div id="title">Conversations</div>
    <RightMenuFolder :icon="mdiForum" title="Groupes" subText="2 non-lus" :elements="getGroups()"/>
    <RightMenuFolder :icon="mdiMessageText" title="Personnes" subText="0 non-lus" :elements="getConversations()"/>
  </div>
</template>

<style scoped>
.right-menu {
  position: fixed;
  height: 85%;
  width: 16%;
  padding: 5px 10px 5px 10px;
  background: var(--bg-bg-color);
  right: 0;
  border-left: 2px solid var(--bg-color);
  top: 12%;
}

#title {
  text-align: center;
  border-bottom:2px solid var(--bg-color);
  font-weight: bold;
  font-size: 1.7em;
  padding-bottom: 5px;
  color: var(--secondary-color);
}
</style>