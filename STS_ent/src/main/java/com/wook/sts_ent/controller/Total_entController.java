package com.wook.sts_ent.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class Total_entController {

    @GetMapping("total_ent_main")
    public String Total_entMain(@PathVariable int category){

    }

}
