package dreamjob.controller;

import dreamjob.model.Resume;
import dreamjob.service.CityService;
import dreamjob.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    private final CityService cityService;

    public ResumeController(ResumeService resumeService, CityService cityService) {
        this.resumeService = resumeService;
        this.cityService = cityService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("resumes", resumeService.findAll());
        return "resumes/list";
    }

    @GetMapping("/create")
    public String createGet(Model model) {
        model.addAttribute("cities", cityService.findAll());
        return "resumes/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Resume resume) {
        resumeService.save(resume);
        return "redirect:/resumes";
    }

    @GetMapping("/update/{resumeId}")
    public String updateGet(Model model, @PathVariable("resumeId") int id) {
        var resumeOptional = resumeService.findById(id);
        if (resumeOptional.isEmpty()) {
            model.addAttribute("message",
                    "Резюме с указанным идентификатором не найдена");
            return "error/404";
        }
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("resume", resumeOptional.get());
        return "resumes/update";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Resume resume) {
        resumeService.update(resume);
        return "redirect:/resumes";
    }
}
