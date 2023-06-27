import { useState } from "react";

import styles from "./home.module.scss";

const Products = () => {
  const [cartItems, setCartItems] = useState([]);

  const products = [
    { id: 1, name: "Product 1", price: 9.99, type: "Type A" },
    { id: 2, name: "Product 2", price: 14.99, type: "Type B" },
    { id: 3, name: "Product 3", price: 19.99, type: "Type C" },
  ];

  const addToCart = (product) => {
    setCartItems([...cartItems, product]);
  };

  return (
    <div className={styles.products_container}>
      <h2>Products</h2>
      <div className={styles.product_list}>
        {products.map((product) => (
          <div key={product.id} className={styles.product_card}>
            <h3>{product.name}</h3>
            <p>Type: {product.type}</p>
            <p>Price: ${product.price.toFixed(2)}</p>
            <button onClick={() => addToCart(product)}>Add to Cart</button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Products;
