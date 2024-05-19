

public class Tanke extends Enemigo{
    //Construcor especifico de la clase Tanke
    public Tanke(){
        super(100,10,1,0.6,0.6);
    }

    //Implementacion del metodo abstracto de la interfaz Visible
    public char getRepresentacion(){
        return 'K';
    }
}
