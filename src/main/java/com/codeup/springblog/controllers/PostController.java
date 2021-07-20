package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String viewPosts() {
        return "View all posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable long id){
        return "view an individual post.";
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
