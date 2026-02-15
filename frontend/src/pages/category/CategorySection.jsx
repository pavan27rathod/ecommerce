import { Link } from "react-router-dom";

export default function CategorySection({ category }) {

  return (

    <div className="border-b border-gray-300 py-5">

      <div className="flex items-start">

        {/* LEFT IMAGE COLUMN */}
        <div className="w-[80px] mr-4 flex-shrink-0">

          <img
            src={`http://localhost:8080${category.imageUrl}`}
            alt={category.name}
            className="w-[60px] h-[60px] object-contain"
          />

        </div>


        {/* RIGHT CONTENT COLUMN */}
        <div className="flex-1 min-w-0">

          {/* TITLE */}
          <div className="flex items-center mb-2">

            <Link
              to={`/category/${category.id}`}
              className="text-[16px] font-semibold text-gray-900 hover:text-blue-600"
            >
              {category.name}
            </Link>

            <span className="text-gray-500 text-sm ml-2">
              ({category.productCount})
            </span>

            <Link
              to={`/category/${category.id}`}
              className="text-blue-600 text-sm ml-3 hover:underline"
            >
              View all
            </Link>

          </div>


          {/* SUBCATEGORY GRID */}
          <div className="grid grid-cols-3 gap-x-24 gap-y-1">

            {category.children?.map((child) => (

              <Link
                key={child.id}
                to={`/category/${child.id}`}
                className="text-blue-600 text-[14px] hover:underline block"
              >
                {child.name}

                <span className="text-gray-500 ml-1">
                  ({child.productCount})
                </span>

              </Link>

            ))}

          </div>

        </div>

      </div>

    </div>

  );
}
