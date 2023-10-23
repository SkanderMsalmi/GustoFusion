import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import reportWebVitals from "./reportWebVitals";
import { RouterProvider, createBrowserRouter } from "react-router-dom";
import AdminLayout from "./components/layouts/AdminLayout";
import ClientLayout from "./components/layouts/ClientLayout";
import CollaboratorLayout from "./components/layouts/CollaboratorLayout";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";
import BookTableSection from "./components/common/BookTableSection";
import ListReservation from "./components/common/Personel/Reservations/ListReservation";
import ListTable from "./components/common/Client/ListTable";
import CartPage from "./pages/CartPage";
import Chefs from "./pages/Employees/Chefs";
import CreateChef from "./pages/Employees/CreateChef";
import UpdateChef from "./pages/Employees/UpdateChef";
import Livreurs from "./pages/Employees/Livreurs";
import CreateLivreur from "./pages/Employees/CreateLivreur";
import UpdateLivreur from "./pages/Employees/UpdateLivreur";
import SousChefs from "./pages/Employees/SousChefs";
import CreateSousChef from "./pages/Employees/CreateSousChef";
import UpdateSousChef from "./pages/Employees/UpdateSousChef";
const router = createBrowserRouter([
  {
    path: "/admin",
    element: <AdminLayout />,

    children: [
      {
        path: "team",
        element: <h1>Hello Admin</h1>,
      },
      {
        path: "employees/chefs",
        element: <Chefs />,
      },
      {
        path: "employees/chefs/create",
        element: <CreateChef />,
      },
      {
        path: "employees/chefs/edit/:id",
        element: <UpdateChef />,
      },
      {
        path: "employees/livreurs",
        element: <Livreurs />,
      },
      {
        path: "employees/livreurs/create",
        element: <CreateLivreur />,
      },
      {
        path: "employees/livreurs/edit/:id",
        element: <UpdateLivreur />,
      },
      {
        path: "employees/sousChefs",
        element: <SousChefs />,
      },
      {
        path: "employees/sousChefs/create",
        element: <CreateSousChef />,
      },
      {
        path: "employees/sousChefs/edit/:id",
        element: <UpdateSousChef />,
      },
    ],
  },
  {
    path: "/",
    element: <ClientLayout />,
    children: [
      {
        path: "/",
        element: <Home />,
      },
      {
        path: "login",
        element: <Login />,
      },
      {
        path: "register",
        element: <Register />,
      },
      {
        path: "reservation",
        element: <BookTableSection />,
      },
      {
        path: "table",
        element: <ListTable />,
      },
      {
        path: "cart",
        element: <CartPage />,
      },
    ],
  },
  {
    path: "collaborator",
    element: <CollaboratorLayout />,
    children: [
      {
        path: "reservations",
        element: <ListReservation />,
      },
    ],
  },
]);

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
