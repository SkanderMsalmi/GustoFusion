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
const router = createBrowserRouter([
  {
    path: "/admin",
    element: <AdminLayout />,

    children: [
      {
        path: "team",
        element: <h1>Hello Admin</h1>,
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
