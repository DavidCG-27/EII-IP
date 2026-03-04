
/**
 * Clase Potenciómetro
 * 
 * @author David Covián Gómez
 * @version 21-10-2022
 */
public class Potentiometer
{
    private int value;
    /**
     * Constante que expresa el valor mínimo del potenciómetro.
     */
    public static final int MIN_VALUE=0;
    /**
     * Constante que expresa el valor máximo del potenciómetro.
     */
    public static final int MAX_VALUE=10;
    
    
    /**
     * Constructor por defecto
     */
    public Potentiometer()
    {
    }
    
     
    /**
     * Lanza un error cuando no se cumple.
     */
    private void checkParam(boolean condition, String errorMsg){
        if (condition==false) {
            throw new IllegalArgumentException(errorMsg); 
        }
    }
    
    /**
     * Método que permite cambiar la posición del potenciómetro dentro del intervalo permitido
     */
    public void movePosition(int value)
    {
     checkParam(value>=0 && value<=10, "Valor inválido");
     this.value=value;
    }
    
    /**
    * Método que devuelve el valor de la posición.
    * @return Posición
    */
   public int getPosition()
    {
        return value;
    }
    
    /**
     * Método que devuelve la posición del potenciómetro.
     * @return Posición del potenciómetro.
     */
    public String toString()
    {
        return ""+value;
    }
}
