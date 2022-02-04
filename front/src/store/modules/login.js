import router from '../../router/main'

const login = {
    state: () => ({  }),
    mutations: {  },
    actions: {
        logUser(context, loginVM) {
            router.push({name: 'Home'}).catch(e => console.error(e))
        }
    },
    getters: {  }
}


export default login;
