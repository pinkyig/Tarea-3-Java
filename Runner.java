

public class Runner extends Enemigo{
    //Construcor especifico de la clase Runner
    public Runner(){
        super(30,5,0.2,0.1,0.1);
    }

    //Implementacion del metodo abstracto de la interfaz Visible
    public char getRepresentacion(){
        return 'R';
    }
}