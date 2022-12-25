package dreamjob.service;

import dreamjob.model.Resume;

import java.util.Collection;
import java.util.Optional;

public interface ResumeService {

    Resume save(Resume resume);

    boolean deleteById(int id);

    boolean update(Resume resume);

    Optional<Resume> findById(int id);

    Collection<Resume> findAll();
}
