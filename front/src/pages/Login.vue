<script setup>
import {ref} from "vue";
import { mdiEye, mdiEyeOff } from '@mdi/js';
import {useStore} from "vuex";

let store = useStore();

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

const numValid = function () {
  return login.value !== "";
}

const pwValid = function () {
  return password.value.length > 8;
}

const validationPossible = function() {
  return numValid() && pwValid()
}

const submitForm = () => {
  if(validationPossible())
    store.dispatch("logUser", {identifiant: login.value, motsDePasse: password.value});
}
</script>

<template>
  <div class="login">
    <div class="card">
      <h1>Login</h1>
      <input type="text" :class="numValid() ? 'valid':''" placeholder="Utilisateur" v-model="login"/>
      <div id="password">
        <input :type="inputType" :class="pwValid() ? 'valid':''" placeholder="Mot de passe" v-model="password"/>
        <MdiSvg style="position: absolute; right:8px;" @click="showPw" :path="icon" :size="30"/>
      </div>
      <button @click="submitForm()" :class="validationPossible() ? 'enabled':'disabled'">Valider</button>
      <router-link to="/register">Pas encore de compte ? Créez-en un ici</router-link>
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
    background: var(--theme-color);
    color: var(--font-color);
    box-shadow: 0px 0px 10px gray;
  }

  .card h1 {
    color: var(--font-color);
  }

  input {
    border-radius: 10px;
    padding: 10px;
    border: 4px solid var(--outline-color);
    font-size: 15pt;
    font-family: "Nunito sans";
    outline: none;
  }

  .enabled, .disabled {
    border-radius: 10px;
    padding: 10px;
    width: 60%;
    font-size: 15pt;
    transition: all linear .2s;
    font-family: "Nunito sans";
    border: 4px solid;
  }

  .valid {
    border-color: var(--secondary-color);
  }
  .enabled {
    cursor: pointer;
    background: var(--primary-color);
    border-color: var(--secondary-color);
  }

  .enabled:hover {
    box-shadow: 0px 0px 5px var(--secondary-color);
    transform: scale(1.01);
  }

  #password {
    position: relative;
    display: flex;
    flex-direction: row;
    align-items: center;
  }

  .disabled {
    background: #e0e0e0;
    border-color: #e0e0e0;
    color: #a1a1a1;
  }
</style>