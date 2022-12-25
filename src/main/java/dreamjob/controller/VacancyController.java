package dreamjob.controller;

import dreamjob.model.Vacancy;
import dreamjob.store.VacancyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacancies")
public class VacancyController {

    private final VacancyRepository vacancyRepository;

    public VacancyController(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("vacancies", vacancyRepository.findAll());
        return "vacancies/list";
    }

    @GetMapping("/create")
    public String createGet() {
        return "vacancies/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Vacancy vacancy) {
        vacancyRepository.save(vacancy);
        return "redirect:/vacancies";
    }

    @GetMapping("/update/{vacancyId}")
    public String updateGet(Model model, @PathVariable("vacancyId") int id) {
        model.addAttribute("vacancy", vacancyRepository.findById(id));
        return "vacancies/update";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Vacancy vacancy) {
        vacancyRepository.update(vacancy);
        return "redirect:/vacancies";
    }
}
