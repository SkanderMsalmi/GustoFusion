import React from "react";
import { Outlet } from "react-router-dom";
import SideBarAdmin from "./admin/SideBarAdmin";
import HeaderAdmin from "./admin/HeaderAdmin";

function AdminLayout() {
  return (
    <>
      <HeaderAdmin />
      <div className="row">
        <div className="col-lg-2" style={{ paddingRight: "0px" }}>
          <SideBarAdmin />
        </div>
        <div className="col-lg-10 " style={{ backgroundColor: "#f5f5f5" }}>
          <Outlet />
        </div>
      </div>
    </>
  );
}

export default AdminLayout;
