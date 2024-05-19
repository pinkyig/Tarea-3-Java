

public class Escopeta extends Arma{

    private int perdigones;

    public Escopeta(){
        super(2, 0.5F);
        this.perdigones = 10;
    }



    public int calcularDano(float prob_hit){
        /*
        Metodo que calcula el dano de una escopeta en base a la probabilidad de acierto y la precision de la escopeta
        @param: prob_hit: float
        @return: int danoTotal

         */
        int danoTotal = 0;
        int perdigonesAcierto = 0;
        for (int i = 0; i < this.perdigones; i++){
            float r = (float) Math.random();
            if (r > prob_hit * this.getPrecision()){
                danoTotal += this.getDano();
                perdigonesAcierto++;
            }
        }

        if (perdigonesAcierto == 0){
            return 0;
        }
            return danoTotal;


    }

}
