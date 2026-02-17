import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useParams } from "react-router-dom";

import { fetchProductsByCategoryAll }
from "@/store/slices/productSlice";

import ProductRow from "@/components/product/ProductRow";

export default function ProductListingAll() {

  const { categoryId } = useParams();

  const dispatch = useDispatch();

  const { products, loading, error } =
    useSelector((state) => state.product);

  useEffect(() => {

    dispatch(fetchProductsByCategoryAll({
      categoryId,
      page: 0
    }));

  }, [categoryId, dispatch]);

  if (loading)
    return <div className="p-6">Loading...</div>;

  if (error)
    return <div className="p-6 text-red-500">{error}</div>;

  return (

    <div className="max-w-[1400px] mx-auto px-6 py-6">

      {products.map((product) => (

        <ProductRow
          key={product.id}
          product={product}
        />

      ))}

    </div>

  );

}
