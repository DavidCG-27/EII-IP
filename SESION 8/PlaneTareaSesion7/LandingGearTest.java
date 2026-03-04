

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LandingGearTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LandingGearTest
{
    /**
     * Pruebas del constructor por defecto
     * Caso único:
     */
    @Test
    public void constWithoutParams()
    {
        LandingGear lg=new LandingGear();
        
        assertFalse(lg.getLever());
        
        assertNotNull(lg.getNose());
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getNose().isDeployed());
        
        assertNotNull(lg.getRight());
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getRight().isDeployed());
        
        assertNotNull(lg.getLeft());
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getLeft().isDeployed());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 1: Todo correcto. Puntales desplegados
     */
    @Test
    public void constWithParamsOK()
    {
        WheelStrut nose=new WheelStrut();
        WheelStrut left=new WheelStrut();
        WheelStrut right=new WheelStrut();
        
        LandingGear lg=new LandingGear(left,right,nose);
                
        assertFalse(lg.getLever());
        
        assertNotNull(lg.getNose());
        assertEquals(nose,lg.getNose()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getNose().isDeployed());
        
        assertNotNull(lg.getRight());
        assertEquals(right,lg.getRight()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getRight().isDeployed());
        
        assertNotNull(lg.getLeft());
        assertEquals(left,lg.getLeft()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getLeft().isDeployed());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 2: Todo correcto. Puntales replegados
     */
    @Test
    public void constPuntalesRepleg()
    {
        WheelStrut nose=new WheelStrut();
        WheelStrut left=new WheelStrut();
        WheelStrut right=new WheelStrut();
        nose.retract();left.retract();right.retract();
        
        LandingGear lg=new LandingGear(left,right,nose);
                
        assertFalse(lg.getLever());
        
        assertNotNull(lg.getNose());
        assertEquals(nose,lg.getNose()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getNose().isDeployed());
        
        assertNotNull(lg.getRight());
        assertEquals(right,lg.getRight()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getRight().isDeployed());
        
        assertNotNull(lg.getLeft());
        assertEquals(left,lg.getLeft()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getLeft().isDeployed());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 3: Todo correcto. Nose replegado
     */
    @Test
    public void constNoseRepleg()
    {
        WheelStrut nose=new WheelStrut();
        WheelStrut left=new WheelStrut();
        WheelStrut right=new WheelStrut();
        nose.retract();
        
        LandingGear lg=new LandingGear(left,right,nose);
                
        assertFalse(lg.getLever());
        
        assertNotNull(lg.getNose());
        assertEquals(nose,lg.getNose()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getNose().isDeployed());
        
        assertNotNull(lg.getRight());
        assertEquals(right,lg.getRight()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getRight().isDeployed());
        
        assertNotNull(lg.getLeft());
        assertEquals(left,lg.getLeft()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getLeft().isDeployed());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 4: Todo correcto. Left replegado
     */
    @Test
    public void constLeftRepleg()
    {
        WheelStrut nose=new WheelStrut();
        WheelStrut left=new WheelStrut();
        WheelStrut right=new WheelStrut();
        left.retract();
        
        LandingGear lg=new LandingGear(left,right,nose);
                
        assertFalse(lg.getLever());
        
        assertNotNull(lg.getNose());
        assertEquals(nose,lg.getNose()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getNose().isDeployed());
        
        assertNotNull(lg.getRight());
        assertEquals(right,lg.getRight()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getRight().isDeployed());
        
        assertNotNull(lg.getLeft());
        assertEquals(left,lg.getLeft()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getLeft().isDeployed());
    }
    
     /**
     * Pruebas del constructor con parámetros
     * Caso 5: Todo correcto. Right replegado
     */
    @Test
    public void constRightRepleg()
    {
        WheelStrut nose=new WheelStrut();
        WheelStrut left=new WheelStrut();
        WheelStrut right=new WheelStrut();
        right.retract();
        
        LandingGear lg=new LandingGear(left,right,nose);
                
        assertFalse(lg.getLever());
        
        assertNotNull(lg.getNose());
        assertEquals(nose,lg.getNose()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getNose().isDeployed());
        
        assertNotNull(lg.getRight());
        assertEquals(right,lg.getRight()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getRight().isDeployed());
        
        assertNotNull(lg.getLeft());
        assertEquals(left,lg.getLeft()); 
        assertEquals(WheelStrut.IS_DEPLOYED ,lg.getLeft().isDeployed());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 6: Un puntal null
     */
    @Test
    public void constLeftNull()
    {
        WheelStrut nose=new WheelStrut();
        WheelStrut right=new WheelStrut();
        WheelStrut left=null;
        try
        {
        LandingGear lg=new LandingGear(left,right,nose);
        fail("No debería de haberse creado el tren de aterrizaje");
        }   
        catch(Exception e)
        {
            assertEquals("Esperaba puntal izquierdo en lugar de null", e.getMessage());
        }
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 7: Un puntal null
     */
    @Test
    public void constNoseNull()
    {
        WheelStrut left=new WheelStrut();
        WheelStrut right=new WheelStrut();
        WheelStrut nose=null;
        try
        {
        LandingGear lg=new LandingGear(left,right,nose);
        fail("No debería de haberse creado el tren de aterrizaje");
        }   
        catch(Exception e)
        {
            assertEquals("Esperaba puntal derecho en lugar de null", e.getMessage());
        }
    }
    
    /**
     * Pruebas del constructor con parámetros
     * Caso 7: Un puntal null
     */
    @Test
    public void constRightNull()
    {
        WheelStrut left=new WheelStrut();
        WheelStrut nose=new WheelStrut();
        WheelStrut right=null;
        try
        {
        LandingGear lg=new LandingGear(left,right,nose);
        fail("No debería de haberse creado el tren de aterrizaje");
        }   
        catch(Exception e)
        {
            assertEquals("Esperaba puntal derecho en lugar de null", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método moveLever()
     * Caso 1: Palanca abajo; movemos arriba
     */
    @Test
    public void moveLeverFromDownToUp()
    {
        LandingGear lg=new LandingGear();
        lg.moveLever(LandingGear.LEVER_UP);
        assertEquals(lg.getLever(), lg.LEVER_UP);
        assertFalse(lg.getNose().isDeployed());
        assertFalse(lg.getLeft().isDeployed());
        assertFalse(lg.getRight().isDeployed());
        
    }
    
    /**
     * Pruebas del método moveLever()
     * Caso 2: Palanca abajo; movemos abajo
     */
    @Test
    public void moveLeverFromDownToDown()
    {
        LandingGear lg=new LandingGear();
        lg.moveLever(LandingGear.LEVER_DOWN);
        
        assertEquals(lg.getLever(), lg.LEVER_DOWN);
        assertTrue(lg.getNose().isDeployed());
        assertTrue(lg.getLeft().isDeployed());
        assertTrue(lg.getRight().isDeployed());
        
    }
    
    /**
     * Pruebas del método moveLever()
     * Caso 3: Palanca arriba; movemos abajo
     */
     @Test
    public void moveLeverFromUpToDown()
    {
        //Preparo el caso
        LandingGear lg=new LandingGear();
        lg.moveLever(LandingGear.LEVER_UP);
        //Caso Preparado. Paso a realizar la acción a comprobar
        lg.moveLever(LandingGear.LEVER_DOWN);
        
        assertEquals(lg.getLever(), lg.LEVER_DOWN);
        assertTrue(lg.getNose().isDeployed());
        assertTrue(lg.getLeft().isDeployed());
        assertTrue(lg.getRight().isDeployed());
        
    }
    
    /**
     * Pruebas del método moveLever()
     * Caso 3: Palanca arriba; movemos arriba
     */
     @Test
    public void moveLeverFromUpToUp()
    {
        //Preparo el caso
        LandingGear lg=new LandingGear();
        lg.moveLever(LandingGear.LEVER_UP);
        //Caso Preparado. Paso a realizar la acción a comprobar
        lg.moveLever(LandingGear.LEVER_UP);
        
       assertEquals(lg.getLever(), lg.LEVER_UP); 
       assertFalse(lg.getNose().isDeployed());
       assertFalse(lg.getLeft().isDeployed());
       assertFalse(lg.getRight().isDeployed());
        
    }
    
    /**
     * Test del test
     * Caso único. Los puntales SIEMPRE se crean buenos (ya no es único por culpa del método changePressure() de la clase Wheel)
     */
    @Test
    public void testUniqCase()
    {
        LandingGear lg=new LandingGear(); 
        //el tren de aterrizaje siempre va a ser correcto
        assertTrue(lg.test());
    }
    
    /**
     * Test del test
     * Caso 2: Puntal IZQD. Mal (rueda izqd del puntal izqd desinflada)
     */
    @Test
    public void testLeftStrutFalse1()
    {
        LandingGear lg=new LandingGear(); 
        
        lg.getLeft().getLeftWheel().changePressure(0); //Desinflo la rueda izqd del puntal izqd
        
        assertFalse(lg.test());
    }
    
    /**
     * Test del test
     * Caso 3: Puntal IZQD. Mal (rueda dcha del puntal izqd desinflada)
     */
    @Test
    public void testLeftStrutFalse2()
    {
        LandingGear lg=new LandingGear(); 
        
        lg.getLeft().getRightWheel().changePressure(0); //Desinflo la rueda izqd del puntal izqd
        
        assertFalse(lg.test());
    }
    
    /**
     * Test del test
     * Caso 4: Puntal dcho. Mal (rueda IZQDA del puntal dcho desinflada)
     */
    @Test
    public void testRightStrutFalse1()
    {
        LandingGear lg=new LandingGear(); 
        
        lg.getRight().getLeftWheel().changePressure(0);
        
        assertFalse(lg.test());
    }
    
    /**
     * Test del test
     * Caso 4: Puntal dcho. Mal (rueda dcha del puntal dcho desinflada)
     */
    @Test
    public void testRightStrutFalse2()
    {
        LandingGear lg=new LandingGear(); 
        
        lg.getRight().getRightWheel().changePressure(0);
        
        assertFalse(lg.test());
    }
    
     /**
     * Test del test
     * Caso 3: Puntal del morro mal (rueda DCHA del puntal del morro desinflada)
     */
    @Test
    public void testNoseStrutFalse1()
    {
        LandingGear lg=new LandingGear(); 
        
        lg.getNose().getRightWheel().changePressure(0);
        
        assertFalse(lg.test());
    }
    
    /**
     * Test del test
     * Caso 3: Puntal del morro mal (rueda izqd del puntal del morro desinflada)
     */
    @Test
    public void testNoseStrutFalse2()
    {
        LandingGear lg=new LandingGear(); 
        
        lg.getNose().getLeftWheel().changePressure(0);
        
        assertFalse(lg.test());
    }
}
