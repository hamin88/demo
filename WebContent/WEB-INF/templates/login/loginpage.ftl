<#import "/baseLayout.ftl" as layout>
<@layout.mainlayout>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
<br/><br/>
         <br/><br/>
                 
<center>
             <form action="login" method="post">
	
<table>	<tr><td>Login Id:</td><td><input type="text" name="userId"></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"></td></tr>
<tr><td></td><td><input type="submit" value="Login"></td></tr></table>
             </form>
        </center>
    </body>
</html>
 </@layout.mainlayout>
  