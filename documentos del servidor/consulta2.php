<?php
//these are the server details
//the username is root by default in case of xampp
//password is nothing by default
//and lastly we have the database named android. if your database name is different you have to change it 
$servername = "localhost";
$database = "id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$username = "id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$password = "12345";


//creating a new connection object using mysqli 
$conn = new mysqli($servername, $username, $password, $database);

//if there is some error connecting to the database
//with die we will stop the further execution by displaying a message causing the error 
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

//if everything is fine

//creating an array for storing the data 
$heroes = array(); 

//this is our sql query 
$sql = "SELECT id, nombre FROM heroes;";

//creating an statment with the query
$stmt = $conn->prepare($sql);

//executing that statment
$stmt->execute();

?>