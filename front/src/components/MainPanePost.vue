<script setup>

</script>

<template>
  <div class="post">
    <div id="heading">
      <img src="user.png" alt="photo de profil" id="pfp"/>
      <h1>Ismaël Mohamed-Bouh</h1>
    </div>
    <div id="content">
      Lorem ipsum dolor sit amet, consectetur adipiscing elit.
      Donec pretium, velit pulvinar euismod interdum, turpis magna dapibus odio,
      a luctus massa quam volutpat tortor. Orci varius natoque penatibus et magnis
      dis parturient montes, nascetur ridiculus mus. Sed mollis quam nec libero lacinia
      consequat. Cras rhoncus nisl sed orci finibus, quis molestie velit pretium.
      Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;
      Nulla facilisi. Duis elementum risus leo, eu vulputate lectus pretium sit amet.
      Sed dictum turpis eget iaculis commodo. Nam venenatis ultricies libero et imperdiet.
      Duis nec eros tristique enim rutrum tincidunt a sit amet nulla. Ut vitae laoreet ipsum.
      Vivamus blandit velit eu nulla consequat fermentum.
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

  #content {
    padding: 20px;
  }
</style>