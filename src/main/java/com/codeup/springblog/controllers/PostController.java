package com.codeup.springblog.controllers;


import com.codeup.springblog.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService ) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String viewPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost (@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getById(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getById(id));
        return "posts/edit";
    }
    @PostMapping ("/posts/{id}/edit")
    public String editPost(@PathVariable long id, @ModelAttribute Post post){
        post.setUser(userDao.getById(1l));
        postDao.save(post);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id){
        postDao.delete(postDao.getById(id));
        return "redirect:/posts";
    }

    @GetMapping("posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

//    @RequestMapping (path = "posts/create", method = RequestMethod.GET)
    @PostMapping("/posts/create")

    public String createPost(@ModelAttribute Post post) {
        User user = userDao.getById(1l);
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSend(post, "You created:" + post.getTitle(), post.getBody());
        return "redirect:/posts";
    }

//    @GetMapping("/ads/create")
//    public String createAndForm(Model model)  {
//        model.addAttribute(("ad", new Ad());
//        return "ads/create";
//    }

}
