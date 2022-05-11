package com.jxzj.external.data.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogRespository blogRespository;

    @PostMapping("/add")
    public String add(@RequestBody BlogModel request) {
        BlogModel save = blogRespository.save(request);
        return "successfully!";
    }

}
