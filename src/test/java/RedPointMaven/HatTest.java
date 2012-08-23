package RedPointMaven;

import junit.framework.TestCase;

public class HatTest extends TestCase
{
  public void testDrawPuck() throws Exception
  {
    Hat myHat = new Hat(3);

    assertEquals((int)3, (int)myHat.pucks.size());
    assertEquals((int)102, (int)myHat.pucks.get(2));
    assertTrue("Fails - Less than", myHat.drawPuck() >= 100);
    assertTrue("Fails - Greater than", myHat.drawPuck() <= 102);

    myHat.pucks.clear();
    assertEquals((int)0, (int)myHat.drawPuck());
  }

  public void testRemovePuck() throws Exception
  {

  }

  public void testDiscardsSize() throws Exception
  {

  }

  public void testDiscardPuck() throws Exception
  {

  }

  public void testReturnDiscards() throws Exception
  {

  }
}
