import {httpClient} from "./httpClient";

export const registerUser = (data) => {
  console.log("REGISTER USER SERVICE HIT", data);
  return httpClient.post("/auth/register", data);
};

export const loginUser = (data) => {
  return httpClient.post("/auth/login", data);
};
