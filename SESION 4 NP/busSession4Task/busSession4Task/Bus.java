
/**
 * Autobús correspondiente a la Tarea no presencial de la Sesión 4
 * 
 * 
 * @author ip-profes
 * @version 2/10/2022
 */
public class Bus
{
    // ATRIBUTOS CONSTANTES
    /**
     * Indica la presencia de conductor. true si está presente
     */
    public static final boolean IS_DRIVER_PRESENT = true;      
     /**
     * Número máximo de asientos del autobús
     */
    public static final int MAX_SEATS = 60;
     /**
     * Número mínimo de asientos del autobús
     */
    public static final int MIN_SEATS = 10;  
    
     /**
     * Valor por defecto para construir el autobús. Conductor ausente.
     */
    public static final boolean DEFAULT_DRIVER_PRESENT = ! IS_DRIVER_PRESENT;
    /**
     * Valor por defecto para construir el autobús. Número de asientos disponibles.
     */
    public static final int DEFAULT_AVAILABLE_SEATS = MAX_SEATS;
    
    /**
     * Texto indicativo de que hay conductor
     */
    public static final String ON_DUTY = "ON DUTY";
    /**
     * Texto indicativo de que no hay conductor
     */
    public static final String OUT_SERVICE = "OUT OF SERVICE";
    
     
    // ATRIBUTOS VARIALBES 
    private boolean driverPresent;      // indica si el autobús tiene o no conductor
    private int availableSeats;         // número de asientos libres en el bus
    

    /**
     * Constructor sin parámetros con valores por defecto
     * driverPresent: false.
     * availableSeats: al número máximo de asientos libres
     * 
     */
    public Bus()  {
        setDriverPresent(DEFAULT_DRIVER_PRESENT);
        setAvailableSeats(DEFAULT_AVAILABLE_SEATS);
    }
    
    /**
     * Constructor con un párametro
     * @param driverPresent, de tipo boolean
     * 
     */
    public Bus(boolean driverPresent) {
        this();
        setDriverPresent(driverPresent);    
    }
    
    /**
     * Constructor con un párametro
     * @param availableSeats, de tipo int
     * 
     */
    public Bus(int availableSeats) {
        this();
        setAvailableSeats(availableSeats);    
    }
    
    /**
     * Constructor CON parámetros 
     * @param boolean Si está o no presente el conductor
     * @pararm int máximo número de asientos disponibles
     * 
     */
    public Bus(boolean isDriverPresent, int availableSeats) {
        this();
        setDriverPresent(isDriverPresent);
        setAvailableSeats(availableSeats);
    }
        
    /**
     * Modifica el valor del atributo isDriverPresent
     * 
     * @param  boolean true si está¡ presente el conductor
     *
     */
    private void setDriverPresent(boolean driverPresent) {
        this.driverPresent = driverPresent;
    }
    
    /**
     * Devuelve el valor del atributo isDriverPresent
     * @return boolean si está¡ o no presente el conductor
     */
    public boolean isDriverPresent(){
        return driverPresent;
    }
    
    /**
     * Devuelve el valor del atributo availableSeats
     * @return int número de asientos disponibles
     */
    public int getAvailableSeats() {
        return availableSeats;
    }
         
    /**
     * Modifica el valor del atributo availableSeats
     * 
     * @param  int número de asientos disponibles (entre [MIN_SEATS,MAX_SEATS]
     *
     */
    private void setAvailableSeats(int availableSeats){
        checkParam(availableSeats >= MIN_SEATS && availableSeats <= MAX_SEATS,
                    "Asientos fuera de límites");
        this.availableSeats = availableSeats;
    }
    
    /**
     * Valida el parámetro 
     * @param condition, de tipo boolean
     * @return true si se cumple la condición
     */
    private void checkParam(boolean condition, String cause) {
        if (! condition) {
            throw new IllegalArgumentException (cause);
        }
    }
    
    /**
     *  Má©todo que hace que el conductor está presente
     *  
     */
    public void sitDriver() {
        setDriverPresent(IS_DRIVER_PRESENT);        
    }
    
    /**
     *  Recibe el número de pasajeros que quieren subir. 
     *  Si el conductor está en el bus y hay sitio suficiente
     *  para todos, se decrementa el número de asientos libres en cantidad igual al número de pasajeros 
     *  y retorna true
     *
     *@param boolean true si han podido subir los pasajeros
     */
    public boolean getOn(int passengers) {
        checkParam(passengers > 0, "Pasajeros no pueden ser negativos");
        if (isDriverPresent() && passengers <= getAvailableSeats())
        {
            setAvailableSeats(getAvailableSeats() - passengers);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     *  devuelve una cadena que contiene la siguiente información separada por guiones: 
     *   "ON DUTY", si el conductor está en el autobús o "OUT OF SERVICE", si no lo está. 
     *   Número de asientos disponibles. 
     */
    public String toString()  {
        String data = driverPresentAsString() + "-" + getAvailableSeats();
        return data;
    }
    
    /**
     * Transforma el valor de driverPresent en un strign "ON DUTY" O "OUT OF SERVICE"
     * 
     */
    private String driverPresentAsString() {
        if (isDriverPresent() ) {
            return ON_DUTY ;
        } else {
            return  OUT_SERVICE ;
        }
    }
}
