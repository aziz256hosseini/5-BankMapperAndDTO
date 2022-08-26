package org.example.BankMapper.bank;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class BankDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;


    @NotNull
    @NotBlank
    @ApiModelProperty(required = true, hidden = false)
    private String title;



}
