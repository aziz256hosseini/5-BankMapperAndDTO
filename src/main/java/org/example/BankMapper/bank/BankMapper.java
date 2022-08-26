package org.example.BankMapper.bank;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankMapper {


    Bank toBank (BankDTO bankDTO);

    BankDTO toBankDTO (Bank bank);

    List<BankDTO> toBankDTOS (List<Bank> banks);
    List<Bank> toBanks (List<BankDTO> bankDTOS);



}
