
import java.util.*;

public class Jugador implements Visible{


    private int vida;
    private int energia;
    private ArrayList<Arma> armas;
    private int P_points;


    //Constructor de la clase Jugador

    public Jugador(){
        this.vida = 100;
        this.energia = 3;
        this.armas = new ArrayList<Arma>();
        this.armas.add(new Revolver());
        this.P_points = 0;
    }

    //Metodos de la clase Jugador

    public void mover (int direccion,int posJugador, ArrayList<Visible> mapa, Jugador jugador){
        /* Metodo que permite al jugador moverse en el mapa
        - @param direccion: entero que indica la direccion en la que se movera el jugador
        - @param posJugador: entero que indica la posicion actual del jugador en el mapa
        - @param mapa: ArrayList de objetos de la interfaz Visible que representa el mapa del juego
        - @param jugador: objeto de la clase Jugador que representa al jugador
        - @return: void

        - Si el jugador se mueve a la derecha o izquierda y en la siguiente posicion se encuentra un enemigo,
           se inicia un enfrentamiento entre el jugador y el enemigo en esa posicion y se verifica si el jugador derrota o huye del enemigo
        - Si el jugador se mueve a la derecha o izquierda y en la siguiente posicion se encuentra una terminal, se inicia un ciclo que permite al jugador comprar armas, vida o energia
        - Si el jugador se mueve a la derecha o izquierda y en la siguiente posicion se encuentra  Vacio, se mueve al jugador a esa posicion
        */
        if (direccion == 1){
            if (posJugador < mapa.size() - 1){
                //Caso en que se encuentre cualquier instancia de enemigo: Husk, Runner o Tanke
                if (mapa.get(posJugador + 1) instanceof Enemigo){
                    Enemigo enemigo = (Enemigo) mapa.get(posJugador + 1);
                    jugador.Enfremiento(enemigo, jugador, direccion, mapa, posJugador);
                    //Verificando si derroto o huyo del enemigo
                    if (enemigo.getVida() <= 0) {
                        mapa.set(posJugador, new Vacio());
                        mapa.set(posJugador + 1, jugador);
                    }

                } else if (mapa.get(posJugador + 1) instanceof Terminal) {
                    Terminal terminal = (Terminal) mapa.get(posJugador + 1);
                    Scanner sc = new Scanner(System.in);
                    boolean flag = true;
                    //Ciclo para que el jugador pueda comprar armas, vida o energia
                    while (flag) {
                        System.out.println("----------------------------");
                        System.out.println("Bienvenido a la terminal!!!");
                        System.out.println("----------------------------\n");
                        System.out.println("Puntos disponibles: " + jugador.getP_points());
                        System.out.println("1. Comprar Arma");
                        System.out.println("2. Comprar Vida");
                        System.out.println("3. Comprar Energia");
                        System.out.println("4. Salir");
                        int opcion = sc.nextInt();
                        switch (opcion) {
                            case 1 -> {
                                terminal.comprarArma(jugador);
                            }
                            case 2 -> {
                                terminal.comprarVida(jugador);
                            }
                            case 3 -> {
                                terminal.comprarEnergia(jugador);
                            }
                            case 4 -> {
                                System.out.println("Saliendo de la terminal...");
                                //verificando si en el otro lado de la terminal hay un enemigo
                                if (mapa.get(posJugador + 2) instanceof Enemigo){
                                    Enemigo enemigo = (Enemigo) mapa.get(posJugador + 2);
                                    jugador.Enfremiento(enemigo, jugador, direccion, mapa, posJugador);
                                    //Verificando si derroto o huyo del enemigo
                                    if (enemigo.getVida() <= 0) {
                                        mapa.set(posJugador, new Vacio());
                                        mapa.set(posJugador + 2, jugador);
                                    }
                                }else {
                                    mapa.set(posJugador, new Vacio());
                                    mapa.set(posJugador + 2, jugador);
                                }
                                flag = false;
                            }

                        }

                    }

                } else {
                    System.out.println("Avanzas determinadamente hacia da derecha...");
                    Arena.pausa(1);
                    mapa.set(posJugador, new Vacio());
                    mapa.set(posJugador + 1, jugador);
                }
            }else {

                //caso en que el jugador llegue al final del mapa y encuentre un enemigo al inicio
                if (mapa.get(0) instanceof Enemigo){
                    Enemigo enemigo = (Enemigo) mapa.get(0);
                    jugador.Enfremiento(enemigo, jugador, direccion, mapa, posJugador);
                    //Verificando si derroto o huyo del enemigo
                    if (enemigo.getVida() <= 0) {
                        mapa.set(posJugador, new Vacio());
                        mapa.set(0, jugador);
                    }
                }else {
                    mapa.set(posJugador, new Vacio());
                    mapa.set(0, jugador);
                }
            }
        }else if (direccion == 2){
            //Caso en que se encuentre un enemigo
            if (posJugador > 0){
                if (mapa.get(posJugador - 1) instanceof Enemigo){
                    Enemigo enemigo = (Enemigo) mapa.get(posJugador - 1);
                    jugador.Enfremiento(enemigo, jugador, direccion, mapa, posJugador);
                    //Verificando si derroto o huyo del enemigo
                    if (enemigo.getVida() <= 0) {
                        mapa.set(posJugador, new Vacio());
                        mapa.set(posJugador - 1, jugador);
                    }
                } else if (mapa.get(posJugador - 1) instanceof Terminal) {
                    Terminal terminal = (Terminal) mapa.get(posJugador - 1);
                    Scanner sc = new Scanner(System.in);
                    boolean flag = true;
                    //Ciclo para que el jugador pueda comprar armas, vida o energia
                    while (flag) {
                        System.out.println("----------------------------");
                        System.out.println("Bienvenido a la terminal!!!");
                        System.out.println("----------------------------\n");
                        System.out.println("Puntos disponibles: " + jugador.getP_points());
                        System.out.println("1. Comprar Arma");
                        System.out.println("2. Comprar Vida");
                        System.out.println("3. Comprar Energia");
                        System.out.println("4. Salir");
                        int opcion = sc.nextInt();
                        switch (opcion) {
                            case 1 -> {
                                terminal.comprarArma(jugador);
                            }
                            case 2 -> {
                                terminal.comprarVida(jugador);
                            }
                            case 3 -> {
                                terminal.comprarEnergia(jugador);
                            }
                            case 4 -> {
                                System.out.println("Saliendo de la terminal...");
                                //verificando si en el otro lado de la terminal hay un enemigo
                                if (mapa.get(posJugador - 2) instanceof Enemigo){
                                    Enemigo enemigo = (Enemigo) mapa.get(posJugador - 2);
                                    jugador.Enfremiento(enemigo, jugador, direccion, mapa, posJugador);
                                    //Verificando si derroto o huyo del enemigo
                                    if (enemigo.getVida() <= 0) {
                                        mapa.set(posJugador, new Vacio());
                                        mapa.set(posJugador - 2, jugador);
                                    }
                                }else {
                                    mapa.set(posJugador, new Vacio());
                                    mapa.set(posJugador - 2, jugador);
                                }
                                flag = false;
                            }

                        }

                    }
                } else {
                    System.out.println("Te mueves con determinacion hacia la izquierda...");
                    mapa.set(posJugador, new Vacio());
                    mapa.set(posJugador - 1, jugador);
                }
            }else {
                if (mapa.get(mapa.size() - 1) instanceof Enemigo){
                    Enemigo enemigo = (Enemigo) mapa.get(mapa.size() - 1);
                    jugador.Enfremiento(enemigo, jugador, direccion, mapa, posJugador);
                    if (enemigo.getVida() <= 0) {
                        mapa.set(posJugador, new Vacio());
                        mapa.set(mapa.size() - 1, jugador);
                    }
                }else {
                    mapa.set(posJugador, new Vacio());
                    mapa.set(mapa.size() - 1, jugador);
                }
            }
        }
    }

