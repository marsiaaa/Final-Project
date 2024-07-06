package com.sda.Final.Project.mapper;

import com.sda.Final.Project.dto.SocialMediaDTO;
import com.sda.Final.Project.entity.SocialMediaEntity;
import com.sda.Final.Project.entity.UserEntity;

public class SocialMediaMapper {
    public  static SocialMediaDTO toDTO (SocialMediaEntity socialMediaEntity){
          SocialMediaDTO socialMediaDTO = new SocialMediaDTO();
          socialMediaDTO.setId(socialMediaEntity.getId());
          socialMediaDTO.setLinkedin(socialMediaDTO.getLinkedin());
          socialMediaDTO.setInstagram(socialMediaDTO.getInstagram());
          socialMediaDTO.setFacebook(socialMediaEntity.getFacebook());

          socialMediaDTO.setUserDTO(UserMapper.toDTO(socialMediaEntity.getUserEntity()));

        return  socialMediaDTO;
    }

    public  static SocialMediaEntity toEntity(SocialMediaDTO socialMediaDTO , UserEntity userEntity){
            SocialMediaEntity socialMediaEntity = new SocialMediaEntity();
               socialMediaEntity.setLinkedin(socialMediaDTO.getLinkedin());
               socialMediaEntity.setInstagram(socialMediaDTO.getInstagram());
               socialMediaEntity.setFacebook(socialMediaDTO.getFacebook());
               socialMediaEntity.setUserEntity(userEntity);
               return socialMediaEntity;
    }
    public  static SocialMediaEntity toEntityForUpdate(SocialMediaEntity socialMediaEntity, SocialMediaDTO socialMediaDTO, UserEntity userEntity){
        socialMediaEntity.setLinkedin(socialMediaDTO.getLinkedin());
        socialMediaEntity.setInstagram(socialMediaDTO.getInstagram());
        socialMediaEntity.setFacebook(socialMediaDTO.getFacebook());
        socialMediaEntity.setUserEntity(userEntity);
        return socialMediaEntity;
    }
}
