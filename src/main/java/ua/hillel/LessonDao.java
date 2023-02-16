package ua.hillel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDao implements LessonRepo{

    private Connection connection;

    public LessonDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addLesson(Lesson lesson) {
        String sql = "INSERT INTO Lesson" + "(name, updatedAt, homework_id)" + "VALUES(?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lesson.getName());
            statement.setString(2, lesson.getUpdatedAt());
            statement.setInt(3, lesson.getHomework_id());

            int i = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Lesson deleteLesson(Integer id)  {
        String sql = " DELETE FROM Lesson WHERE id = ?";
        try (PreparedStatement statement =  connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            Lesson lesson = new Lesson();

            lesson.setId(resultSet.getInt("id"));
            lesson.setName(resultSet.getString("name"));
            lesson.setName(resultSet.getString("updatedAt"));
            lesson.setId(resultSet.getInt("homework_id"));

            return lesson;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Lesson findId(Integer id) {
        String sql = "SELECT * FROM Lesson WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            Lesson lesson = new Lesson();

             lesson.setId(resultSet.getInt("id"));
              lesson.setName(resultSet.getString("name"));
             lesson.setUpdatedA(resultSet.getString("updatedAt"));
              lesson.setHomework_id(resultSet.getInt("homework_id"));

            return lesson;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        @Override
    public void findAll(Lesson lesson) {
            String sql = "SELECT * FROM Lesson ";
            try (Statement statement = connection.createStatement()) {

                statement.execute(sql);
                ResultSet resultSet = statement.getResultSet();
                List<Lesson> lessonList = new ArrayList<>();
                while (resultSet.next()){

                    lesson.setId(resultSet.getInt("id"));
                    lesson.setName(resultSet.getString("name"));
                    lesson.setUpdatedA(resultSet.getString("updatedAt"));
                    lesson.setHomework_id(resultSet.getInt("homework_id"));
                    lessonList.add(lesson);
                }
                System.out.println(lessonList);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }
}
