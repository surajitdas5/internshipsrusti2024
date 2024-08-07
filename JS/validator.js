function validate(e){
    console.log("Connected...");
    let name = document.querySelector("#name").value
    let dob = document.querySelector("#dob").value
    let mobile = document.querySelector("#mobile").value
    let email = document.querySelector("#email").value
    let password = document.querySelector("#password").value
    let password2 = document.querySelector("#password2").value

    let gender = document.querySelector("input[name='gender']:checked")
    console.log(gender);

    let error = false

    if(!gender){
        document.querySelector("#genderError").innerHTML = "Please select your gender";
        error = true
    } else {
        document.querySelector("#genderError").innerHTML = "";
    }
    

    if(name === "" || name === null){
        document.querySelector("#nameError").innerHTML = "Please enter your name";
        error = true
    } else {
        document.querySelector("#nameError").innerHTML = "";
    }

    if(dob === "" || dob === null){
        document.querySelector("#dobError").innerHTML = "Please enter your Date of Birth";
        error = true
    }  else {
        let today = new Date()
        dob = new Date(dob)
        // console.log(today, dob);
        if(dob >today){
            document.querySelector("#dobError").innerHTML = "Please enter valid Date of Birth";
            error = true
        } else {
            document.querySelector("#dobError").innerHTML = "";
        }
    }

    if(mobile === "" || mobile === null){
        document.querySelector("#mobileError").innerHTML = "Please enter your mobile number";
        error = true
    } else if(mobile.length != 10 || isNaN(mobile)){
        document.querySelector("#mobileError").innerHTML = "Pleae enter a valid 10 digit mobile number";
        error = true
    } else {
        document.querySelector("#mobileError").innerHTML = "";
    }

    let emailPat = /^[a-zA-Z0-9_.]{4,}@[a-z.]{3,}.[a-z]{2,5}$/
    if(email === "" || email === null){
        document.querySelector("#emailError").innerHTML = "Please enter your Email";
        error = true
    } else if(!email.match(emailPat)){
        document.querySelector("#emailError").innerHTML = "Please enter a valid email";
        error = true
    }  else {
        document.querySelector("#emailError").innerHTML = "";
    }

    let passErrors = "";
    if(password === "" || password === null){
        document.querySelector("#passwordError").innerHTML = "Please enter your Password";
        error = true
    }  else {
        if(!password.match(/[a-z]/)){
            passErrors += "Password should have at least one lower case character.<br>"
            error = true
        }
        if(!password.match(/[A-Z]/)){
            passErrors += "Password should have at least one upper case character.<br>"
            error = true
        }
        if(!password.match(/[0-9]/)){
            passErrors += "Password should have at least one number.<br>"
            error = true
        }
        if(!password.match(/[!@#$%^&*]/)){
            passErrors += "Password should have at least one special character.<br>"
            error = true
        }
        if(password.length <8 || password.length >16){
            passErrors += "Password length should be between 8 - 16.<br>"
            error = true
        }
        document.querySelector("#passwordError").innerHTML = passErrors;
    }

    if(password2 === "" || password2 === null){
        document.querySelector("#password2Error").innerHTML = "Please enter your Confirm Password";
        error = true
    } else if( password2 !== password){
        document.querySelector("#password2Error").innerHTML = "Password and Confirm password must be same";
        error = true
    }  else {
        document.querySelector("#password2Error").innerHTML = "";
    }

    if(error){
        e.preventDefault()
    }
}