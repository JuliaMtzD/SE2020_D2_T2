public class Utils {
    public static String header(String title) {
        StringBuilder str = new StringBuilder();
        str.append("<!DOCTYPE HTML>");
        str.append("<html lang='en'>");
        str.append("<title>" + title + "</title>");
        str.append("<meta charset='UTF-8'>");
        str.append("<meta name='viewport' content='width=device-width, initial-scale=1'>");
        str.append("<link rel='stylesheet' href='w3.css'>");
        str.append("<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Raleway'>");
        str.append("<style> body,h1,h2,h3,h4,h5 {font-family: 'Raleway', sans-serif} .w3-third img{margin-bottom: -6px; opacity: 0.8; cursor: pointer} .w3-third img:hover{opacity: 1}</style>");
		str.append("<body class='w3-light-grey w3-content' style='max-width:1600px'>");
		

		str.append("<div class='w3-display-topffw3-text-grey w3-black' style='z-index:3;margin-left:300px'>");
		str.append("<div class='w3-row w3-large w3-grey' >");
		str.append("<div class='w3-col s3'>");
		str.append("<a href='index.html' class='w3-button w3-block'><img src='flecha.png' class='w3-align-left' style='width:35px'> Back</a>");
		str.append("</div> ");
		str.append("<div class='w3-col s3'>");
		str.append("<a class=' w3-block'></a>");
		str.append("</div>");
		str.append("<div class='w3-col s3'>");
		str.append("<a class=' w3-block'></a>");
		str.append("</div>");
		str.append("<div class='w3-col s3'>");
		str.append("<a class='w3-block'></a>");
		str.append("</div> ");
		str.append("</div>");
		str.append("</div>");
		
		
		str.append("<nav class='w3-sidebar w3-bar-block w3-white w3-animate-left w3-text-grey w3-collapse w3-top w3-center' style='z-index:3;width:300px;font-weight:bold' id='mySidebar'>");
		str.append("<img src='ProSeg.png' class='w3-image w3-padding-8' style='width:300px'>"); 
		str.append("<a href='#Cat1' onclick='w3_close()' class='w3-bar-item w3-button'>Category 1</a>  ");
		str.append("<a href='#Cat2' onclick='w3_close()' class='w3-bar-item w3-button'>Category 2</a>  ");
		str.append("<a href='#Cat3' onclick='w3_close()' class='w3-bar-item w3-button'>Category 3</a>  ");
		str.append("</nav>");
		
		
		str.append("<div class='w3-main' style='margin-left:300px'>");
		str.append("<div class='w3-container w3-white w3-padding-32 w3-padding-large'>");
		str.append("<div class='w3-content' style='max-width:800px'>");
        str.append("<h1 align=center ><b>" + title + "</b></h1>");
        return str.toString();
    }

    public static String footer(String title) {
        StringBuilder str = new StringBuilder();
		str.append("</div>");
		str.append("</div>");
		
		str.append("<footer class='w3-container w3-padding-32 w3-grey'>");  
		str.append("<div class='w3-row-padding'>");
		str.append("<div class='w3-third'>");
        str.append("<h3>INFO</h3>");
        str.append("<p>ProSeg is compromised with your future, please do not heasite to send us your CV if you are interested in working with us<br><br>cv@proseg.com</p>  ");
		str.append("<img src='iso.png' class='w3-left w3-margin-right' style='width:50px'>"); 
		str.append("<img src='secure.png' class='w3-left w3-margin-right' style='width:50px'>"); 
		str.append("</div>");
    
		str.append("<div class='w3-third'>");
        str.append("<h3>FIND US</h3>");
        str.append("<ul class='w3-ul'>");
        str.append("<li class='w3-padding-16'>");
         str.append("<img src='mundo.png' class='w3-left w3-margin-right' style='width:50px'>"); 
        str.append("<span class='w3-large'>Industrial Estate Landaben-Street F</span><br>");
        str.append("<span>20009 </span><br>");
		str.append("<span>Donostia - San Sebastián</span>");
        str.append("</li> ");
        str.append("<li class='w3-padding-16'>");
         str.append("<img src='phone.png' class='w3-left w3-margin-right' style='width:50px'>"); 
        str.append("<span class='w3-large'>+34 905 633 554</span><br>");
        str.append("<span>Attention hours: 9:00 - 20:00</span>");
        str.append("</li> ");
        str.append("</ul>");
		str.append("</div>");

		str.append("<div class='w3-third'>");
        str.append("<h3>SOCIAL NETWORKS<h3>");
		str.append("<img src='facebook.png' class='w3-left w3-margin-right' style='width:30px'>");
		 str.append("<img src='instagram.png' class='w3-left w3-margin-right' style='width:30px'>"); 
		str.append("<img src='twitter.png' class='w3-left w3-margin-right' style='width:30px'>");
		 str.append("<img src='linkedin.png' class='w3-left w3-margin-right' style='width:30px'>  "); 
		str.append("</div>");
		str.append("</div>");
		str.append("</footer>");
  
		str.append("<div class='w3-black w3-center w3-padding-24'>Powered by <a href='https://www.w3schools.com/w3css/default.asp' title='W3.CSS' target='_blank' class='w3-hover-opacity'>w3.css</a></div>");
		str.append("</div>");
		
		
		
        str.append("</body>");
        str.append("</html>");
        return str.toString();
    }
}