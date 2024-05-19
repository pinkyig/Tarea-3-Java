
import java.util.Scanner;

public class Ultrajava {
    /*
    * Metodo principal del juego UltraJava que se encarga de manejar las opciones del jugador y el flujo del juego
    * @param: String[] args
    *
     */
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        Arena arena = new Arena();
        Jugador jugador = new Jugador();

        System.out.println("Bienvenido a UltraJava \n");
        System.out.println("Generando mapa... \n ");
        Arena.pausa(2);
        //Iniciando el juego
        arena.nuevaRonda();



        int opcion = 0;
        while(opcion != 4){
            int cantidadEnemigosActual = 0;

            //recorriendo la arena contando los enemigos
            for(int i = 0; i < arena.getMapa().size(); i++){
                if(arena.getMapa().get(i) instanceof Enemigo){
                    cantidadEnemigosActual++;
                }
            }
            arena.setCantidadEnemigos(cantidadEnemigosActual);



            if (arena.getCantidadEnemigos() == 0) {
                arena.nuevaRonda();
                if(arena.getRonda() == 4){
                    System.out.println("FELICIDADES! Has completado las 3 rondas del juego!");
                    System.out.println("Gracias por jugar la beta de UltraJava!");
                    System.exit(0);
                }
                System.out.println("FELICIDADES! Has completado la ronda " + (arena.getRonda() - 1) + "!");
                System.out.println("Comenzando nueva ronda!\n");
                Arena.pausa(2);
            }

            arena.mostrar();
            Arena.pausa(1);
            System.out.println("\n Menu de opciones");
            System.out.println("1. Ver estadisticas");
            System.out.println("2. Moverse");
            System.out.println("3. Restart");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opcion:");
            opcion = lectura.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("--------------------");
                    System.out.println("Estadisticas del jugador: ");
                    System.out.println("Vida: " + jugador.getVida());
                    System.out.println("Energia " + jugador.getEnergia());
                    System.out.println("P Points: " + jugador.getP_points());
                    jugador.mostrarArmas();
                    System.out.println("--------------------");
                }
                case 2 -> {
                    System.out.println("Moviendo jugador");
                    System.out.print("Ingrese la direccion a moverse:\n ");
                    System.out.println("1. Derecha");
                    System.out.println("2. Izquierda");
                    System.out.println(">>");
                    int direccion = lectura.nextInt();
                    int posJugador = jugador.getPosicion(arena.getMapa());
                    jugador.mover(direccion, posJugador, arena.getMapa(), jugador);
                }
                case 3 -> {
                    System.out.println("Reiniciando juego");
                    arena.setRonda(0);
                    arena.nuevaRonda();
                }
                case 4 -> System.out.println("Saliendo del juego");
                default -> System.out.println("Opcion no valida");
            }
        }

    }
}
