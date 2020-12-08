<?php
$servername = "localhost";
$database = "id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$username = "id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$password = "12345";



  // array for JSON response
$response = array();
// check for required fields
if (isset($_GET['n']) && isset($_GET['p'])) {
    
    $user = 'kevin';
    $pwd = 'kevn';
//creating a new connection object using mysqli 
$conn = new mysqli($servername, $username, $password, $database);

$response2 = array();
if (!$conn) {

    
    
}


	$consulta="SELECT user, clave FROM tbl_usuario;";
	
	$stmt = $conn->prepare($consulta);
	
	$stmt->execute();
    
    $stmt->bind_result($user, $clave);
    
    
    while($stmt->fetch()){
	
	//pushing fetched data in an array 
	$temp = [
		'user'=>$user,
		'clave'=>$clave
	];
	
	//pushing the array inside the hero array 
	array_push($response2, $temp);
}
    
   echo json_encode($response2);
   
 } else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) missing";
    print(json_encode($response));

    // echoing JSON response
    
}






?> 