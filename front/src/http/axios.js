import axios from "axios";

export const HTTP = axios.create({
  baseURL: "http://192.168.43.141:8080",
  headers: {
    "Content-Type": "application/json",
  },
});
