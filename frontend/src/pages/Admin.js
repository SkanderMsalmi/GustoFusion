import React from "react";
import SideBarAdmin from "../components/layouts/admin/SideBarAdmin";
import HeaderAdmin from "../components/layouts/admin/HeaderAdmin";
import ReservationsTable from "../components/common/Admin/Reservations/ReservationsTable";
import TablesTable from "../components/common/Admin/Tables/TablesTable";

function Admin() {
  return (
    <div>
      <HeaderAdmin />
      <div className="row">
        <div className="col-lg-2" style={{ paddingRight: "0px" }}>
          <SideBarAdmin />
        </div>
        <div className="col-lg-10 " style={{ backgroundColor: "#f5f5f5" }}>
          <TablesTable />
        </div>
      </div>
    </div>
  );
}

export default Admin;
