package com.wook.sts_ent.controller;

import com.wook.sts_ent.service.Total_entService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class Total_entController {

    private final Total_entService total_entService;

    @GetMapping("total_ent_main")
    public String Total_entMain(@RequestParam("category") int category){



        return "total_ent/total_ent_main";
    }

}
