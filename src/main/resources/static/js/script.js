'use-strict';

const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

const usernameSignup = document.getElementById('username-signup');
const emailSignup = document.getElementById('email-signup');
const pwdSignup = document.getElementById('pwd-signup');
const signUpBtn = document.getElementById('sign-up');

const usrToolTip = document.getElementById("username-tooltip");
const usrLength = document.getElementById("usr-length");
const usrConstraints = document.getElementById("usr-constraints");
const usrUp = document.getElementById("usr-up");
const usrLo = document.getElementById("usr-lo");
const usrUs = document.getElementById("usr-us");
const usrNo = document.getElementById("usr-no");

const emailToolTip = document.getElementById("email-tooltip");

const pwdToolTip = document.getElementById("pwd-tooltip");
const pwdLength = document.getElementById("pwd-length");
const pwdConstraints = document.getElementById("pwd-constraints");
const pwdUp = document.getElementById("pwd-up");
const pwdLo = document.getElementById("pwd-lo");
const pwdNo = document.getElementById("pwd-no");

let usrSignupValid = false;
let pwdSignupValid = false;
let emailSignupValid = false;

signUpButton.addEventListener('click', () => {
    container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
    container.classList.remove("right-panel-active");
});

usernameSignup.addEventListener('change', () => {
    let checkedString = usernameSignup.value;
    usrSignupValid = validateUsername(checkedString);
    enableSignUp(usrSignupValid, emailSignupValid, pwdSignupValid);
})

usernameSignup.addEventListener('focus', () => {
    if(!usrToolTip.classList.contains("show"))
        usrToolTip.classList.add("show");
});

usernameSignup.addEventListener('blur', () => {
    if(usrToolTip.classList.contains("show")) usrToolTip.classList.remove("show");
});

emailSignup.addEventListener('change', () => {
    let checkedString = emailSignup.value;
    emailSignupValid = validateEmail(checkedString);
    enableSignUp(usrSignupValid, emailSignupValid, pwdSignupValid);
})

emailSignup.addEventListener('focus', () => {
    if(!emailToolTip.classList.contains("show") && emailToolTip.innerHTML !== "")
        emailToolTip.classList.add("show");
});

emailSignup.addEventListener('blur', () => {
    if(emailToolTip.classList.contains("show")) emailToolTip.classList.remove("show");
});

pwdSignup.addEventListener('change', () => {
    let checkedString = pwdSignup.value;
    pwdSignupValid = validatePassword(checkedString);
    enableSignUp(usrSignupValid, emailSignupValid, pwdSignupValid);
});

pwdSignup.addEventListener('focus', () => {
    if(!pwdToolTip.classList.contains("show") && pwdToolTip.innerHTML !== "")
        pwdToolTip.classList.add("show");
});

pwdSignup.addEventListener('blur', () => {
    if(pwdToolTip.classList.contains("show")) pwdToolTip.classList.remove("show");
});

function validateUsername(usernameString) {
    let lowercase = /[a-z]/g;
    let uppercase = /[A-Z]/g;
    let numbers = /[0-9]/g;
    let underscores = /[_]/g;

    const lowercaseTest = usernameString.match(lowercase);
    const uppercaseTest = usernameString.match(uppercase);
    const numbersTest = usernameString.match(numbers);
    const underscoreTest = usernameString.match(underscores);
    const lengthTest = usernameString.length > 3;

    if(lengthTest) {
        usrLength.style.color = "#1fca1f";
        usernameSignup.style.borderColor = "transparent";
    }
    else {
        usrLength.style.color = "#ff3c3c";
        usernameSignup.style.borderColor = "#ff3c3c";
    }

    if(lowercaseTest) usrLo.style.color = "#1fca1f";
    else usrLo.style.color = "black";

    if(uppercaseTest) usrUp.style.color = "#1fca1f";
    else usrUp.style.color = "black";

    if(numbersTest) usrNo.style.color = "#1fca1f";
    else usrNo.style.color = "black";

    if(underscoreTest) usrUs.style.color = "#1fca1f";
    else usrUs.style.color = "black";

    if(uppercaseTest || lowercaseTest || numbersTest || underscoreTest) {
        usrConstraints.style.color = "#1fca1f";
        usernameSignup.style.borderColor = "transparent";
    }
    else {
        usrConstraints.style.color = "#ff3c3c";
        usernameSignup.style.borderColor = "#ff3c3c";
    }

    return (uppercaseTest || lowercaseTest || numbersTest || underscoreTest) && lengthTest;
}

