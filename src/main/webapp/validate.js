function validate() 
{ 

  let errorMessage = "";
  //Validating username
  let username =  document.getElementById("username").value;
  let pattern = /^[a-z_\d]*$/
  if(!username.match(pattern))
  {
    errorMessage += "Please enter a valid User Name,an Username can contain only lower case alphabets,numbers and underscore";
    document.getElementById("demo").innerHTML = errorMessage;
	return false;
  }
  //Validating password
  let password =  document.getElementById("password").value;
  if(password.length<8)
  {
    errorMessage += "Password should have atleast 8 characters";
    document.getElementById("demo").innerHTML = errorMessage;
	return false;
  }

//Validating firstname
  let firstname =  document.getElementById("firstname").value;
  pattern = /^[a-zA-Z\s]*$/
  if(!firstname.match(pattern))
  {
    errorMessage += "Please enter a valid First name";
    document.getElementById("demo").innerHTML = errorMessage;
	return false;
  }
  //Validating lastname
  let lastname =  document.getElementById("lastname").value;
  pattern = /^[a-zA-Z\s]*$/
  if(!lastname.match(pattern))
  {
    errorMessage += "Please enter a valid Last Name";
    document.getElementById("demo").innerHTML = errorMessage;
	return false;
  }

  //Validating Age
  let age = document.getElementById("age").value;
  pattern = /^[\d]+$/;
  if (!age.match(pattern) || age<=0)
  {
    errorMessage += "Please enter a valid age";
    document.getElementById("demo").innerHTML = errorMessage;
	return false;
  }
	
  //Validating Contact 
  let contact = document.getElementById("contact").value;
  pattern = /^\d{10}$/;
  if (!contact.match(pattern))
  {
    errorMessage += "Please enter a valid Contact number";
    document.getElementById("demo").innerHTML = errorMessage;
	return false;
  }

  return true;
}