    public void recibirDano(int dmg){

        /*
        * Metodo que se encarga de recibir el dano del enemigo y darle la opcion al jugador de esquivar el ataque o recibirlo directamente
        * @param dmg: dano que recibe el jugador
        * @return void
        *
        *
        */

        //dandole la opcion al jugador si desea usar su energia para esquivar el ataque
        System.out.println("Deseas usar tu energia para esquivar el ataque?");
        System.out.println("Energia restante: " + this.energia);
        System.out.println("1) Si");
        System.out.println("2) No");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if (opcion == 1) {
            if (this.energia > 0) {
                this.energia -= 1;
                System.out.println("Ataque esquivado con exito");
                System.out.println("Que haras ahora?!");

            } else {
                this.vida -= dmg;
                System.out.println("Energia insuficiente el jugador recibio " +dmg+ " de dano\n");
                System.out.println("Que accion tomaras al respecto?!");

            }
        }else {
            this.vida -= dmg;
            System.out.println("El jugador recibio " +dmg+ " de dano\n");
            System.out.println("Que accion tomaras al respecto?!");
        }
    }


    //Metodo que devulve toda la info de las armas del jugador
    public void mostrarArmas(){
        /*
        * Metodo que se encarga de mostrar todas las armas que posee el jugador
        * @param void
        * @return void
        *
        * */
        int i = 1;
        for (Arma arma : this.armas) {
            System.out.println(i+") Arma: " + arma.getClass().getSimpleName()+" danio: "+arma.getDano());
            i++;
        }
    }

