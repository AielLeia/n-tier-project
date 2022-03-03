import { createStore } from 'vuex';
import account from "./modules/account.js";

const store = new createStore({
    modules: {
        account: account
    }
})

export default store;