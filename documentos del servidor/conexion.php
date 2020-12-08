<?php
$hostname_localhost="localhost";
$database_localhost="id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$username_localhost="id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$password_localhost="12345";


		
$conn=mysqli_connect($hostname_localhost, $username_localhost, $password_localhost, $database_localhost);
		
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
echo "conectado a tu culo mamalo y chupalo xd ";
mysqli_close($conn);
?>
		
	