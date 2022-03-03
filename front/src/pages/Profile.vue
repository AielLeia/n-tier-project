<script setup>

</script>

<template>
  <div id="profile">
    <div class="content">
      <div id="heading">
        <img src="user.png" alt="photo de profil" id="pfp"/>
        <h1>Ali Hadj-Said</h1>
      </div>
      <div id="information">
        <span><b>Numéro étudiant:</b> e21807583</span>
        <span><b>Âge:</b> 22 ans</span>
        <span><b>Promotion:</b> M2 TIIL-A</span>
      </div>
    </div>
  </div>
</template>

<style scoped>
  #profile {
    width: 60%;
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
    justify-content: flex-start;
    padding: 10px;
  }

  #heading h1 {
    font-size: 3em;
  }

  #information {
    background: var(--bg-color);
    border-radius: 10px;
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    padding: 10px;
    font-size: 1.5em;
    align-items: flex-start;
    gap: 8px;
  }

  #pfp {
    border-radius: 50%;
    width: 150px;
    height: auto;
  }
</style>