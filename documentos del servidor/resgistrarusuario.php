<?php
$vcedula = $_REQUEST["cedula"];
$vnombres = $_REQUEST["nombres"];
$vapellidos = $_REQUEST["apellidos"];
$vcorreo = $_REQUEST["correo"];
$vcelular = $_REQUEST["celular"];
$vuser = $_REQUEST["user"];
$vclave = $_REQUEST["clave"];

$con = mysqli_connect("localhost","id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02","12345","id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02") or die("Sin Conexion");
$sql = "INSERT INTO tbl_usuario (cedula,nombres,apellidos,correo,celular,user,clave) values ('$vcedula','$vnombres','$vapellidos','$vcorreo','$vcelular','$vuser','$vclave')";
$resul = mysqli_query($con,$sql);
echo $resul;
mysql_close($con);
?> 