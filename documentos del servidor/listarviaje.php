<?php
$con = mysqli_connect("localhost","id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02","12345","id10406735_wp_ea0cf53b94f8e34662e306da4df5eb02") or die("Sin Conexion");
$sql = "SELECT a.nombres AS Chofer,b.nombres AS Pasajero,c.lugar_desde AS Origen, c.lugar_hasta AS Destino,d.fecha
FROM (SELECT id_usuario,nombres FROM tbl_usuario) a, (SELECT id_usuario,nombres FROM tbl_usuario)b, tbl_ruta c,tbl_viaje d
WHERE d.id_chofer=a.id_usuario AND b.id_usuario=d.id_pasajero AND d.id_ruta=c.id_ruta";
$resul = mysqli_query($con,$sql);
$json=array();
while($row = mysqli_fetch_object($resul)){
    $json[]= $row;
}
echo json_encode ($json);
mysqli_close();
?>