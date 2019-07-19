package com.w.drug.web.controller;

import com.w.drug.data.model.Drug;
import com.w.drug.logic.impl.DrugService;
import com.w.drug.web.response.GeneralResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/drug")
@Api(value = "Drug Management API", produces = "application/json")
public class DrugController {
    @Autowired
    DrugService drugService;

    @GetMapping("/getAllDrug")
    @ResponseBody
    public GeneralResponse<List<Drug>> getAllDrug() {
        List<Drug> drugList = drugService.getAllDrug();

        GeneralResponse<List<Drug>> resp = new GeneralResponse<List<Drug>>();
        resp.setObj(drugList);
        return resp;
    }

    @GetMapping("/getDrugByKeyWordInPerscription")
    @ResponseBody
    public GeneralResponse<List<Drug>> getDrugByKeyWordInPerscription(String keyword) {
        List<Drug> drugList = drugService.getDrugByKeyWordInPerscription(keyword);

        GeneralResponse<List<Drug>> resp = new GeneralResponse<List<Drug>>();
        resp.setObj(drugList);
        return resp;
    }
}
