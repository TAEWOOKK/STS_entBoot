package com.wook.sts_ent.controller;

import com.wook.sts_ent.dto.Total_entDTO;
import com.wook.sts_ent.service.Total_entService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class Total_entController {

    private final Total_entService total_entService;

    @GetMapping("total_ent_main")
    public String Total_entMain(@RequestParam("category") int category, Model model){

        List<Total_entDTO> total_entDTOList = total_entService.findAll(category);

        model.addAttribute("total_entList",total_entDTOList);

        return "total_ent/total_ent_main";
    }
    @GetMapping("total_ent_detail")
    public String Total_ent_detail(Total_entDTO total_entDTO,Model model){

        Total_entDTO totalEntDTO = total_entService.findByTseq(total_entDTO.getTseq());
        model.addAttribute("total_ent",totalEntDTO);

        return "total_ent/total_ent_detail";
    }

}
