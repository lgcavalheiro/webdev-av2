package av2.webdev.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import av2.webdev.model.dao.JunctionDao;
import av2.webdev.model.dao.impl.utils.QueryLogger;
import av2.webdev.model.utils.DatabaseConnector;

public class JunctionDaoJDBC implements JunctionDao {
    static private Connection connection;
    static private PreparedStatement query;
    static private ResultSet resultSet;

    @Override
    public int insertStudentCourseGradeJunction(String studentId, String courseId, String gradeId) {
        int rowsAffected = 0;

        try {
            connection = DatabaseConnector.getConnection();
            query = connection
                    .prepareStatement("INSERT INTO `STUDENT_COURSE_GRADE_JT`(`STUDENT_FK`, `COURSE_FK`, `GRADE_FK`)"
                            + " VALUES (2020010017, 3, 37)");

            rowsAffected = query.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery("Grade Dao", "insertGrade");
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

        return rowsAffected;
    }
}
