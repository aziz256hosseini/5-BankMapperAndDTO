package org.example.BankMapper.bank;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.BankMapper.util.PaginationDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")

@AllArgsConstructor
@Api(tags = "Tag1")
@Tag(name = "BankController", description = "My Custom Description")

public class BankController {
   private final IBankService bankService;
   private final BankMapper bankMapper;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success|OK"),
            @ApiResponse(responseCode = "201", description = "create"),
            @ApiResponse(responseCode = "409", description = "not found"),})


    @PostMapping("/v1")
    public ResponseEntity<Void> saveNew(@RequestBody BankDTO bankDTO){

   Bank bank=bankMapper.toBank(bankDTO);

       bankService.save(bank) ;

     return    ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<BankDTO> getById(@PathVariable Long id){

   Bank bank=     bankService.getById(id);


BankDTO bankDTO=bankMapper.toBankDTO(bank);


     return    ResponseEntity.ok(bankDTO);

    }


    @GetMapping("/v1")
    public ResponseEntity<List<BankDTO>> getAll(){

  List<Bank> banks=bankService.getAll();
  List<BankDTO> bankDTOs=bankMapper.toBankDTOS(banks);



     return    ResponseEntity.ok(bankDTOs);

    }


    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PaginationDTO> getAllWithPage(@PathVariable(name = "page") int page, @PathVariable(name = "size") int size){

  Page<Bank> bankPage=bankService.getAllWithPage(page,size);

    int totalPage=    bankPage.getTotalPages();
      Long totalElement=  bankPage.getTotalElements();

       List<Bank> banks= bankPage.getContent();


  List<BankDTO> bankDTOs=bankMapper.toBankDTOS(banks);

        PaginationDTO<BankDTO> paginationDTO=new PaginationDTO<>(totalElement,totalPage,bankDTOs);



     return    ResponseEntity.ok(paginationDTO);

    }


}
