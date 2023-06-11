package org.example.controller;

import org.example.models.CarrinhoDeCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.example.service.CarrinhoDeComprasService;


@Controller
public class CarrinhoDeComprasController {

    @Autowired
    CarrinhoDeComprasService carrinhoDeComprasService;

    @RequestMapping(value = "view/carrinhoDeCompras", method = RequestMethod.GET)
    public ModelAndView getIndex(@ModelAttribute("message") final String message,
                                 @ModelAttribute("error") final String error) {

        ModelAndView mav = new ModelAndView("main");
        mav.addObject("listCarrinhoDeCompras", carrinhoDeComprasService.getAllCarrinhoDeCompras());
        mav.addObject("message", message);
        mav.addObject("error", error);

        return mav;
    }

    @RequestMapping(value = "view/readCarrinhoDeCompras", method = RequestMethod.GET)
    public ModelAndView read() {
        return new ModelAndView("read", "listCarrinhoDeCompras", carrinhoDeComprasService.getAllCarrinhoDeCompras());
    }

    @RequestMapping(value = "view/insertCarrinhoDeCompras", method = RequestMethod.GET)
    public ModelAndView insert() {

        ModelAndView mav = new ModelAndView("insert");
        mav.addObject("carrinhoDeCompras", new CarrinhoDeCompras());

        return mav;
    }

    @RequestMapping(value = "view/insertCarrinhoDeCompras", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("carrinhoDeCompras")CarrinhoDeCompras carrinhoDeCompras,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            carrinhoDeComprasService.insertCarrinhoDeCompras(carrinhoDeCompras);
            redirectAttributes.addFlashAttribute("message", "CarrinhoDeCompras inserido!");
        }

        return "redirect:/view/CarrinhoDeCompras";
    }

    @RequestMapping(value = "view/updateCarrinhoDeCompras", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {

        ModelAndView mav = new ModelAndView("update");
        mav.addObject("carrinhoDeCompras", carrinhoDeComprasService.getCarrinhoDeComprasById(id).get());

        return mav;
    }

    @RequestMapping(value = "view/updateCarrinhoDeCompras", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("carrinhoDeCompras")CarrinhoDeCompras carrinhoDeCompras,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            carrinhoDeComprasService.updateCarrinhoDeCompras(carrinhoDeCompras);
            redirectAttributes.addFlashAttribute("message", "Carrinho De Compras atualizado!");
        }

        return "redirect:/view/carrinhoDeCompras";
    }

    @RequestMapping(value = "view/deleteCarrinhoDeCompras", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {

        ModelAndView mav = new ModelAndView("delete");
        mav.addObject("carrinhoDeCompras", carrinhoDeComprasService.getCarrinhoDeComprasById(id).get());

        return mav;
    }

    @RequestMapping(value = "view/deleteCarrinhoDeCompras", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("carrinhoDeCompras")CarrinhoDeCompras carrinhoDeCompras,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            carrinhoDeComprasService.deleteCarrinhoDeComprasById(carrinhoDeCompras.getId());
            redirectAttributes.addFlashAttribute("message", "Carrinho De Compras Excluido!");
        }

        return "redirect:/view/carrinhoDeCompras";
    }
}