    public float Disparar(Enemigo enemigo){
        /*
        * Metodo que se encarga de disparar al enemigo y calcular el dano total que se le hizo dependiendo de la parte del cuerpo a la que se le disparo
        * @param enemigo: enemigo al que se le dispara
        * @return danoTotal: dano total que se le hizo al enemigo
        *
         */
        int danoTotal=0;
        System.out.println("RAPIDO!!! elige un arma para disparar");
        this.mostrarArmas();
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        //Obteniendo la  arma seleccionada por el jugador
        Arma arma = this.armas.get(opcion - 1);

        //Preguntando a que parte del cuerpo desea disparar
        System.out.println("A que parte del cuerpo deseas disparar?");
        System.out.println("1. Cabeza");
        System.out.println("2. Torso");
        System.out.println("3. Piernas");
        int parteCuerpo = sc.nextInt();

        //Calculando el dano tota
        switch (parteCuerpo) {
            case 1 -> {
                System.out.println("Te mantienes firme y disparas al " + enemigo.getClass().getSimpleName() + " con tu " + arma.getClass().getSimpleName());
                if (arma.calcularDano((float) enemigo.getProbCabeza()) == 0) {
                    System.out.println("Pero fallas el disparo a la cabeza...");
                    break;
                }
                System.out.println("HEADSHOT!!! 2x DANO");
                danoTotal = arma.calcularDano((float) enemigo.getProbCabeza()) * 2;
                enemigo.setVida(enemigo.getVida() - danoTotal);
                System.out.println("Dano causado: " + danoTotal);

            }
            case 2 -> {
                if (arma.calcularDano((float) enemigo.getProbTorso()) == 0) {
                    System.out.println("Fallas el disparo al torso...");
                    break;
                }
                danoTotal = arma.calcularDano((float) enemigo.getProbTorso());
                System.out.println("Te mantienes firme y disparas al " + enemigo.getClass().getSimpleName() + " con tu " + arma.getClass().getSimpleName());
            }
            case 3 -> {
                if (arma.calcularDano((float) enemigo.getProbPierna()) == 0) {
                    System.out.println("Fallas el disparo a las piernas...");
                    break;
                }
                danoTotal = arma.calcularDano((float) enemigo.getProbPierna()) / 2;
                System.out.println("Te mantienes firme y disparas al " + enemigo.getClass().getSimpleName() + " con tu " + arma.getClass().getSimpleName());
            }
        }

        return danoTotal;
    }


