package dreamjob.repository;

import dreamjob.model.Resume;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MemoryResumeRepository implements ResumeRepository {

    /*private final static MemoryResumeRepository INSTANCE = new MemoryResumeRepository();*/

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

    /*public static MemoryResumeRepository getInstance() {
        return INSTANCE;
    }*/

    @Override
    public Resume save(Resume resume) {
        resume.setId(nextId.getAndIncrement());
        resumes.put(resume.getId(), resume);
        return resume;
    }

    @Override
    public boolean deleteById(int id) {
        return resumes.remove(id) != null;
    }

    @Override
    public boolean update(Resume resume) {
        return resumes.computeIfPresent(
                resume.getId(),
                (id, oldVacancy) -> new Resume(
                        oldVacancy.getId(),
                        resume.getTitle(),
                        resume.getDescription(),
                        resume.isVisible(),
                        resume.getCityId())
        ) != null;
    }

    @Override
    public Optional<Resume> findById(int id) {
        return Optional.ofNullable(resumes.get(id));
    }

    @Override
    public Collection<Resume> findAll() {
        return resumes.values();
    }
}
