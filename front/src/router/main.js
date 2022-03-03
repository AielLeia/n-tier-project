import { createWebHistory, createRouter} from "vue-router";
import Home from "../pages/Home.vue";
import Login from "../pages/Login.vue";
import Register from "../pages/Register.vue";
import SuccessRegister from "../pages/SuccessRegister.vue";
import Publications from "../pages/Publications.vue";
import Profile from "../pages/Profile.vue";

const routes = [
    {
        path: "/",
        name: "Home",
        component: Home,
        children: [
            {
                path: "",
                name: "Publications",
                component: Publications
            },
            {
                path: "/:userId",
                name: "Profile",
                component: Profile
            }
        ]
    },
    {
        path: "/account",
        name: "Login",
        component: Login
    },
    {
        path: "/register",
        name: "Register",
        component: Register
    },
    {
        path: "/success",
        name: "Success",
        component: SuccessRegister
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

router.beforeEach((to, from, next) => {
    const token = sessionStorage.getItem("token");
    if((token === "" || token === null) && to.name !== 'Login' && to.name !== 'Register') {
        next({name: 'Login'})
    } else {
        next()
    }
})

export default router;