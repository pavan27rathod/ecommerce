import CategorySection from "./CategorySection";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";



import { fetchBrowseCategories }
from "@/store/slices/categorySlice";

export default function CategoryLanding() {

  const dispatch = useDispatch();

  // ✅ GET DATA FROM REDUX STORE
  const browseCategories = useSelector(
    (state) => state.category.browseCategories
  );

  const loading = useSelector(
    (state) => state.category.loading
  );

  const error = useSelector(
    (state) => state.category.error
  );

  // ✅ FETCH DATA ON LOAD
  useEffect(() => {

    dispatch(fetchBrowseCategories());

  }, [dispatch]);


  if (loading)
    return <div className="p-6">Loading categories...</div>;

  if (error)
    return <div className="p-6 text-red-500">{error}</div>;


  return (

    <div className="w-full bg-white">

      <div className="max-w-[1200px] mx-auto px-6 py-6">

        {browseCategories.map((category) => (

          <CategorySection
            key={category.id}
            category={category}
          />

        ))}

      </div>

    </div>

  );
}
