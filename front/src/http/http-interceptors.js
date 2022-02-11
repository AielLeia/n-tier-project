import { HTTP } from './http-common'
import router from '../../router/router'
import handleError from '../../store/errors/errorManagement'

const TIMEOUT = 1000000;
const onRequestSuccess = config => {
    const token = JSON.parse(localStorage.getItem("token"));
    if (token) {
        if (!config.headers) {
            config.headers = {};
        }
        config.headers.Authorization = `Bearer ${token.id_token}`;
    }
    config.timeout = TIMEOUT;
    return config;
};

const setupAxiosInterceptors = onUnauthenticated => {
    const onResponseError = err => {
        const status = err.status || err.response.status;
        if (status === 403 || status === 401) {
            localStorage.removeItem("token");
            router.push("/account").catch(e => {handleError(e)})
            onUnauthenticated();
        }
        return Promise.reject(err);
    };
    if (HTTP.interceptors) {
        HTTP.interceptors.request.use(onRequestSuccess);
        HTTP.interceptors.response.use(res => res, onResponseError);
    }
};

export { onRequestSuccess, setupAxiosInterceptors };