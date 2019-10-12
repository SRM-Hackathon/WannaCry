// Initialize Firebase(2)
var i=0;
var config = {
  	apiKey: "AIzaSyAkL0SmgCgZHhUJhhErD8HmgSn_Ru1OsLw",
    authDomain: "webapp-dce5b.firebaseapp.com",
    databaseURL: "https://webapp-dce5b.firebaseio.com",
    projectId: "webapp-dce5b",
    storageBucket: "webapp-dce5b.appspot.com",
    messagingSenderId: "88104536922",
    appId: "1:88104536922:web:6115ad7decaf2bd9c1c163",
    measurementId: "G-C24QGPZDB3"
};
firebase.initializeApp(config);

//Reference for form collection(3)
let formMessage = firebase.database().ref('ttedetails');

//listen for submit event//(1)
document
  .getElementById('registrationform')
  .addEventListener('submit', formSubmit);

//Submit form(1.2)
function formSubmit(e) {
  e.preventDefault();
  // Get Values from the DOM
  let name = document.querySelector('#name').value;
  let email = document.querySelector('#email').value;
  let password = document.querySelector('#password').value;

  //send message values
  sendMessage(name, email, password);

  //Show Alert Message(5)
  document.querySelector('.alert').style.display = 'block';

  //Hide Alert Message After Seven Seconds(6)
  setTimeout(function() {
    document.querySelector('.alert').style.display = 'none';
  }, 7000);

  //Form Reset After Submission(7)
  document.getElementById('registrationform').reset();
}

//Send Message to Firebase(4)

function sendMessage(name, email, password) {
  let newFormMessage = formMessage.child(i++);
  newFormMessage.set({
    username: name,
    tte_id: email,
    password: password,
  });
}