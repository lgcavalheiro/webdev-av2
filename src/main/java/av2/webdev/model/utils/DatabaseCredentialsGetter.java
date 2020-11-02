package av2.webdev.model.utils;

import java.util.HashMap;
import java.util.Map;

public class DatabaseCredentialsGetter {
    private static Map<String, String> databaseCredentials = new HashMap<String, String>();

    public static Map<String, String> getDatabaseCredentials() {
        databaseCredentials.put("url", "");
        databaseCredentials.put("driver", "");
        databaseCredentials.put("username", "");
        databaseCredentials.put("password", "");
        return databaseCredentials;
    }
}
