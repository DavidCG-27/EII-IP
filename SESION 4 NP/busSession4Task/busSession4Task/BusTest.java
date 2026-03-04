

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BusTest.
 *
 * @author  ip-profes
 * @version 10-10-22
 */
public class BusTest {
 /**
 * Prueba del constructor por defecto
 * 
 */
@Test
public void testConstructorWithoutParameters()
{
    Bus bus1 = new Bus();
    
    assertEquals(Bus.DEFAULT_DRIVER_PRESENT, bus1.isDriverPresent());
    assertEquals(Bus.DEFAULT_AVAILABLE_SEATS, bus1.getAvailableSeats());
}

/**
 *  Pruebas constructor con parametro driverPresent
 *  
 *  1- conductor presente
 *  2- conductor no presente
 */
/**
 * Prueba del constructor CON parametro driverPresent
 *   1- conductor presente
 */
@Test
public void constructorWithParameterDriverPresent()
{
    boolean driver = Bus.IS_DRIVER_PRESENT;
    
    Bus bus1 = new Bus(driver);
     
    assertEquals(Bus.IS_DRIVER_PRESENT, bus1.isDriverPresent());
    assertEquals(Bus.DEFAULT_AVAILABLE_SEATS, bus1.getAvailableSeats());
}

/**
 * Prueba del constructor CON parametro driverPresent
 *   2- Conductor no presente
 */
@Test
public void constructorWithParameterNoDriverPresent()
{   
    boolean driver = ! Bus.IS_DRIVER_PRESENT;
    Bus bus1 = new Bus(driver);
     
    assertEquals(!Bus.IS_DRIVER_PRESENT, bus1.isDriverPresent());
    assertEquals(Bus.DEFAULT_AVAILABLE_SEATS, bus1.getAvailableSeats());
}


/*
 * Pruebas constructor asientos disponibles
 * 1- asientos dentro de límites permitidos (60)
 * 2- Por debajo de límite inferior (10)
 * 3- Por encima de límite superior
 * 4- En límite inferior 
 * 5- En límite superior 
 * 
 */
/**
 * Prueba del constructor CON parametro availableSeats
 *   1- asientos dentro de límites permitidos 
 */
@Test
public void testConstructorWithParameterAvailableSeats() {
    int seats = Bus.MAX_SEATS -1;   // caso 1
    Bus bus1 = new Bus(seats);
     
    assertEquals(Bus.DEFAULT_DRIVER_PRESENT, bus1.isDriverPresent());
    assertEquals(seats, bus1.getAvailableSeats());
}

/**
 * Prueba del constructor CON parametros
 *     2- Por debajo de límite inferior
 */
@Test
public void constructorBellowLowerLimitSeats() {
    int seats = Bus.MIN_SEATS -1;   // caso 2
    try{
        Bus bus1 = new Bus(seats);  
        fail("Debería haber saltado excepción");
    } catch (IllegalArgumentException e) {
        assertEquals("Asientos fuera de límites", e.getMessage());
    }   
}

/**
 * Prueba del constructor CON parametros
 *     3- Por encima de límite superior
 */
@Test
public void constructorAboveUpperLimitSeats() {
    int seats = Bus.MAX_SEATS + 1;   // caso 3
    try{
        Bus bus1 = new Bus(seats);  
        fail("Debería haber saltado excepción");
    } catch (IllegalArgumentException e) {
        assertEquals("Asientos fuera de límites", e.getMessage());
    }   
}

/**
 * Prueba del constructor CON parametros
 *     4- En límite inferior
 */
@Test
public void constructorInLowerLimitSeats()
{
    int seats = Bus.MIN_SEATS ;   // caso 4
    Bus bus1 = new Bus(seats);
     
    assertEquals(Bus.DEFAULT_DRIVER_PRESENT, bus1.isDriverPresent());
    assertEquals(seats, bus1.getAvailableSeats());  
}

/**
 * Prueba del constructor CON parametros
 *     5- En límite superior
 */
@Test
public void constructorInUpperLimitSeats()
{
    int seats = Bus.MAX_SEATS;   // caso 5
    Bus bus1 = new Bus(seats);
     
    assertEquals(Bus.DEFAULT_DRIVER_PRESENT, bus1.isDriverPresent());
    assertEquals(seats, bus1.getAvailableSeats());  
}
  
 

/*
 * Pruebas de sitDriver
 * Caso 1 no hay conductor llamo al sitDriver- > debe quedar presente
 * Caso 2 hay conductor, llamo al sitDriver-> debe quedar presente
 */
/**
 * Prueba el método sitDriver
 * Caso 1 no hay conductor llamo al sitDriver- > debe quedar presente
 */
@Test
public void sitDriverWithoutDriver()
{
    boolean driver = !Bus.IS_DRIVER_PRESENT;    // no hay conductor
    Bus bus1 = new Bus(driver, Bus.MAX_SEATS - 1);
    
    bus1.sitDriver();
    
    assertEquals(Bus.IS_DRIVER_PRESENT,bus1.isDriverPresent());
}
  
/**
 * Prueba el método sitDriver
 * // caso 2 creo bus con conductor
 */
@Test
public void sitWithDriver()
{  
    boolean driver = Bus.IS_DRIVER_PRESENT;    // si hay conductor
    Bus bus1 = new Bus(driver, Bus.MAX_SEATS - 1);
    
    bus1.sitDriver();
    
    assertEquals(Bus.IS_DRIVER_PRESENT,bus1.isDriverPresent());
}


/**
 * Prueba del método getOn
 * // caso 1 conductor presente y pasajerso tienen asientos disponibles -> true y cambia disponibles
 * // caso 2 conductor no presente y pasajeros tienen asientos disponibles -> false
 * // caso 3 conductor presentes pero no hay suficentes asientos disponibles -> false
 * 
 * // cas 4 número de pasajeros negativo - > salta excepción
 * 
 */

/**
 *  // caso 1 conductor presente y pasajerso tienen asientos disponibles -> true y cambia disponibles
 */
 @Test
 public void getOnPassengersOkDriverPresentAvailableSeats()
 {
     Bus bus1 = new Bus(Bus.IS_DRIVER_PRESENT,20);   // situación inicial hay 20 asientos disponibles y conductor
    
     assertEquals(true,bus1.getOn(5));              // suben 5
     
     assertEquals(15,bus1.getAvailableSeats());
 }

/**
 * Prueba del método getOn
 * // caso 2 no hay conductor pero si asientos
 */
 @Test
 public void getOnPassengersOkNoDriver()
 { 
     Bus bus1 = new Bus(!Bus.IS_DRIVER_PRESENT,20);     // no hay conductor y si asientos disponibles 20
     
     assertEquals(false,bus1.getOn(5));                 // getOn devuelve false
     
     assertEquals(20,bus1.getAvailableSeats());         // no se ha ocupado ninguno
 }
 
 
 /**
 * Prueba del método getOn
 *   // caso 3 si conductor pero desean subir más de los asientos libres
 */
 @Test
 public void getOnPassengersFailNoDriver()
 { 
     Bus bus1 = new Bus(Bus.IS_DRIVER_PRESENT,20);
     
     assertEquals(false,bus1.getOn(40));        // se suben más de los disponibles
     
     assertEquals(20,bus1.getAvailableSeats());     
    }
    
