<?php
$servername = "localhost";
$database = "id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$username = "id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$password = "12345";



  // array for JSON response
$response = array();
// check for required fields
if (isset($_POST['name']) && isset($_POST['password'])) {
    
  $user = $_POST['name'];
    $pwd = $_POST['password'];
//creating a new connection object using mysqli 
$conn = new mysqli($servername, $username, $password, $database);

$response2 = array();
if (!$conn) {

    
    
}


	$consulta="SELECT id_usuario FROM tbl_usuario WHERE user= '{$user}' AND clave = '{$pwd}' ;";
	
	$stmt = $conn->prepare($consulta);
	
	$stmt->execute();
    
    $stmt->bind_result($id_usuario);
    
    $registro=0;
    $iddeconsulta = 0;
    while($stmt->fetch()){
    
	$registro=$registro+1;
	
			 
}
    if($registro>=1){

    $response2["success"] = 1;
    $response2["message"] = "Login successful.";
    $response2["id"] = $id_usuario;
   	echo json_encode($response2);
    }else{
    $response["success"] = 0;
    $response["message"] = "Required field(s) missing";
    $response["id"] = 0;
    print(json_encode($response));
        
    }
   
 } else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) missing";
    $response["id"] = 0;
    print(json_encode($response));

    // echoing JSON response
    
}






?> 