<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hand.myWeb.common.Constants" %>
<!DOCTYPE HTML >
<html>
  <head>   	   
    <title>Login</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<script type="text/javascript">
	 	function login(){
	 		var loginform=document.getElementById("login_Form");
	 		var name=document.getElementsByName("userName").value;
	 		if(name){
	 			alert("userName is required");
	 		}else{
	 			loginform.submit();
	 		}	 		
	 	}	 	
	</script>
  </head>  
  <body>
  	<div class="loginform">
	  	<form name="login_Form" id="login_Form" method="post" action="login" >
	  		<div class="loginInput_title_div"><h1 >Login</h1> </div>
	  		<div class="loginInput_div">请输入用户名：<input class="loginInput" type="text" name="userName" ></div>
	  		<div class="loginInput_div"><input class="button_type" type="button" value="submit" onclick="login()"/></div>
	  	</form>
  	</div> 
  </body>
</html>
