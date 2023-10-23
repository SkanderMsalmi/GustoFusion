import React from "react";
import HeaderCol from "./collaborator/HeaderCol";
import FooterCol from "./collaborator/FooterCol";
import { Outlet } from "react-router-dom";

function ClientLayout() {
  return (
    <>
      <HeaderCol />
      <Outlet />
      <FooterCol />
    </>
  );
}

export default ClientLayout;
