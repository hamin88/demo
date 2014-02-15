<#macro mainlayout> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   		<meta charset="utf-8"> 
		<title>Demo</title>
  
 <link rel="stylesheet" type="text/css" href="../extjs-4.2.1/resources/ext-theme-neptune/ext-theme-neptune-all.css" />
   
 <script type="text/javascript" src="../extjs-4.2.1/ext-all.js"></script>
 
 <script type="text/javascript" src="../extjs-4.2.1/ext-theme-neptune.js"></script>
  
 <style>
 
 /* A Free Design by Bryant Smith (bryantsmith.com) */



#body {
	margin: 0;
	padding: 0;
	text-align: left;
	font: 12px Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #061C37;
	background: #BCBCA8;
 }
*
{
  margin: 0 auto 0 auto;
 text-align:left;}

#container
{
  display: block; 
  height:auto;
  position: relative; 
  width: 960px;
}


#header
{
height:85px;
width:90%px;
float:left;	
}

#header h1
{
position:absolute;
text-align:left;
color:#FFFFFF;
font-size:43px;
color:#FFF;	
left:150px;
top:18px;
}


#header h2
{
position:absolute;
text-align:right;
color:#000;
left:500px;
top:50px;
width:550px;
}

#header h2 a
{
position:absolute;
text-align:right;
color:#000;
}

#mainpic
{
background-image:url(images/main.jpg);
background-repeat:no-repeat;
width:900px;
height:354px;	
}

.off
{
color:#300;
}


#menu
{
display:block;
float:left;
clear:both;
width:100%;
height:35px;
float:left;
clear:both;
padding-left:150px;
padding-right:150px;
}
 #leftmenu
{
margin-top:15px;
width:204px;
float:left;
}

#content
{
display:block;
float:left;
width:689px;
height:auto;
padding-left:10px;
padding-top:15px;
padding-right:10px;
padding-bottom:5px;
}
 
#content_main
{
width:659px;
padding-left:15px;
padding-right:15px;
}
 
#footer
{
width:100%;
height:auto;
//float:right;
position:fixed; 
bottom:20px;
left:980px;
}

#footer h3 a,#footer h3 a:visited
{
display:inline;
text-align:center;
font-size:12px;
text-decoration:none;
color:#FFF;
}

 
#content p
{
	
}


html, body {
text-align: center;
}
p {text-align: left;}

</style>


</head>


<body id="body">
<div id="container">
		<div id="header">
        	<h1>Absoluit<span class="off"> IT Solutions</span></h1>
            <h2>Welocome Admin | <a href="../home/logout">Logout</a></h2>
        </div>   
        
        <div id="menu">
         <#include "header.jsp">
        </div>
        
        <div id="leftmenu">

                 
         </div>
         
		<div id="content">
<div id="content_main"> <#nested /> </di
v>		        
  
        </div>
             
            <div id="footer">  
         <#include "footer.jsp">
  
</div>
      </div>
   </div>
</body>
</html>
 

</#macro> 