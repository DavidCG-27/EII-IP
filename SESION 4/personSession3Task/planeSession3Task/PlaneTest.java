
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PlaneTest.
 *Versión 1.0 sólo pruebas del constructor por defecto.
 *
 * @author  David
 * @version 07/10/2022
 */
public class PlaneTest
{
    /**
     * Default constructor for test class PlaneTest
     */
    public PlaneTest()
    {
    }

    /**
     * Pruebas del constructor por defecto
     * Caso 1. Caso único. Creamos un avión con los valores por defecto.
     */
    @Test
    public void constructorWithoutParamUniqCase(){
        Plane plane1= new Plane();
        
        assertEquals(null, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(0, plane1.getFuel());
    }
    
     /**
     * Pruebas del constructor con tres parámetros. Pruebas fuel
     * Caso P1. Fuel igual a 0
     */
    @Test
    public void constWithParamFuelEquals0(){
        Person pilot=new Person();
        Plane plane1= new Plane(pilot, 'A', 0);
        
        assertEquals(pilot, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(0, plane1.getFuel());
    }
     /**
     * Pruebas del constructor con tres parámetros. Pruebas fuel
     * Caso P2. Fuel igual a 1000
     */
    @Test
    public void constWithParamFuelEquals1000(){
        Person pilot=new Person();
        Plane plane1= new Plane(pilot, 'A', 1000);
        
        assertEquals(pilot, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(1000, plane1.getFuel());
    }
     /**
     * Pruebas del constructor con tres parámetros. Pruebas fuel
     * Caso P3. Fuel igual a 5000
     */
    @Test
    public void constWithParamFuelEquals5000(){
        Person pilot=new Person();
        Plane plane1= new Plane(pilot, 'A', 5000);
        
        assertEquals(pilot, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(5000, plane1.getFuel());
    }
    /**
     * Pruebas del constructor con tres parámetros. Pruebas fuel
     * Caso N1: Fuel <0
     */
    @Test
    public void constWithParamFuelBelowLimit(){
    Person pilot=new Person();
    try{
        Plane plane1=new Plane(pilot, 'A', -1);
        fail("Debería haber fallado, dado que el fuel es <0");
    }
    catch(RuntimeException e){
        assertEquals("Combustible fuera de rango", e.getMessage());
    }
    }
    /**
     * Pruebas del constructor con tres parámetros. Pruebas fuel
     * Caso N2: Fuel >5000
     */
     @Test
    public void constWithParamFuelAboveLimit(){
    Person pilot=new Person();
    try{
        Plane plane1=new Plane(pilot, 'A', 5001);
        fail("Debería haber fallado, dado que el fuel es >5000");
    }
    catch(RuntimeException e){
        assertEquals("Combustible fuera de rango", e.getMessage());
    }
    }
    
    /**
     * Pruebas del constructor con tres parámetros. Pruebas identifier
     * Caso N1: Fuel <0
     */
}
