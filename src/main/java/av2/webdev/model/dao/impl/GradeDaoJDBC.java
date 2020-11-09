package av2.webdev.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    @Override
    public List<Grade> getGradeByCourseId(String courseId) {
        try {
            connection = DatabaseConnector.getConnection();
            query = connection.prepareStatement("SELECT GRADE.ID, STUDENT_FK, GRADE.EXAM_AV1,"
                    + " GRADE.ASSIGNMENT_AV1, GRADE.EXAM_AV2, GRADE.ASSIGNMENT_AV2, GRADE.EXAM_AV3,"
                    + " GRADE.FINAL_GRADE, GRADE.UPDATE_TIMESTAMP FROM STUDENT_COURSE_GRADE_JT"
                    + " INNER JOIN GRADE ON GRADE_FK = GRADE.ID WHERE COURSE_FK = ?");
            query.setInt(1, Integer.parseInt(courseId));
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
                temp.setStudentId(String.valueOf(resultSet.getInt("STUDENT_FK")));
                result.add(temp);
            }

            return result;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery("Grade Dao", "getGradeByCourseId");
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
    public int updateGrade(String studentId, String courseId, Grade grade) {
        int rowsAffected = 0;

        try {
            connection = DatabaseConnector.getConnection();
            query = connection.prepareStatement("UPDATE GRADE INNER JOIN STUDENT_COURSE_GRADE_JT"
                    + " ON STUDENT_COURSE_GRADE_JT.GRADE_FK = GRADE.ID"
                    + " SET EXAM_AV1=?, ASSIGNMENT_AV1=?, EXAM_AV2=?, ASSIGNMENT_AV2=?, EXAM_AV3=?, FINAL_GRADE=?"
                    + " WHERE STUDENT_COURSE_GRADE_JT.STUDENT_FK = ? AND STUDENT_COURSE_GRADE_JT.COURSE_FK = ?");
            query.setFloat(1, grade.getExamAv1());
            query.setFloat(2, grade.getAssignmentAv1());
            query.setFloat(3, grade.getExamAv2());
            query.setFloat(4, grade.getAssignmentAv2());
            query.setFloat(5, grade.getExamAv3());
            query.setFloat(6, grade.getFinalGrade());
            query.setInt(7, Integer.valueOf(studentId));
            query.setInt(8, Integer.valueOf(courseId));

            rowsAffected = query.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery("Grade Dao", "updateGrade");
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

    @Override
    public String insertGrade(Grade grade) {
        int rowsAffected = 0;
        String gradeId = "";

        try {
            connection = DatabaseConnector.getConnection();
            query = connection.prepareStatement(
                    "INSERT INTO GRADE (`EXAM_AV1`, `ASSIGNMENT_AV1`, `EXAM_AV2`, `ASSIGNMENT_AV2`, `EXAM_AV3`, `FINAL_GRADE`, `UPDATE_TIMESTAMP`)"
                            + " VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)",
                    Statement.RETURN_GENERATED_KEYS);
            query.setFloat(1, grade.getExamAv1());
            query.setFloat(2, grade.getAssignmentAv1());
            query.setFloat(3, grade.getExamAv2());
            query.setFloat(4, grade.getAssignmentAv2());
            query.setFloat(5, grade.getExamAv3());
            query.setFloat(6, grade.getFinalGrade());

            rowsAffected = query.executeUpdate();

            if (rowsAffected > 0) {
                resultSet = query.getGeneratedKeys();
                if (resultSet.next()) {
                    gradeId = String.valueOf(resultSet.getInt(1));
                }
            }

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

        return gradeId;
    }

    @Override
    public void deleteGrade(String gradeId) {
        try {
            connection = DatabaseConnector.getConnection();
            query = connection.prepareStatement("DELETE FROM GRADE WHERE ID = ?");
            query.setInt(1, Integer.parseInt(gradeId));

            query.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery("Grade Dao", "deleteGrade");
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