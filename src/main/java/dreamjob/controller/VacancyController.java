package dreamjob.controller;

import dreamjob.model.Vacancy;
import dreamjob.service.SimpleVacancyService;
import dreamjob.service.VacancyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacancies")
public class VacancyController {

    private final VacancyService vacancyService = SimpleVacancyService.getInstance();

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("vacancies", vacancyService.findAll());
        return "vacancies/list";
    }

    @GetMapping("/create")
    public String createGet() {
        return "vacancies/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Vacancy vacancy) {
        vacancyService.save(vacancy);
        return "redirect:/vacancies";
    }

    @GetMapping("/update/{vacancyId}")
    public String updateGet(Model model, @PathVariable("vacancyId") int id) {
        model.addAttribute("vacancy", vacancyService.findById(id));
        return "vacancies/update";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Vacancy vacancy) {
        vacancyService.update(vacancy);
        return "redirect:/vacancies";
    }
}
