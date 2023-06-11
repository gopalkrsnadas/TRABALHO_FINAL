package org.example.controller;

import org.example.models.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.example.service.VendaService;

@Controller
public class VendaController {

    @Autowired
    VendaService vendaService;

    @RequestMapping(value = "view/venda", method = RequestMethod.GET)
    public ModelAndView getIndex(@ModelAttribute("message") final String message,
                                 @ModelAttribute("error") final String error) {

        ModelAndView mav = new ModelAndView("main");
        mav.addObject("listVenda", vendaService.getAllVenda());
        mav.addObject("message", message);
        mav.addObject("error", error);

        return mav;
    }

    @RequestMapping(value = "view/readVenda", method = RequestMethod.GET)
    public ModelAndView read() {
        return new ModelAndView("read", "listVenda", vendaService.getAllVenda());
    }

    @RequestMapping(value = "view/insertVenda", method = RequestMethod.GET)
    public ModelAndView insert() {

        ModelAndView mav = new ModelAndView("insert");
        mav.addObject("venda", new Venda());

        return mav;
    }

    @RequestMapping(value = "view/insertVenda", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("aluno")Venda venda,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            vendaService.insertVenda(venda);
            redirectAttributes.addFlashAttribute("message", "Venda inserida!");
        }

        return "redirect:/view/venda";
    }

    @RequestMapping(value = "view/updateVenda", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {

        ModelAndView mav = new ModelAndView("update");
        mav.addObject("venda", vendaService.getVendaById(id).get());

        return mav;
    }

    @RequestMapping(value = "view/updateVenda", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("venda")Venda venda,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            vendaService.updateVenda(venda);
            redirectAttributes.addFlashAttribute("message", "Venda atualizada!");
        }

        return "redirect:/view/alunos";
    }

    @RequestMapping(value = "view/deleteVenda", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {

        ModelAndView mav = new ModelAndView("delete");
        mav.addObject("venda", vendaService.getVendaById(id).get());

        return mav;
    }

    @RequestMapping(value = "view/deleteVenda", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("venda")Venda venda,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            vendaService.deleteVendaById(venda.getId());
            redirectAttributes.addFlashAttribute("message", "Venda Excluida!");
        }

        return "redirect:/view/venda";
    }
}
