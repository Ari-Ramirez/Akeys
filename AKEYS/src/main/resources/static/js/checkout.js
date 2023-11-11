// Function to add items to the cart
function addToCart(itemName, itemPrice) {
    console.log(`Added to Cart: ${itemName} - $${itemPrice}`);

    const cart = loadCart();
    cart.push({ name: itemName, price: itemPrice, quantity: 1 });

    // Save the updated cart to local storage
    localStorage.setItem("cart", JSON.stringify(cart));

    // Update the cart display
    displayCart();

    // Calculate total price and update
    updateTotal();
}

// Function to increment the quantity of an item in the cart
function incrementItemQuantity(item) {
    const cart = loadCart();
    const itemIndex = cart.findIndex(cartItem => cartItem.name === item.name);

    if (itemIndex !== -1) {
        // Increment the quantity for the item
        cart[itemIndex].quantity += 1;

        // Update the cart in local storage
        localStorage.setItem('cart', JSON.stringify(cart));

        // Redisplay the cart with the updated data
        displayCart();

        // Calculate total price and update
        updateTotal();
    }
}

// Function to load cart data from local storage
function loadCart() {
    const cart = JSON.parse(localStorage.getItem("cart"));
    console.log("Retrieved cart from local storage:", cart);
    return cart ? cart : [];
}

function displayCart() {
    const cartItemsElement = document.getElementById('cart-items');
    if (cartItemsElement) {
        cartItemsElement.innerHTML = '';
        const cart = loadCart();

        cart.forEach(item => {
            const cartItemElement = document.createElement('li');
            const cartItemName = document.createElement('span');
            cartItemName.textContent = item.name + '  $' + item.price + ' x' + ' ' + item.quantity;

            const removeButton = document.createElement('button');
            removeButton.textContent = ' - ';
            removeButton.addEventListener('click', () => {

                removeItemFromCart(item);
            });

            const addQuantityButton = document.createElement('button');
            addQuantityButton.textContent = '+';
            addQuantityButton.addEventListener('click', () => {

                incrementItemQuantity(item);
            });

            cartItemElement.appendChild(cartItemName);
            cartItemElement.appendChild(removeButton);
            cartItemElement.appendChild(addQuantityButton);
            cartItemsElement.appendChild(cartItemElement);
        });


        updateTotal();
    }
}

// Function to remove an item from the cart
function removeItemFromCart(item) {
    const cart = loadCart();
    const itemIndex = cart.findIndex(cartItem => cartItem.name === item.name);

    if (itemIndex !== -1) {
        cart.splice(itemIndex, 1);
        // Update the cart in local storage
        localStorage.setItem('cart', JSON.stringify(cart));
        // Redisplay the cart with the updated data
        displayCart();
        // Calculate total price and update
        updateTotal();
    }
}

// Function to calculate and update the total price
function updateTotal() {
    const cart = loadCart();
    let totalPrice = 0;

    cart.forEach(item => {
        totalPrice += item.price * item.quantity;
    });

    const totalElement = document.getElementById('total');
    if (totalElement) {
        totalElement.textContent = 'Total: $' + totalPrice;
    }
}

displayCart();