package com.vivo.fabricachocolate.chocolates.facade;

import com.vivo.fabricachocolate.chocolates.dto.ChocolateDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChocolatesFacade {
    private static final Map<Long, ChocolateDTO> chocolates = new HashMap<>();
    //private long chocolateContagem = 1;

    public ChocolateDTO adicionar(ChocolateDTO chocolateDTO) {

            if(tituloExistente(String.valueOf(chocolateDTO))) {return null;}

            Long incrementoId = chocolates.keySet().size() + 1L;
            chocolateDTO.setId(incrementoId);
            chocolates.put(incrementoId, chocolateDTO);
            return chocolateDTO;
    }

    public ChocolateDTO getById (Long chocolateId) {
        return chocolates.get(chocolateId);
    }

    public List<ChocolateDTO> getAll() {
        return new ArrayList<>(chocolates.values());
    }

    private boolean tituloExistente(String titulo) {
        return chocolates.values().stream().anyMatch(chocolate -> chocolate.getTitulo().equals(titulo));
    }
}
