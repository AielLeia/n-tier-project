<script setup>

</script>

<template>
  <div id="groups">
    <div class="group">
      <h3>M2 TIIL-A</h3>
      <button class="consult">Consulter</button>
      <button class="leave">Quitter</button>
    </div>
    <div class="group">
      <h3>Métaprogrammation</h3>
      <button class="consult">Consulter</button>
      <button class="leave">Quitter</button>
    </div>
    <div class="group">
      <h3>Architectures N-Tiers</h3>
      <button class="consult">Consulter</button>
      <button class="leave">Quitter</button>
    </div>
  </div>
</template>

<style scoped>
#groups {
  color: var(--font-color);
  width: 60%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.group {
  width: 100%;
  padding: 10px;
  border-top: 1px solid var(--outline-color);
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}

.consult, .leave {
  border-radius: 20px;
  font-size: 1.1em;
  padding: 10px;
  width: 15%;
  cursor: pointer;
  font-weight: bold;
}

.consult {
  border: 3px solid var(--primary-color);
  background: var(--primary-color);
}

.leave {
  border: 3px solid red;
  background: red;
}
</style>