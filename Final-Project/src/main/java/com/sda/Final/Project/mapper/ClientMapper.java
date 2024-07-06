package com.sda.Final.Project.mapper;

import ch.qos.logback.core.net.server.Client;
import com.sda.Final.Project.dto.ClientDTO;
import com.sda.Final.Project.entity.ClientEntity;

import java.awt.print.Book;

public class ClientMapper {
    public static ClientDTO toDTO(ClientEntity clientEntity){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(clientEntity.getId());
        clientDTO.setName(clientEntity.getName());
        clientDTO.setSurname(clientEntity.getSurname());
        clientDTO.setPhone(clientEntity.getPhone());
        clientDTO.setEmail(clientEntity.getEmail());

        return clientDTO;

    }
    public static ClientEntity toEntity(ClientDTO clientDTO){
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(clientDTO.getName());
        clientEntity.setSurname(clientDTO.getSurname());
        clientEntity.setPhone(clientDTO.getPhone());
        clientEntity.setEmail(clientDTO.getEmail());
        return clientEntity;

    }

    public static ClientEntity toEntityForUpdate(ClientEntity clientEntity, ClientDTO clientDTO ){
        clientEntity.setName(clientDTO.getName());
        clientEntity.setSurname(clientDTO.getSurname());
        clientEntity.setPhone(clientDTO.getPhone());
        clientEntity.setEmail(clientDTO.getEmail());
        return clientEntity;
    }


}
