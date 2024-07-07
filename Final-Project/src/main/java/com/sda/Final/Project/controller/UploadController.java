package com.sda.Final.Project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.Final.Project.dto.UploadDto;
import com.sda.Final.Project.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sda.Final.Project.service.iUploadService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/upload")
@AllArgsConstructor
public class UploadController {

    private final iUploadService iUploadService;

    @PostMapping("/upload")
    public ResponseEntity<UploadDto> upload(
            @RequestParam("image") MultipartFile multipartFile ,
            @RequestParam("UserDTO") String json
            ){
        try{
            UploadDto uploadDto = new UploadDto();
            uploadDto.setImage(multipartFile.getBytes());
            uploadDto.setFilename(multipartFile.getOriginalFilename());
            UserDTO userDTO = new ObjectMapper().readValue(json, UserDTO.class);
            uploadDto.setIdUserUpload(userDTO);
            iUploadService.save(uploadDto);
            return ResponseEntity.ok(uploadDto);

        }catch (Exception e){
            e.printStackTrace();
            log.error("File not found");
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{userId}")
    public List<UploadDto> findAllByUserId(@PathVariable  Integer userId){
        return iUploadService.findAllByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        iUploadService.delete(id);
    }
}
