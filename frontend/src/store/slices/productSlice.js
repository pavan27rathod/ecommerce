import { createSlice, createAsyncThunk }
from "@reduxjs/toolkit";

import {
  getProductsByCategory,
  getProductsByCategoryAll
} from "@/services/product.service";


export const fetchProductsByCategory =
createAsyncThunk(

  "product/fetchProductsByCategory",

  async (categoryId, thunkAPI) => {

    try {

      return await getProductsByCategory(categoryId);

    } catch (error) {

      return thunkAPI.rejectWithValue(error.response?.data);

    }

  }

);

export const fetchProductsByCategoryAll =
createAsyncThunk(
  "product/fetchProductsByCategoryAll",

  async ({ categoryId, page }, thunkAPI) => {
    try {

      return await getProductsByCategoryAll(categoryId, page, 20);

    } catch (error) {

      return thunkAPI.rejectWithValue(
        error.response?.data || "Failed to fetch products"
      );

    }
  }
);

const productSlice = createSlice({

  name: "product",

  initialState: {
    products: [],
    loading: false,
    error: null,
  },

  extraReducers: (builder) => {

    builder

      .addCase(fetchProductsByCategory.pending,
        (state) => {

          state.loading = true;

        })

      .addCase(fetchProductsByCategory.fulfilled,
        (state, action) => {

          state.loading = false;

          state.products = action.payload.content;

        })

      .addCase(fetchProductsByCategory.rejected,
        (state, action) => {

          state.loading = false;

          state.error = action.payload;

        })

        .addCase(fetchProductsByCategoryAll.pending, (state) => {
        state.loading = true;
        })

        .addCase(fetchProductsByCategoryAll.fulfilled, (state, action) => {
        state.loading = false;
        state.products = action.payload.content;
        })

        .addCase(fetchProductsByCategoryAll.rejected, (state, action) => {
        state.loading = false;
        state.error = action.payload;
        })


  }

});

export default productSlice.reducer;
