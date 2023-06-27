import { useState } from "react";
import { Outlet, useNavigate } from "react-router";

//icons
import { FaBoxes } from "react-icons/fa";
// import { AiFillBoxPlot } from "react-icons/ai";
import { BsFillCartFill } from "react-icons/bs";

//styles
import styles from "./home.module.scss";

const Home = () => {
  const navigate = useNavigate();

  const [active, setActive] = useState("products");

  const handleActive = (value) => {
    setActive(value);
    navigate(`/home/${value}`);
  };

  return (
    <>
      <div className={styles.container}>
        <div className={styles.sidebar}>
          <div className={styles.header}>
            <p className={styles.head}>
              Binary <span>Supermarket</span>
            </p>
          </div>
          <div className={styles.menu}>
            <div
              className={active === "products" ? styles.active : styles.one}
              onClick={() => handleActive("products")}
            >
              <FaBoxes className={styles.icon} />
              <p>Products</p>
            </div>
            <div
              className={active === "cart" ? styles.active : styles.one}
              onClick={() => handleActive("cart")}
            >
              <BsFillCartFill className={styles.icon} />
              <p>Cart</p>
            </div>
            {/* <div
              className={active === "purchases" ? styles.active : styles.one}
              onClick={() => handleActive("purchases")}
            >
              <AiFillBoxPlot className={styles.icon} />
              <p>Purchases</p>
            </div> */}
          </div>
        </div>
        <div className={styles.content}>
          <div className={styles.notes}>
            <Outlet />
          </div>
        </div>
      </div>
    </>
  );
};

export default Home;
