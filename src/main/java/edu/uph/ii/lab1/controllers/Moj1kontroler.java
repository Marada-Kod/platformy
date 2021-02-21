package edu.uph.ii.lab1.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.script.ScriptContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Moj1kontroler {



    @GetMapping("/test.html")
    public void MetodaKontorlera(HttpServletResponse response)throws IOException {

        response.getWriter().write("Odpowiedz kontrolera" + this.getClass().getName());

    }

        @GetMapping("/test2.html")
        public String dwaMetodaKontorlera(Model model){
            model.addAttribute("wiadomosc", "odpowiedz 2");
            return "widok";
    }



    @GetMapping("/test3.html")
    public ModelAndView trzyMetodaKontorlera(ModelAndView mav){
        mav.setViewName("widokdwa");
        mav.addObject("wiadomosc2", "odpowiedz 3");
        return mav;
    }


    @RequestMapping(value="/form.html", method={RequestMethod.GET, RequestMethod.POST})
    public ModelAndView firstMethod4(HttpServletRequest request) throws IOException {
        ModelAndView nav = new ModelAndView();
        nav.setViewName("podsumowanie");
        nav.addObject("wynik", request.getParameter("wynik1"));

        return nav;
    }

}
