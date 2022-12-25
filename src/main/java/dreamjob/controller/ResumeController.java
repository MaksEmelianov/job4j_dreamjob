package dreamjob.controller;

import dreamjob.model.Resume;
import dreamjob.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("resumes", resumeService.findAll());
        return "resumes/list";
    }

    @GetMapping("/create")
    public String createGet() {
        return "resumes/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Resume resume) {
        resumeService.save(resume);
        return "redirect:/resumes";
    }

    @GetMapping("/update/{resumeId}")
    public String updateGet(Model model, @PathVariable("resumeId") int id) {
        model.addAttribute("resume", resumeService.findById(id));
        return "resumes/update";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Resume resume) {
        resumeService.update(resume);
        return "redirect:/resumes";
    }
}
