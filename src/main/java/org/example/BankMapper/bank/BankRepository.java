package org.example.BankMapper.bank;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankRepository extends PagingAndSortingRepository <Bank,Long> {
}
