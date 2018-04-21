<?php
   $con=mysqli_connect("localhost","progettopizza","password","my_progettopizza");

   if (mysqli_connect_errno($con)) {
      echo "Errore durante la connessione al db: " . mysqli_connect_error();
   }

   $categoria = $_POST['categoria'];
   $risultato = mysqli_query($con,"SELECT id, prodotto, costo, descrizione FROM listino where categoria='$categoria'");
   $letto = mysqli_fetch_array($risultato);
   $data = $letto[0];

   if($data){
      echo $data;
   }
   mysqli_close($con);
?>