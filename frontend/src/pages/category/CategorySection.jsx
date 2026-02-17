import { Link } from "react-router-dom";

export default function CategorySection({ category }) {

  return (

    <div className="border-b border-gray-300 py-2">

      <div className="flex">

        {/* IMAGE COLUMN (keep as placeholder) */}
        <div className="w-[72px] flex-shrink-0">

          <div className="w-[60px] h-[60px] border border-gray-300 bg-white"></div>

        </div>


        {/* CONTENT COLUMN */}
        <div className="flex-1">

          {/* TITLE ROW */}
          <div className="flex items-center mb-1">

            <Link
              to={`/category/${category.slug}`}
              className="text-[15px] font-semibold text-[#333] hover:text-blue-600"
            >
              {category.name}
            </Link>

            <span className="text-gray-500 text-[13px] ml-1">
              ({category.productCount})
            </span>

            <Link
              to={`/category/${category.slug}`}
              className="text-blue-600 text-[13px] ml-3 hover:underline"
            >
              View all
            </Link>

          </div>


          {/* SUBCATEGORY GRID — EXACT ELEMENT14 STYLE */}
          <div className="grid grid-cols-3 gap-x-32 gap-y-1">

            {category.subCategories?.map((child) => (

              <Link
                key={child.id}
                to={`/category/${child.slug}`}
                className="text-blue-600 text-[13px] hover:underline whitespace-nowrap"
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
