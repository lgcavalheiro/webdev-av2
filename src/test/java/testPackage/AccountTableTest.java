package testPackage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import av2.webdev.database.AccountTable;

public class AccountTableTest {
  AccountTable db = new AccountTable();

  @Test
  public void getByKeyAndValueUsingName() {
    String test = db.getByKeyAndValue("name", "Alan Almeida");

    assertEquals("Alan Almeida", test);
  }

  @Test
  public void getByKeyAndValueUsingInvalidName() {
    String test = db.getByKeyAndValue("name", "Invalid Name");

    assertEquals("", test);
  }

  @Test
  public void getByKeyAndValueUsingInvalidKey() {
    String test = db.getByKeyAndValue("invalidKey", "Alan Almeida");

    assertEquals("", test);
  }

  @Test
  public void getValueByIdAndKeyValid() {
    String test = db.getValueByIdAndKey(99990001, "password");

    assertEquals("333za", test);
  }

  @Test
  public void getValueByIdAndKeyInvalidId() {
    String test = db.getValueByIdAndKey(1234, "password");

    assertEquals("", test);
  }

  @Test
  public void getValueByIdAndKeyInvalidKey() {
    String test = db.getValueByIdAndKey(99990001, "invalid");

    assertEquals("", test);
  }
}
