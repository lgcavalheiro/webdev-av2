package av2.webdev.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import av2.webdev.model.Student;
import av2.webdev.model.Teacher;
import av2.webdev.model.User;

public class AccountTable implements Table<Integer, User> {
  private transient Map<Integer, User> table = new HashMap<Integer, User>();
  private transient List<String> schema = new ArrayList<String>();

  public AccountTable() {
    this.table.put(2020010001, new Student("2020010001", "a123", "Alan Almeida"));
    this.table.put(99990001, new Teacher("99990001", "333za", "Zacarias Alves"));

    this.schema = this.table.get(2020010001).getSchema();
  }

  @Override
  public Map<Integer, User> getAll() {
    return this.table;
  }

  @Override
  public User getById(int id) {
    return this.table.get(id);
  }

  @Override
  public String getByKeyAndValue(String key, String value) {
    if (!this.schema.contains(key))
      return "";

    for (Map.Entry<Integer, User> entry : this.table.entrySet()) {
      if (entry.getValue().getName() == value)
        return entry.getValue().getName();
    }

    return "";
  }

  @Override
  public String getValueByIdAndKey(int id, String key) {
    if (!this.schema.contains(key) || this.table.get(id) == null)
      return "";

    switch (key) {
      case "id":
        return this.table.get(id).getId();
      case "password":
        return this.table.get(id).getPassword();
      case "name":
        return this.table.get(id).getName();
    }

    return "";
  }
}
