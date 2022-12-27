package dreamjob.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Resume {

    private int id;
    private String title;
    private String description;
    private LocalDateTime createDate = LocalDateTime.now();
    private boolean visible;
    private int cityId;
    private byte[] photo;

    public Resume(int id, String title, String description, boolean visible, int cityId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.visible = visible;
        this.cityId = cityId;
    }

    public Resume(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Resume() {
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

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Resume resume = (Resume) o;
        return id == resume.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
