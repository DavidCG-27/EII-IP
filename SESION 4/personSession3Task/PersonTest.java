

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Prueba para la clase Person
 *
 * @author David Covián Gómez
 * @version 30/09/2022
 */
public class PersonTest
{
    /**
     * Default constructor for test class PersonTest
     */
    public PersonTest()
    {
    }
    
    public final static int ADULTHOOD_AGE = 18;
    public final static int RETIREMENT_AGE = 65;
    
    /**
     * Pruebas del setAge
     * Caso 1: Edad recibida dentro de los límites.
     */
    @Test
    public void setAgeBetweenLimits() {
        Person p=new Person();
        
        p.setAge(55);
        assertEquals(55, p.getAge());
        
        
    }
    
    /**
     * Pruebas del setAge
     * Caso 2: Edad por debajo del límite inferior
     */
    @Test
    public void setAgeBelowLowerLimits() {
        Person p=new Person();
        try{
            p.setAge(-1);
            fail("Debería de haber fallado, dado que la edad es incorrecta");
        }
        catch (RuntimeException e){
            assertEquals("La edad debe ser >=0 y <120", e.getMessage());
        }
    }
    
     /**
     * Pruebas del setAge
     * Caso 3: Edad por encima del límite superior
     */
    @Test
    public void setAgeBelowHigherLimits() {
        Person p=new Person();
        try{
            p.setAge(123);
            fail("Debería de haber fallado, dado que la edad es incorrecta");
        }
        catch (RuntimeException e){
            assertEquals("La edad debe ser >=0 y <120", e.getMessage());
        }
    }
    
    /**
     * Pruebas del setAge
     * Caso 4: Edad en el límite inferior
     */
    @Test
    public void setAgeInferiorLimit() {
        Person p=new Person();
        
        p.setAge(0);
        assertEquals(0, p.getAge());
        
        
    }
    
    /**
     * Pruebas del setAge
     * Caso 5: Edad en el límite superior
     */
    @Test
    public void setAgeSuperiorLimit() {
        Person p=new Person();
        try{
            p.setAge(120);
            fail("Debería de haber fallado, dado que la edad es incorrecta");
        }
        catch (RuntimeException e){
            assertEquals("La edad debe ser >=0 y <120", e.getMessage());
        }
    }
       
    
    /**
     * Pruebas del getCriticalAge()
     * Caso 1: Edad recibida menor que 18.
     */
    @Test
    public void getCriticalAgeBeforeAdulthood() {
         Person p=new Person();
         p.setAge(Person.ADULTHOOD_AGE - 1);
         assertEquals(Person.ADULTHOOD_AGE - p.getAge(), p.getCriticalAge());
    }
    
    /**
     * Pruebas del getCriticalAge()
     * Caso 2: Edad recibida de 18.
     */
    @Test
    public void getCriticalAgeAdulthood() {
         Person p=new Person();
         p.setAge(Person.ADULTHOOD_AGE);
         assertEquals(Person.RETIREMENT_AGE - p.getAge(), p.getCriticalAge());
    }
    

    /**
     * Pruebas del getCriticalAge()
     * Caso 3: Edad recibida mayor que 65.
     */
    @Test
    public void getCriticalAgeAfterRetirement() {
         Person p=new Person();
         p.setAge(Person.RETIREMENT_AGE + 1);
         assertEquals(p.getAge() - Person.RETIREMENT_AGE, -p.getCriticalAge());
    }
    
    /**
     * Pruebas del getHashCode()
     * Caso 1: Edad recibida mayor que 65.
     */
    @Test
    public void getHashCode(){
        Person p=new Person();
        p.getHashCode();
        assertEquals("42-CARLOS-6-SAINZ-5", p.getHashCode());
    }
}
