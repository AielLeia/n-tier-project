import { createStore } from 'vuex';
import login from "./modules/login";

const store = new createStore({
    modules: {
        login: login
    }
})

export default store;