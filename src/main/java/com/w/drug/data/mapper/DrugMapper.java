package com.w.drug.data.mapper;

import com.w.drug.data.model.Drug;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DrugMapper {
    @Select("select * from drugInfo where id=#{id}")
    List<Drug> getDrugById(@Param("id") int id);

    @Select("select * from drugInfo")
    List<Drug> getAllDrugs();

    @Select("select * from drugInfo where Contains(indication, keyword=#{keyword})")
    List<Drug> getDrugByKeywordInPerscription(@Param("keyword") String keyword);
}