    public void Enfremiento(Enemigo enemigo, Jugador jugador, int direccion, ArrayList<Visible> mapa, int posJugador){
        /*
        * Metodo que se encarga de simular el enfrentamiento entre el jugador y el enemigo y de darle la opcion al
        * jugador de huir o enfrentarse al enemigo
        * @param enemigo: enemigo con el que se enfrentara el jugador
        * @param jugador: jugador que se enfrentara al enemigo
        * @param direccion: direccion en la que se encuentra el enemigo
        * @param mapa: mapa en el que se encuentra el jugador
        * @param posJugador: posicion del jugador en el mapa
        * @return void
        *
        *
         */
        if (direccion == 1) {
            System.out.println("Avanzas determinadamente hacia da derecha...");
        } else {
            System.out.println("Avanzas determinadamente hacia da izquierda...");
        }

        Arena.pausa(1);
        System.out.println("OH NO!! te encuentras en tu camino con un " + enemigo.getClass().getSimpleName());
        Arena.pausa(1);
        System.out.println("Preparate para el combate...");
        Arena.pausa(1);
        boolean huir = false;
        while (enemigo.getVida() > 0 && jugador.getVida() > 0 && !huir){
            Arena.pausa(1);
            System.out.println("\n");
            System.out.println("------------"+enemigo.getClass().getSimpleName()+"------------");
            System.out.println("-Vida del enemigo: " + enemigo.getVida());
            System.out.println("-Ataque del enemigo: " + enemigo.getAtk());
            System.out.println("------------"+enemigo.getClass().getSimpleName()+"------------\n");

            System.out.println("CUIDADO!! el enemigo lanza un ataque.");
            Arena.pausa(1);
            jugador.recibirDano(enemigo.getAtk());
            System.out.println("1. Disparar");
            System.out.println("2. Huir");
            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> jugador.Disparar(enemigo);
                case 2 -> {
                    System.out.println("Huyendo del enemigo...");
                    huir = true;
                }
            }
        }
        if (enemigo.getVida() <= 0){
            System.out.println("------------"+enemigo.getClass().getSimpleName()+"------------");
            System.out.println("EL ENEMIGO HA SIDO DERROTADO!!!");
            System.out.println("------------"+enemigo.getClass().getSimpleName()+"------------\n");
            System.out.println("*obtienes 30 P points*\n");
            jugador.setP_points(jugador.getP_points() + 30);
            //seteando la cantidad de enemigos de la arena en -1
        } else if (jugador.getVida() <= 0){
            System.out.println("Has sido derrotado por el enemigo");
            System.out.println("GAME OVER");
            System.exit(0);
        }
    }



    //Override del metodo de la interfaz Visible
    public char getRepresentacion(){
        /*
        * Metodo que se encarga de retornar la representacion del jugador en el mapa
        * @return char de la representacion del jugador
        * */
        return 'J';
    }


    //getters y setters

    public int getVida(){
        /*
        * Metodo que se encarga de retornar la vida del jugador
        *
        *
        * @return int vida del jugador
        *
        * */
        return this.vida;
    }

    public void setVida(int vida){
        /*
        * Metodo que se encarga de setear la vida del jugador
        * @param vida: vida del jugador
         */
        this.vida = vida;
    }

    public int getEnergia(){
        /*
        * Metodo que se encarga de retornar la energia del jugador
        * @return int energia del jugador
         */
        return this.energia;
    }

    public void setEnergia(int energia){
        /*
        * Metodo que se encarga de setear la energia del jugador
        * @param energia: energia del jugador
         */
        this.energia = energia;
    }

    public ArrayList<Arma> getArmas(){
        /*
        * Metodo que se encarga de retornar las armas del jugador
        * @return ArrayList<Arma> armas del jugador
         */
        return this.armas;
    }

    public void setArmas(ArrayList<Arma> armas, Arma arma){
        /*
        * Metodo que se encarga de setear las armas del jugador
        * @param armas: armas del jugador
         */
        this.armas.add(0,arma);
        this.armas = armas;
    }



    public int getP_points(){
        /*
        * Metodo que se encarga de retornar los P points del jugador
        * @return int P points del jugador
         */
        return this.P_points;
    }

    public void setP_points(int P_points){
        /*
        * Metodo que se encarga de setear los P points del jugador
        * @param P_points: P points del jugador
        *
         */
        this.P_points = P_points;
    }

    public int getPosicion(ArrayList<Visible> mapa){
        /*
        * Metodo que se encarga de retornar la posicion del jugador en el mapa
        * @param mapa: mapa en el que se encuentra el jugador
        * @return int posicion del jugador en el mapa
         */
        int posJugador = 0;
        for (int i = 0; i < mapa.size(); i++){
            if (mapa.get(i).getRepresentacion() == 'J'){
                posJugador = i;
            }
        }
        return posJugador;
    }
















}
