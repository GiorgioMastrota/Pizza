package progettopizzaserver;

public class ProgettoPizzaServer {

    public static void main(String[] args) {
        
        ReteServer rete = new ReteServer();
        GestioneCodici gc = new GestioneCodici();
        
        while (true){
            // Attesa della richiesta
            String ricevuto = rete.Ricevi();
            if (ricevuto.equals("richiestaMenu")){
                // Lettura del database e successivo invio
            }    
            else if (ricevuto.equals("richiestaBarcode")){
                String nuovoCodice = gc.getNuovoCodice();
                rete.Invia(nuovoCodice);
            }
        }
    }
    
}
