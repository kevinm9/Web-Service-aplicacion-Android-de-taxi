<?php
$servername = "localhost";
$database = "id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$username = "id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$password = "12345";



  // array for JSON response
$response = array();
// check for required fields
if (isset($_GET['user']) && isset($_GET['pwd'])) {
    
        $user=$_GET['user'];
		$pwd=$_GET['pwd'];
//creating a new connection object using mysqli 
$conn = new mysqli($servername, $username, $password, $database);

$response2 = array();
if (!$conn) {

    
    
}


	$consulta="SELECT * FROM tbl_usuario WHERE user= '{$user}' AND clave = '{$pwd}' ;";
	
	$stmt = $conn->prepare($consulta);
	
	$stmt->execute();
    
    $stmt->bind_result($user, $clave);
    
    $registro=0;
    while($stmt->fetch()){
	
	$registro=$registro+1;
	
			 
}
    if($registro>=1){
    $response2["success"] = 1;
    $response2["message"] = "Login successful.";
   	echo json_encode($response2);
    }else{
    $response["success"] = 0;
    $response["message"] = "Required field(s) missing";
    print(json_encode($response));
        
    }
   
 } else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) missing";
    print(json_encode($response));

    // echoing JSON response
    
}






?> 