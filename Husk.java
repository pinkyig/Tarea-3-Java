

public class Husk extends Enemigo{
    //Construcor especifico de la clase Husk
    public Husk(){
        super(10,5,0.6,0.4,0.4);
    }

    //Implementacion del metodo abstracto de la interfaz Visible
    public char getRepresentacion(){
        return 'H';
    }

}
