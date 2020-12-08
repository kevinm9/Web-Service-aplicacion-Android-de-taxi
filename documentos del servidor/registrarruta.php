<?php
$vdesde = $_REQUEST["desde"];
$vhasta = $_REQUEST["hasta"];
$vprecio = $_REQUEST["precio"];

$con = mysqli_connect("localhost","id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02","12345","id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02") or die("Sin Conexion");
$sql = "INSERT INTO tbl_ruta (lugar_desde,lugar_hasta,precio) values ('$vdesde','$vhasta','$vprecio')";
$resul = mysqli_query($con,$sql);
echo $resul;
mysql_close($con);
?> 