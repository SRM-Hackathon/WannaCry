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
let formMessage = firebase.database().ref('tteduty');
let formMessage1 = firebase.database().ref('tteduty/');

//listen for submit event//(1)
document
  .getElementById('registrationform')
  .addEventListener('submit', formSubmit);

//Submit form(1.2)
function formSubmit(e) {
  e.preventDefault();
  // Get Values from the DOM
  let dest_stn = document.querySelector('#name').value;
  let src_stn = document.querySelector('#email').value;
  let tteid = document.querySelector('#tteid').value;
  let train_name = document.querySelector('#password').value;
  let trainno = document.querySelector('#trainno').value;
  let coach1 = document.querySelector('#coach1').value;
  let coach2 = document.querySelector('#coach2').value;
  let coach3 = document.querySelector('#coach3').value;
  let coach4 = document.querySelector('#coach4').value;


  //send message values
  sendMessage(dest_stn, src_stn, train_name, trainno, tteid, coach1, coach2, coach3, coach4);

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

function sendMessage(dest_stn, src_stn, train_name, trainno, tteid, coach1, coach2, coach3, coach4) {
	tteid: tteid;
  let newFormMessage = formMessage.child(tteid);
  newFormMessage.set({
    dest_stn: dest_stn,
    src_stn: src_stn,
   	train_name: train_name,
   	trainno: trainno,
  });

  let newFormMessage1 = formMessage1.child(tteid+'/coach');
  newFormMessage1.set({
    0: coach1,
    1: coach2,
   	2: coach3,
   	3: coach4
  });
}