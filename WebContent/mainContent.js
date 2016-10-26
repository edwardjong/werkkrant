
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

		function loadPerson(id) {
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
      			       	text += "<a href=\"kandidaat1.html\">"	
						text += "<img src=\""  +  json.plaatje + "\">" 
     		  			text += "</a>"
      		  			text +="</div>"
      		  				
      		  			text +="<th rowspan=\"2\">Stout, servicegericht, behulpzaam en slordig</th>"
      		  			text +="<thead><tr><th colspan=\"3\"><b>Opleidingsniveau: </b>WO</th>"
      		  			text +="<thead><tr><th colspan=\"3\"><b>Kennis en ervaring: </b> o.a.: Active Directory.</th>"     		  	    		  	
      		  			text +="<thead><tr><th colspan=\"3\"><b>Recente Werkervaring: </b>Lambert heeft vanuit zijn rol als Teamleider.</th>"
      		  			text +="<thead><tr><th colspan=\"3\"><b>CV: </b><a href=\"CV/Yvonne2.pdf\">download pdf</a></th>"

      		  		    text += "</tr></thead>"
      		  		    text +="</tr></tbody></table>"
	
      				document.getElementById("main-content-candidates").innerHTML = text
    			}
  			};
  			xhttp.open("GET", "/werkkrant/rest/aanbod/person/"+id, true);
  			xhttp.send();
			
		} 
