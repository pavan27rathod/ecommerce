import { useNavigate } from "react-router-dom";

export default function SubcategoryCard({ subcategory }) {

  const navigate = useNavigate();

  const handleClick = () => {

    navigate(`/products/category/${subcategory.id}`);

  };

  return (

    <div
      onClick={handleClick}
      className="cursor-pointer border border-gray-300 p-4 hover:shadow"
    >

      <img
        src={`http://localhost:8080${subcategory.imageUrl}`}
        className="h-[100px] object-contain mx-auto"
      />

      <div className="text-center mt-2 text-blue-600">

        {subcategory.name}

      </div>

    </div>

  );

}