    /**
 * Prueba del método getOn
 *   // caso 4 si conductor pero desean subir negativos
 */
 @Test
 public void getOnPassengersNegativeNoDriver()
 { 
     Bus bus1 = new Bus(Bus.IS_DRIVER_PRESENT,20);
     try {
         bus1.getOn(-10);
         fail("Esperaba fallo por fuera de límite");
    } catch (IllegalArgumentException e) {
        assertEquals("Pasajeros no pueden ser negativos", e.getMessage());        
    } 
     
     
 }
 
 /*
  * Pruebas de toString
  * ON DUTY-20  si hay conductor y 20 asientos disponibles
  * OUT OF SERVICE-20  si no hay conductor y 20 asientos disponibles
  */
 /**
 * Prueba del método toString
 * // caso 1 el conductor está presente
 */
 @Test
 public void toStringDriver()
    {
         Bus bus1 = new Bus(Bus.IS_DRIVER_PRESENT,20);
         assertEquals("ON DUTY-20",bus1.toString());
    }
    
 /**
 * Prueba del método toString
 * // CASO 2 el conductor no estÃ¡ presente
 */
 @Test
 public void toStringNoDriver()
 {        
       
         Bus bus1 = new Bus(!Bus.IS_DRIVER_PRESENT,20);
         assertEquals("OUT OF SERVICE-20",bus1.toString());
         
  }
}
