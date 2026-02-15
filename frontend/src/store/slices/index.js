import { configureStore } from "@reduxjs/toolkit";

// import authReducer from "./slices/authSlice";
import categoryReducer from "./categorySlice";

export const store = configureStore({
  reducer: {
    category: categoryReducer
  },
});
