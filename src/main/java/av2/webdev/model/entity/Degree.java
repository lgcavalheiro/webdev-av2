package av2.webdev.model.entity;

public class Degree {
    private String id;
    private String name;
    private String courseFk;

    public Degree() {

    }

    public Degree(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseFk() {
        return courseFk;
    }

    public void setCourseFk(String courseFk) {
        this.courseFk = courseFk;
    }
}
