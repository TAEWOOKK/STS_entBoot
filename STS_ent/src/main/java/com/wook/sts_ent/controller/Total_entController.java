package com.wook.sts_ent.controller;

import com.wook.sts_ent.dto.Total_entDTO;
import com.wook.sts_ent.service.Total_entService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequiredArgsConstructor
@Slf4j
public class Total_entController {

    private final Total_entService total_entService;

    @GetMapping("total_ent_main")
    public String Total_entMain(@RequestParam("category") int category, Model model){

        List<Total_entDTO> total_entDTOList = total_entService.findByCategory(category);

        model.addAttribute("total_entList",total_entDTOList);

        return "total_ent/total_ent_main";
    }
    @GetMapping("total_ent_detail")
    public String Total_ent_detail(Total_entDTO total_entDTO,Model model){

        Total_entDTO totalEntDTO = total_entService.findByTseq(total_entDTO.getTseq());

        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");

        String formattedSDate = simpleDateFormat.format(totalEntDTO.getSdate());
        String formattedEDate = simpleDateFormat.format(totalEntDTO.getEdate());

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(totalEntDTO.getSeat());
        String seat = "";

        if (total_entDTO.getCategory() == 1) {

            int r = 0, a = 0, b = 0;

            if (matcher.find()) {
                r = Integer.parseInt(matcher.group());
            }

            if (matcher.find()) {
                a = Integer.parseInt(matcher.group());
            }

            if (matcher.find()) {
                b = Integer.parseInt(matcher.group());
            }

            seat = "R석 " + r + "석, A석 " + a + "석, B석 " + b + "석 ";
        }

        else if (total_entDTO.getCategory() == 2) {

            int width = 0;
            int height = 0;

            if (matcher.find()) {
                width = Integer.parseInt(matcher.group());
            }

            if (matcher.find()) {
                height = Integer.parseInt(matcher.group());
            }

            seat = String.valueOf(width * height) + " 석";
        }

        else {

            int am = 0;
            int pm = 0;

            if (matcher.find()) {
                am = Integer.parseInt(matcher.group());
            }

            if (matcher.find()) {
                pm = Integer.parseInt(matcher.group());
            }

            seat = "오전 : " + am + "명 , 오후 : " + pm + "명";
        }

        model.addAttribute("total_ent",totalEntDTO);
        model.addAttribute("formattedSDate", formattedSDate);
        model.addAttribute("formattedEDate", formattedEDate);
        model.addAttribute("seat", seat);

        return "total_ent/total_ent_detail";
    }

}
