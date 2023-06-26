import { ToastContainer } from "react-toastify";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

//pages
import Index from "./pages/index";
import Home from "./pages/home/home";

//components
import Cart from "./components/home/cart";
import Start from "./components/start/start";
import Login from "./components/start/login";
import Signup from "./components/start/signup";
import Products from "./components/home/products";
import Purchases from "./components/home/purchases";

//globals
import "react-toastify/dist/ReactToastify.css";

function App() {
  return (
    <Router>
      <ToastContainer position="top-right" />
      <Routes>
        <Route path="/" element={<Index />}>
          <Route path="" element={<Start />} />
          <Route path="login" element={<Login />} />
          <Route path="signup" element={<Signup />} />
        </Route>
        <Route path="/home" element={<Home />}>
          <Route path="cart" element={<Cart />} />
          <Route path="products" element={<Products />} />
          <Route path="purchases" element={<Purchases />} />
        </Route>
      </Routes>
    </Router>
  );
}

export default App;
