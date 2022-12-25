package dreamjob.controller;

import dreamjob.model.Post;
import dreamjob.repository.old.PostStore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    private final PostStore postStore = PostStore.instOf();

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", postStore.findAll());
        return "posts/posts";
    }

    @GetMapping("/formAddPost")
    public String formAddPost(Model model) {
        return "posts/addPost";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute Post post) {
        postStore.add(post);
        return "redirect:posts";
    }

    @GetMapping("/formUpdatePost/{postId}")
    public String formUpdatePost(Model model, @PathVariable("postId") int id) {
        model.addAttribute("post", postStore.findById(id));
        return "posts/updatePost";
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute Post post) {
        postStore.update(post);
        return "redirect:posts";
    }

/*    @GetMapping("/formAddPost")
    public String addPost(Model model) {
        model.addAttribute("post",
                new Post(0, "Заполните название",
                        "Заполните описание", LocalDateTime.now()));
        return "addPost";
    }*/

/*    @PostMapping("/createPost")
    public String createPost(HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.print(name);
        postStore.add(new Post(1, name, "desc", LocalDateTime.now()));
        return "redirect:/posts";
    }*/
}
