package dreamjob.controller;

import dreamjob.model.Resume;
import dreamjob.service.interfaceÑ‹.CityService;
import dreamjob.service.interfaceÑ‹.ResumeService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @GetMapping("/getPhoto/{resumeId}")
    public ResponseEntity<Resource> downloadPhoto(@PathVariable("resumeId") Integer id) {
        var resume = resumeService.findById(id).get();
        return ResponseEntity.ok()
                .headers(new HttpHeaders())
                .contentLength(resume.getPhoto().length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new ByteArrayResource(resume.getPhoto()));
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Resume resume,
                             @RequestParam("file") MultipartFile file) throws IOException {
        resume.setPhoto(file.getBytes());
        resumeService.save(resume);
        return "redirect:/resumes";
    }

    @GetMapping("/update/{resumeId}")
    public String updateGet(Model model, @PathVariable("resumeId") int id) {
        var resumeOptional = resumeService.findById(id);
        if (resumeOptional.isEmpty()) {
            model.addAttribute("message",
                    "Ð ÐµÐ·ÑŽÐ¼Ðµ Ñ? ÑƒÐºÐ°Ð·Ð°Ð½Ð½Ñ‹Ð¼ Ð¸Ð´ÐµÐ½Ñ‚Ð¸Ñ„Ð¸ÐºÐ°Ñ‚Ð¾Ñ€Ð¾Ð¼ Ð½Ðµ Ð½Ð°Ð¹Ð´ÐµÐ½Ð°");
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
