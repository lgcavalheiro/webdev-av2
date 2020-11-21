package av2.webdev.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import av2.webdev.model.dao.CourseDao;
import av2.webdev.model.dao.impl.utils.QueryLogger;
import av2.webdev.model.entity.Course;
import av2.webdev.model.utils.DatabaseConnector;

public class CourseDaoJDBC implements CourseDao {
    static private Connection connection;
    static private PreparedStatement query;
    static private ResultSet resultSet;

    @Override
    public List<Course> getCourseByStudentId(String studentId) {
        try {
            connection = DatabaseConnector.getConnection();
            query = connection.prepareStatement("SELECT COURSE.* FROM STUDENT_COURSE_GRADE_JT"
                    + " INNER JOIN COURSE ON COURSE_FK = COURSE.ID WHERE STUDENT_FK = ?");
            query.setInt(1, Integer.parseInt(studentId));
            resultSet = query.executeQuery();

            List<Course> result = new ArrayList<Course>();
            while (resultSet.next()) {
                Course temp = new Course(String.valueOf(resultSet.getInt("ID")),
                        String.valueOf(resultSet.getString("CLASS_NUMBER")), resultSet.getString("NAME"),
                        resultSet.getTimestamp("UPDATE_TIMESTAMP"));
                result.add(temp);
            }

            return result;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery(this.getClass().getSimpleName(), "getCourseByStudentId");
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
    public List<Course> getCourseByTeacherId(String teacherId) {
        try {
            connection = DatabaseConnector.getConnection();
            query = connection.prepareStatement("SELECT COURSE.* FROM COURSE_TEACHER_JT"
                    + " INNER JOIN COURSE ON COURSE_FK = COURSE.ID WHERE TEACHER_FK = ?");
            query.setInt(1, Integer.parseInt(teacherId));
            resultSet = query.executeQuery();

            List<Course> result = new ArrayList<Course>();
            while (resultSet.next()) {
                Course temp = new Course(String.valueOf(resultSet.getInt("ID")),
                        String.valueOf(resultSet.getString("CLASS_NUMBER")), resultSet.getString("NAME"),
                        resultSet.getTimestamp("UPDATE_TIMESTAMP"));
                result.add(temp);
            }

            return result;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery(this.getClass().getSimpleName(), "getCourseByTeacherId");
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
