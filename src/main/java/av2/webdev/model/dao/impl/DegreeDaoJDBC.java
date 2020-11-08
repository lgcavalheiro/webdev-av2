package av2.webdev.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import av2.webdev.model.dao.DegreeDao;
import av2.webdev.model.dao.impl.utils.QueryLogger;
import av2.webdev.model.entity.Degree;
import av2.webdev.model.utils.DatabaseConnector;

public class DegreeDaoJDBC implements DegreeDao {
    static private Connection connection;
    static private PreparedStatement query;
    static private ResultSet resultSet;

    @Override
    public Degree getDegreeByStudentId(String studentId) {
        try {
            connection = DatabaseConnector.getConnection();
            query = connection.prepareStatement("SELECT DEGREE.* FROM STUDENT"
                    + " INNER JOIN DEGREE ON DEGREE_FK = DEGREE.ID" + " WHERE STUDENT.ID = ?");
            query.setInt(1, Integer.parseInt(studentId));
            resultSet = query.executeQuery();

            Degree result = new Degree();
            if (resultSet.next()) {
                result.setId(String.valueOf(resultSet.getInt("ID")));
                result.setName(resultSet.getString("NAME"));
            }

            return result;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery("Degree Dao", "getDegreeByStudentId");
                if (query != null)
                    query.close();
                if (resultSet != null)
                    resultSet.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Degree> getDegreeByCourseId(String courseId) {
        try {
            connection = DatabaseConnector.getConnection();
            query = connection.prepareStatement("SELECT COURSE_FK, DEGREE.ID, DEGREE.NAME"
                    + " FROM COURSE_DEGREE_JT INNER JOIN DEGREE ON DEGREE_FK = DEGREE.ID WHERE COURSE_FK = ?");
            query.setInt(1, Integer.parseInt(courseId));
            resultSet = query.executeQuery();

            List<Degree> results = new ArrayList<Degree>();
            while (resultSet.next()) {
                Degree temp = new Degree();
                temp.setId(String.valueOf(resultSet.getInt("ID")));
                temp.setName(resultSet.getString("NAME"));
                temp.setCourseFk(String.valueOf(resultSet.getInt("COURSE_FK")));
                results.add(temp);
            }

            return results;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery("Degree Dao", "getDegreeByCourseId");
                if (query != null)
                    query.close();
                if (resultSet != null)
                    resultSet.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
