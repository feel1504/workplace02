package cn.gzsxy.seriablizale;

import java.io.Serializable;

public class Problem implements Serializable {

    private static final long serialVersionUID = -2509731521761112281L;
    private int id;
    private String title;

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
