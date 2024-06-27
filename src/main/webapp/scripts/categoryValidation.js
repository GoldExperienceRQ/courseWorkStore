const nameInput = document.getElementById('name');
const descriptionInput = document.getElementById('description');
const form = document.querySelector('form');

form.addEventListener('submit', (event) => {
    const errors = [];
    if (nameInput.value.length < 3 || nameInput.value.length > 50){
        errors.push('Name must be at least 3 characters long and less than 50');
    }
    if (descriptionInput.value.length < 3 || descriptionInput.value.length > 200){
        errors.push('Description must be at least 3 characters long and less than 100')
    }

    if(errors.length > 0) {
        event.preventDefault();
        alert(errors.join('\n'));
    }
})