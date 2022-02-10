import router from '../../router/main'

const login = {
    state: () => ({  }),
    mutations: {
        setToken(state) {
            sessionStorage.setItem("token", "1vr884v16w8w64vt1h86t4xh81tdh4gw1r8g64we9sfgwregththeergrw")
            router.push({name: 'Home'}).catch(e => console.error(e))
        }
    },
    actions: {
        logUser({ commit }, loginVM) {
            commit("setToken")
        }
    },
    getters: {  }
}


export default login;
