package dreamjob.repository;

import dreamjob.model.Vacancy;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MemoryVacancyRepository implements VacancyRepository {

    private final static MemoryVacancyRepository INSTANCE = new MemoryVacancyRepository();

    private final AtomicInteger nextId = new AtomicInteger(1);

    private final Map<Integer, Vacancy> vacancies = new HashMap<>();

    public MemoryVacancyRepository() {
        save(new Vacancy("Java Developer", "Intern Java Developer"));
        save(new Vacancy("Java Developer", "Junior Java Developer"));
        save(new Vacancy("Java Developer", "Junior+ Java Developer"));
        save(new Vacancy("Java Developer", "Middle Java Developer"));
        save(new Vacancy("Java Developer", "Middle+ Java Developer"));
        save(new Vacancy("Java Developer", "Senior Java Developer"));
    }

    public static MemoryVacancyRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public synchronized Vacancy save(Vacancy vacancy) {
        vacancy.setId(nextId.getAndIncrement());
        vacancies.put(vacancy.getId(), vacancy);
        return vacancy;
    }

    @Override
    public synchronized boolean deleteById(int id) {
        return vacancies.remove(id) != null;
    }

    @Override
    public synchronized boolean update(Vacancy vacancy) {
        return vacancies.computeIfPresent(
                vacancy.getId(),
                (id, oldVacancy) -> new Vacancy(
                            oldVacancy.getId(),
                            vacancy.getTitle(),
                            vacancy.getDescription())
                ) != null;
    }

    @Override
    public synchronized Optional<Vacancy> findById(int id) {
        return Optional.ofNullable(vacancies.get(id));
    }

    @Override
    public synchronized Collection<Vacancy> findAll() {
        return vacancies.values();
    }
}
