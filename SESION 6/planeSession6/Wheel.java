/**
 * Definición de las ruedas del avión
 * 
 * @author David Covián Gómez
 * @version 21/10/2022
 */
public class Wheel
{
    /**
     * Porcentaje, sobre la presión máxima, que debe tener una rueda en el momento que sea operativa.
     */
    public static final int THRESHOLD = 85; // umbral, porcentaje sobre la presión máxima por encima del cual la rueda está operativa
    /**
     * Constante estándar de la presión máxima.
     */
    public static final double STANDARD_MAX_PRESSURE = 1000;
    /**
     * Constante estándar de la presión.
     */
    public static final double STANDARD_PRESSURE = 900;
   
    private double pressure;// presión actual que tiene la rueda, de tipo double
    private double maxPressure;// presión máxima que soporta la rueda, de tipo double

    /**
     * Constructor para crear rueda con valores standard
     */
    public Wheel()
    {
     this.setPressure(Wheel.STANDARD_PRESSURE);
     this.setMaxPressure(Wheel.STANDARD_MAX_PRESSURE);
    }
    
     /**
     * Constructor para crear la rueda con las presión que se desee
     * 
     * @param pressión máxima
     * @param presión actual
     */
    public Wheel(double pressure, double maxPressure)
    {
        this();
        this.setPressure(pressure);
        this.setMaxPressure(maxPressure);
    }

    /**
     * Método que modifica la presión máxima de la rueda
     * 
     * @param  nuevo valor para la presión máxima (>=0), de tipo double  
     *  
     */
    private void setMaxPressure(double maxPressure)
    {
        checkParam(maxPressure>=0 && maxPressure<=STANDARD_MAX_PRESSURE, "Valor inválido");
        this.maxPressure=maxPressure;
    }
    
       
    /**
     * Método que modifica la presión actual
     * 
     * @param  nuevo valor para la presión actual entre [0,maxPressure], de tipo double
     *  
     */
    private void setPressure(double pressure)
    {
        checkParam(pressure>=0 && pressure<=this.getMaxPressure(), "Valor inválido");
        this.pressure=pressure;
    }
    
    /**
     * Método que devuelve la presión máxima
     * 
     * @return presión máxima que puede soportar la rueda, de tipo double
     */
    public double getMaxPressure()
    {
        return this.maxPressure;
    }
    
    /**
    /**
     * Método que devuelve la presión actual
     * 
     * @return presión actual que puede soportar la rueda, de tipo double
     */
    public double getPressure()
    {
        return this.pressure;
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
     * Método que comprueba si una rueda está o no operativa
     * Está operativa si su presión actual es mayor o igual que el 85% del la presión máxima
     * 
     * @return true si la rueda está operativoa y false si no lo es
     */
    public boolean test()
    {
      if (this.getPressure()>(this.getMaxPressure()*Wheel.THRESHOLD/100))
      {
        return true;
      }
      else
      {
        return false;
      }
    }
    
    /**
     * Devuelve el estado de la rueda con el siguiente formato:
     * MaxP: 20700,0 Mb - Pressure: 19300,0 Mb - Percentage: 93,24 - Test: true
     * 
     * @return estado de la rueda con el formato anterior
     */
    public String toString()
    {
        return String.format("MaxP: %.2f Mb - Pressure: %.1f Mb - Percentage: %.2f - Test: %b",
                              this.getMaxPressure(),
                              this.getPressure(),
                              this.getPressure()/this.getMaxPressure()*100,
                              this.test());
        // usaremos  String.format para formatear números decimales
    }
    
    /**
     * Imprime los datos de la rueda en el siguiente formato
     * 
     * Max Pressure....... 34500,0 Mb
     * Current Pressure... 32000,0 Mb (92,75%)
     * Test............... OK (FAIL, si falló el test).
     * 
     */
    public String print()
    {
      System.out.println("Max Pressure......."+this.getMaxPressure() + "Mb");
      System.out.println("Current Pressure..."+this.getPressure() + "Mb" + "("+this.getPressure()/this.getMaxPressure()*100+")";
    }
}