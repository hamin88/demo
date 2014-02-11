<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- <link rel="stylesheet" type="text/css" href="menu.css" /> -->
<style>

/*
 menu css end
*/
.drop_menu {
	background:#0480B6;
	padding:0;
	margin:0;
	list-style-type:none;
	height:30px;
}
.drop_menu li { float:left; z-index:999999 }
.drop_menu li a {
	padding:9px 20px;
	display:block;
	color:#fff;
	text-decoration:none;
	font:12px arial, verdana, sans-serif;
}

/* Submenu */
.drop_menu ul {
	position:absolute;
	left:-9999px;
	top:-9999px;
	list-style-type:none;
}
.drop_menu li:hover { position:relative; background:#C90422; }
.drop_menu li:hover ul {
	left:0px;
	top:30px;
	background:#C90422;
	padding:0px;
}

.drop_menu li:hover ul li a {
	padding:5px;
	display:block;
	width:168px;
	text-indent:15px;
	background-color:#C90422;
}
.drop_menu li:hover ul li a:hover { background:#C90422; }
 
 </style>
 </head>
<body>
<div class="drop">
<ul class="drop_menu">
<li><a href='#'>User Management</a>
	<ul>
	<li><a href='../role/list'>Manage Role</a></li>
	<li><a href='../user/list'>Manage User</a></li>
	<li><a href='#'>Manage Contacts</a></li>
	</ul>
</li>
<li><a href='#'>Masters</a>
	<ul>
	<li><a href='../company/list'>Company Master</a></li>
	<li><a href='../branch/list'>Branch Master</a></li>
	<li><a href='../location/list'>Location Master</a></li>
	<li><a href='../tax/list'>Tax Master</a></li>
	</ul>
</li> 
<li><a href='#'>Product</a>
	<ul>
	<li><a href='#'>Manage Product</a></li>	 
	</ul>
</li>
</ul>
</div>
</body>
</html>