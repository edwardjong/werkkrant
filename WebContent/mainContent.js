
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
  								text += "<h3><span><f>"+ json[i].skills + " </f></span></h3>"	
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
					var json = JSON.parse(this.responseText)
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
      		  			text +="<thead><tr><th colspan=\"3\"><b>Kennis en ervaring: </b>" + json.ervaring + "</th>"     		  	    		  	
      		  			text +="<thead><tr><th colspan=\"3\"><b>Recente Werkervaring: </b>" + json.werkervaring + "</th>"
      		  			text +="<thead><tr><th colspan=\"3\"><b>CV: </b><a href=\"CV/Yvonne2.pdf\">download pdf</a></th>"
      		  			text += "</tr></thead>"
      		  		    text +="</tr></tbody></table>"
	
      				document.getElementById("main-content-candidates").innerHTML = text
    			}
  			};
  			xhttp.open("GET", "/werkkrant/rest/aanbod/person/"+id, true);
  			xhttp.send();
			
		} 
		
/*
 * function changePerson(id) { var xhttp = new XMLHttpRequest();
 * xhttp.onreadystatechange = function() { if (this.readyState == 4 &&
 * this.status == 200) { var json = JSON.parse(this.responseText) var text = ""
 * text += "<table id=\"table-example-2\" style=\"width:75%\">" text += "<tr>"
 * text += "<td>" + "Voornaam" + "</td>" text += "<td>" + json.firstName + "</td>"
 * text += "</tr>" text += "<tr>" text += "<td>" + "Achternaam" + "</td>"
 * text += "<td>" + json.lastName + "</td>" text += "</tr>" text += "<tr>"
 * text += "<td>" + "Vaardigheden" + "</td>" text += "<td>" + json.skills + "</td>"
 * text += "</tr>" text += "<tr>" text += "<td>" + "Opleiding" + "</td>"
 * text += "<td>" + json.opleiding + "</td>" text += "</tr>" text += "<td>" +
 * "Ervaring" + "</td>" text += "<td>" + json.ervaring + "</td>" text += "</tr>"
 * text += "<td>" + "Werkervaring" + "</td>" text += "<td>" +
 * json.werkervaring + "</td>" text += "</tr>" text += "<td>" + "Profiel" + "</td>"
 * text += "<td>" + json.profiel + "</td>" text += "</tr>" text += "<td>" +
 * "Plaatje" + "</td>" text += "<td>" + json.plaatje + "</td>" text += "</tr>"
 * text += "<td>" + "CV" + "</td>" text += "<td>" + json.cv + "</td>"
 * text += "</tr>" text +="</table>"
 * 
 * document.getElementById("main-content-candidates").innerHTML = text } };
 * xhttp.open("GET", "/werkkrant/rest/aanbod/person/"+id, true); xhttp.send();
 *  }
 */
		
		function formSubmit() {
			  var firstName = document.getElementById("firstName").value;
			  var lastName = document.getElementById("lastName").value;
			  var skills = document.getElementById("skills").value;
			  var opleiding = document.getElementById("opleiding").value;
			  var ervaring = document.getElementById("ervaring").value;	
			  var werkervaring = document.getElementById("werkervaring").value;			  
			  var profiel = document.getElementById("profiel").value;			  
			  var plaatje = document.getElementById("plaatje").value;
			  var cv = document.getElementById("cv").value;

			  
			  var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 204) {
			      
			      document.getElementById("main-content-candidates").innerHTML ="Persoon toegevoegd"
			    }
			  };
			  xhttp.open("POST", "/werkkrant/rest/aanbod/person/1", true);
			  xhttp.setRequestHeader("Content-Type", "application/json");
			  xhttp.send(JSON.stringify({firstName:firstName, lastName:lastName, skills:skills, opleiding:opleiding, ervaring:ervaring, werkervaring:werkervaring, profiel:profiel, plaatje:plaatje, cv:cv}));

			 
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