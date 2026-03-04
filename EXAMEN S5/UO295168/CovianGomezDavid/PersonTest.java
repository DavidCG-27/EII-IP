

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
    
    /**
     * Pruebas del constructor sin parámetros (o constructor por defecto)
     * Caso 1: Caso único
     */
    @Test
    public void constructorUniqCase() {
        Person p=new Person();
        assertEquals(p.DEFAULT_NAME, p.getName());
        assertEquals(p.DEFAULT_AGE, p.getAge());
        assertEquals(p.DEFAULT_SURNAME, p.getSurname());
        assertEquals(p.DEFAULT_GENDER, p.getGender());
    
    }
    
        //Las pruebas del setAge son en realidad las pruebas del parámetro
    /**
     * Pruebas del setAge
     * Caso 1: Edad recibida dentro de los límites.
     */
    @Test
    public void setAgeBetweenLimits() {
        Person p=new Person(55);
    
        //p.setAge(55);
        assertEquals(55, p.getAge());
        
        
    }
    
    /**
     * Pruebas del setAge
     * Caso 2: Edad por debajo del límite inferior
     */
    @Test
    public void setAgeBelowLowerLimits() {
        try{
            Person p=new Person(Person.MIN_AGE - 1);
            //p.setAge(-1);
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
        
        try{
            Person p=new Person(Person.MAX_AGE + 1);
            //p.setAge(123);
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
        Person p=new Person(0);
        
        //p.setAge(0);
        assertEquals(0, p.getAge());
        
        
    }
    
    /**
     * Pruebas del setAge
     * Caso 5: Edad en el límite superior
     */
    @Test
    public void setAgeSuperiorLimit() {
        
        try{
            Person p=new Person(Person.MAX_AGE);
            //p.setAge(120);
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
         Person p=new Person(Person.ADULTHOOD_AGE - 1);
         //p.setAge(Person.ADULTHOOD_AGE - 1);
         assertEquals(Person.ADULTHOOD_AGE - p.getAge(), p.getCriticalAge());
    }
    
    /**
     * Pruebas del getCriticalAge()
     * Caso 2: Edad recibida de 18.
     */
    @Test
    public void getCriticalAgeAdulthood() {
         Person p=new Person(Person.ADULTHOOD_AGE);
         //p.setAge(Person.ADULTHOOD_AGE);
         assertEquals(Person.RETIREMENT_AGE - p.getAge(), p.getCriticalAge());
    }
    

    /**
     * Pruebas del getCriticalAge()
     * Caso 3: Edad recibida mayor que 65.
     */
    @Test
    public void getCriticalAgeAfterRetirement() {
         Person p=new Person(Person.RETIREMENT_AGE + 1);
         //p.setAge(Person.RETIREMENT_AGE + 1);
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
        //assertEquals(p.getAge() + "-" + p.getName().substring(0, 2).toUpperCase() + "-" + p.getSurnameShort().toUpperCase() + "-" + p.getTypeAge(), p.getHashCode());
        assertEquals(p.getAge() + "-" + p.getName().toUpperCase() + "-" + p.getName().length() + "-" + p.getSurname().toUpperCase() + "-" + p.getSurname().length(), p.getHashCode());
    }
    
    //# Deberías incluir un comentario para separar los tests de cada método
    //# Estamos usando el convenio de llamar a los tests con el mismo nombre del método 
    //# a probar más el caso concreto (como lo has hecho, pero sin el test delante
    //# Además, no sigues el convenio de nombrado de java (sería testGet...), 
    /**
     * Pruebas del getDiscount()
     * Caso 1: Edad adulta.
     */
    
    @Test
    public void getDiscountAdult(){
        Person p=new Person(Person.ADULTHOOD_AGE);
        assertEquals(0, p.getDiscount());
    }
    
    /**
     * Pruebas del getDiscount()
     * Caso 2: Edad de jubilación.
     */
    @Test
    public void getDiscountRetirementAge(){
        Person p=new Person(Person.RETIREMENT_AGE);
        assertEquals(10, p.getDiscount());
    }
    
    /**
     * Pruebas del getDiscount()
     * Caso 3: Edad igual o menor a 12 años.
     */
    
    @Test
    public void getDiscountTwelveYears(){
        Person p=new Person(12);
        assertEquals(15, p.getDiscount());
    }
    
    /**
     * Pruebas del getDiscount()
     * Caso 4: Edad distinta a los casos anteriores.
     */
    
    @Test
    public void getDiscountOtherYears(){
        Person p=new Person(16);
        assertEquals(5, p.getDiscount());
    }
    
    /**
     * Pruebas método canBePilot()
     * Caso P1: Mujer mayor de edad y no jubilada
     */
    @Test
    public void canBePilotWomanCorrect(){
        Person p=new Person(Person.DEFAULT_NAME, Person.DEFAULT_SURNAME, 20, Person.GENDER_FEMALE);
        assertEquals(true, p.canBePilot());
    }
    
    /**
     * Pruebas método canBePilot()
     * Caso P2: Hombre entre los 30 y los 50 años.
     */
    @Test
    public void canBePilotMenCorrect(){
        Person p=new Person(Person.DEFAULT_NAME, Person.DEFAULT_SURNAME, 40, Person.GENDER_MALE);
        assertEquals(true, p.canBePilot());
    }
    
    /**
     * Pruebas método canBePilot()
     * Caso N1: Mujer menor de edad.
     */
    @Test
    public void canBePilotWomenTeen(){
        Person p=new Person(Person.DEFAULT_NAME, Person.DEFAULT_SURNAME, 16, Person.GENDER_FEMALE);
        assertEquals(false, p.canBePilot());
    }
    
    /**
     * Pruebas método canBePilot()
     * Caso N2: Mujer jubilada.
     */
    @Test
    public void canBePilotWomenOld(){
        Person p=new Person(Person.DEFAULT_NAME, Person.DEFAULT_SURNAME, 89, Person.GENDER_FEMALE);
        assertEquals(false, p.canBePilot());
    }
    
    /**
     * Pruebas método canBePilot()
     * Caso N3: Hombre menor que 30.
     */
    @Test
    public void canBePilotMenYoung(){
        Person p=new Person(Person.DEFAULT_NAME, Person.DEFAULT_SURNAME, Person.MIN_MEN_AGE-1, Person.GENDER_MALE);
        assertEquals(false, p.canBePilot());
    }
    
    /**
     * Pruebas método canBePilot()
     * Caso N4: Hombre mayor que 50.
     */
    @Test
    public void canBePilotMenOld(){
        Person p=new Person(Person.DEFAULT_NAME, Person.DEFAULT_SURNAME, Person.MAX_MEN_AGE+1, Person.GENDER_MALE);
        assertEquals(false, p.canBePilot());
    }

}

