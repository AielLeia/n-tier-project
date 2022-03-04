import router from '../../router/main'
import {HTTP} from "../../http/axios";

const account = {
    state: () => ({
    }),
    mutations: {
        setToken(state, token) {
            sessionStorage.setItem("token", token)
            router.push({name: 'Home'}).catch(e => console.error(e))
        },
        setUser(state, user) {
            sessionStorage.setItem("user", JSON.stringify(user))
        }
    },
    actions: {
        logUser({ commit }, loginVm) {
            HTTP.post("/compte/login", loginVm).then((response) => {
                commit("setToken", response.data.token)
                commit("setUser", response.data.compteDto)
            })
        },
        register({ commit }, profileInfos) {
            HTTP.post("/compte/enregistrement", profileInfos).then((response) => {
                router.push({name: 'Success'}).catch(e => console.error(e))
            })
        },
        disconnect(_) {
            sessionStorage.setItem("token", "")
            router.push({name: "Login"}).catch(e => console.error(e));
        }
    },
    getters: {
    }
}


export default account;
