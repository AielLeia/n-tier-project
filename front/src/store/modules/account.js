import router from '../../router/main'
import {HTTP} from "../../http/axios";

const account = {
    state: () => ({  }),
    mutations: {
        setToken(state, token) {
            sessionStorage.setItem("token", token)
            router.push({name: 'Home'}).catch(e => console.error(e))
        }
    },
    actions: {
        logUser({ commit }, loginVm) {
            HTTP.post("/compte/login", loginVm).then((response) => {
                console.log(response)
                commit("setToken", response.data.token)
            })
        },
        register({ commit }, profileInfos) {
            HTTP.post("/compte/enregistrement", profileInfos).then((response) => {
                router.push({name: 'Success'}).catch(e => console.error(e))
            })
        }
    },
    getters: {  }
}


export default account;
