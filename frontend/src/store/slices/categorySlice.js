import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { browseCategories } from "@/services/category.service";

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

const categorySlice = createSlice({
  name: "category",

  initialState: {
    browseCategories: [],
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
      });
  },
});

export default categorySlice.reducer;
