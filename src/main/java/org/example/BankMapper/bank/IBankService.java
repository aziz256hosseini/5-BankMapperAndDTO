package org.example.BankMapper.bank;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IBankService {


    Bank save(Bank bank);
    Bank getById(Long id);
    List<Bank> getAll();
    Page<Bank> getAllWithPage(int page, int pageSize);


}
