package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.ClientDTO;
import com.sda.Final.Project.dto.CompanyDTO;
import com.sda.Final.Project.dto.UserDTO;
import com.sda.Final.Project.entity.CompanyEntity;
import com.sda.Final.Project.entity.UserEntity;
import com.sda.Final.Project.exception.BadRequestException;
import com.sda.Final.Project.exception.NotFoundException;
import com.sda.Final.Project.mapper.CompanyMapper;
import com.sda.Final.Project.repository.CompanyRepository;
import com.sda.Final.Project.repository.MeetingRepository;
import com.sda.Final.Project.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService implements iCompanyService{


    @Autowired
    private final CompanyRepository companyRepository;

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final MeetingRepository meetingRepository;

    @Override
    public void save(CompanyDTO companyDTO) {
        Optional<UserEntity> userEntities = userRepository
                .findById(companyDTO.getIdUserCompany().getId());

        if(!userEntities.isPresent()){
            throw new NotFoundException("This company exists");
        }

        if (companyRepository.existsById(companyDTO.getIdUserCompany().getId())){
            throw new BadRequestException("This user has already a company \n Thank you for choosing us!");
        }

        companyRepository.save(CompanyMapper.toEntity(companyDTO ,userEntities.get() ));
    }

    @Override
    public void update(CompanyDTO companyDTO) {
        Optional<CompanyEntity> companyEntityOptional = companyRepository
                .findById(companyDTO.getId());
        if (companyEntityOptional.isPresent()){
            CompanyEntity companyEntity = companyEntityOptional.get();
            companyEntity = CompanyMapper.toEntityForUpdate(companyEntity , companyDTO);
            companyRepository.save(companyEntity);
        }else {
            throw new NotFoundException("Company cannot be found");
        }
    }

    @Override
    public CompanyDTO findById(Integer id) {
        Optional<CompanyEntity> companyEntityOptional =
                companyRepository.findById(id);

        if(companyEntityOptional.isPresent()){
            CompanyEntity companyEntity = companyEntityOptional.get();
            return CompanyMapper.toDTO(companyEntity);
        }else {
            throw new NotFoundException("Company with id"+id+"cannot be found");
        }
    }

    @Override
    public List<CompanyDTO> findAll() {
        return companyRepository.findAll().stream().map(CompanyMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        companyRepository.deleteById(id);
    }

    @Override
    public List<ClientDTO> findAllClientsOfCompany(Integer companyId) {
        Optional<CompanyEntity> companyEntityOptional =
                companyRepository.findById(companyId);

        if (companyEntityOptional.isPresent()) {
            UserEntity userEntity = companyEntityOptional.get().getIdUserCompany();
           return meetingRepository.findAllClientsOfUser(userEntity.getId());
        }

        return Collections.emptyList();
    }
}
