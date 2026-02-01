import { Outlet } from "react-router-dom";
import Header from "../components/common/Header";
import Footer from "../components/Footer";

export default function AuthLayout() {
  return (
    <>
      <Header/>
      <div className="min-h-screen flex items-center justify-center bg-gray-100">
        <div className="w-full max-w-md bg-white p-8 rounded shadow">
          <Outlet />
        </div>
      </div>
      <Footer />
    </>
    
  );
}
