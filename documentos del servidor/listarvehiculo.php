<?php
$con = mysqli_connect("localhost","id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02","12345","id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02") or die("Sin Conexion");
$sql = "SELECT * from tbl_vehiculo";
$resul = mysqli_query($con,$sql);
$json=array();
while($row = mysqli_fetch_object($resul)){
    $json[]= $row;
}
echo json_encode ($json);
mysqli_close();

?>