package testPackage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import av2.webdev.database.AccountDatabase;

public class ServletTest {

  @Test
  public void doesItWork() {
    assert (1 > 0);
  }

  @Test
  public void testCobertura() {
    assertEquals(AccountDatabase.sum(1, 2), 3);
  }

  @Test
  public void testBuildScan() {
    assertEquals(12, 12);
  }
}
