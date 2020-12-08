<?php
$hostname_localhost="localhost";
$database_localhost="id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$username_localhost="id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$password_localhost="12345";

$cedula = $_REQUEST["cedula"];
$nombres = $_REQUEST["nombres"];
$apellidos = $_REQUEST["apellidos"];
$correo = $_REQUEST["correo"];
$celular = $_REQUEST["celular"];
$user = $_REQUEST["user"];
$clave = $_REQUEST["clave"];
		
$conn=mysqli_connect($hostname_localhost, $username_localhost, $password_localhost, $database_localhost);
		
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
$sql = "INSERT INTO tbl_usuario (cedula,nombres,apellidos,correo,celular,user,clave) values ('$cedula','$nombres','$apellidos','$correo','$celular','$user','$clave')";
$result = mysql_query($con,$sql);
echo $result;
?>
	