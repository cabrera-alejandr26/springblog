package com.codeup.springblog.controllers;


import com.codeup.springblog.models.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    @ResponseBody
    public String viewPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "View all posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable long id, Model model){
        model.addAttribute("post", postDao);
        return "posts/";
    }

    @GetMapping("posts/create")
    @ResponseBody
    public String createForm(){
        return "View form to create a post.";
    }

//    @RequestMapping (path = "posts/create", method = RequestMethod.GET)
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create new post.";
    }
}
