import { useState } from "react";

import styles from "./home.module.scss";

const Cart = () => {
  const [cartItems, setCartItems] = useState([
    { id: 1, name: "Product 1", price: 9.99, quantity: 1 },
    { id: 2, name: "Product 2", price: 14.99, quantity: 2 },
    { id: 3, name: "Product 3", price: 19.99, quantity: 3 },
  ]);

  const calculateTotalCost = () => {
    return cartItems
      .reduce((total, item) => total + item.price * item.quantity, 0)
      .toFixed(2);
  };

  const increaseQuantity = (itemId) => {
    setCartItems((prevItems) =>
      prevItems.map((item) =>
        item.id === itemId ? { ...item, quantity: item.quantity + 1 } : item
      )
    );
  };

  const decreaseQuantity = (itemId) => {
    setCartItems((prevItems) =>
      prevItems.map((item) =>
        item.id === itemId ? { ...item, quantity: item.quantity - 1 } : item
      )
    );
  };

  return (
    <div className={styles.cart_page}>
      <h2>Cart</h2>
      {cartItems.length > 0 ? (
        <div className={styles.cart_items}>
          <ul>
            {cartItems.map((item) => (
              <li key={item.id}>
                <span className={styles.name}>{item.name}</span>
                <span>Price: {item.price}</span>
                <span>Quantity: {item.quantity}</span>
                <div className={styles.buttons}>
                  <button onClick={() => increaseQuantity(item.id)}>+</button>
                  <button onClick={() => decreaseQuantity(item.id)}>-</button>
                </div>
              </li>
            ))}
          </ul>
          <p className={styles.total}>Total Cost: ${calculateTotalCost()}</p>
        </div>
      ) : (
        <p className="empty-cart-message">Your cart is empty.</p>
      )}
      <button className={styles.purchase}>Purchase</button>
    </div>
  );
};

export default Cart;
