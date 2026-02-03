import axios from "axios";
import { API_BASE_URL } from "./api";

//Creating axios instance so that we don't have to use & configure axios again & again
//While making POST request we need URL & header, we just configuring that
export const httpClient = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    "Content-Type": "application/json",
  },
});
