<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>   	   
    <title> Index jsp</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script type="text/javascript">
	 	function login(){
	 		var loginform=document.getElementById("login_Form");
	 		var name=document.getElementsByName("userName").value;
	 		var pass=document.getElementsByName("password").value;
	 		if(name){
	 			alert("userName is required");
	 		}else if(pass){
	 			alert("password is required");
	 		}else{
	 			loginform.submit();
	 		}	 		
	 	}	 	
	</script>
  </head>  
  <body>
  	<div class="main">	  	
  		<div class="Index_href_div">
  			<a class="index_href" href="login.jsp">Go to Login</a>
  		</div>
  		<div class="Index_href_div">
  			<a class="index_href" href="addFilm">Add Film</a>
  		</div>
  		<div class="Index_href_div">
  			<a class="index_href" href="dashBorad">Delete Film</a>
  		</div>
  		<div class="Index_href_div">
  			<a class="index_href" href="editFilm.jsp">Edit Film</a>
  		</div> 		
  		<div class="Index_href_div">
  		<a class="index_href" href="showFilm">Query Film</a>
  		</div>
  	</div> 
  </body>
</html>
