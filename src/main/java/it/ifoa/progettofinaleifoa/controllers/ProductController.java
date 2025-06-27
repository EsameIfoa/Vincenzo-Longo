package it.ifoa.progettofinaleifoa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.ifoa.progettofinaleifoa.models.Product;
import it.ifoa.progettofinaleifoa.repositories.CategoryRepository;
import it.ifoa.progettofinaleifoa.services.CrudService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private CrudService<Product, Long> productService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String indexProduct(Model viewModel){
        viewModel.addAttribute("title", "Tutti i prodotti");
        viewModel.addAttribute("products", productService.readAll());
        return "products";
    }

    //COMPLETA
    //COMPLETA LA CLASSE CON GLI HANDLER MANCANTI
    //CREATE - STORE - EDIT - UPDATE
    //NON DIMENTICARE I MAPPING GET E POST CORRISPONDENTI


    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id){
        productService.delete(id);
        return "redirect:/products";
    }
}