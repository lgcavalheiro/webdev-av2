package av2.webdev.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import av2.webdev.model.dao.GradeDao;
import av2.webdev.model.dao.impl.utils.QueryLogger;
import av2.webdev.model.entity.Grade;
import av2.webdev.model.utils.DatabaseConnector;

public class GradeDaoJDBC implements GradeDao {
    static private Connection connection;
    static private PreparedStatement query;
    static private ResultSet resultSet;

    @Override
    public List<Grade> getGradeByStudentId(String studentId) {
        try {
            connection = DatabaseConnector.getConnection();
            query = connection.prepareStatement("SELECT GRADE.ID, COURSE_FK, GRADE.EXAM_AV1,"
                    + " GRADE.ASSIGNMENT_AV1, GRADE.EXAM_AV2, GRADE.ASSIGNMENT_AV2, GRADE.EXAM_AV3,"
                    + " GRADE.FINAL_GRADE, GRADE.UPDATE_TIMESTAMP FROM STUDENT_COURSE_GRADE_JT"
                    + " INNER JOIN GRADE ON GRADE_FK = GRADE.ID WHERE STUDENT_FK = ?");
            query.setInt(1, Integer.parseInt(studentId));
            resultSet = query.executeQuery();

            List<Grade> result = new ArrayList<Grade>();

            while (resultSet.next()) {
                Grade temp = new Grade();
                temp.setId(String.valueOf(resultSet.getInt("ID")));
                temp.setExamAv1(resultSet.getFloat("EXAM_AV1"));
                temp.setExamAv2(resultSet.getFloat("EXAM_AV2"));
                temp.setExamAv3(resultSet.getFloat("EXAM_AV3"));
                temp.setAssignmentAv1(resultSet.getFloat("ASSIGNMENT_AV1"));
                temp.setAssignmentAv2(resultSet.getFloat("ASSIGNMENT_AV2"));
                temp.setFinalGrade(resultSet.getFloat("FINAL_GRADE"));
                temp.setUpdateTimestamp(resultSet.getTimestamp("UPDATE_TIMESTAMP"));
                temp.setCourseId(String.valueOf(resultSet.getInt("COURSE_FK")));
                result.add(temp);
            }

            return result;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery("Grade Dao", "getGradeByStudentId");
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
