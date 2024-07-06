package com.sda.Final.Project.mapper;

import com.sda.Final.Project.dto.CompanyDTO;
import com.sda.Final.Project.entity.CompanyEntity;
import com.sda.Final.Project.entity.MeetingEntity;
import com.sda.Final.Project.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyMapper {


    public  static CompanyDTO toDTO(CompanyEntity companyEntity){
        CompanyDTO companyDTO =  new CompanyDTO();
        companyDTO.setId(companyEntity.getId());
        companyDTO.setCompanyName(companyEntity.getCompanyName());
        companyDTO.setIdUserCompany(companyDTO.getIdUserCompany());
        return companyDTO;
    }

    public static CompanyEntity toEntity(CompanyDTO companyDTO , UserEntity userEntity ){
          CompanyEntity companyEntity = new CompanyEntity();
           companyEntity.setIdUserCompany(userEntity);

        return extractFields(companyEntity , companyDTO);

    }

    public static CompanyEntity toEntityForUpdate(CompanyEntity companyEntity , CompanyDTO companyDTO){
        return extractFields( companyEntity ,  companyDTO);
    }

    public static List<CompanyDTO> toDTOList(List<CompanyEntity> companyEntityList){
        return companyEntityList.stream()
                .map(CompanyMapper::toDTO)
                .collect(Collectors.toList());
    }

    private static CompanyEntity extractFields(CompanyEntity companyEntity , CompanyDTO companyDTO){

        UserEntity userEntity = UserMapper.toEntity(companyDTO.getIdUserCompany());

        companyEntity.setCompanyName(companyDTO.getCompanyName());
        companyEntity.setIdUserCompany(userEntity);

        return companyEntity;
    }
}
