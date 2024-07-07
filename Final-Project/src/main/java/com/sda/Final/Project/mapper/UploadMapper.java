package com.sda.Final.Project.mapper;

import com.sda.Final.Project.dto.UploadDto;
import com.sda.Final.Project.entity.UploadEntity;
import com.sda.Final.Project.entity.UserEntity;
import com.sda.Final.Project.exception.BadRequestException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;



public class UploadMapper {

    private static final Path ROOT = Path.of("C:\\Users\\Sosana\\Desktop\\sda\\Spring\\Final-Project2\\Final-Project\\src\\main\\resources\\img");

    public static UploadDto toDTO(UploadEntity uploadEntity){
        UploadDto uploadDto = new UploadDto();

        uploadDto.setId(uploadEntity.getId());
        uploadDto.setIdUserUpload(UserMapper.toDTO(uploadEntity.getIdUserUpload()));
        uploadDto.setImage(uploadEntity.getImage());
        uploadDto.setFilename(uploadDto.getFilename());

        return uploadDto;
    }

    public static UploadEntity toEntity(UploadDto uploadDto , UserEntity userEntity){
        UploadEntity uploadEntity1 = new UploadEntity();
        uploadEntity1.setIdUserUpload(userEntity);
        upload(uploadDto.getImage() , uploadDto.getFilename());
        return extractFields(uploadDto , uploadEntity1);
    }

    public static UploadEntity toEntityForUpdate(UploadDto uploadDto , UploadEntity uploadEntity){
        return extractFields(uploadDto , uploadEntity);
    }
    public static List<UploadDto> toDTOList(List<UploadEntity> uploadEntityList){
        return uploadEntityList.stream()
                .map(UploadMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static String upload(byte[] image , String filename){
        try (InputStream inputStream = new ByteArrayInputStream(image)){
            Path location = Files.exists(ROOT.resolve(filename))
                    ?ROOT.resolve(preAlphabeticRandomify(filename)) :
                    ROOT.resolve(filename);

            Files.copy(inputStream , location);
            return location.toFile().getAbsolutePath();
        }catch (IOException e){
            throw new BadRequestException("Cannot upload");
        }
    }

    public static UploadEntity extractFields(UploadDto uploadDto , UploadEntity uploadEntity){
        uploadEntity.setImage(uploadDto.getImage());
        uploadEntity.setFilename(uploadDto.getFilename());
        return  uploadEntity;
    }

    private static String preAlphabeticRandomify(String str) {
        return getSaltString(3)  + str;

    }
    protected static String getSaltString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();

    }

}
