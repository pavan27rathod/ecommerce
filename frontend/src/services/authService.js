import {httpClient} from "./httpClient";

export const registerUser = (data) => {
  return httpClient.post("/auth/register", data);
};

export const loginUser = (data) => {
  return httpClient.post("/auth/login", data);
};
