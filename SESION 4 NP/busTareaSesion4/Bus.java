
/**
 * Write a description of class Bus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bus
{
    private boolean driverPresent; //Conductor presente (true-->si, false-->no)
    private int availableSeats; //Número de asientos en el bus

    /**
     * Constructor por defecto de la clase Bus (DriverPresent false y AvailableSeats 60)
     */
    public Bus()
    {
        this.setDriverPresent(false);
        this.setAvailableSeats(60);
    }
    /**
     * Constructor por parámetros DriverPresent y AvailableSeats.
     * @param driverPresent Presencia del conductor
     * @param availableSeats Nº de asientos disponibles
     */
    public Bus(boolean driverPresent, int availableSeats){
        this.setDriverPresent(driverPresent);
        this.setAvailableSeats(availableSeats);
    }
    
    /**
     * Permite modificar el valor booleano del conductor
     * @param driverPresent Presencia del conductor
     */
    private void setDriverPresent(boolean driverPresent){
        this.driverPresent=driverPresent;
    }
    
    /**
     * Permite modificar el número de asientos disponibles.
     * @param availableSeats Nº de asientos disponibles.
     */
    private void setAvailableSeats(int availableSeats){
        checkParam(availableSeats>=10 && availableSeats<=60, "El número de asientos no puede ser mayor que 60 ni menor que 10");
        this.availableSeats=availableSeats;
    }
    
    private void checkParam(boolean condition, String errorMsg){
        if (condition==false){
            throw new IllegalArgumentException(errorMsg);
        }
    }
    
    public boolean getDriverPresent(){
        return driverPresent;
    }
    
    public int getAvailableSeats(){
        return availableSeats;
    }
}
