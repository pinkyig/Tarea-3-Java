import java.util.*;
import java.util.concurrent.TimeUnit;


public class Arena {

    private int ronda;
    private int tamano;

    private int cantidadEnemigos;

    private ArrayList<Visible> mapa;

    //Constructor de la clase Arena
    public Arena(){
        this.tamano = 15;
        this.ronda = 0;
        this.cantidadEnemigos = 0;
        this.mapa = new ArrayList<Visible>(15);
    }

    //Metodos de la clase Arena

    //Metodo que muestra el mapa de la arena

    public void mostrar(){
        /*
        Metodo que muestra el mapa de la arena
        @param: No recibe parametros
         */
        System.out.println("Ronda: " + this.ronda);
        for(int i = 0; i < this.tamano; i++){
            System.out.print(this.mapa.get(i).getRepresentacion());
        }


    }


    //Metodo para empezar nueva ronda

    public void nuevaRonda(){
        /*
        Metodo que genera una nueva ronda del juego con enemigos, jugador y terminal
        @param: No recibe parametros
         */
        this.mapa.clear();
        this.cantidadEnemigos = 0;
        this.ronda++;
        int Contador=0;

        //Generando mapa vacio
        for (int i = 0; i < this.tamano; i++) {
            this.mapa.add(new Vacio());
        }

        //Generando jugador y terminal

        this.mapa.set(this.tamano/2, new Terminal());
        this.mapa.set((this.tamano/2)+1, new Jugador());

        int enemigosGenerados = (int) (Math.random() * 3) + 3;

        //Generando enemigos

        while(this.cantidadEnemigos < enemigosGenerados) {

            if (Contador == this.tamano) {
                Contador = 0;
            }

            if (Contador != (this.tamano/2)+1 && Contador != this.tamano / 2) {
                //40% de probabilidad de que se genere un Husk
                if (Math.random() < 0.4) {
                    this.mapa.set(Contador, new Husk());
                    this.cantidadEnemigos++;
                } else if (Math.random() < 0.2) {
                    this.mapa.set(Contador, new Runner());
                    this.cantidadEnemigos++;
                } else if (Math.random() < 0.1) {
                    this.mapa.set(Contador, new Tanke());
                    this.cantidadEnemigos++;

                }

            }
            Contador++;
        }



    }

    public static void pausa(int segundos) {
        /*
        Metodo que pausa la ejecucion del programa por un tiempo determinado en segundos
        @param: segundos: int

         */
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Getters y Setters

    public int getRonda(){
        /*
        Metodo que retorna la ronda actual del juego
        @param: No recibe parametros
        @return: int ronda
         */
        return this.ronda;
    }

    public int getTamano(){
        /*
        Metodo que retorna el tamaño del mapa de la arena
        @param: No recibe parametros
        @return: int tamano
         */
        return this.tamano;
    }

    public int getCantidadEnemigos(){
        /*
        Metodo que retorna la cantidad de enemigos en el mapa de la arena
        @param: No recibe parametros
        @return: int cantidadEnemigos
         */
        return this.cantidadEnemigos;
    }

    public void setRonda(int ronda){
        /*
        Metodo que establece la ronda actual del juego
        @param: ronda: int
         */
        this.ronda = ronda;
    }

    public void setTamano(int tamano){
        /*
        Metodo que establece el tamaño del mapa de la arena
        @param: tamano: int

         */
        this.tamano = tamano;
    }

    public void setCantidadEnemigos(int cantidadEnemigos){
        /*
        Metodo que establece la cantidad de enemigos en el mapa de la arena
        @param: cantidadEnemigos: int
         */
        this.cantidadEnemigos = cantidadEnemigos;
    }

    public ArrayList<Visible> getMapa(){
        /*
        Metodo que retorna el mapa de la arena
        @param: No recibe parametros
        @return: ArrayList<Visible> mapa
         */
        return this.mapa;
    }

    public void setMapa(ArrayList<Visible> mapa){
        /*
        Metodo que establece el mapa de la arena
        @param: mapa: ArrayList<Visible>
         */
        this.mapa = mapa;
    }



}
