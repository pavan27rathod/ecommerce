import CategorySection from "./CategorySection";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchBrowseCategories } from "@/store/slices/categorySlice";

export default function CategoryLanding() {

  const dispatch = useDispatch();

  const { browseCategories, loading, error } =
    useSelector((state) => state.category);

  useEffect(() => {
    dispatch(fetchBrowseCategories());
  }, [dispatch]);

  if (loading)
    return <div className="px-4 py-2">Loading categories...</div>;

  if (error)
    return <div className="px-4 py-2 text-red-500">{error}</div>;

  return (

    <div className="w-full bg-white">

      <div className="max-w-[1280px] mx-auto px-4 pt-2 pb-4">

        {browseCategories?.map((category) => (

          <CategorySection
            key={category.id}
            category={category}
          />

        ))}

      </div>

    </div>

  );

}
