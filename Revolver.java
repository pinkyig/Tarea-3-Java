

public class Revolver extends Arma{

    public Revolver(){
        super(6, 0.8F);
    }

    public int calcularDano(float prob_hit){
        /*
        Metodo que calcula el dano de un revolver en base a la probabilidad de acierto y la precision del revolver
        @param: prob_hit: float
        @return: int dano

         */
        float r = (float) Math.random();
        if (r > prob_hit * this.getPrecision()){
            return this.getDano();
        } else {
            return 0;
        }

    }
}
