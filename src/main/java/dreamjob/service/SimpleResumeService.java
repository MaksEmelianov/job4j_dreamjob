package dreamjob.service;

import dreamjob.model.Resume;
import dreamjob.repository.interfaces.ResumeRepository;
import dreamjob.service.interfaces.ResumeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class SimpleResumeService implements ResumeService {

    private final ResumeRepository resumeRepository;

    public SimpleResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @Override
    public Resume save(Resume resume) {
        return resumeRepository.save(resume);
    }

    @Override
    public boolean deleteById(int id) {
        return resumeRepository.deleteById(id);
    }

    @Override
    public boolean update(Resume resume) {
        return resumeRepository.update(resume);
    }

    @Override
    public Optional<Resume> findById(int id) {
        return resumeRepository.findById(id);
    }

    @Override
    public Collection<Resume> findAll() {
        return resumeRepository.findAll();
    }
}
