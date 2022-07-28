package cn.gzsxy.seriablizale;

import java.io.Serializable;
import java.util.Objects;

public class Problem implements Serializable {

    private static final long serialVersionUID = 8476022349487840492L;

    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return id == problem.id && Objects.equals(title, problem.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
