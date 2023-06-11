package org.example.controller;

import org.example.models.Loja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.example.service.LojaService;


@Controller
public class LojaController {

    @Autowired
    LojaService lojaService;

    @RequestMapping(value = "view/loja", method = RequestMethod.GET)
    public ModelAndView getIndex(@ModelAttribute("message") final String message,
                                 @ModelAttribute("error") final String error) {

        ModelAndView mav = new ModelAndView("main");
        mav.addObject("listLoja", lojaService.getAllLoja());
        mav.addObject("message", message);
        mav.addObject("error", error);

        return mav;
    }

    @RequestMapping(value = "view/readLoja", method = RequestMethod.GET)
    public ModelAndView read() {
        return new ModelAndView("read", "listLoja", lojaService.getAllLoja());
    }

    @RequestMapping(value = "view/insertLoja", method = RequestMethod.GET)
    public ModelAndView insert() {

        ModelAndView mav = new ModelAndView("insert");
        mav.addObject("loja", new Loja());

        return mav;
    }

    @RequestMapping(value = "view/insertLoja", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("loja")Loja loja,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            lojaService.insertLoja(loja);
            redirectAttributes.addFlashAttribute("message", "Loja inserida!");
        }

        return "redirect:/view/loja";
    }

    @RequestMapping(value = "view/updateLoja", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {

        ModelAndView mav = new ModelAndView("update");
        mav.addObject("loja", lojaService.getLojaById(id).get());

        return mav;
    }

    @RequestMapping(value = "view/updateLoja", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("loja")Loja loja,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            lojaService.updateLoja(loja);
            redirectAttributes.addFlashAttribute("message", "Loja atualizada!");
        }

        return "redirect:/view/loja";
    }

    @RequestMapping(value = "view/deleteLoja", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {

        ModelAndView mav = new ModelAndView("delete");
        mav.addObject("loja", lojaService.getLojaById(id).get());

        return mav;
    }

    @RequestMapping(value = "view/deleteLoja", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("loja")Loja loja,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            lojaService.deleteLojaById(loja.getId());
            redirectAttributes.addFlashAttribute("message", "Loja Excluida!");
        }

        return "redirect:/view/loja";
    }
}