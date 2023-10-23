import "./App.css";

import Client from "./pages/Client";

// import Reservation from "./pages/Reservation";
import Cart from "./components/common/Cart/cart";
import { BrowserRouter as Router, Route, Switch, Routes, BrowserRouter } from 'react-router-dom';
import CartPage from "./pages/CartPage";
function App() {
  return (
    <BrowserRouter>
    <Routes>
    <Route path="/" element={<Client/>} />
      
        <Route path="/cart" element={<CartPage/>}  />
    </Routes>
    </BrowserRouter>
    // <div className="App">
    //   <Client />
    // </div>
  );
}

export default App;
