package dreamjob.store;

import dreamjob.model.Resume;

import java.util.Collection;
import java.util.Optional;

public interface ResumeRepository {

    Resume save(Resume resume);

    boolean deleteById(int id);

    boolean update(Resume resume);

    Optional<Resume> findById(int id);

    Collection<Resume> findAll();
}
