export default function ProductRow({ product }) {

  return (

    <div className="flex border-b border-gray-200 p-4">

      <div className="w-[100px]">
        <img
          src={`http://localhost:8080${product.imageUrl}`}
          className="w-[80px] h-[80px] object-contain"
        />
      </div>

      <div className="flex-1">

        <div className="text-blue-600 font-medium hover:underline">
          {product.name}
        </div>

        <div className="text-sm text-gray-600 mt-1">
          {product.manufacturer}
        </div>

      </div>

      <div className="w-[200px] text-right">

        <div className="text-green-600 font-semibold">
          ₹ {product.price}
        </div>

        <button className="mt-2 bg-blue-600 text-white px-4 py-1 rounded hover:bg-blue-700">
          Add
        </button>

      </div>

    </div>

  );

}
