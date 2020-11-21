package av2.webdev.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import av2.webdev.model.dao.StudentDao;
import av2.webdev.model.dao.impl.utils.QueryLogger;
import av2.webdev.model.entity.Student;
import av2.webdev.model.utils.DatabaseConnector;

public class StudentDaoJDBC implements StudentDao {
    static private Connection connection;
    static private PreparedStatement query;
    static private ResultSet resultSet;

    @Override
    public List<Student> getStudentByCourseId(String courseId) {
        try {
            connection = DatabaseConnector.getConnection();
            query = connection.prepareStatement(
                    "SELECT STUDENT.ID, STUDENT.NAME" + " FROM STUDENT_COURSE_GRADE_JT INNER JOIN STUDENT"
                            + " ON STUDENT_FK = STUDENT.ID WHERE COURSE_FK = ?");
            query.setInt(1, Integer.parseInt(courseId));
            resultSet = query.executeQuery();

            List<Student> result = new ArrayList<Student>();
            while (resultSet.next()) {
                Student temp = new Student();
                temp.setId(resultSet.getString("ID"));
                temp.setName(resultSet.getString("NAME"));
                result.add(temp);
            }

            return result;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery(this.getClass().getSimpleName(), "getStudentByCourseId");
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
    public int insertStudent(Student student) {
        try {
            connection = DatabaseConnector.getConnection();
            query = connection
                    .prepareStatement("INSERT INTO STUDENT(`ID`, `NAME`, `PASSWORD`, `DEGREE_FK`, `UPDATE_TIMESTAMP`)"
                            + " VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)");
            query.setInt(1, Integer.parseInt(student.getId()));
            query.setString(2, student.getName());
            query.setString(3, student.getPassword());
            query.setInt(4, Integer.parseInt(student.getDegree().getId()));

            return query.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery(this.getClass().getSimpleName(), "insertStudent");
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
}
