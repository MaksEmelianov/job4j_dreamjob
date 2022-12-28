package dreamjob.service;

import dreamjob.model.Vacancy;
import dreamjob.repository.db.VacancyDBRepository;
import dreamjob.service.interfaces.VacancyService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class SimpleVacancyService implements VacancyService {

    private final VacancyDBRepository vacancyRepository;

    public SimpleVacancyService(VacancyDBRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    public Vacancy save(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    @Override
    public boolean deleteById(int id) {
        return vacancyRepository.deleteById(id);
    }

    @Override
    public boolean update(Vacancy vacancy) {
        return vacancyRepository.update(vacancy);
    }

    @Override
    public Optional<Vacancy> findById(int id) {
        return vacancyRepository.findById(id);
    }

    @Override
    public Collection<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }
}
