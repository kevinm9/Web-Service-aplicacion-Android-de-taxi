<?PHP
$hostname="localhost";
$database="id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$username="id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02";
$password="12345";
$json=array();
	if(isset($_GET["user"]) && isset($_GET["pwd"])){
	    $json2=array();
		$user=$_GET['user'];
		$pwd=$_GET['pwd'];
		
		$conexion=mysqli_connect($hostname,$username,$password,$database);
		
		$consulta="SELECT user, clave, nombres FROM tbl_usuarios WHERE user= '{$user}' AND clave = '{$pwd}'";
		$resultado=mysqli_query($conexion,$consulta);

		if($consulta){
		
			if($reg=mysqli_fetch_array($resultado)){
				$json['datos'][]=$reg;
			}
			mysqli_close($conexion);
			echo json_encode($json2);
		}



		else{
			$results["user"]='';
			$results["clave"]='';
			$results["nombres"]='';
			$json['datos'][]=$results;
			echo json_encode($json2);
		}
		
	}
	else{
		   	$results["user"]='';
			$results["clave"]='';
			$results["nombres"]='';
			$json['datos'][]=$results;
			echo json_encode($json);
		}
