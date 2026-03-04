
/**
 * Clase Heater
 * 
 * @author David Covián Gómez
 * @version 21-10-22 */
public class Heater
{
   private double temperature; //Temperatura del radiador
   
   /**
    * Constante que indica la temperatura mínima.
    */
   public static final double TEMP_MIN=10d;
   /**
    * Constante que indica la temperatura máxima.
    */
   public static final double TEMP_MAX=27d;
   
   /**
    * Constructor por defecto de la clase Heater
    */
   public Heater()
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
    * Método que cambia el valor de la temperatura teniendo en cuenta el intervalo disponible.
    * @param temperature Temperatura del radiador.
    */
   public void changeTemperature(double temperature)
   {
    checkParam(temperature>=TEMP_MIN && temperature<=TEMP_MAX, "Valor inválido");
    this.temperature=temperature;
    }

   /**
    * Método que devuelve el valor de la temperatura.
    * @return Temperatura
    */
   public double getTemperature()
    {
        return temperature;
    }
    
   /**
    * Método que devuelve la temperatura del radiador
    * @return Temperatura del radiador
    */
   public String toString()
   {
        return temperature + "ºC";
    }
}
