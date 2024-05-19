

abstract class Arma {

    private int dano;
    private float precision;

    public Arma(int dano, float precision){
        this.dano = dano;
        this.precision = precision;
    }

    public int getDano(){
        /*
        Metodo que devuelve el dano de un arma
        @return int dano
         */
        return this.dano;
    }

    public void setDano(int dano){
        /*
        Metodo que cambia el dano de un arma
        @param int dano
         */
        this.dano = dano;
    }

    public float getPrecision(){
        /*
        Metodo que devuelve la precision de un arma
        @return float precision
         */
        return this.precision;
    }

    public void setPrecision(int precision){
        /*
        Metodo que cambia la precision de un arma
        @param float precision
         */
        this.precision = precision;
    }

    public abstract int calcularDano(float prob_hit);

}
