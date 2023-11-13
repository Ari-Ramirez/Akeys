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
                decrementItemQuantity(item);
            });

            removeButton.classList.add('remove-button');

            const addQuantityButton = document.createElement('button');
            addQuantityButton.textContent = ' + ';
            addQuantityButton.addEventListener('click', () => {
                incrementItemQuantity(item);
            });

            addQuantityButton.classList.add('add-quantity-button');

            cartItemElement.appendChild(cartItemName);
            cartItemElement.appendChild(removeButton);
            cartItemElement.appendChild(addQuantityButton);
            cartItemsElement.appendChild(cartItemElement);
        });

        updateTotal();
    }
}

// Function to decrement the quantity of an item in the cart
function decrementItemQuantity(item) {
    const cart = loadCart();
    const itemIndex = cart.findIndex(cartItem => cartItem.name === item.name);

    if (itemIndex !== -1) {
        // Decrement the quantity for the item by 1
        if (cart[itemIndex].quantity > 1) {
            cart[itemIndex].quantity -= 1;

            // Update the cart in local storage
            localStorage.setItem('cart', JSON.stringify(cart));

            // Redisplay the cart with the updated data
            displayCart();

            // Calculate total price and update
            updateTotal();
        } else {
            // If quantity is 1, remove the item from the cart
            cart.splice(itemIndex, 1);

            // Update the cart in local storage
            localStorage.setItem('cart', JSON.stringify(cart));

            // Redisplay the cart with the updated data
            displayCart();

            // Calculate total price and update
            updateTotal();
        }
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

// Function to get the selected products
function getSelectedProducts() {
    const cart = loadCart();
    return cart.map(item => ({
        name: item.name,
        price: item.price,
        quantity: item.quantity,
    }));
}

// Function to handle the checkout process
function checkout() {
    // Check if the user is logged in
    if (!isLoggedIn()) {
        // Redirect to the account page for unauthenticated users
        window.location.href = '/account';
        return;
    }

    // Get the selected products
    var selectedProducts = getSelectedProducts();

    // Make an AJAX request to the server to create an order
    // Replace '/checkout' with the actual endpoint for checkout
    fetch('/checkout', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ products: selectedProducts }),
    })
    .then(response => response.json())
    .then(data => {
        // Check if the response indicates a successful checkout
        if (data.success) {
            // Redirect to the account page for authenticated users
            window.location.href = '/account';
        } else {
            // Display an error message on the page
            displayErrorMessage(data.message || 'Error processing checkout. Please try again.');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        // Handle errors, e.g., show an error message to the user
        displayErrorMessage('Error processing checkout. Please try again.');
    });
}

// Function to check if the user is logged in
function isLoggedIn() {
    // Implement your logic to check if the user is logged in
    // For example, you can check the presence of a user session or token
    // Replace this with your actual authentication logic
    return false; // Return true if the user is logged in
}

// Function to display the login message on the page
function displayLoginMessage(message) {
    var loginMessageElement = document.getElementById('loginMessage');
    if (loginMessageElement) {
        loginMessageElement.textContent = message;
    }
}

// Function to display an error message on the page
function displayErrorMessage(message) {
    // Adjust this part based on how you want to display error messages
    alert(message);
}

// Call displayCart when the page loads
document.addEventListener('DOMContentLoaded', displayCart);