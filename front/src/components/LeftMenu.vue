<script setup>
import LeftMenuLink from './LeftMenuLink.vue'
import {mdiAccount, mdiAccountMultiple, mdiAccountGroup, mdiCloud} from '@mdi/js'

</script>

<template>
  <div class="left-menu">
    <div id="title">Gestion</div>
    <LeftMenuLink :icon="mdiAccount" linkTo="/e21706737" title="Ali Hadj-Said" subText="2 notifications"/>
    <LeftMenuLink :icon="mdiAccountMultiple" linkTo="/contacts" title="Contacts" subText="1 invitation"/>
    <LeftMenuLink :icon="mdiAccountGroup" linkTo="/groups" title="Groupes" subText="3 groupes intégrés"/>
    <LeftMenuLink :icon="mdiCloud" linkTo="/cloud" title="Stockage cloud" subText="0 ko utilisés"/>
  </div>
</template>

<style scoped>
.left-menu {
  position: fixed;
  height: 85%;
  width: 16%;
  padding: 5px 10px 5px 10px;
  background: var(--bg-bg-color);
  left: 0;
  border-right: 2px solid var(--bg-color);
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