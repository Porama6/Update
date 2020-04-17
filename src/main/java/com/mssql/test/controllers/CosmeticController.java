package com.mssql.test.controllers;


import java.util.List;
import java.util.Optional;

import com.mssql.test.entities.Cosmetic;
import com.mssql.test.services.CosmeticService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CosmeticController {

    @Autowired
    private CosmeticService cosmeticService;

   
    @RequestMapping("/cosmetic")
    public List<Cosmetic> getAllCosmetics() {
        List<Cosmetic> cosmetics = cosmeticService.getAllCosmetics();
        return cosmetics;
    }

    @ApiOperation(value = "Show Cosmetic in Basket", notes = "Show Cosmetic in Basket By product ID")
    @RequestMapping("/cosmetic/{id}")
    public Optional<Cosmetic> getCosmeticById(
        @ApiParam(value = "Product ID", required = true) 
        @PathVariable String id) {
        return cosmeticService.getCosmeticById(id);
    }


    @RequestMapping(value = "/cosmetic/{id}", method = RequestMethod.DELETE)
    public void deleteCosmetics(@PathVariable String id){
        List<Cosmetic> cosmetics= cosmeticService.getAllCosmetics();
        
        for(int i=0; i<cosmetics.size(); i++){
            if(cosmetics.get(i).getId().equals(id)){
                System.out.println(cosmetics.get(i).getId()+"\n"+cosmetics.toString());
                cosmeticService.deleteCosmetic(cosmetics.get(i).getId());
                break;
            }
        }
    }

    @RequestMapping(value = "/cosmetic/clear", method = RequestMethod.DELETE)
    public void deleteAllCosmetic(){
        List<Cosmetic> cosmetics= cosmeticService.getAllCosmetics();
        cosmeticService.deleteAllCosmetic(cosmetics);
    }


    @RequestMapping(value="/cosmetic", method = RequestMethod.POST)
    public void addCosmetic(@RequestBody List<Cosmetic> cosmetics){
        cosmeticService.addCosmetic(cosmetics);
    }


}