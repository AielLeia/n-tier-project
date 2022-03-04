import {HTTP} from "../../http/axios";

const publications = {
    state: () => ({}),
    mutations: {
        setPublications(state, publications) {
            sessionStorage.setItem("userpubli", JSON.stringify(publications))
        }
    },
    actions: {
        getPublications({commit}, id) {
            let token = "Bearer " + sessionStorage.getItem("token")
            HTTP.get("/publications/" + id, {
                headers: {
                    Authorization: token
                }
            }).then(res => commit("setPublications", res.data))
        },
        postPublications({commit}, publication) {
            let token = "Bearer " + sessionStorage.getItem("token")
            HTTP.post("/publications/", {
                texte: publication
            }, {
                headers: {
                    Authorization: token
                }
            }).then(res => {
                HTTP.get("/publications/" + id, {
                    headers: {
                        Authorization: token
                    }
                }).then(res => commit("setPublications", res.data))
            })
        }
    },
    getters: {}
}


export default publications;
