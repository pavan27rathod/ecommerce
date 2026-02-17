import { httpClient } from "./httpClient";

export const browseCategories = async () => {

  const response = await httpClient.get("/api/categories/browse");

  return response.data;

};

export const getCategoryDetails = async (slug) => {

  const response =
    await httpClient.get(`/api/categories/${slug}`);

  return response.data;

};
