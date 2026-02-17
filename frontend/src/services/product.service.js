import { httpClient } from "./httpClient";

export const getProductsByCategory = async (
  categoryId,
  page = 0,
  size = 20
) => {

  const response = await httpClient.get(
    `/api/products/category/${categoryId}`,
    {
      params: { page, size }
    }
  );

  return response.data;

};

export const getProductsByCategoryAll = async (categoryId, page = 0, size = 20) => {
  const response = await httpClient.get(
    `/api/products/category/${categoryId}/all`,
    { params: { page, size } }
  );
  return response.data;
};