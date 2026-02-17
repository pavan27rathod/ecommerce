import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { browseCategories } from "@/services/category.service";
import { getCategoryDetails }
from "@/services/category.service";


export const fetchBrowseCategories = createAsyncThunk(
  "category/fetchBrowseCategories",
  async (_, thunkAPI) => {
    try {
      return await browseCategories();
    } catch (error) {
      return thunkAPI.rejectWithValue(
        error.response?.data || "Failed to fetch categories"
      );
    }
  }
);

export const fetchCategoryDetails = createAsyncThunk(
  "category/fetchCategoryDetails",

  async (slug, thunkAPI) => {

    try {

      return await getCategoryDetails(slug);

    } catch (error) {

      return thunkAPI.rejectWithValue(
        error.response?.data || "Failed to fetch category"
      );

    }

  }
);

const categorySlice = createSlice({
  name: "category",

  initialState: {
    browseCategories: [],
    categoryDetails: null,
    loading: false,
    error: null,
  },

  reducers: {},

  extraReducers: (builder) => {
    builder
      .addCase(fetchBrowseCategories.pending, (state) => {
        state.loading = true;
        state.error = null;
      })

      .addCase(fetchBrowseCategories.fulfilled, (state, action) => {
        state.loading = false;
        state.browseCategories = action.payload;
      })

      .addCase(fetchBrowseCategories.rejected, (state, action) => {
        state.loading = false;
        state.error = action.payload;
      })

      .addCase(fetchCategoryDetails.pending, (state) => {

        state.loading = true;
        state.error = null;

      })

      .addCase(fetchCategoryDetails.fulfilled, (state, action) => {

        state.loading = false;
        state.categoryDetails = action.payload;

      })

      .addCase(fetchCategoryDetails.rejected, (state, action) => {

        state.loading = false;
        state.error = action.payload;

      })

  },
});

export default categorySlice.reducer;
