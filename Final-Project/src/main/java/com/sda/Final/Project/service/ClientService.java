package com.sda.Final.Project.service;
import ch.qos.logback.core.net.server.Client;
import com.sda.Final.Project.dto.ClientDTO;
import com.sda.Final.Project.exception.BadRequestException;
import com.sda.Final.Project.exception.NotFoundException;
import com.sda.Final.Project.entity.ClientEntity;
import com.sda.Final.Project.mapper.ClientMapper;
import com.sda.Final.Project.repository.ClientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService implements IClientService {

    @Autowired
    public ClientRepository clientRepository;


   @Override
   public void save(ClientDTO clientDTO) {
        ClientEntity clientEntity=ClientMapper.toEntity(clientDTO);
        clientRepository.save(clientEntity);
   }

    @Override
   public void update(ClientDTO clientDTO) {
       Optional<ClientEntity> clientEntity = clientRepository.findById(clientDTO.getId());
       if (clientEntity.isPresent()){
           ClientEntity update = ClientMapper.toEntityForUpdate(
                   clientEntity.get() , clientDTO
           );
           clientRepository.save(update);
       }else {
           throw new NotFoundException("Entity Client not found ");
       }
}

    @Override
    public ClientDTO findById(Integer id) {
        Optional<ClientEntity> clientEntity = clientRepository.findById(id);
        if (clientEntity.isPresent()){
            return ClientMapper.toDTO(clientEntity.get());
        }else {
            throw new NotFoundException("Entity Client not found ");
        }
    }

    @Override
    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream().map(ClientMapper::toDTO).toList();
    }

    @Override
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}
