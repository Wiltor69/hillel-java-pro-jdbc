package ua.hillel;

public class Lesson {
    private Integer id;
    private String name;
    private  int homework_id;
    private String updatedAt;

    public Lesson() {

    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedA(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHomework_id() {
        return homework_id;
    }

    public void setHomework_id(int homework_id) {
        this.homework_id = homework_id;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homework_id=" + homework_id +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
