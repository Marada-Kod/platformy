package edu.uph.ii.lab1.configuration;


import edu.uph.ii.lab1.models.*;
import edu.uph.ii.lab1.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
public class InsertData {

    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CostumeRepository costumeRepository;

    @Autowired
    private CostumeTypeRepository costumeTypeRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RoleRepository roleRepository;

    public static List<CostumeRepository> costumeList;
    @Bean
    InitializingBean init() {

        return () -> {



            if (costumeRepository.findAll().isEmpty()) {

                var costium1 = new CostumeType();
                costium1.setName("Dla Dzieci");
                costumeTypeRepository.save(costium1);

                var costium2 = new CostumeType();
                costium2.setName("Dla Dorosłych");
                costumeTypeRepository.save(costium2);

                costumeTypeRepository.flush();

                var gender1 = new Gender();
                gender1.setName("Mężczyzna");
                genderRepository.save(gender1);

                var gender2 = new Gender();
                gender2.setName("Kobieta");
                genderRepository.save(gender2);


                genderRepository.flush();

                var categories1 = new Categories();
                categories1.setName_costume("Bajki");
                categoriesRepository.save(categories1);

                var categories2 = new Categories();
                categories2.setName_costume("Filmy");
                categoriesRepository.save(categories2);

                var categories3 = new Categories();
                categories3.setName_costume("Dziki Zachód");
                categoriesRepository.save(categories3);


                var categories4 = new Categories();
                categories4.setName_costume("Super Bohaterowie");
                categoriesRepository.save(categories4);

                var categories5 = new Categories();
                categories5.setName_costume("Zawody");
                categoriesRepository.save(categories5);

                var categories6 = new Categories();
                categories6.setName_costume("Zwierzęta");
                categoriesRepository.save(categories6);

                var categories7 = new Categories();
                categories7.setName_costume("Lata 20-90");
                categoriesRepository.save(categories7);

                categoriesRepository.flush();

                var size1 = new Size();
                size1.setName_size("do 100cm");
                sizeRepository.save(size1);

                var size2 = new Size();
                size2.setName_size("od 100cm do 125cm");
                sizeRepository.save(size2);


                var size4 = new Size();
                size4.setName_size("od 125cm do 155cm");
                sizeRepository.save(size4);

                var size5 = new Size();
                size5.setName_size("od 155cm do 170cm");
                sizeRepository.save(size5);

                var size6 = new Size();
                size6.setName_size("od 170cm do 185cm");
                sizeRepository.save(size6);

                var size7 = new Size();
                size7.setName_size("od 185cm do 200cm");
                sizeRepository.save(size7);

                sizeRepository.flush();

                var price1 = new Price();
                price1.setName_price("Dorosły Kostium");
                price1.setCost(25);
                price1.setDeposit(45);
                priceRepository.save(price1);

                var price2 = new Price();
                price2.setName_price("Dzieciecy Kostium");
                price2.setCost(15);
                price2.setDeposit(30);
                priceRepository.save(price2);

                var price3 = new Price();
                price3.setName_price("Promocja");
                price3.setCost(10);
                price3.setDeposit(20);
                priceRepository.save(price3);



                priceRepository.flush();

                costumeRepository.save(Costume.create("Batman", "Opis", 1, costium2, gender1, price1, size1, categories1));
                costumeRepository.save(Costume.create("Flash", "Nowy Opisgg", 1, costium2, gender1, price1, size4, categories4));
                costumeRepository.save(Costume.create("Arrow", "opisasdsf", 1, costium2, gender1, price1, size7, categories1));
                costumeRepository.save(Costume.create("SuperGirl", "opisassd", 1, costium2, gender1, price2, size2, categories1));
                costumeRepository.save(Costume.create("WonderWomen", "opisassdf", 1, costium2, gender1, price3, size6, categories1));


                costumeRepository.save(Costume.create("Batman", "Opisdf", 1, costium1, gender2, price1, size1, categories1));
                costumeRepository.save(Costume.create("Flash", "Opissdf", 1, costium1, gender2, price1, size1, categories1));
                costumeRepository.save(Costume.create("Arrow", "Opissdf", 1, costium1, gender2, price1, size1, categories1));
                costumeRepository.save(Costume.create("SuperGirl", "Opisdsf", 1, costium1, gender2, price1, size1, categories1));
                costumeRepository.save(Costume.create("WonderWomen", "Opissd", 1, costium1, gender2, price1, size1, categories1));


                costumeRepository.flush();

            }








            if (userRepository.findAll().isEmpty()) {
                var role1 = new Role();

                role1.setRoleName("ROLE_ADMIN");
                roleRepository.save(role1);
                var role2 = new Role();
                role2.setRoleName("ROLE_USER");
                roleRepository.save(role2);
                roleRepository.flush();


                var account = new User();
                account.setFirst_name("Adam");
                account.setLast_name("Adam1");
                account.setUsername("user");
                account.setAddress("Adam12");
                account.setPostcode("08-110 Siedlce");
                account.setEmail("email@gmail.com");
                account.setPassword(bCryptPasswordEncoder().encode("user1"));
                account.setRole(role2);
                userRepository.save(account);
                userRepository.flush();

                var account1 = new User();
                account1.setFirst_name("Adam");
                account1.setLast_name("Adam1");
                account1.setUsername("admin");
                account1.setAddress("Adam12");
                account1.setPostcode("08-110 Siedlce");
                account1.setEmail("admin@gmail.com");
                account1.setPassword(bCryptPasswordEncoder().encode("admin"));
                account1.setRole(role1);
                userRepository.save(account1);
                userRepository.flush();

                var status1 = new Status();
                status1.setName_status("Zamówione");
                statusRepository.save(status1);

                var status2 = new Status();
                status2.setName_status("W przygotowaniu");
                statusRepository.save(status2);

                var status3 = new Status();
                status3.setName_status("Wysłane");
                statusRepository.save(status3);

                var status4 = new Status();
                status4.setName_status("Wydane");
                statusRepository.save(status4);

                var status5 = new Status();
                status4.setName_status("Zwrócone");
                statusRepository.save(status4);


                statusRepository.flush();


            }




        };
    }
}



