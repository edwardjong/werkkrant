
		function loadDoc() 
		{
  			var xhttp = new XMLHttpRequest();
  			xhttp.onreadystatechange = function() 
  			{
    			if (this.readyState == 4 && this.status == 200) 
    			{
					var json = JSON.parse(this.responseText)
      				var text = ""
      				for (var i = 0; i < json.length; i++) 
        				{
  							text += "<div class=\"candidate-info-holder\">"	 
  								text += "<div class=\"image-holder position-img\">"	 				 
  									text +=	"<a href=\"#\" onClick=\"loadPerson("+json[i].id+")\">"
 	       								text += "<img src=\""  +  json[i].plaatje + "\">" 
  									text += "</a>"			
  								text += "</div>"	
  								text += "<h3><span><e>" + json[i].firstName + "  " + json[i].lastName + "</e></span></h3>"
  								text += "<h3><span><f>"+ json[i].beroep + " </f></span></h3>"	
  							text += "</div>"		
         				}
      				document.getElementById("main-content-candidates").innerHTML = text
    			}
  			};
  			xhttp.open("GET", "/werkkrant/rest/aanbod/person", true);
  			xhttp.send();
		}

		function loadPerson(id)
		{
  			var xhttp = new XMLHttpRequest();
  			xhttp.onreadystatechange = function() 
  			{
    			if (this.readyState == 4 && this.status == 200) 
    			{   
					var json = JSON.parse(this.responseText);
      				var text = ""
      					text += "<table id=\"table-example-1\">"
      					text += "<thead><tr><th colspan=\"3\">" + json.firstName + " " + json.lastName + "</th>"
      					text += "</tr><tr><th>"
      							text +=  "<div class=\"image-holder position-img\">"	
      							text += "<img src=\""  +  json.plaatje + "\">" 
      							text += "</a>"
      							text +="</div>"     		  				
      		  			text +="<th rowspan=\"2\">" + json.profiel + "</th>" 
      		  			text +="<thead><tr><th colspan=\"3\"><b>Opleidingsniveau: </b>" + json.opleiding + "</th>"
      		  			text +="<thead><tr><th colspan=\"3\"><b>Kennis: </b>" + json.ervaring + "</th>"     		  	    		  	
      		  			text +="<thead><tr><th colspan=\"3\"><b>Werkervaring: </b>" + json.werkervaring + "</th>"
      		  			text +="<thead><tr><th colspan=\"3\"><b>CV: </b><a href=\"CV/Yvonne2.pdf\">download pdf</a></th>"
      		  			text += "</tr></thead>"
      		  		    text +="</tr></tbody></table>"
      		  		    	
      		  	      	text += "<div id =\"admin-bar\">"
      					text += "<button id=\"btnChangePerson\" onclick=\"formSubmit(true)\">Persoon Wijzigen</button>"
          				text += "<button id=\"btnDeletePerson\" onclick=\"retirePerson("+json.id+")\">Persoon Verwijderen!!!</button>"
      					text += "</div>"
      					
	
      				document.getElementById("main-content-candidates").innerHTML = text
      				document.getElementById("btnChangePerson").setAttribute( "onClick", "formFillPerson(" + json.id + ")");
      				document.getElementById("btnDeletePerson").setAttribute( "onClick", "retirePerson(" + json.id + ")");
      				
    			}
  			};
  			xhttp.open("GET", "/werkkrant/rest/aanbod/person/"+id, true);
  			xhttp.send();
			
		} 
		
		function formFillPerson(id) 
		{
	  			var html = new XMLHttpRequest();
	  			html.open("get", "/werkkrant/personForm.html", true);
	  			html.onreadystatechange = function() 
	  			{
	    			if (this.readyState == 4 && this.status == 200) 
	    			{
	    				document.getElementById("main-content-candidates").innerHTML = this.responseText;
	    				var xhttp = new XMLHttpRequest();
	    	  			xhttp.onreadystatechange = function() 
	    	  			{
	    	    			if (this.readyState == 4 && this.status == 200) 
	    	    			{   
	    	    				var person = JSON.parse(this.responseText);
	    	    				document.getElementById("personId").value = id;
	    	    				document.getElementById("firstName").value = person.firstName;
	    	    				document.getElementById("lastName").value = person.lastName;
	    	    				document.getElementById("beroep").value = person.beroep;
	    	    				document.getElementById("opleiding").value = person.opleiding;
	    	    				document.getElementById("ervaring").value = person.ervaring;	
	    	    				document.getElementById("werkervaring").value = person.werkervaring;			  
	    	    				document.getElementById("profiel").value = person.profiel;			  
	    	    				document.getElementById("plaatje").value = person.plaatje;
	    	    				document.getElementById("cv").value = person.cv;
	    	    			}
	    	  			};
	    	  			xhttp.open("GET", "/werkkrant/rest/aanbod/person/"+id, true);
	    	  			xhttp.send();   				
	    			}
	  			}
	  			html.send();
		}
		

		function formSubmit() 
		{
			  var firstName = document.getElementById("firstName").value;
			  var lastName = document.getElementById("lastName").value;
			  var beroep = document.getElementById("beroep").value;
			  var opleiding = document.getElementById("opleiding").value;
			  var ervaring = document.getElementById("ervaring").value;	
			  var werkervaring = document.getElementById("werkervaring").value;			  
			  var profiel = document.getElementById("profiel").value;			  
			  var plaatje = document.getElementById("plaatje").value;
			  var cv = document.getElementById("cv").value;
			  var personId = document.getElementById("personId").value;

			  
			  var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 204) {

				    	document.getElementById("main-content-candidates").innerHTML ="Persoon toegevoegd" 		

			    }
			  };
			  xhttp.open("POST", "/werkkrant/rest/aanbod/person", true);
			  xhttp.setRequestHeader("Content-Type", "application/json");
			  xhttp.send(JSON.stringify({id:personId ,firstName:firstName, lastName:lastName, beroep:beroep, opleiding:opleiding, ervaring:ervaring, werkervaring:werkervaring, profiel:profiel, plaatje:plaatje, cv:cv}));

			 
		}
		
		function getPersonForm() 
		{
			  var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() 
			  {
			      document.getElementById("main-content-candidates").innerHTML = this.responseText
			   }
			  xhttp.open("get", "/werkkrant/personForm.html", true);
			  xhttp.send();
			
		}
		
		function uploadOnChange(e, divName) {
		    var filename = e.value;var lastIndex = filename.lastIndexOf("\\");
		    if (lastIndex >= 0) {
		        filename = filename.substring(lastIndex +1);
		    }
		    document.getElementById(divName).value = "Images/" + filename;
		}
		
		
		function retirePerson(id)
		{
  			var xhttp = new XMLHttpRequest();
  			xhttp.onreadystatechange = function() 
  			{
    			if (this.readyState == 4 && this.status == 204) 
    			{   

  			      document.getElementById("main-content-candidates").innerHTML = "Persoon verwijderd"
    			}
  			};
  			xhttp.open("DELETE", "/werkkrant/rest/aanbod/person/"+id, true);
  			xhttp.send();
			
		} 