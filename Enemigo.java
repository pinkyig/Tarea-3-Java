

abstract class Enemigo implements Visible{

    private int vida;
    private int atk;
    private   double prob_torso;
    private   double prob_pierna;
    private   double prob_cabeza;

    //Construcor generico de la clase Enemigo
    public Enemigo(int vida, int atk, double prob_torso, double prob_pierna, double prob_cabeza){
        this.vida = vida;
        this.atk = atk;
        this.prob_torso = prob_torso;
        this.prob_pierna = prob_pierna;
        this.prob_cabeza = prob_cabeza;
    }


    //Getters y Setters de la clase Enemigo

    public int getVida(){
        /*
        Metodo que retorna la vida de un enemigo
        @param: No recibe parametros
        @return: int vida
         */
        return this.vida;
    }

    public void setVida(int vida){
        /*
        Metodo que establece la vida de un enemigo
        @param: vida: int

         */
        this.vida = vida;
    }

    public int getAtk(){
        /*
        Metodo que retorna el ataque de un enemigo
        @param: No recibe parametros
        @return: int atk
         */
        return this.atk;
    }

    public void setAtk(int atk){
        /*
        Metodo que establece el ataque de un enemigo
        @param: atk: int

         */
        this.atk = atk;
    }

    public double getProbTorso(){
        /*
        Metodo que retorna la probabilidad de acertar al torso de un enemigo
        @param: No recibe parametros
        @return: double prob_torso
         */
        return this.prob_torso;
    }

    public void setProbTorso(double prob_torso){
        /*
        Metodo que establece la probabilidad de acertar al torso de un enemigo
        @param: prob_torso: double

         */
        this.prob_torso = prob_torso;
    }

    public double getProbPierna(){
        /*
        Metodo que retorna la probabilidad de acertar a la pierna de un enemigo
        @param: No recibe parametros
        @return: double prob_pierna

         */
        return this.prob_pierna;
    }

    public void setProbPierna(double prob_pierna){
        /*
        Metodo que establece la probabilidad de acertar a la pierna de un enemigo
        @param: prob_pierna: double

         */
        this.prob_pierna = prob_pierna;
    }

    public double getProbCabeza(){
        /*
        Metodo que retorna la probabilidad de acertar a la cabeza de un enemigo
        @param: No recibe parametros
        @return: double prob_cabeza

         */
        return this.prob_cabeza;
    }

    public void setProbCabeza(double prob_cabeza){
        /*
        Metodo que establece la probabilidad de acertar a la cabeza de un enemigo
        @param: prob_cabeza: double

         */
        this.prob_cabeza = prob_cabeza;
    }




}
