package edu.uph.ii.lab1.controllers;


import edu.uph.ii.lab1.models.Costume;
import edu.uph.ii.lab1.models.Order;
import edu.uph.ii.lab1.models.Price;
import edu.uph.ii.lab1.models.User;
import edu.uph.ii.lab1.repository.*;
import edu.uph.ii.lab1.service.UserServiceImpla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/costume")
public class CostumeController {

    @Autowired
    private CostumeRepository costumeRepository;

    @Autowired
    private CostumeTypeRepository costumeTypeRepository;
    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserServiceImpla userServiceImpla;

    @Autowired
    private StatusRepository  statusRepository;

    @GetMapping("/list")
    public String showlist(Model model) {
        model.addAttribute("list", costumeRepository.findAll());
        return "costume/list";
    }

    @GetMapping("/index")
    public String showindex(Model model) {

        return "costume/index";

    }

    @GetMapping("/account")
    public String showAccount(Model model) {
        model.addAttribute("list", orderRepository.findByUser(getLoggedUser()));
        model.addAttribute("user", userRepository.findAll());

        return "costume/client/account";
    }

    @GetMapping("/orderss")
    public String showorders(Model model) {
        model.addAttribute("orders",orderRepository.findAll());

        return "costume/admin/statusyzamowien";
    }

    @GetMapping("/accountall")
    public String showaccountall(Model model) {
        model.addAttribute("account", userRepository.findAll());
        return "costume/admin/allaccount";
    }

    @GetMapping("/kostium")
    public String showkostium(Model model) {

        model.addAttribute("costumes", costumeRepository.findAll());
        return "costume/kostium";
    }

    @GetMapping("/kontakt")
    public String showkontakt(Model model) {
        return "costume/kontakt";
    }

    @GetMapping("/cena")
    public String showcena(Model model) {
        model.addAttribute("cena", priceRepository.findAll());
        return "costume/cena";
    }

    @GetMapping("/logowanie")
    public String showlogowanie(Model model, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors() == true) {
            model.addAttribute("User", user);
            return "costume/logowanie";
        }
        model.addAttribute("user", new User());

        return "costume/logowanie";

    }
    @GetMapping("/rejestracja")
    public String newuser(Model model, @ModelAttribute("user") User user){

        return "/costume/rejestracja";

    }


    @PostMapping("zamowienie/{costume}")
    public String zam(Model model, @ModelAttribute("order") Order order,@PathVariable Costume costume){
        order.setCostume(costume);
        var status = statusRepository.findAll();
        int cena;
        cena = (costume.getPrice().getCost() * order.getHowLong())+costume.getPrice().getDeposit();
        order.setStatus(status.get(0));
        order.setCost(cena);
        order.setUser(getLoggedUser());
        orderRepository.saveAndFlush(order);

        return "costume/client/status1";

    }


    @ModelAttribute("zalogowany")
    protected User getLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        return userRepository.findByUsernameOrEmail(name);
    }


    @GetMapping("/zamowienia")
    public String showzamoweinia(Model model) {
        model.addAttribute("order", orderRepository.findAll());
        return "costume/admin/statusyzamowien";


    }
}
