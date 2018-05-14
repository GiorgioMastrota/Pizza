<?php
 
// include la classe db connect
require_once __DIR__ . '/db_connect.php';
 
// si connette al db
$db = new DB_CONNECT();

$codice = $_GET['codice'];
$asporto = $_GET['asporto'];
$costoTot = $_GET['costoTot']; // in centesimi
number_format($costoTot, 8, '.');
$dataOra = $_GET['dataOra'];
$ordine = $_GET['ordine'];

$result = mysql_query("INSERT INTO ordini (codice, asporto, costo_tot, data_ora, stringaOrdine) VALUES ('".$codice."', '".$asporto."', '".$costoTot."', '".$dataOra."', '".$ordine."')") or die(mysql_error());

?>