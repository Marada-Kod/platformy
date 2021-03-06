package edu.uph.ii.lab1.controllers;

import edu.uph.ii.lab1.models.*;
import edu.uph.ii.lab1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SingleCostumeController {



    @Autowired
    private CostumeRepository costumeRepository;
    @Autowired
    private CostumeTypeRepository costumeTypeRepository ;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PriceRepository  priceRepository;
    @Autowired
    private GenderRepository  genderRepository;
    @Autowired
    private CategoriesRepository  categoriesRepository;

    @Autowired
    private SizeRepository  sizeRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StatusRepository statusRepository;


    @GetMapping({"/costumee/{costume}"})
    public String home(Model model, @PathVariable Costume costume) {

        model.addAttribute("costume", costume);
        return "costume/kostium1";
    }
    @GetMapping({"/order/{order}"})
    public String home(Model model, @PathVariable Order order,Status status) {
        model.addAttribute("order", order);
        model.addAttribute("status", status);
        return "costume/admin/status";
    }



    @GetMapping({"/costumeee/{costume}"})
    public String order2(Model model, @PathVariable Costume costume,@ModelAttribute("order") Order order,BindingResult bindingResult) {

        if (bindingResult.hasErrors()==true) {

            return "costume/client/zamowienie";
        }
        model.addAttribute("order",order);
        model.addAttribute("costume", costume);
        return "costume/client/zamowienie";
    }

    @GetMapping({"/dodaj"})
    public String dodaj(Model model) {


        model.addAttribute("costume", new Costume());

        return "costume/admin/dodawanie";
    }

    @PostMapping("/send")
    public String saveBook(Model model, @ModelAttribute("costume") @Valid Costume costume, BindingResult bindingResult) {

        if (bindingResult.hasErrors()==true) {

            return "costume/admin/dodawanie";
        }


        costumeRepository.saveAndFlush(costume);

        model.addAttribute("costume", new Costume());
        return "redirect:/dodaj";
    }


    @PostMapping("costume/sendlog")
    public String savelog(Model model, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        if ( bindingResult.hasErrors()==true) {
            model.addAttribute("User", user);
            return "costume/rejestracja";
        }
       //??? user.setRole();
        userRepository.saveAndFlush(user);
        model.addAttribute("user", new User());
        return "costume/logowanie";
    }


    @PostMapping("costumee/savee1/{id}")
    public String savee(Model model, @ModelAttribute("costume") Costume costume, @PathVariable long id){
        costume.setId(id);
        costumeRepository.saveAndFlush(costume);
        model.addAttribute("costume",costume);

        return "redirect:/costume/kostium";

    }

    @PostMapping("orders/save/{order}")
    public String saveordes(Model model, @ModelAttribute("order") Order order){

        orderRepository.saveAndFlush(order);


        return "redirect:/costume/orderss";

    }


    @PostMapping("costume/order/{id}")
    public String order(Model model, @ModelAttribute("order") Order order, @PathVariable long id){
        model.addAttribute("order", new Order());
        return "redirect:/costume/kostium";
    }

    @PostMapping("delet/{id}")
    public String delet(@PathVariable long id){

        costumeRepository.deleteById(id);
        costumeRepository.flush();

        return "redirect:/costume/kostium";

    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable long id){

        orderRepository.deleteById(id);
        orderRepository.flush();

        return "redirect:/costume/kostium";

    }




    @ModelAttribute("type_list")
    public List<CostumeType> costumeTypeList() {

        return costumeTypeRepository.findAll();
    }

    @ModelAttribute("price_list")
    public List<Price> priceList(){

        return priceRepository.findAll();

    }

    @ModelAttribute("gender_list")
    public List<Gender> genderList(){

        return genderRepository.findAll();

    }

    @ModelAttribute("categories_list")
    public List<Categories> categoriesList(){

        return categoriesRepository.findAll();

    }

    @ModelAttribute("size_list")
    public List<CostumeSize> sizeList(){

        return sizeRepository.findAll();

    }

    @ModelAttribute("status_list")
    public List<Status> statusList() {

        return statusRepository.findAll();
    }

}

