<script setup>

</script>

<template>
  <div class="write">
    <div id="heading">
      <img src="user.png" alt="photo de profil" id="pfp"/>
      <h1>Ali Hadj-Said</h1>
    </div>
    <div id="content">
      <label for="text-area">Quoi de neuf ?</label>
      <textarea id="text-area" rows="3" res placeholder="Partagez quelque-chose ..."></textarea>
    </div>
  </div>
</template>

<style scoped>
.write {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  color: var(--font-color);
  width: 60%;
  background: var(--bg-color);
  border-radius: 15px;
  padding: 20px;
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

#content {
  padding-top: 20px;
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  gap: 10px;
}

#text-area {
  font-size: 1.2em;
  width: 100%;
  border: 3px solid var(--outline-color);
  border-radius: 10px;
  -webkit-box-sizing: border-box; /* Safari/Chrome, other WebKit */
  box-sizing: border-box;
  outline: none;
  resize:none;
  background: var(--text-area-color);
  color: var(--text-color);
  padding: 5px;
}

::placeholder {
  color: var(--placeholder-color);
}
</style>