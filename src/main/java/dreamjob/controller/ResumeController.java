package dreamjob.controller;

import dreamjob.model.Resume;
import dreamjob.store.ResumeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resumes")
public class ResumeController {

    private final ResumeRepository resumeRepository;

    public ResumeController(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("resumes", resumeRepository.findAll());
        return "resumes/list";
    }

    @GetMapping("/create")
    public String createGet() {
        return "resumes/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Resume resume) {
        resumeRepository.save(resume);
        return "redirect:/resumes";
    }

    @GetMapping("/update/{resumeId}")
    public String updateGet(Model model, @PathVariable("resumeId") int id) {
        model.addAttribute("resume", resumeRepository.findById(id));
        return "resumes/update";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Resume resume) {
        resumeRepository.update(resume);
        return "redirect:/resumes";
    }
}
