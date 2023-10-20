package com.vivo.fabricachocolate.chocolates.api;

import com.vivo.fabricachocolate.chocolates.dto.ChocolateDTO;
import com.vivo.fabricachocolate.chocolates.facade.ChocolatesFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/chocolates", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChocolatesAPI {
    @Autowired
    private ChocolatesFacade chocolatesFacade;

    @PostMapping
    @ResponseBody
    public ChocolateDTO adicionar(@RequestBody ChocolateDTO chocolateDTO) {
        return chocolatesFacade.adicionar(chocolateDTO);
    }

    @GetMapping
    @ResponseBody
    public List<ChocolateDTO> getAll() {
        return chocolatesFacade.getAll();
    }
}
