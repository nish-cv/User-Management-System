function validatePass() 
{ 

  let errorMessage = "";

  //Validating password
  let password =  document.getElementById("newpassword").value;

  let repassword =  document.getElementById("repassword").value;

  if(password.length<8)
  {
    errorMessage = "Password shoud be atleast 8 characters long";
    document.getElementById("msg").innerHTML = errorMessage;
	return false;
  }

 //Check if same
  if(!(password==repassword))
  {
    errorMessage = "New password and re-entered password does not match";
    document.getElementById("msg").innerHTML = errorMessage;
	return false;
  }

  return true;
}