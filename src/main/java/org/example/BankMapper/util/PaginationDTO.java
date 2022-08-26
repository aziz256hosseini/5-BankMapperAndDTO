package org.example.BankMapper.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PaginationDTO<T> {

    private Long totalElements;
    private Integer totalPage;

    private List<T> data;
}
