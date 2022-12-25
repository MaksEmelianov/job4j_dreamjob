package dreamjob.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Vacancy {

    private int id;
    private String title;
    private String description;
    private LocalDateTime createDate = LocalDateTime.now();
    private boolean visible;

    public Vacancy(int id, String title, String description, boolean visible) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.visible = visible;
    }

    public Vacancy(String title, String description, boolean visible) {
        this.title = title;
        this.description = description;
        this.visible = visible;
    }

    public Vacancy(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Vacancy(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Vacancy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return id == vacancy.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
