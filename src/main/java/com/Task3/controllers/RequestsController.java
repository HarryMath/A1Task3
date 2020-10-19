package com.Task3.controllers;

import com.Task3.models.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestsController {

    @RequestMapping("/")
    public Response getPostings(@RequestParam(value="period", required=false, defaultValue="") String period,
                             @RequestParam(value="auth", required=false, defaultValue="") String auth) {
        return new Response(period, auth);
    }

}
