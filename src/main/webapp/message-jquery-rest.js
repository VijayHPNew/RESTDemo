$(document).ready(function () {
 
 /*
  * Blur event after user enter's city - to get Longitude, Latitude and Weather
  */
 var Myval = 'City value NOT yet set';
  $(document).on("blur","#city",function() {
	  
	   Myval = $("#city").val();   
	   
	   var restWeatherURL = 'https://api.openweathermap.org/data/2.5/weather?q='+Myval+'&APPID=70784f37f0855ca418ba5dc7fb429a8b';
	   
	   /*
	    * Ajax pre-filter to handle CORS
	   */
	   $.ajaxPrefilter( function (options) {
		   if (options.crossDomain && jQuery.support.cors) {
		     
		     options.url = 'https://cors-anywhere.herokuapp.com/' + options.url;
		     
		   }
		 });
	   
	   /*
	    * Ajax call to query OpenWeatherMap REST (external domain) and display results
	   */
	   $.ajax({
			 url: restWeatherURL,
		     type: 'GET',
		     //headers: {
		         //'Content-Type': 'application/json'
		     //},
		     success: function(data){
		       //alert('REST call successful. Response returned is '+data);
		       
	           if (data != null)
	        	   $("#footer").append("<br/><br/><b><i><u>" + Myval + " Longitude, Latitude and Weather </u></i></b>");
	           
		       for (var key in data) {
		        
		        for (var prop in data[key]) {
		        	
		        	//alert('key: '+key);
		        	
		        	if(prop == "lon" || prop == "lat" || prop == "temp" || prop == "pressure" || prop == "humidity" || prop == "temp_min" || prop == "temp_max")
		        			        	         
		        	$("#footer").append("<br/>" + prop + " = " + data[key][prop]);
		        }
		       
		       }
		       $("#footer").append("<br/>");
		              
		     },
		     error: function(xhrRequest, status, error) {
		       alert(JSON.stringify(xhrRequest));
		     }
		   });
  });
  
  
	  /*
	   * To handle submit event (of message form) to REST to submit message with User details
	   * */
	  var form = $('#message_form')[0];
	  
	  form.onsubmit = function(e){
	  
	  var user = $("#message_form").serializeArray();
	
	  var json = {};
	
	  jQuery.each(user, function() {
		  json[this.name] = this.value || '';
	  });
	
	    	
	  	 /* Ajax POST call to REST API to store message, user details, after that get All submissions 
	  	  from user
	  	 */
	     $.ajax({
		 url: "/messages",
	     data: JSON.stringify(json),
	     type: 'POST',
	     headers: {
	         'Content-Type': 'application/json'
	     },
	     success: function(data){
	       //alert('REST call successful. Response returned is '+data);
	       
	       var responseData = JSON.stringify(data);
	       
	       //alert('After JSON stringify responseData is '+responseData);
	       
	       
	       $("#footer").append("<br/><br/><b><i><u>Messages posted by User</u></i></b>");
	       $("#footer").append("<form  method = 'POST' id='response_message_form'>");
	       
	       for (var key in data) {
	        
	        for (var prop in data[key]) {
	        	
	        	$("#footer").append("<br/>" + prop + " = " + data[key][prop]);
	        }
	        $("#footer").append("-------------------------------------------------------");
	       }
	       $("#footer").append("</form>");
	              
	     },
	     error: function(xhrRequest, status, error) {
	       alert(JSON.stringify(xhrRequest));
	     }
	   });
	       return false;
	   }
  
  
});