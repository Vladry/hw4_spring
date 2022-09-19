package vlad.homework4.controller.account;

import vlad.homework4.DTO.account.AccountRequestDto;
import vlad.homework4.DTO.account.AccountTransferDto;
import vlad.homework4.DTO.account.ListAccountRequestDto;
import vlad.homework4.domain.Account;
import vlad.homework4.domain.Currency;
import vlad.homework4.domain.Customer;
import vlad.homework4.service.AccountService;
import vlad.homework4.service.CustomerService;
import vlad.homework4.service.dtoMappers.AccountRequestDtoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
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


    /*** TRANSFER endpoints ***/
    @PostMapping("/put-amount")
    public boolean putAmount(
            @RequestBody AccountTransferDto dto) {
        System.out.println("controller putAbount()-> ");
        boolean res = accService.putAmount(dto.getTo(), dto.getAmount());
        System.out.println("res: " + res);
        return res;
    }

    @PostMapping("/draw-amount")
    public boolean drawAmount(
            @RequestBody AccountTransferDto dto) {
        return accService.drawAmount(dto.getFrom(), dto.getAmount());
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
        return accService.getById(id).orElse(null);
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
