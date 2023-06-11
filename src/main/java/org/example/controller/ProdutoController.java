package org.example.controller;

import org.example.models.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.example.service.ProdutoService;

@Controller
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(value = "view/produto", method = RequestMethod.GET)
    public ModelAndView getIndex(@ModelAttribute("message") final String message,
                                 @ModelAttribute("error") final String error) {

        ModelAndView mav = new ModelAndView("main");
        mav.addObject("listProduto", produtoService.getAllProduto());
        mav.addObject("message", message);
        mav.addObject("error", error);

        return mav;
    }

    @RequestMapping(value = "view/readProduto", method = RequestMethod.GET)
    public ModelAndView read() {
        return new ModelAndView("read", "listProduto", produtoService.getAllProduto());
    }

    @RequestMapping(value = "view/insertProduto", method = RequestMethod.GET)
    public ModelAndView insert() {

        ModelAndView mav = new ModelAndView("insert");
        mav.addObject("produto", new Produto());

        return mav;
    }

    @RequestMapping(value = "view/insertProduto", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("produto")Produto produto,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            produtoService.insertProduto(produto);
            redirectAttributes.addFlashAttribute("message", "Produto inserido!");
        }

        return "redirect:/view/produto";
    }

    @RequestMapping(value = "view/updateProduto", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {

        ModelAndView mav = new ModelAndView("update");
        mav.addObject("produto", produtoService.getProdutoById(id).get());

        return mav;
    }

    @RequestMapping(value = "view/updateProduto", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("produto") Produto produto,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            produtoService.updateProduto(produto);
            redirectAttributes.addFlashAttribute("message", "Produto atualizado!");
        }

        return "redirect:/view/produto";
    }

    @RequestMapping(value = "view/deleteProduto", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {

        ModelAndView mav = new ModelAndView("delete");
        mav.addObject("produto", produtoService.getProdutoById(id).get());

        return mav;
    }

    @RequestMapping(value = "view/deleteProduto", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("produto")Produto produto,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        } else {
            produtoService.deleteProdutoById(produto.getId());
            redirectAttributes.addFlashAttribute("message", "Produto Excluido!");
        }

        return "redirect:/view/produto";
    }
}
