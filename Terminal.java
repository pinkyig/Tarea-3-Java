
import java.util.*;


public class Terminal implements Visible{

    private ArrayList<Arma> armas_disponibles;


    public Terminal(){
        this.armas_disponibles = new ArrayList<Arma>();
        this.armas_disponibles.add(new Revolver());
        this.armas_disponibles.add(new Escopeta());
    }

    //Metodos de la clase Terminal

    public void comprarArma(Jugador jugador){
        /*
        Metodo que permite al jugador comprar un arma en la terminal si tiene suficientes puntos y no tiene ya el arma en su inventario
        @param: Jugador jugador

         */
        Scanner sc = new Scanner(System.in);

        System.out.println("Comprar Arma");
        System.out.println("1. Revolver (50 Puntos)");
        System.out.println("2. Escopeta (100 Puntos)");
        int opcionArma = sc.nextInt();
        switch (opcionArma) {
            case 1 -> {
                if (jugador.getP_points() >= 50) {
                    //busacndo en el array de armas del jugador
                    boolean tieneArma = false;
                    for (Arma arma : jugador.getArmas()) {
                        if (arma instanceof Revolver) {
                            tieneArma = true;
                            break;
                        }
                    }
                    if (tieneArma){
                        System.out.println("Ya tienes un revolver");
                    } else{
                        jugador.setArmas(jugador.getArmas(), new Revolver());
                        jugador.setP_points(jugador.getP_points() - 50);
                        System.out.println("Arma comprada con exito");
                    }
                } else {
                    System.out.println("No tienes suficientes puntos");
                }
            }
            case 2 -> {
                if (jugador.getP_points() >= 100) {
                    //busacndo en el array de armas del jugador
                    boolean tieneArma = false;
                    for (Arma arma : jugador.getArmas()) {
                        if (arma instanceof Escopeta) {
                            tieneArma = true;
                            break;
                        }
                    }
                    if (tieneArma){
                        System.out.println("Ya tienes una escopeta");
                    } else{
                    jugador.setArmas(jugador.getArmas(), new Escopeta());
                    jugador.setP_points(jugador.getP_points() - 100);
                    System.out.println("Arma comprada con exito");
                    }
                } else {
                    System.out.println("No tienes suficientes puntos");
                }
            }
        }


    }

    public void comprarVida(Jugador jugador){
        /*
        Metodo que permite al jugador comprar vida en la terminal si tiene suficientes puntos
        @param: Jugador jugador
         */
        if (jugador.getP_points() >= 10){
            jugador.setVida(jugador.getVida() + 10);
            jugador.setP_points(jugador.getP_points() - 10);
        }
        else{
            System.out.println("No tienes suficientes puntos");
        }
    }


    public void comprarEnergia(Jugador jugador){
        /*
        Metodo que permite al jugador comprar energia en la terminal si tiene suficientes puntos
        @param: Jugador jugador

         */
        if (jugador.getP_points() >= 50){
            jugador.setEnergia(jugador.getEnergia() + 1);
            jugador.setP_points(jugador.getP_points() - 50);
        }
        else{
            System.out.println("No tienes suficientes puntos");
        }
    }





    public char getRepresentacion(){
        return 'T';
    }
}
