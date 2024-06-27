const nameInput = document.getElementById('name');
const priceInput = document.getElementById('price');
const producerInput = document.getElementById('producer');
const descriptionInput = document.getElementById('description');
const quantityInput = document.getElementById('quantity');

const form = document.querySelector('form');

form.addEventListener('submit', (e) => {
    const errors = [];

    if(nameInput.value.trim() === "" || nameInput.value.length > 50){
        errors.push("Name is required and must be less than 50 characters")
    }
    if(priceInput.value.trim() === "" || priceInput.value < 0 || priceInput.value > 10000000){
        errors.push("Price is required and must be greater than 0 and less than 10000000")
    }
    if(producerInput.value.trim() === "" || producerInput.value.length > 50){
        errors.push("Producer is required and must be less than 50 characters")
    }
    if(descriptionInput.value.trim() === "" || descriptionInput.value.length > 200){
        errors.push("Description is required and must be less than 200 characters")
    }
    if(quantityInput.value.trim() === "" || quantityInput.value < 0 || quantityInput.value > 10000000){
        errors.push("Quantity is required and must be greater than 0 and less than 10000000")
    }
    if(errors.length > 0){
        e.preventDefault()
        alert(errors.join("\n"))
    }
})