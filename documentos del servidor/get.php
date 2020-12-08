<?php

  // array for JSON response
$response = array();

// check for required fields
if (isset($_GET['name']) && isset($_GET['password'])) {
  
    $name = $_GET['name'];
    $message = $_GET['message'];

    $response["success"] = 1;
    $response["message"] = "Login successful.";

    // echoing JSON response
    print(json_encode($response));
    
  
 } else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) missing";

    // echoing JSON response
    print(json_encode($response));
}
?> 