package org.example.BankMapper.bank;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class BankService implements IBankService{


  private final   BankRepository repository;


    @Override
    public Bank save(Bank bank) {

        return repository.save(bank);
    }

    @Override
    public Bank getById(Long id) {
        Optional<Bank> optionalBank = repository.findById(id);
        if (!optionalBank.isPresent()){

            //
        }


        return optionalBank.get();
    }

    @Override
    public List<Bank> getAll() {
        return (List<Bank>) repository.findAll();
    }

    @Override
    public Page<Bank> getAllWithPage(int page, int pageSize) {

        Pageable firstPageWithTwoElements = PageRequest.of(page, pageSize);

        return repository.findAll(firstPageWithTwoElements);
    }
}
