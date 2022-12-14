package vlad.homework4.controller.account;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/put-amount")
    public boolean putAmount(
            @RequestBody AccountTransferDto dto) {
        System.out.println("controller putAbount()-> ");
        boolean res = accService.putAmount(dto.getTo(), dto.getAmount());
        System.out.println("res: " + res);
        return res;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/draw-amount")
    public boolean drawAmount(
            @RequestBody AccountTransferDto dto) {
        return accService.drawAmount(dto.getFrom(), dto.getAmount());
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/transfer-amount")
    public boolean transferAmount(
            @RequestBody AccountTransferDto dto) {
        return accService.transferAmount(dto.getFrom(), dto.getTo(), dto.getAmount());
    }


    /*** CREATE endpoints ***/
    @PreAuthorize("hasRole('USER')")
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

    @PreAuthorize("hasRole('USER')")
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
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/all")
    public List<Account> findAll() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication: " + auth);
        return accService.findAll();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public Account getById(
            @PathVariable("id") Long id) {
        return accService.getById(id).orElse(null);
    }


    /*** DELETE endpoints ***/
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/all")
    public void deleteAll(
            @RequestBody List<Account> la) {
        accService.deleteAll(la);
    }


    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") Long id) {
        accService.deleteById(id);
    }


}
