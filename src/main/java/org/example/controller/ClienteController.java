package org.example.controller;

import org.example.models.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.example.service.ClienteService;

//@Controller = Define uma classe que contém métodos para estrutura Spring MVC
@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    //@RequestMapping = Mapeia requisições REST
    //@ModelAttribute = Define o atributo modelAttribute que será utilizado em um form HTML
    //@PathVariable = Permite receber parâmetros via {} em uma requisição

    @RequestMapping(value = "view/cliente", method = RequestMethod.GET)
    public ModelAndView getIndex(@ModelAttribute("message") final String message,
                                 @ModelAttribute("error") final String error) {

        ModelAndView mav = new ModelAndView("main");
        mav.addObject("listCliente", clienteService.getAllCliente());
        mav.addObject("message", message);
        mav.addObject("error", error);

        return mav;
    }

    @RequestMapping(value = "view/readCliente", method = RequestMethod.GET)
    public ModelAndView read() {
        return new ModelAndView("read", "listCliente", clienteService.getAllCliente());
    }

    @RequestMapping(value = "view/insert", method = RequestMethod.GET)
    public ModelAndView insert() {

        ModelAndView mav = new ModelAndView("insert");
        mav.addObject("cliente", new Cliente());

        return mav;
    }

    @RequestMapping(value = "view/insertCliente", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("cliente")Cliente cliente,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            clienteService.insertCliente(cliente);
            redirectAttributes.addFlashAttribute("message", "Cliente inserido!");
        }

        return "redirect:/view/cliente";
    }

    @RequestMapping(value = "view/updateCliente", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {

        ModelAndView mav = new ModelAndView("update");
        mav.addObject("cliente", clienteService.getClienteById(id).get());

        return mav;
    }

    @RequestMapping(value = "view/updateCliente", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("cliente") Cliente cliente,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            clienteService.updateCliente(cliente);
            redirectAttributes.addFlashAttribute("message", "Cliente atualizado!");
        }

        return "redirect:/view/cliente";
    }

    @RequestMapping(value = "view/deleteCliente", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {

        ModelAndView mav = new ModelAndView("delete");
        mav.addObject("cliente", clienteService.getClienteById(id).get());

        return mav;
    }

    @RequestMapping(value = "view/deleteCliente", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("cliente")Cliente cliente,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            clienteService.deleteClienteById(cliente.getId());
            redirectAttributes.addFlashAttribute("message", "Cliente Excluido!");
        }

        return "redirect:/view/cliente";
    }
}
