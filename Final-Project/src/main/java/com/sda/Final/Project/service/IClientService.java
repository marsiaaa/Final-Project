package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.ClientDTO;


import java.util.List;

public interface IClientService {
    void save(ClientDTO clientDTO) ;
    void update(ClientDTO clientDTO);
    ClientDTO findByEmail(String email);

    List<ClientDTO> findAll();
    void delete (Integer id);


}

