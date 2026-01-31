export default function Input({
  label,
  name,
  type = "text",
  value,
  onChange,
  onBlur,
  error,
  touched,
}) {
  return (
    <div className="mb-4">
      <label className="block text-sm font-medium mb-1">{label}</label>

      <input
        name={name}
        type={type}
        value={value}
        onChange={onChange}
        onBlur={onBlur}
        className={`w-full px-3 py-2 border rounded outline-none
          ${error && touched ? "border-red-500" : "border-gray-300"}
        `}
      />

      {error && touched && (
        <p className="text-red-500 text-xs mt-1">{error}</p>
      )}
    </div>
  );
}
