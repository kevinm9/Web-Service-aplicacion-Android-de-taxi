<?php
$vusuario = $_REQUEST["usuario"];
$vmatricula = $_REQUEST["matricula"];
$vmodelo = $_REQUEST["modelo"];
$vanio = $_REQUEST["anio"];

$con = mysqli_connect("localhost","id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02","12345","id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02") or die("Sin Conexion");
$sql = "INSERT INTO tbl_vehiculo (id_usuario,matricula,modelo,anio) values ('$vusuario','$vmatricula','$vmodelo','$vanio')";
$resul = mysqli_query($con,$sql);
echo $resul;
mysql_close($con);
?> 