<?php
//these are the server details
//the username is root by default in case of xampp
//password is nothing by default
//and lastly we have the database named android. if your database name is different you have to change it 
$servidor = "localhost";
$basededato = "id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$usuario = "id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$clave = "12345";


//creating a new connection object using mysqli 
$conexion = new mysqli($servidor, $usuario, $clave, $basededato);

//if there is some error connecting to the database
//with die we will stop the further execution by displaying a message causing the error 
if ($conexion->connect_error) {
    die("Conexion fallida: " . $conexion->connect_error);
}else {
     echo "exito";
}
 echo "otro mensaje despues del if xd "; 
 
 ?>