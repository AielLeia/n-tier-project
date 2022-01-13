import { createWebHistory, createRouter} from "vue-router";
import Home from "../pages/Home.vue";
import Login from "../pages/Login.vue";
import store from "../store/main";
const routes = [
    {
        path: "/",
        name: "Home",
        component: Home
    },
    {
        path: "/login",
        name: "Login",
        component: Login
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;