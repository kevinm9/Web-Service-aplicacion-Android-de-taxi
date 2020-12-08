<?php
$servername = "localhost";
$database = "id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$username = "id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$password = "12345";
  // array for JSON response
$response1 = array();


// check for required fields
if (isset($_POST['name']) && isset($_POST['password'])) {
    $response2 = array();
    $user = $_POST['name'];
    $pwd =  $_POST['password'];


	$conexion = new mysqli_connect($servername, $username, $password, $database);
	$consulta="SELECT * FROM tbl_usuario WHERE user= '{$user}' AND clave = '{$pwd}'";
	
	$resultado=mysqli_query($conexion,$consulta);

    if(mysqli_fetch_array($resultado)){
                
				$response2["success"] = 1;
    			$response2["message"] = "Login successful.";
   				 // echoing JSON response
    			print(json_encode($response2));
        }
        


		
 } else {
    // required field is missing
    $response1["success"] = 0;
    $response1["message"] = "Required field(s) missing";
    // echoing JSON response
    print(json_encode($response1));
}





?> 