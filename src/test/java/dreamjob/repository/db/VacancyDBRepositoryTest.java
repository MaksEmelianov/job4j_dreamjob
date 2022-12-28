package dreamjob.repository.db;

import dreamjob.Main;
import dreamjob.model.Vacancy;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class VacancyDBRepositoryTest {

    @Test
    void whenCreateVacancy() {
        VacancyDBRepository repository = new VacancyDBRepository(new Main().loadPoolTest());
        Vacancy vacancy = new Vacancy(
                "Title2", "Desc2",
                LocalDateTime.now(), true, 1);
        repository.save(vacancy);
        Vacancy expected = repository.findById(vacancy.getId()).orElseThrow();
        assertThat(expected.getTitle()).isEqualTo(vacancy.getTitle());
    }
}
