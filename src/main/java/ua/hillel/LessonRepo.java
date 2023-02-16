package ua.hillel;

public interface LessonRepo {
    void addLesson (Lesson lesson);
    Lesson deleteLesson(Integer id);
    Lesson findId(Integer id);
    void findAll (Lesson lesson);

}
