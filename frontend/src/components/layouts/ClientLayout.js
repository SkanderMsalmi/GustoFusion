import React from "react";
import Header from "./client/Header";
import Footer from "./client/Footer";
import { Outlet } from "react-router-dom";

function ClientLayout() {
  return (
    <>
      <Header />
      <Outlet />
      <Footer />
    </>
  );
}

export default ClientLayout;
