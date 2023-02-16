package ua.hillel;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/Hillelhomeworks";
            String username = System.getenv("User");
            String password = System.getenv("Password");

            Connection connection = DriverManager.getConnection(url, username, password);

            if(!connection.isClosed()) {
                System.out.println("Database connection established");
            }
                LessonRepo lessonRepo = new LessonDao(connection);

                Lesson lesson = new Lesson();
                lesson.setName("OOP");
                lesson.setUpdatedA("Think about");
                lesson.setHomework_id(1);

            Lesson lesson1 = new Lesson();
            lesson1.setName("JDBC");
            lesson1.setUpdatedA("Think always about");
            lesson1.setHomework_id(2);

            lessonRepo.addLesson(lesson);
            lessonRepo.addLesson(lesson1);

            System.out.println(lessonRepo.findId(7));

            lessonRepo.findAll(lesson);

            lessonRepo.deleteLesson(6);

            connection.close();
            if (connection.isClosed()){
                System.out.println("Database connection closed");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
