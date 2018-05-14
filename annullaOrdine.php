<?php
 
// include la classe db connect
require_once __DIR__ . '/db_connect.php';
 
// si connette al db
$db = new DB_CONNECT();

$codice = $_GET['codice'];

$result = mysql_query("DELETE FROM ordini WHERE codice='".$codice."'") or die(mysql_error());

?>