<script setup>
import {ref} from "vue";
import { mdiEye, mdiEyeOff } from '@mdi/js';

const login = ref("")
const password = ref("")

const inputType = ref("password")
const icon = ref(mdiEye)
const pwVisible = ref(false)

const showPw = () => {
  pwVisible.value = !pwVisible.value
  if(pwVisible.value) {
    icon.value = mdiEyeOff
    inputType.value = "text"
  } else {
    icon.value = mdiEye
    inputType.value = "password"
  }
}
</script>

<template>
  <div class="login">
    <div class="card">
      <h1>Login</h1>
      <input type="text" placeholder="Utilisateur" v-model="login"/>
      <div id="password">
        <input :type="inputType" placeholder="Mot de passe" v-model="password"/>
        <MdiSvg style="position: absolute; right:8px;" @click="showPw" :path="icon" :size="30"/>
      </div>
      <button>Valider</button>
    </div>
  </div>
</template>

<style scoped>
  .login {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    height: 100vh;
    font-family: "Nunito sans";
  }

  .card {
    padding: 30px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    gap: 15px;
    align-items: center;
    border-radius: 10px;
    background: #F1F1F1;
    box-shadow: 0px 0px 10px gray;
  }

  input {
    border-radius: 10px;
    padding: 10px;
    border: 4px solid #0095ff;
    font-size: 15pt;
    font-family: "Nunito sans";
  }

  button {
    cursor: pointer;
    border-radius: 10px;
    padding: 10px;
    width: 60%;
    background: #0095ff;
    color: white;
    border: 4px solid #167ac9;
    font-size: 15pt;
    transition: all linear .2s;
    font-family: "Nunito sans";
  }

  button:hover {
    box-shadow: 0px 0px 5px #167ac9;
    transform: scale(1.01);
  }

  #password {
    position: relative;
    display: flex;
    flex-direction: row;
    align-items: center;
  }
</style>