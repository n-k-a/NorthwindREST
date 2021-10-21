package org.sparta.northwindrest.controllers;

import org.sparta.northwindrest.entities.*;
import org.sparta.northwindrest.repositories.*;
import org.sparta.northwindrest.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ShipperController {
    private ShipperRepository shipperRepository;


    /* Look up how auto wired work, just to see how a case switch
     * would work for this instead of instantiating everything*/

    @Autowired
    public ShipperController(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }


    /*
        @GetMapping ("/shippers")
        @ResponseBody
        public List<OrderEntity> foundOrder(@RequestParam(required = false) String name){
        }*/
    @GetMapping("/shippers/{id}")
    public Optional<ShipperEntity> getShipperByID(@PathVariable Integer id) {
        return shipperRepository.findById(id);


    }
}