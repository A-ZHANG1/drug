package com.w.drug.logic.impl;

import com.w.drug.data.mapper.DrugMapper;
import com.w.drug.data.model.Drug;
import com.w.drug.web.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DrugService {
    @Autowired
    DrugMapper drugMapper;

    public List<Drug> getAllDrug() {
        List<Drug> list = drugMapper.getAllDrugs();
        return list;
    }

    public List<Drug> getDrugByKeyWordInPerscription(String keyword) {
        List<Drug> list = drugMapper.getDrugByKeywordInPerscription(keyword);
        return list;
    }
}
