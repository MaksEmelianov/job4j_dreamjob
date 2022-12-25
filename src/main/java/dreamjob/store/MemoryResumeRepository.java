package dreamjob.store;

import dreamjob.model.Resume;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MemoryResumeRepository implements ResumeRepository {

    private final AtomicInteger nextId = new AtomicInteger(1);

    private final Map<Integer, Resume> resumes = new HashMap<>();

    public MemoryResumeRepository() {
        save(new Resume("Java Developer", "Intern Developer"));
        save(new Resume("Java Developer", "Junior Developer"));
        save(new Resume("Java Developer", "Junior+ Developer"));
        save(new Resume("Java Developer", "Middle Developer"));
        save(new Resume("Java Developer", "Middle+ Developer"));
        save(new Resume("Java Developer", "Senior Developer"));
    }

    @Override
    public synchronized Resume save(Resume resume) {
        resume.setId(nextId.getAndIncrement());
        resumes.put(resume.getId(), resume);
        return resume;
    }

    @Override
    public synchronized boolean deleteById(int id) {
        return resumes.remove(id) != null;
    }

    @Override
    public synchronized boolean update(Resume resume) {
        return resumes.computeIfPresent(
                resume.getId(),
                (id, oldVacancy) -> new Resume(
                        oldVacancy.getId(),
                        resume.getTitle(),
                        resume.getDescription())
                ) != null;
    }

    @Override
    public synchronized Optional<Resume> findById(int id) {
        return Optional.ofNullable(resumes.get(id));
    }

    @Override
    public synchronized Collection<Resume> findAll() {
        return resumes.values();
    }
}
