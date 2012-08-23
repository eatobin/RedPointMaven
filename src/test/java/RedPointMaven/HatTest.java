package RedPointMaven;

import junit.framework.TestCase;

public class HatTest extends TestCase
{
  public void testDrawPuck() throws Exception
  {
    Hat myHat = new Hat(3);

    assertEquals(3, myHat.pucks.size());
    assertEquals(102, (int)myHat.pucks.get(2));
    assertTrue("Fails - Less than", myHat.drawPuck() >= 100);
    assertTrue("Fails - Greater than", myHat.drawPuck() <= 102);

    myHat.pucks.clear();
    assertEquals(0, myHat.drawPuck());
  }

  public void testRemovePuck() throws Exception
  {
    Hat myHat = new Hat(3);

    assertTrue(myHat.removePuck(100));
    assertEquals(2, myHat.pucks.size());
  }

  public void testDiscardsSize() throws Exception
  {
    Hat myHat = new Hat(3);

    assertTrue(myHat.discardPuck(100));
    assertEquals(1, myHat.discardsSize());
  }

  public void testDiscardPuck() throws Exception
  {
    Hat myHat = new Hat(3);

    assertTrue(myHat.discardPuck(100));
    assertFalse(myHat.discardPuck(109));
    assertEquals(2, myHat.pucks.size());
  }

  public void testReturnDiscards() throws Exception
  {
    Hat myHat = new Hat(3);

    assertTrue(myHat.discardPuck(100));
    assertEquals(2, myHat.pucks.size());
    assertEquals(1, myHat.discardsSize());

    myHat.returnDiscards();
    assertEquals(3, myHat.pucks.size());
    assertEquals(0, myHat.discardsSize());
  }
}
