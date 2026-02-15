import { Routes, Route, Navigate } from "react-router-dom";
import AuthLayout from "@/layouts/AuthLayout";
import Login from "@/pages/auth/Login";
import Register from "@/pages/auth/Register";
import CategoryLanding from "@/pages/category/CategoryLanding";
export default function AppRoutes() {
  return (
    <Routes>
      <Route element={<AuthLayout />}>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/browse-for-products" element={<CategoryLanding />} />
      </Route>

      {/* default */}
      <Route path="*" element={<Navigate to="/login" replace />} />
    </Routes>
  );
}
