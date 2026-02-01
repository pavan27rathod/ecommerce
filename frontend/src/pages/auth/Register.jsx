import { Formik } from "formik";
import * as Yup from "yup";
import Input from "@/components/common/Input";
import { Link } from "react-router-dom";

const registerSchema = Yup.object({
  email: Yup.string().email("Invalid email").required("Required"),
  password: Yup.string()
    .min(8, "Minimum 8 characters")
    .matches(/[A-Z]/, "One uppercase letter")
    .matches(/[a-z]/, "One lowercase letter")
    .matches(/[0-9]/, "One number")
    .required("Required"),
  firstName: Yup.string().required("Required"),
  lastName: Yup.string().required("Required"),
  phone: Yup.string().required("Required"),
});

export default function Register() {
  return (
    <div className="w-full max-w-[520px] px-[48px] pt-[32px] pb-[80px]">
      {/* Header */}
      <h1 className="text-[28px] font-semibold text-black mb-[6px]">
        Register
      </h1>

      <p className="text-[14px] text-[#333] mb-[24px]">
        Already registered?{" "}
        <Link
          to="/login"
          className="text-[#0070c9] hover:underline"
        >
          Log In
        </Link>
      </p>

      <div className="h-[1px] bg-[#e5e5e5] mb-[32px]" />

      <Formik
        initialValues={{
          email: "",
          password: "",
          title: "",
          firstName: "",
          lastName: "",
          phone: "",
          company: "",
          gst: "",
          jobRole: "",
          usage: "",
          contactEmail: true,
          contactPhone: true,
          contactSms: true,
          mobile: "",
        }}
        validationSchema={registerSchema}
        onSubmit={(values) => {
          console.log("REGISTER DATA:", values);
        }}
      >
        {({
          values,
          errors,
          touched,
          handleChange,
          handleBlur,
          handleSubmit,
        }) => (
          <form onSubmit={handleSubmit} className="space-y-[24px]">
            {/* Email */}
            <Input
              label="Email Address"
              name="email"
              placeholder="name@company.com"
              value={values.email}
              onChange={handleChange}
              onBlur={handleBlur}
              error={errors.email}
              touched={touched.email}
              className="h-[44px] bg-[#f5f5f5] px-[14px] text-[15px]
                         border-b border-[#8a8a8a] focus:outline-none"
            />

            {/* Password */}
            <Input
              label="Password"
              name="password"
              type="password"
              placeholder="Enter your password"
              value={values.password}
              onChange={handleChange}
              onBlur={handleBlur}
              error={errors.password}
              touched={touched.password}
              className="h-[44px] bg-[#f5f5f5] px-[14px] text-[15px]
                         border-b border-[#8a8a8a] focus:outline-none"
            />

            {/* Password rules */}
            <ul className="text-[14px] text-[#444] space-y-[6px] ml-[2px]">
              <li>○ 8 or more characters</li>
              <li>○ One uppercase letter (A–Z)</li>
              <li>○ One lowercase letter (a–z)</li>
              <li>○ One number (0–9)</li>
            </ul>

            {/* Title */}
            <div>
              <label className="block text-[15px] mb-[6px]">
                Title
              </label>
              <select
                name="title"
                value={values.title}
                onChange={handleChange}
                className="w-full h-[44px] bg-[#f5f5f5] px-[14px]
                           text-[15px] border-b border-[#8a8a8a]
                           focus:outline-none"
              >
                <option value="">Please select</option>
                <option>Mr</option>
                <option>Ms</option>
                <option>Mrs</option>
              </select>
            </div>

            {/* First / Last Name */}
            <div className="grid grid-cols-2 gap-[24px]">
              <Input
                label="First Name"
                name="firstName"
                placeholder="First Name(s)"
                value={values.firstName}
                onChange={handleChange}
                onBlur={handleBlur}
                error={errors.firstName}
                touched={touched.firstName}
                className="h-[44px] bg-[#f5f5f5] px-[14px]
                           text-[15px] border-b border-[#8a8a8a]
                           focus:outline-none"
              />

              <Input
                label="Last Name"
                name="lastName"
                placeholder="Last Name(s)"
                value={values.lastName}
                onChange={handleChange}
                onBlur={handleBlur}
                error={errors.lastName}
                touched={touched.lastName}
                className="h-[44px] bg-[#f5f5f5] px-[14px]
                           text-[15px] border-b border-[#8a8a8a]
                           focus:outline-none"
              />
            </div>

            {/* Phone */}
            <Input
              label="Phone Number"
              name="phone"
              placeholder="Please enter number"
              value={values.phone}
              onChange={handleChange}
              onBlur={handleBlur}
              error={errors.phone}
              touched={touched.phone}
              className="h-[44px] bg-[#f5f5f5] px-[14px]
                         text-[15px] border-b border-[#8a8a8a]
                         focus:outline-none"
            />

            {/* Company */}
            <Input
              label="Company Name (Optional)"
              name="company"
              placeholder="Company Name"
              value={values.company}
              onChange={handleChange}
              className="h-[44px] bg-[#f5f5f5] px-[14px]
                         text-[15px] border-b border-[#8a8a8a]
                         focus:outline-none"
            />

            {/* GST */}
            <Input
              label="GST number"
              name="gst"
              placeholder="Enter GST Number"
              value={values.gst}
              onChange={handleChange}
              className="h-[44px] bg-[#f5f5f5] px-[14px]
                         text-[15px] border-b border-[#8a8a8a]
                         focus:outline-none"
            />

            {/* Job Role */}
            <div>
              <label className="block text-[15px] mb-[6px]">
                Which of the following best describes your job role?
              </label>
              <select
                name="jobRole"
                value={values.jobRole}
                onChange={handleChange}
                className="w-full h-[44px] bg-[#f5f5f5] px-[14px]
                           text-[15px] border-b border-[#8a8a8a]
                           focus:outline-none"
              >
                <option value="">Please select</option>
                <option>Engineer</option>
                <option>Student</option>
                <option>Purchasing</option>
              </select>
            </div>

            {/* Usage */}
            <div>
              <label className="block text-[15px] mb-[6px]">
                What is the primary use for the products you purchase?
              </label>
              <select
                name="usage"
                value={values.usage}
                onChange={handleChange}
                className="w-full h-[44px] bg-[#f5f5f5] px-[14px]
                           text-[15px] border-b border-[#8a8a8a]
                           focus:outline-none"
              >
                <option value="">Please select</option>
                <option>Personal</option>
                <option>Business</option>
                <option>Education</option>
              </select>
            </div>

            {/* Contact Preferences */}
            <div>
              <h3 className="text-[16px] font-semibold mb-[12px]">
                How should we contact you? (Optional)
              </h3>

              <div className="space-y-[10px] text-[15px]">
                <label className="flex items-center gap-[10px]">
                  <input type="checkbox" name="contactEmail" checked={values.contactEmail} onChange={handleChange} />
                  Email Address
                </label>

                <label className="flex items-center gap-[10px]">
                  <input type="checkbox" name="contactPhone" checked={values.contactPhone} onChange={handleChange} />
                  Phone Number
                </label>

                <label className="flex items-center gap-[10px]">
                  <input type="checkbox" name="contactSms" checked={values.contactSms} onChange={handleChange} />
                  SMS / MMS
                </label>
              </div>
            </div>

            {/* Mobile */}
            <Input
              label="Mobile Number"
              name="mobile"
              placeholder="Please enter Mobile Number"
              value={values.mobile}
              onChange={handleChange}
              className="h-[44px] bg-[#f5f5f5] px-[14px]
                         text-[15px] border-b border-[#8a8a8a]
                         focus:outline-none"
            />

            {/* Register Button */}
            <button
              type="submit"
              className="mt-[16px] bg-[#e5e5e5] text-[#999]
                         px-[36px] py-[12px] rounded-[6px]
                         text-[15px] cursor-not-allowed"
            >
              Register
            </button>
          </form>
        )}
      </Formik>
    </div>
  );
}
