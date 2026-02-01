import { Formik, Form } from "formik";
import { loginSchema } from "@/utils/validators";
import Header from "../../components/common/Header";

export default function Login() {
  return (
    <div className="min-h-screen bg-white">
      <div className="pl-[48px] pt-[40px] max-w-[520px]">
        {/* Heading */}
        <h1 className="text-[28px] font-semibold mb-[28px] text-black">
          Log In
        </h1>

        <Formik
          initialValues={{
            email: "",
            password: "",
            rememberMe: true,
          }}
          validationSchema={loginSchema}
          onSubmit={(values) => {
            console.log("Login Data:", values);
          }}
        >
          {({
            values,
            errors,
            touched,
            handleChange,
            handleBlur,
            handleSubmit,
            isSubmitting,
          }) => (
            <Form onSubmit={handleSubmit}>
              {/* Email */}
              <div className="mb-[24px]">
                <label className="block text-[15px] mb-[6px] text-black">
                  Email or username
                </label>
                <input
                  type="text"
                  name="email"
                  placeholder="name@company.com or Username123"
                  value={values.email}
                  onChange={handleChange}
                  onBlur={handleBlur}
                  className="
                    w-[420px]
                    h-[44px]
                    bg-[#f5f5f5]
                    px-[14px]
                    text-[15px]
                    text-black
                    placeholder:text-[#6b6b6b]
                    border-b
                    border-[#8a8a8a]
                    focus:outline-none
                    focus:border-black
                  "
                />
                {touched.email && errors.email && (
                  <p className="text-[13px] text-[#d93025] mt-[4px]">
                    {errors.email}
                  </p>
                )}
              </div>

              {/* Password */}
              <div className="mb-[24px]">
                <label className="block text-[15px] mb-[6px] text-black">
                  Password
                </label>
                <input
                  type="password"
                  name="password"
                  placeholder="Password"
                  value={values.password}
                  onChange={handleChange}
                  onBlur={handleBlur}
                  className="
                    w-[420px]
                    h-[44px]
                    bg-[#f5f5f5]
                    px-[14px]
                    text-[15px]
                    text-black
                    placeholder:text-[#6b6b6b]
                    border-b
                    border-[#8a8a8a]
                    focus:outline-none
                    focus:border-black
                  "
                />
                {touched.password && errors.password && (
                  <p className="text-[13px] text-[#d93025] mt-[4px]">
                    {errors.password}
                  </p>
                )}
              </div>

              {/* Remember me */}
              <div className="flex items-center gap-[8px] mb-[32px]">
                <input
                  type="checkbox"
                  name="rememberMe"
                  checked={values.rememberMe}
                  onChange={handleChange}
                  className="w-[16px] h-[16px] accent-black"
                />
                <span className="text-[15px] text-black">
                  Remember me
                </span>
              </div>

              {/* Login button */}
              <button
                type="submit"
                disabled={isSubmitting}
                className="
                  bg-[#0070c9]
                  text-white
                  text-[15px]
                  px-[36px]
                  py-[12px]
                  rounded-[6px]
                  hover:bg-[#005fa3]
                  transition
                  disabled:opacity-50
                "
              >
                Log In
              </button>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
}
