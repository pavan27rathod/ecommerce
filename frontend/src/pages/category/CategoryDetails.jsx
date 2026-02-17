import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useParams } from "react-router-dom";

import { fetchCategoryDetails } from "@/store/slices/categorySlice";

import SubcategoryCard from "@/components/category/SubcategoryCard";
import { useNavigate } from "react-router-dom";

export default function CategoryDetails() {

  const { slug } = useParams();

  const dispatch = useDispatch();

  const { categoryDetails, loading, error } =
    useSelector((state) => state.category);

  useEffect(() => {

    dispatch(fetchCategoryDetails(slug));

  }, [slug, dispatch]);

  const navigate = useNavigate();

  const handleViewAllProducts = () => {

    if (!categoryDetails?.id) return;

    navigate(`/products/category/${categoryDetails.id}/all`);

  };


    // const showAllProducts = () => {
    //   navigate(`/products/category/${category.id}/all`);

    // };
  if (loading)
    return <div className="p-6">Loading...</div>;

  if (error)
    return <div className="p-6 text-red-500">{error}</div>;

  if (!categoryDetails)
    return null;

  return (

    <div className="max-w-[1200px] mx-auto px-6 py-6">

      <h1 className="text-xl font-semibold mb-6">
        {categoryDetails.name}
      </h1>

      <div className="grid grid-cols-5 gap-4">

        {categoryDetails.children?.map((sub) => (

          <SubcategoryCard
            key={sub.id}
            subcategory={sub}
          />

        ))}

      </div>
      <div className="text-center mt-6">

        <button
          onClick={handleViewAllProducts}
          className="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700"
        >
          View All Products
        </button>

        </div>


    </div>

  );

}
