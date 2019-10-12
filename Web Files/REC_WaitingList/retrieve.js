var rootRef = firebase.database().ref('players/');
var i=0;
var username = document.getElementById('username').innerHTML;

rootRef.orderByChild("name").equalTo("John").on("child_added", function(data) {
        var name = data.val().name;
        var email = data.val().email;
        var pnr = data.val().pnr;

/*rootRef.on("child_added", snap=> {
  var name = snap.child("name").val();
  var name = snap.child("email").val();
  var name = snap.child("pnr_no").val();
  var name = snap.child("doj").val();*/

  $("#table_body").append("<tr><td>" + name + "</td><td>" + email + "</td><td>" + pnr + "</td><td><button onclick='delete_data();'>Remove</button></td></tr>");

});


    var oldRef = firebase.database().ref('players/1');
    var newRef = firebase.database().ref('ttedetails/'+ i++);

function delete_data() {
    alert("Are u sure to exit");
    moveFbRecord(oldRef, newRef);
}

function moveFbRecord(oldRef, newRef) {    
        oldRef.once('value', function(snap)  {
              newRef.set( snap.val(), function(error) {
                  if( !error ) {  oldRef.remove(); }
                  else if( typeof(console) !== 'undefined' && console.error ) {  console.error(error); }
              });
        });
    }
