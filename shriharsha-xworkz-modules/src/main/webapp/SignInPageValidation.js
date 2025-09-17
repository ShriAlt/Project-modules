 const submitBtn = document.getElementById("submitBtn");
   async function validateEmail(){
  const email=document.getElementById("email").value;
  const errorSpan =  document.getElementById("emailError");
  if(!email.includes("@") || !email.includes(".")){
    errorSpan.innerHTML="email must contain @ and ."
    submitBtn.disabled = true;
    return false;
  }
  const existEmail = await axios("http://localhost:8080/shriharsha-xworkz-modules/checkEmail?email="+email);// will return true if it exist
  alert(existEmail.data);
  if(existEmail.data === false){
    errorSpan.innerHTML="email is not registered , please use registered email"
    submitBtn.disabled = true;
    return false;
  }
  else{
    errorSpan.innerHTML="";
    submitBtn.disabled = false;
  }
}
