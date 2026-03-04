
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
    public void constructorWithoutParamUniqCase()
    {
        Plane plane1= new Plane();
        
        assertEquals(null, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(0, plane1.getFuel());
        assertNotNull(plane1.getLandingGear());
    }
    
     /**
     * Pruebas del constructor con tres parámetros. Pruebas fuel
     * Caso P1. Fuel igual a 0
     */
    @Test
    public void constWithParamFuelEquals0()
    {
        Person pilot=new Person();
        Plane plane1= new Plane(pilot, 'A', 0);
        
        assertEquals(pilot, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(0, plane1.getFuel());
        assertNotNull(plane1.getLandingGear());
    }
    
     /**
     * Pruebas del constructor con tres parámetros. Pruebas fuel
     * Caso P2. Fuel igual a 1000
     */
    @Test
    public void constWithParamFuelEquals1000()
    {
        Person pilot=new Person();
        Plane plane1= new Plane(pilot, 'A', 1000);
        
        assertEquals(pilot, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(1000, plane1.getFuel());
        assertNotNull(plane1.getLandingGear());
    }
    
     /**
     * Pruebas del constructor con tres parámetros. Pruebas fuel
     * Caso P3. Fuel igual a 5000
     */
    @Test
    public void constWithParamFuelEquals5000()
    {
        Person pilot=new Person();
        Plane plane1= new Plane(pilot, 'A', 5000);
        
        assertEquals(pilot, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(5000, plane1.getFuel());
        assertNotNull(plane1.getLandingGear());
    }
    
    /**
     * Pruebas del constructor con tres parámetros. Pruebas fuel
     * Caso N1: Fuel <0
     */
    @Test
    public void constWithParamFuelBelowLimit()
    {
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
    public void constWithParamFuelAboveLimit()
    {
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
     * Pruebas del constructor parámetro fuel. 
     * Caso P1. Fuel igual a 0
     */
    @Test
    public void constWithOnlyParamFuelEquals0()
    {
        Person pilot=new Person();
        Plane plane1= new Plane(0);
        
        assertEquals(0, plane1.getFuel());
        assertNotNull(plane1.getLandingGear());
    }
    
    
     /**
     * Pruebas del constructor parámetro fuel.
     * Caso P2. Fuel igual a 1000
     */
    @Test
    public void constWithOnlyParamFuelEquals1000()
    {
        Person pilot=new Person();
        Plane plane1= new Plane(1000);
    
        assertEquals(1000, plane1.getFuel());
        assertNotNull(plane1.getLandingGear());
    }
     /**
     * Pruebas del constructor parámetro fuel.
     * Caso P3. Fuel igual a 5000
     */
    @Test
    public void constWithOnlyParamFuelEquals5000()
    {
        Person pilot=new Person();
        Plane plane1= new Plane(5000);
        
        assertEquals(5000, plane1.getFuel());
        assertNotNull(plane1.getLandingGear());
    }
    
    /**
     * Pruebas del constructor parámetro fuel.
     * Caso N1: Fuel <0
     */
    @Test
    public void constWithOnlyParamFuelBelowLimit()
    {
        Person pilot=new Person();
        try{
            Plane plane1=new Plane(-1);
            fail("Debería haber fallado, dado que el fuel es <0");
        }
        catch(RuntimeException e){
            assertEquals("Combustible fuera de rango", e.getMessage());
        }
    }
    
    /**
     * Pruebas del constructor parámetro fuel.
     * Caso N2: Fuel >5000
     */
     @Test
    public void constWithOnlyParamFuelAboveLimit()
    {
        Person pilot=new Person();
        try{
            Plane plane1=new Plane(5001);
            fail("Debería haber fallado, dado que el fuel es >5000");
        }
        catch(RuntimeException d){
            assertEquals("Combustible fuera de rango", d.getMessage());
        }
    }

    /**
     * Pruebas del constructor parámetro identifier.
     * Caso P1: Letra mayúscula entre A y Z
     */
    @Test
    public void constWithOnlyParamIdentifierInsideLimit()
    {
        Person p=new Person();
        Plane plane1=new Plane('A');
    
        assertEquals('A', plane1.getIdentifier());
        assertNotNull(plane1.getLandingGear());
    }
    
    /**
     * Pruebas del constructor parámetro identifier.
     * Caso N1: Letra fuera de rango
     */
    @Test
    public void constWithOnlyParamIdentifierBelowLimit()
    {
        Person pilot=new Person();
        try{
            Plane plane1=new Plane('a');
            fail("Debería haber fallado, dado que tiene que estar entre A y Z");
        } 
        catch(RuntimeException e){
            assertEquals("Identificador tiene que ser una letra mayúscula", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método accelerate()
     * Caso P1: El valor de ambas velocidades es correcto.
     */
    @Test
    public void accelerateCorrect()
    {
        Plane p=new Plane();
        p.accelerate(0,0);
        assertEquals(0, p.getXSpeed());
        assertEquals(0, p.getYSpeed());
    }
    
    /**
     * Pruebas del método accelerate()
     * Caso N1: El valor de xSpeed es correcto pero de ySpeed no.
     */
    @Test
    public void accelerateWrongY()
    {
        Plane p=new Plane();
        try
        {
            p.accelerate(0,16);
            fail("El valor de ySpeed es incorrecto");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Velocidad de coordenada fuera de rango", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método accelerate()
     * Caso N2: El valor de ySpeed es correcto pero de xSpeed no.
     */
    @Test
    public void accelerateWrongX()
    {
        Plane p=new Plane();
        try
        {
            p.accelerate(16,0);
            fail("El valor de xSpeed es incorrecto");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Velocidad de coordenada fuera de rango", e.getMessage());
        }
    }
    
     /**
     * Pruebas del método accelerate()
     * Caso N3: Los valores de ySpeed y de xSpeed no son correctos.
     */
    @Test
    public void accelerateWrongXandY()
    {
        Plane p=new Plane();
        try
        {
            p.accelerate(16,16);
            fail("El valor de xSpeed es incorrecto");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Velocidad de coordenada fuera de rango", e.getMessage());
        }
    }
  
    /**
     * Pruebas del método fly()
     * Caso P1: Fuel 0
     */
    @Test
    public void flyfuel0()
    {
        Plane p=new Plane();
        assertEquals(false, p.fly());
    }
    
    /**
     * Pruebas del método fly()
     * Caso P2: Fuel >0 y con xPos y yPos >0 y <Máximos
     */
    @Test
    public void flyP2()
    {
        Plane p=new Plane(null,'A',30,1,2,1,1);
        
        assertTrue(p.fly());
        assertEquals(2,p.getXPos());
        assertEquals(3,p.getYPos());
    }
    
     /**
     * Pruebas del método fly()
     * Caso P3: Fuel >0 y con xPos=0
     */
    @Test
    public void flyP3()
    {
        Plane p=new Plane(null,'A',30,0,Plane.MAX_Y-1,-1,1);
        
        assertTrue(p.fly());
        assertEquals(0,p.getXPos());
        assertEquals(p.MAX_Y,p.getYPos());
    }
    
    /**
     * Pruebas del método fly()
     * Caso P4: Fuel >0 y con yPos=0
     */
    @Test
    public void flyP4()
    {
        Plane p=new Plane(null,'A',30,Plane.MAX_X-1,0,1,1);
        
        assertTrue(p.fly());
        assertEquals(Plane.MAX_X,p.getXPos());
        assertEquals(0,p.getYPos());
    }
    
    /**
     * Pruebas del método fly()
     * Caso P5: Fuel >0 y con yPos=MAX_Y
     */
    @Test
    public void flyP5()
    {
        Plane p=new Plane(null,'A',30,Plane.MAX_X-1,Plane.MAX_Y,1,1);
        
        assertTrue(p.fly());
        assertEquals(p.MAX_X,p.getXPos());
        assertEquals(p.MAX_Y,p.getYPos());
    }
    
    /**
     * Pruebas del método fly()
     * Caso P6: Fuel >0 y con xPos=MAX_X
     */
    @Test
    public void flyP6()
    {
        Plane p=new Plane(null,'A',30,Plane.MAX_X,Plane.MAX_Y-1,1,1);
        
        assertTrue(p.fly());
        assertEquals(p.MAX_X,p.getXPos());
        assertEquals(p.MAX_Y,p.getYPos());
    }
    
    /**
     * Pruebas del método toString()
     * Caso P1: pilot=null
     */
    @Test
    public void toStringWithoutPilot()
    {
        Plane p=new Plane(null);
        
        assertEquals(p.getIdentifier() + "-" + p.getFuel() + "-" + "NOT PILOT" + "-" + p.getXPos() + "-" + p.getYPos() + "-" + p.getXSpeed() + "-" + p.getYSpeed(),p.toString());
    }
    
     /**
     * Pruebas del método toString()
     * Caso P1: pilot=null
     */
    @Test
    public void toStringWithPilot()
    {
        Person pilot=new Person();
        Plane pl=new Plane(pilot);
    
        assertEquals(pl.getIdentifier() + "-" + pl.getFuel() + "-" + pl.getPilot().getAge() + "-" + pl.getPilot().getHashCode() +  "-" + pl.getXPos() + "-" + pl.getYPos() + "-" + pl.getXSpeed() + "-" + pl.getYSpeed(), pl.toString());
    }
}
