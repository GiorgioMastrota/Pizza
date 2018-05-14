<?php
 
// include la classe db connect
require_once __DIR__ . '/db_connect.php';
 
// si connette al db
$db = new DB_CONNECT();

$categoria = $_GET['categoria'];

$stringaProdotti = "";

$result = mysql_query("SELECT id, prodotto, costo, descrizione FROM listino WHERE categoria=\"$categoria\"") or die(mysql_error());
 
    while ($row = mysql_fetch_array($result)) {
    	$singoloProdotto = $row["id"].";".$row["prodotto"].";".$row["costo"].";".$row["descrizione"].":";
    	$stringaProdotti = $stringaProdotti.$singoloProdotto;
        $singoloProdotto = "";
    }
 
    // stampa la risposta in json
    echo $stringaProdotti;
?>