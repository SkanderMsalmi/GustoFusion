import React from "react";
import Header from "../components/layouts/client/Header";
import BookTableSection from "../components/common/BookTableSection";
import Cart from "../components/common/Cart/cart";
import Footer from "../components/layouts/client/Footer";

function CartPage() {
  return (
    <div>
      <Header />
      <Cart />
      <Footer />
    </div>
  );
}

export default CartPage;
