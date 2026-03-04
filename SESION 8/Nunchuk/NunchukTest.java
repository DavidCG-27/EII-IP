
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class NunchukTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NunchukTest
{
    /**
     * Default constructor for test class NunchukTest
     */
    public NunchukTest()
    {
    }
    
    /**
     * Pruebas del método advance()
     * Caso 1: left
     */
    public void advanceLeft()
    {
        Figure f = new Figure("Monstruo",10,10);
        Weapon w=new Weapon(); 
        Nunchuk n = new Nunchuk(f,w);
        
        n.advance('L');
        
        assertEquals(9, f.getXPos());
    }
    
    /**
     * Pruebas del método advance()
     * Caso 2: right
     */
    public void advanceRight()
    {
        Figure f = new Figure("Monstruo",10,10);
        Weapon w=new Weapon(); 
        Nunchuk n = new Nunchuk(f,w);
        
        n.advance('R');
        
        assertEquals(11, f.getXPos());
    }
    
    /**
     * Pruebas del método advance()
     * Caso 3: up
     */
    public void advanceUp()
    {
        Figure f = new Figure("Monstruo",10,10);
        Weapon w=new Weapon(); 
        Nunchuk n = new Nunchuk(f,w);
        
        n.advance('U');
        
        assertEquals(11, f.getYPos());
    }
    
    /**
     * Pruebas del método advance()
     * Caso 4: down
     */
    public void advanceDown()
    {
        Figure f = new Figure("Monstruo",10,10);
        Weapon w=new Weapon(); 
        Nunchuk n = new Nunchuk(f,w);
        
        n.advance('D');
        
        assertEquals(9, f.getYPos());
    }
    
    /**
     * Pruebas del método midleAdvance()
     * Caso 1: left
     */
    public void midleAdvanceLeft()
    {
        Figure f = new Figure("Monstruo",10,10);
        Weapon w=new Weapon(); 
        Nunchuk n = new Nunchuk(f,w);
        
        n.midleAdvance('L');
        
        assertEquals(8, f.getXPos());
    }
    
    /**
     * Pruebas del método midleAdvance()
     * Caso 2: right
     */
    public void midleAdvanceRight()
    {
        Figure f = new Figure("Monstruo",10,10);
        Weapon w=new Weapon(); 
        Nunchuk n = new Nunchuk(f,w);
        
        n.midleAdvance('R');
        
        assertEquals(12, f.getXPos());
    }
    
    /**
     * Pruebas del método midleAdvance()
     * Caso 3: down
     */
    public void midleAdvanceDown()
    {
        Figure f = new Figure("Monstruo",10,10);
        Weapon w=new Weapon(); 
        Nunchuk n = new Nunchuk(f,w);
        
        n.midleAdvance('D');
        
        assertEquals(8, f.getYPos());
    }
    
    /**
     * Pruebas del método midleAdvance()
     * Caso 4: up
     */
    public void midleAdvanceUp()
    {
        Figure f = new Figure("Monstruo",10,10);
        Weapon w=new Weapon(); 
        Nunchuk n = new Nunchuk(f,w);
        
        n.midleAdvance('D');
        
        assertEquals(12, f.getYPos());
    }
    
    /**
     * Pruebas del método muchAdvance()
     * Caso 1: left
     */
    public void muchAdvanceLeft()
    {
        Figure f = new Figure("Monstruo",10,10);
        Weapon w=new Weapon(); 
        Nunchuk n = new Nunchuk(f,w);
        
        n.muchAdvance('L');
        
        assertEquals(15, f.getXPos());
    }
    
    /**
     * Pruebas del método muchAdvance()
     * Caso 2: right
     */
    public void muchAdvanceRight()
    {
        Figure f = new Figure("Monstruo",10,10);
        Weapon w=new Weapon(); 
        Nunchuk n = new Nunchuk(f,w);
        
        n.muchAdvance('R');
        
        assertEquals(5, f.getXPos());
    }
    
    /**
     * Pruebas del método muchAdvance()
     * Caso 3: DOWN
     */
    public void muchAdvanceDown()
    {
        Figure f = new Figure("Monstruo",10,10);
        Weapon w=new Weapon(); 
        Nunchuk n = new Nunchuk(f,w);
        
        n.muchAdvance('D');
        
        assertEquals(5, f.getYPos());
    }
    
    /**
     * Pruebas del método muchAdvance()
     * Caso 4: Up
     */
    public void muchAdvanceUp()
    {
        Figure f = new Figure("Monstruo",10,10);
        Weapon w=new Weapon(); 
        Nunchuk n = new Nunchuk(f,w);
        
        n.muchAdvance('U');
        
        assertEquals(15, f.getYPos());
    }
    
    /**
     * Pruebas del método shootWeapon()
     * Caso 1: true
     */
    @Test
    public void shootWeaponTrue()
    {
        Nunchuk n = new Nunchuk();  
        
        n.shootWeapon(true);
        
        assertEquals(45, n.getWeapon().getAmmunition());
        
    }
    
     /**
     * Pruebas del método shootWeapon()
     * Caso 2: false
     */
    @Test
    public void shootWeaponFalse()
    {
        Nunchuk n = new Nunchuk();  
        
        n.shootWeapon(false);
        
        assertEquals(49, n.getWeapon().getAmmunition());
        
    }
    
    /**
     * Pruebas del método shootForward()
     * Caso 1:
     */
    @Test
    public void shootForwardLeft()
    {
        Nunchuk n = new Nunchuk();
        
        n.shootForward('L');
        
        assertEquals(9, n.getFigure().getXPos());
        assertEquals(49, n.getWeapon().getAmmunition());
    }
    
    /**
     * Pruebas del método shootForward()
     * Caso 2:
     */
    @Test
    public void shootForwardRight()
    {
        Nunchuk n = new Nunchuk();
        
        n.shootForward('R');
        
        assertEquals(11, n.getFigure().getXPos());
        assertEquals(49, n.getWeapon().getAmmunition());
    }
    
    /**
     * Pruebas del método shootForward()
     * Caso 3:
     */
    @Test
    public void shootForwardUp()
    {
        Nunchuk n = new Nunchuk();
        
        n.shootForward('U');
        
        assertEquals(10, n.getFigure().getXPos());
        assertEquals(49, n.getWeapon().getAmmunition());
    }
    
    /**
     * Pruebas del método shootForward()
     * Caso 4:
     */
    @Test
    public void shootForwardDown()
    {
        Nunchuk n = new Nunchuk();
        
        n.shootForward('D');
        
        assertEquals(10, n.getFigure().getXPos());
        assertEquals(49, n.getWeapon().getAmmunition());
    }
}
