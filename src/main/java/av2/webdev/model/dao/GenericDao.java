package av2.webdev.model.dao;

import java.util.List;
import java.util.Map;

public interface GenericDao {
    public List<Map<String, String>> getById(String id);
}
