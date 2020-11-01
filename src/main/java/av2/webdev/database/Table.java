package av2.webdev.database;

import java.util.Map;

public interface Table<K, V> {
    public Map<K, V> getAll();

    public V getById(int id);

    public String getByKeyAndValue(String key, String value);

    public String getValueByIdAndKey(int id, String Key);
}
