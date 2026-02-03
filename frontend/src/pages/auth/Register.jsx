import { Formik, Form } from "formik";
import * as Yup from "yup";
import Input from "@/components/common/Input";
import { Link } from "react-router-dom";
import { registerUser } from "@/services/authService";
import { toast } from "react-toastify";


export const registerSchema = Yup.object({
  email: Yup.string()
    .email("Invalid email")
    .required("Required"),

  password: Yup.string()
    .min(8, "Minimum 8 characters")
    .required("Required"),

  firstName: Yup.string().required("Required"),
  lastName: Yup.string().required("Required"),

  phone: Yup.string()
    .matches(/^[0-9+]{7,15}$/, "Invalid phone number")
    .nullable()
    .notRequired(),

  mobile: Yup.string()
    .matches(/^[0-9+]{7,15}$/, "Invalid mobile number")
    .nullable()
    .notRequired(),

  company: Yup.string().nullable().notRequired(),
  gst: Yup.string().nullable().notRequired(),

  title: Yup.string().oneOf(["", "Mr", "Ms", "Mrs"]),
  jobRole: Yup.string().oneOf(["", "Engineer", "Student", "Purchasing"]),
  usage: Yup.string().oneOf(["", "Personal", "Business", "Education"]),

  contactEmail: Yup.boolean(),
  contactPhone: Yup.boolean(),
  contactSms: Yup.boolean(),
});


export default function Register() {
  return (
    <div className="w-full max-w-[520px] px-[48px] pt-[32px] pb-[80px]">
      <h1 className="text-[28px] font-semibold text-black mb-[6px]">
        Register
      </h1>

      <p className="text-[14px] text-[#333] mb-[24px]">
        Already registered?{" "}
        <Link to="/login" className="text-[#0070c9] hover:underline">
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
        onSubmit={async (values, { setSubmitting, setFieldError }) => {
          console.log("SUBMIT FIRED", values);

          try {
            

            const payload = {
              email: values.email,
              password: values.password,
              title: values.title,
              firstName: values.firstName,
              lastName: values.lastName,

              phoneNumber: values.phone || null,
              mobileNumber: values.mobile || null,

              companyName: values.company || null,
              gstNumber: values.gst || null,
              primaryUse: values.usage || null,

              jobRole: values.jobRole,
              contactEmail: values.contactEmail,
              contactPhone: values.contactPhone,
              contactSms: values.contactSms,
            };

            await registerUser(payload);

            // await registerUser(values); // temporary, no mapping yet
            toast.success("Registration successful. Please login.");
            console.log("API SUCCESS");
          } catch (err) {

            toast.error("Registration failed. Try again.");
            console.log("API ERROR FULL OBJECT 👉", err);
            console.log("API ERROR MESSAGE 👉", err.message);
            console.log("API ERROR RESPONSE 👉", err.response);
            
            if (err.response?.status === 409) {
              toast.error("Email already registered");
              setFieldError("email", "Email already registered");
            }



          } finally {
            setSubmitting(false);
          }
        }}

      >
        {({
          values,
          errors,
          touched,
          handleChange,
          handleBlur,
          isSubmitting,
        }) => (
          <Form className="space-y-[24px]">
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
              <label className="block text-[15px] mb-[6px]">Title</label>
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
                value={values.firstName}
                onChange={handleChange}
                onBlur={handleBlur}
                error={errors.firstName}
                touched={touched.firstName}
              />

              <Input
                label="Last Name"
                name="lastName"
                value={values.lastName}
                onChange={handleChange}
                onBlur={handleBlur}
                error={errors.lastName}
                touched={touched.lastName}
              />
            </div>

            {/* Phone */}
            <Input
              label="Phone Number"
              name="phone"
              value={values.phone}
              onChange={handleChange}
              onBlur={handleBlur}
              error={errors.phone}
              touched={touched.phone}
            />

            {/* Company */}
            <Input
              label="Company Name (Optional)"
              name="company"
              value={values.company}
              onChange={handleChange}
            />

            {/* GST */}
            <Input
              label="GST number"
              name="gst"
              value={values.gst}
              onChange={handleChange}
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
                  <input
                    type="checkbox"
                    name="contactEmail"
                    checked={values.contactEmail}
                    onChange={handleChange}
                  />
                  Email Address
                </label>

                <label className="flex items-center gap-[10px]">
                  <input
                    type="checkbox"
                    name="contactPhone"
                    checked={values.contactPhone}
                    onChange={handleChange}
                  />
                  Phone Number
                </label>

                <label className="flex items-center gap-[10px]">
                  <input
                    type="checkbox"
                    name="contactSms"
                    checked={values.contactSms}
                    onChange={handleChange}
                  />
                  SMS / MMS
                </label>
              </div>
            </div>

            {/* Mobile */}
            <Input
              label="Mobile Number"
              name="mobile"
              value={values.mobile}
              onChange={handleChange}
            />

            {/* Submit */}
            <button
              type="submit"
              disabled={isSubmitting}
              className={`mt-[16px] px-[36px] py-[12px] rounded-[6px] text-[15px]
                ${
                  isSubmitting
                    ? "bg-[#e5e5e5] text-[#999] cursor-not-allowed"
                    : "bg-[#0070c9] text-white hover:bg-[#005fa3]"
                }`}
            >
              Register
            </button>
          </Form>
        )}
      </Formik>
    </div>
  );
}





