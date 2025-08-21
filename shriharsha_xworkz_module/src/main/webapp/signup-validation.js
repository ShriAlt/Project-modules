document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("signupForm");

    form.addEventListener("submit", function (event) {
        let isValid = true;

        // Full Name
        const fullName = document.getElementById("signupName");
        if (fullName.value.trim().length < 3 || fullName.value.trim().length > 10) {
            fullName.classList.add("is-invalid");
            isValid = false;
        } else {
            fullName.classList.remove("is-invalid");
            fullName.classList.add("is-valid");
        }

        // Username
        const username = document.getElementById("signupUsername");
        if (username.value.trim().length < 4 || username.value.trim().length > 20) {
            username.classList.add("is-invalid");
            isValid = false;
        } else {
            username.classList.remove("is-invalid");
            username.classList.add("is-valid");
        }

        // Email
        const email = document.getElementById("signupEmail");
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(email.value.trim())) {
            email.classList.add("is-invalid");
            isValid = false;
        } else {
            email.classList.remove("is-invalid");
            email.classList.add("is-valid");
        }

        // Phone
        const phone = document.getElementById("signupPhone");
        if (!/^\d{10}$/.test(phone.value.trim())) {
            phone.classList.add("is-invalid");
            isValid = false;
        } else {
            phone.classList.remove("is-invalid");
            phone.classList.add("is-valid");
        }

        // Password
        const password = document.getElementById("signupPassword");
        const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{8,}$/;
        if (!passwordPattern.test(password.value)) {
            password.classList.add("is-invalid");
            isValid = false;
        } else {
            password.classList.remove("is-invalid");
            password.classList.add("is-valid");
        }

        // Confirm Password
        const confirmPassword = document.getElementById("confirmPassword");
        if (confirmPassword.value !== password.value || confirmPassword.value === "") {
            confirmPassword.classList.add("is-invalid");
            isValid = false;
        } else {
            confirmPassword.classList.remove("is-invalid");
            confirmPassword.classList.add("is-valid");
        }

        // Gender
        const gender = document.querySelector('input[name="gender"]:checked');
const genderInputs = document.querySelectorAll('input[name="gender"]');
const feedback = document.getElementById('gender-feedback');

if (!gender) {
  genderInputs.forEach(el => el.classList.add("is-invalid"));
  feedback.classList.add("d-block"); // Show feedback
  isValid = false;
} else {
  genderInputs.forEach(el => el.classList.remove("is-invalid"));
  feedback.classList.remove("d-block"); // Hide feedback
}

        // Address
        const address = document.getElementById("signupAddress");
        if (address.value.trim().length < 10 || address.value.trim().length > 100) {
            address.classList.add("is-invalid");
            isValid = false;
        } else {
            address.classList.remove("is-invalid");
            address.classList.add("is-valid");
        }

        // Stop submission if invalid
        if (!isValid) {
            event.preventDefault();
            event.stopPropagation();
        }
    });
});
