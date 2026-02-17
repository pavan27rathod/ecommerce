import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";

import { useParams } from "react-router-dom";

import { fetchProductsByCategory } from "@/store/slices/productSlice";

import ProductRow from "@/components/product/ProductRow";

export default function ProductListing() {

  const { categoryId } = useParams();

  const dispatch = useDispatch();

  const { products, loading }
    = useSelector((state) => state.product);


  useEffect(() => {

    dispatch(fetchProductsByCategory(categoryId));

  }, [categoryId, dispatch]);


  if (loading)
    return <div className="p-6">Loading...</div>;


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
