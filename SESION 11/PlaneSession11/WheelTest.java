

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class WheelTest.
 *
 * @author  David Covián Gómez
 * @version 21/10/2022
 */
public class WheelTest
{
    /**
     * Default constructor for test class WheelTest
     */
    public WheelTest()
    {
    }
    
    /**
     * Pruebas del constructor sin parámetros
     * Caso Único:
     */
     @Test
     public void constWithoutParams()
     {
         Wheel w=new Wheel();
         
         assertEquals(w.STANDARD_MAX_PRESSURE, w.getMaxPressure());
         assertEquals(w.STANDARD_PRESSURE, w.getPressure());
         
     }
     
    /**
     * Pruebas del constructor con parámetros
     * Caso P1: Presión máxima >0, Presión >0 y < Presión Máxima
     */
     @Test
     public void constWithParams()
     {
    
         Wheel w=new Wheel(Wheel.STANDARD_PRESSURE, Wheel.STANDARD_MAX_PRESSURE);
         
         assertEquals(w.STANDARD_PRESSURE, w.getPressure());
         assertEquals(w.STANDARD_MAX_PRESSURE, w.getMaxPressure());
     }
     
    /**
     * Pruebas del constructor con parámetros
     * Caso P2: Presión igual a 0.
     */
     @Test
     public void constWithParamPressureEqual0()
     {
         Wheel w=new Wheel(0, Wheel.STANDARD_MAX_PRESSURE);
         
         assertEquals(w.STANDARD_MAX_PRESSURE, w.getMaxPressure());
         assertEquals(0, w.getPressure());
           
     }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso P3: Presión igual a presión máxima.
     */
     @Test
     public void constWithParamPressureEqualMaxPressure()
     {
         Wheel w=new Wheel(Wheel.STANDARD_MAX_PRESSURE, Wheel.STANDARD_MAX_PRESSURE);
         
         assertEquals(w.STANDARD_MAX_PRESSURE, w.getMaxPressure(),0.001);
         assertEquals(w.STANDARD_MAX_PRESSURE, w.getPressure(),0.001);
           
     }
     
    /**
     * Pruebas del constructor con parámetros
     * Caso P4: Presión igual a presión máxima igual a 0.
     */
     @Test
     public void constWithParamPressureEqualMaxPressureEqual0()
     {
         Wheel w=new Wheel(0,0);
         
         assertEquals(0, w.getMaxPressure());
         assertEquals(0, w.getPressure());
           
     }
     
    /**
     * Pruebas del constructor con parámetros
     * Caso N1: Presión superior a presión máxima.
     */
     @Test
     public void constWithParamPressureAboveLimits()
     {
         try
         {
             Wheel w=new Wheel(Wheel.STANDARD_MAX_PRESSURE+1, Wheel.STANDARD_MAX_PRESSURE);
             fail("Valor inválido");           
         }
         catch(IllegalArgumentException e)
         {
            assertEquals("Valor inválido", e.getMessage());
         }
     }
     
    /**
     * Pruebas del constructor con parámetros
     * Caso N2: Presión negativa.
     */
     @Test
     public void constWithParamPressureNegative()
     {
         try
         {
             Wheel w=new Wheel(-1, Wheel.STANDARD_MAX_PRESSURE);
             fail("Valor inválido");           
         }
         catch(IllegalArgumentException e)
         {
            assertEquals("Valor inválido", e.getMessage());
         }
     }
     
    /**
     * Pruebas del constructor con parámetros
     * Caso N3: Presión máxima negativa.
     */
     @Test
     public void constWithParamMaxPressureNegative()
     {
         try
         {
             Wheel w=new Wheel(Wheel.STANDARD_PRESSURE,-1);
             fail("Valor inválido");           
         }
         catch(IllegalArgumentException e)
         {
            assertEquals("Valor inválido", e.getMessage());
         }
     }
     
    /**
     *  Pruebas del método test()
     *  Caso 1: Presión > Presión mínima (PM*Umbral)->Debe ser true
     */
    @Test
    public void testCaso1()
    {
        Wheel w=new Wheel(Wheel.STANDARD_PRESSURE,Wheel.STANDARD_MAX_PRESSURE);
        w.test();
        assertTrue(w.test());
    }
    
    /**
     *  Pruebas del método test()
     *  Caso 2: Presión = Presión mínima (PM*Umbral)->Debe ser true
     */
    @Test
    public void testCaso2()
    {
        Wheel w=new Wheel(Wheel.STANDARD_MAX_PRESSURE*Wheel.THRESHOLD/100.0,Wheel.STANDARD_MAX_PRESSURE);
        w.test();
        assertTrue(w.test());
    }
    
    /**
     *  Pruebas del método test()
     *  Caso 2: Presión < Presión mínima (PM*Umbral)->Debe ser false
     */
    @Test
    public void testCaso3()
    {
        Wheel w=new Wheel((Wheel.STANDARD_MAX_PRESSURE*Wheel.THRESHOLD/100.0)-0.1,Wheel.STANDARD_MAX_PRESSURE);
        w.test();
        assertFalse(w.test());
    }
    
    /**
     * Pruebas del método getPercentage()
     * Caso 1:
     */
    @Test
    public void getPercentage()
    {
        Wheel w=new Wheel(Wheel.STANDARD_PRESSURE, Wheel.STANDARD_MAX_PRESSURE);
        
        assertEquals(w.getPressure()/w.getMaxPressure()*100, w.getPercentage());
    
    }
    
    /**
     * Pruebas del método getPressure()
     * Caso 1:
     */
    @Test
    public void getPressure()
    {
        Wheel w=new Wheel(Wheel.STANDARD_PRESSURE, Wheel.STANDARD_MAX_PRESSURE);
        
        assertEquals(Wheel.STANDARD_PRESSURE, w.getPressure());
    
    }
    
    /**
     * Pruebas del método getMaxPressure()
     * Caso 1:
     */
    @Test
    public void getMaxPressure()
    {
        Wheel w=new Wheel(Wheel.STANDARD_PRESSURE, Wheel.STANDARD_MAX_PRESSURE);
        
        assertEquals(Wheel.STANDARD_MAX_PRESSURE, w.getMaxPressure());
    
    }
    
    /**
     * Pruebas del método toString()
     * Caso 1: Con test Correcto
     */
    @Test
    public void toStringCorrecto()
    {
        Wheel w=new Wheel();
        assertEquals("MaxP: 1000,0 Mb - Pressure: 900,0 Mb - Percentage: 90,00 - Test: true", w.toString());
    }
    
    /**
     * Pruebas del método toString()
     * Caso 2: Con test incorrecto
     */
    @Test
    public void toStringIncorrecto()
    {
        Wheel w=new Wheel(0, Wheel.STANDARD_MAX_PRESSURE);
        assertEquals("MaxP: 1000,0 Mb - Pressure: 0,0 Mb - Percentage: 0,00 - Test: false",w.toString());
    }
}
