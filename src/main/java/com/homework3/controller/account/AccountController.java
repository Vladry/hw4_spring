package com.homework3.controller.account;

import com.homework3.DTO.account.AccountRequestDto;
import com.homework3.DTO.account.AccountTransferDto;
import com.homework3.DTO.account.ListAccountRequestDto;
import com.homework3.domain.Account;
import com.homework3.domain.Currency;
import com.homework3.domain.Customer;
import com.homework3.service.AccountService;
import com.homework3.service.CustomerService;
import com.homework3.service.dtoMappers.AccountRequestDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accService;
    private final CustomerService customerService;
    private final AccountRequestDtoMapper accReqDtoMapper;

    public AccountController(AccountService accService,
                             CustomerService customerService,
                             AccountRequestDtoMapper accReqDtoMapper) {
        this.accService = accService;
        this.customerService = customerService;
        this.accReqDtoMapper = accReqDtoMapper;
    }


    /*** TRANSVER endpoints ***/
    @PostMapping("/put-amount")
    public boolean putAmount(
            @RequestBody AccountTransferDto dto) {
        return accService.putAmount(dto.getAccNumber(), dto.getAmount());
    }

    @PostMapping("/draw-amount")
    public boolean drawAmount(
            @RequestBody AccountTransferDto dto) {
        return accService.drawAmount(dto.getAccNumber(), dto.getAmount());
    }

    @PostMapping("/transfer-amount")
    public boolean transferAmount(
            @RequestBody AccountTransferDto dto) {
        return accService.transferAmount(dto.getFrom(), dto.getTo(), dto.getAmount());
    }


    /*** CREATE endpoints ***/
    @PostMapping
    public Account create(
            @RequestBody AccountRequestDto a) {
        Currency[] cur = Currency.values();
        Customer c;
        Account ac = null;
        try {
            c = customerService.getById(a.getId());
            ac = new Account(cur[a.getCurrency()], a.getBalance(), c);
            accService.save(ac);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such customer in database!");
        }
        return ac;
    }

    @PostMapping("/all")
    public void saveAll(
            @RequestBody ListAccountRequestDto dtoR) {
        List<AccountRequestDto> laR = dtoR.getList();
        List<Account> la = laR.stream().map(dto -> {
            Account a = accReqDtoMapper.convertToEntity(dto);
            System.out.println("in controller, account: " + a);
            accReqDtoMapper.decorateEntity(a, dto);
            return a;
        }).collect(Collectors.toList());
        accService.saveAll(la);
    }


    /*** RETRIEVE endpoints ***/
    @GetMapping("all")
    public List<Account> findAll() {
        return accService.findAll();
    }

    @GetMapping("/{id}")
    public Account getById(
            @PathVariable("id") Long id) {
        return accService.getById(id);
    }


    /*** DELETE endpoints ***/
    @DeleteMapping("/all")
    public void deleteAll(
            @RequestBody List<Account> la) {
        accService.deleteAll(la);
    }


    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") Long id) {
        accService.deleteById(id);
    }


}
