<?php

$vchofer = $_REQUEST["id_chofer"];
$vpasajero = $_REQUEST["id_pasajero"];
$vruta = $_REQUEST["id_ruta"];


$con = mysqli_connect("localhost","id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02","12345","id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02") or die("Sin Conexion");
$sql = "INSERT INTO tbl_viaje (id_chofer,id_pasajero,id_ruta,fecha) values ('$vchofer','$vpasajero','$vruta',NOW())";
$resul = mysqli_query($con,$sql);
echo $resul;
mysqli_close($con);
?> 