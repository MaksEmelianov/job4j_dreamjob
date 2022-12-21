package dreamjob.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Candidate {

    private int id;
    private String name;
    private String desc;
    private LocalDateTime create;

    public Candidate(int id, String name, String desc, LocalDateTime create) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.create = create;
    }

    public Candidate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getCreate() {
        return create;
    }

    public void setCreate(LocalDateTime create) {
        this.create = create;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return id == candidate.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