function validateEmail(emailString) {
    const emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    const condition = emailRegex.test(emailString);
    if(condition) {
        emailToolTip.innerHTML = "Email is valid";
        emailToolTip.style.color = "#1fca1f";
        emailSignup.style.borderColor = "transparent";
    } else {
        emailToolTip.innerHTML = "Email is NOT valid";
        emailToolTip.style.color = "#ff3c3c";
        emailSignup.style.borderColor = "#ff3c3c";
    }

    return condition;

}

function validatePassword(passwordString) {
    let lowercase = /[a-z]/g;
    let uppercase = /[A-Z]/g;
    let numbers = /[0-9]/g;

    const lowercaseTest = passwordString.match(lowercase);
    const uppercaseTest = passwordString.match(uppercase);
    const numbersTest = passwordString.match(numbers);
    const lengthTest = passwordString.length >= 8;

    if(!lowercaseTest) {
        pwdLo.style.color = "#ff3c3c";
        pwdConstraints.style.color = "#ff3c3c";
        pwdSignup.style.borderColor = "#ff3c3c";
    } else {
        pwdLo.style.color = "#1fca1f";
    }

    if(!uppercaseTest) {
        pwdUp.style.color = "#ff3c3c";
        pwdConstraints.style.color = "#ff3c3c";
        pwdSignup.style.borderColor = "#ff3c3c";
    } else {
        pwdUp.style.color = "#1fca1f";
    }

    if(!numbersTest) {
        pwdNo.style.color = "#ff3c3c";
        pwdConstraints.style.color = "#ff3c3c";
        pwdSignup.style.borderColor = "#ff3c3c";
    } else {
        pwdNo.style.color = "#1fca1f";
    }

    if(!lengthTest) {
        pwdLength.style.color = "#ff3c3c";
        pwdSignup.style.borderColor = "#ff3c3c";
    } else {
        pwdLength.style.color = "#1fca1f";
    }

    if(lowercaseTest && uppercaseTest && numbersTest && lengthTest) {
        pwdConstraints.style.color = "#1fca1f";
        pwdSignup.style.borderColor = "transparent";
    }

    return lowercaseTest && uppercaseTest && numbersTest && lengthTest;
}

function enableSignUp(usr, email, pwd) {
    console.log((usr && email) && pwd);
    signUpBtn.disabled = !((usr && email) && pwd);
}

particlesJS('particles',

    {
        "particles": {
            "number": {
                "value": 80,
                "density": {
                    "enable": true,
                    "value_area": 800
                }
            },
            "color": {
                "value": "#ffffff"
            },
            "shape": {
                "type": "circle",
                "stroke": {
                    "width": 0,
                    "color": "#000000"
                },
                "polygon": {
                    "nb_sides": 5
                },
                "image": {
                    "src": "img/github.svg",
                    "width": 100,
                    "height": 100
                }
            },
            "opacity": {
                "value": 0.5,
                "random": false,
                "anim": {
                    "enable": false,
                    "speed": 1,
                    "opacity_min": 0.1,
                    "sync": false
                }
            },
            "size": {
                "value": 3,
                "random": true,
                "anim": {
                    "enable": false,
                    "speed": 40,
                    "size_min": 0.1,
                    "sync": false
                }
            },
            "line_linked": {
                "enable": true,
                "distance": 150,
                "color": "#ffffff",
                "opacity": 0.4,
                "width": 1
            },
            "move": {
                "enable": true,
                "speed": 1,
                "direction": "bottom-right",
                "random": true,
                "straight": false,
                "out_mode": "out",
                "bounce": false,
                "attract": {
                    "enable": false,
                    "rotateX": 600,
                    "rotateY": 1200
                }
            }
        },
        "interactivity": {
            "detect_on": "canvas",
            "events": {
                "onhover": {
                    "enable": false,
                    "mode": "repulse"
                },
                "onclick": {
                    "enable": false,
                    "mode": "push"
                },
                "resize": true
            },
            "modes": {
                "grab": {
                    "distance": 400,
                    "line_linked": {
                        "opacity": 1
                    }
                },
                "bubble": {
                    "distance": 400,
                    "size": 40,
                    "duration": 2,
                    "opacity": 8,
                    "speed": 3
                },
                "repulse": {
                    "distance": 200,
                    "duration": 0.4
                },
                "push": {
                    "particles_nb": 4
                },
                "remove": {
                    "particles_nb": 2
                }
            }
        },
        "retina_detect": true
    }

);