package com.w.drug.web.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ApiModel
public class GeneralResult<T> {
    private String name;
    private T value;

    public GeneralResult(String name, T value) {
        this.name = name;
        this.value = value;
    }
}
