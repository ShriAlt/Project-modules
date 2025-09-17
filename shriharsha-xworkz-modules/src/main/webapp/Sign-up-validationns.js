const submitBtn = document.getElementById("submitBtn");
function validateName() {
  const nameRegex = /^[a-zA-Z\s]+$/;
  const name = document.getElementById("firstName").value.trim();
  const errorSpan = document.getElementById("firstNameError");
  if (!nameRegex.test(name)) {
    errorSpan.innerHTML = "Name should contain only letters and spaces.";
    submitBtn.disabled = true;
    return false;
  }
  if (name.length < 3 || name.length > 20) {
    errorSpan.innerHTML = "Name must be between 2 and 20 characters long.";
    submitBtn.disabled = true;
    return false;
  }
  else{
    errorSpan.innerHTML = "";
    submitBtn.disabled = false;
  return true;
  }
}
function validateLastName() {
  const nameRegex = /^[a-zA-Z\s]+$/;
  const lastName = document.getElementById("lastName").value.trim();
  const errorSpan = document.getElementById("lastNameError");

  if (!nameRegex.test(lastName)) {
    errorSpan.innerHTML = "Last Name should contain only letters and spaces.";
    submitBtn.disabled = true;
    submitBtn.disabled = true;
    return false;
  }
  if (lastName.length < 1 || lastName.length > 20) {
    errorSpan.innerHTML = "Last Name must be between 1 and 20 characters long.";
    submitBtn.disabled = true;
    return false;
  }
  else{
    errorSpan.innerHTML = "";
    submitBtn.disabled = false;
  return true;
  }
}
   async function validateEmail(){
  const email=document.getElementById("email").value;
  const errorSpan =  document.getElementById("emailError");
  if(!email.includes("@") || !email.includes(".")){
    errorSpan.innerHTML="email must contain @ and ."
    submitBtn.disabled = true;
    return false;
  }
  const existEmail = await axios("http://localhost:8080/shriharsha-xworkz-modules/checkEmail?email="+email);// will return true if it exist
//  console.log(existEmail.data);
  if(existEmail.data === "true"){
    errorSpan.innerHTML="email already exist , please use another email"
    submitBtn.disabled = true;
    return false;
  }
  else{
    errorSpan.innerHTML="";
    submitBtn.disabled = false;
  }
}

 async function validatePhoneNumber(){
  const number = document.getElementById("phoneNumber").value;
  const errorSpan= document.getElementById("phoneError");
  const phoneRegex = /^\d{10}$/;
  if(!phoneRegex.test(number)){
    errorSpan.innerHTML= "number is not valid ";
    submitBtn.disabled = true;
    return false;
  }
  const existNumber = await axios("http://localhost:8080/shriharsha-xworkz-modules/checkNumber?phoneNumber=" + number); // return true if exist
//  console.log(existNumber.data);
  if(existNumber.data === "true"){
    errorSpan.innerHTML="number already exist , please use another number"
    submitBtn.disabled = true;
    return false;
  }
  else{
    errorSpan.innerHTML="";
    submitBtn.disabled = false;
  }
}
function validateDOB() {
  const dob = new Date(document.getElementById("dob").value);
  const today = new Date();
  const spanError =document.getElementById("dateError") ;

  if (dob > today) {
    spanError.innerHTML="there is no Way you were born in future unless you know  time travel  !!!"
    submitBtn.disabled = true;
    return false;
  }
  const age = today.getFullYear() - dob.getFullYear();
  const isOldEnough = age >= 13;
  if (!isOldEnough) {
    spanError.innerHTML="age should be above 13 "
    submitBtn.disabled = true;
    return false;
  }
  else{
    spanError.innerHTML="";
    submitBtn.disabled = false;
    return true;
  }
}
function validateState() {
  const state = document.getElementById("state");
  const stateError = document.getElementById("stateError");
  if (state.value.trim() === "") {
    stateError.innerHTML = "Please enter your state";
    submitBtn.disabled = true;
  }
  else{
  stateError.innerHTML = "";
  submitBtn.disabled = false;
  return true;
  }
}
function validatePinCode() {
  const pinInput = document.getElementById("pinCode").value.trim();
  const errorSpan = document.getElementById("pinCodeError");
  const pinRegex = /^[1-9][0-9]{5}$/;
  if (!pinRegex.test(pinInput)) {
    errorSpan.innerHTML = "Please enter a valid 6-digit PIN code";
    submitBtn.disabled = true;
    return false;
  }
  errorSpan.innerHTML = "";
  submitBtn.disabled = false;
  return true;
}
function validatePasswords() {
  const password = document.getElementById("password").value.trim();
  const confirmPassword = document.getElementById("confirmPassword").value.trim();
  const passwordError = document.getElementById("passwordError");
  const confirmPasswordError = document.getElementById("confirmPasswordError");
  const strengthRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d@$!%*?&]{6,}$/;

  if (!strengthRegex.test(password)) {
    passwordError.innerHTML = "Password must be at least 6 characters long and include letters and numbers";
    submitBtn.disabled = true;
    return false;
  }
  passwordError.innerHTML = "";
  if (password !== confirmPassword) {
    confirmPasswordError.innerHTML = "Passwords do not match";
    submitBtn.disabled = true;
    return false;
  }
  confirmPasswordError.innerHTML = "";
  submitBtn.disabled = false;
  return true;
}

// function validateGender() {
//   const genderInputs = document.getElementsByName("gender");
//   const spanError = document.getElementById("genderError");
//   let selected = false;
//   // alert("yeahhhh")
//   for (let input of genderInputs) {
//     if (input.checked) {
//       selected = true;
//       break;
//     }
//   }
//   if (!selected) {
//     spanError.innerHTML = "Please select a gender before proceeding. Identity matters.";
//     submitBtn.disabled = true;
//     return false;
//   }else{
//     spanError.innerHTML = "";
//     submitBtn.disabled = false;
//     return true;
//   }
// }
// function validateCountry() {
//   const country = document.getElementById("country");
//   const countryError = document.getElementById("countryError");
//
//   if (country.value === "") {
//     countryError.innerHTML = "Please select your country";
//     submitBtn.disabled = true;
//     return false;
//   }
//   else{
//     countryError.innerHTML = "";
//     submitBtn.disabled = false;
//     return true;
//   }
// }

