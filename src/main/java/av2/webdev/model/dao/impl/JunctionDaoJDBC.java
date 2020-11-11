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
        try {
            connection = DatabaseConnector.getConnection();
            query = connection
                    .prepareStatement("INSERT INTO `STUDENT_COURSE_GRADE_JT`(`STUDENT_FK`, `COURSE_FK`, `GRADE_FK`)"
                            + " VALUES (?, ?, ?)");
            query.setInt(1, Integer.parseInt(studentId));
            query.setInt(2, Integer.parseInt(courseId));
            query.setInt(3, Integer.parseInt(gradeId));

            return query.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery("junction Dao", "insertStudentCourseGradeJunction");
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

        return 0;
    }

    @Override
    public String getGradeIdByStudentAndCourse(String studentId, String courseId) {
        try {
            connection = DatabaseConnector.getConnection();
            query = connection.prepareStatement(
                    "SELECT `GRADE_FK` FROM `STUDENT_COURSE_GRADE_JT` WHERE STUDENT_FK = ? AND COURSE_FK = ?");
            query.setInt(1, Integer.parseInt(studentId));
            query.setInt(2, Integer.parseInt(courseId));

            resultSet = query.executeQuery();

            if (resultSet.next())
                return String.valueOf(resultSet.getInt("GRADE_FK"));

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery("junction Dao", "getGradeIdByStudentAndCourse");
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
    public void deleteStudentCourseGradeJunction(String studentId, String courseId, String gradeId) {
        try {
            connection = DatabaseConnector.getConnection();
            query = connection.prepareStatement("DELETE FROM `STUDENT_COURSE_GRADE_JT`"
                    + " WHERE STUDENT_FK = ? AND COURSE_FK = ? AND GRADE_FK = ?");
            query.setInt(1, Integer.parseInt(studentId));
            query.setInt(2, Integer.parseInt(courseId));
            query.setInt(3, Integer.parseInt(gradeId));

            query.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery("junction Dao", "deleteStudentCourseGradeJunction");
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
    }
}
