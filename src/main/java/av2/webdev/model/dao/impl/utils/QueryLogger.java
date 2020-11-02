package av2.webdev.model.dao.impl.utils;

import java.util.Locale;

public class QueryLogger {
    public static void logQuery(String daoName, String queryName) {
        System.out.printf("[%s] Query %s completed.\n", daoName.toUpperCase(Locale.US), queryName);
    }
}
