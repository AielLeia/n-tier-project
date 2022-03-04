import { createStore } from 'vuex';
import account from "./modules/account.js";
import publications from "./modules/publications";

const store = new createStore({
    modules: {
        account: account,
        publications: publications
    }
})

export default store;