package com.sda.Final.Project.controller;

import com.sda.Final.Project.dto.ClientDTO;
import com.sda.Final.Project.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IClientService iClientService;

    @PostMapping
     public void  save(@RequestBody ClientDTO clientDTO){
        iClientService.save(clientDTO);
    }
//    @PutMapping
//    public  void update(@RequestBody ClientDTO clientDTO){
//        iClientService.update(clientDTO);
//    }
//
//    @GetMapping("/{id}")
//    public  ClientDTO findById(@PathVariable Integer id){
//        return iClientService.findById(id);
//    }
//    @GetMapping
//    public List<ClientDTO> findAll(){
//        return iClientService.findAll();
//    }
//    @DeleteMapping("/{id}")
//    public  void delete (@PathVariable("id") Integer id){
//        iClientService.delete(id);
//    }
}
