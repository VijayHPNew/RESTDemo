$(document).ready(function () {
  var form = $('#message_form')[0];
  form.onsubmit = function(e){
  //alert('form submitted');
  var user = $("#message_form").serializeArray();

  var json = {};

  jQuery.each(user, function() {
	  json[this.name] = this.value || '';
  });

  alert('data in json format before REST call '+json);

     $.ajax({
	 url: "/messages",
     data: JSON.stringify(json),
     type: 'POST',
     headers: {
         'Content-Type': 'application/json'
     },
     success: function(data){
       alert('REST call successful. Response returned is '+data);
       
       var responseData = JSON.stringify(data);
       
       //$("#footer").append(responseData+"<br>");
       
       for (var key in data) {
    	   if (data.hasOwnProperty(key)) {
    		 
    	     var val = data[key];
    	     $("#footer").append(" : "+key+" = "+val);
    	   }
    	 }
              
     },
     error: function(xhrRequest, status, error) {
       alert(JSON.stringify(xhrRequest));
     }
   });
       return false;
   }
});