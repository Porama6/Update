package com.mssql.test.controllers;


import java.util.List;
import java.util.Optional;

import com.mssql.test.entities.Cosmetic;
import com.mssql.test.services.CosmeticService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cosmetic")  
@Api(value="cosmeticstore", description="Operation to define cosmetic for customer.")

public class CosmeticController {

    @Autowired
    private CosmeticService cosmeticService;
    @ApiOperation(value = "View a list of available products",response = Cosmetic.class, notes = "Show Cosmetics in Lists")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping("/list")
    public List<Cosmetic> getAllCosmetics() {
        List<Cosmetic> cosmetics = cosmeticService.getAllCosmetics();
        return cosmetics;
    }

    @ApiOperation(value = "Put Cosmetic in Basket", notes = "Show Cosmetic in Basket By product ID",response = Cosmetic.class)
    @RequestMapping("/show/{id}")
    public Optional<Cosmetic> getCosmeticById(
        @ApiParam(value = "Product ID", required = true) 
        @PathVariable String id) {
        return cosmeticService.getCosmeticById(id);
    }

    @ApiOperation(value = "Put Cosmetic ID in Basket", notes = "Delete Cosmetic in Basket By product ID")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCosmetics(  
        @ApiParam(value = "Product ID", required = true) 
        @PathVariable String id){
        List<Cosmetic> cosmetics= cosmeticService.getAllCosmetics();
        
        for(int i=0; i<cosmetics.size(); i++){
            if(cosmetics.get(i).getId().equals(id)){
                System.out.println(cosmetics.get(i).getId()+"\n"+cosmetics.toString());
                cosmeticService.deleteCosmetic(cosmetics.get(i).getId());
                break;
            }
        }
    }

    @ApiOperation(value = "Delete all Cosmetic", notes = "Delete All Cosmetic")
    @RequestMapping(value = "/clear", method = RequestMethod.DELETE)
    public void deleteAllCosmetic(){
        List<Cosmetic> cosmetics= cosmeticService.getAllCosmetics();
        cosmeticService.deleteAllCosmetic(cosmetics);
    }

    @ApiOperation(value = "Add Cosmetic Product", notes = "Add Cosmetic Product you want to buy")
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public void addCosmetic(@RequestBody List<Cosmetic> cosmetics){
        cosmeticService.addCosmetic(cosmetics);
    }


}