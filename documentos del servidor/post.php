<?php

  // array for JSON response
$response = array();

// check for required fields
if (isset($_POST['name']) && isset($_POST['password'])) {
  
    $name = $_POST['name'];
    $message = $_POST['message'];

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