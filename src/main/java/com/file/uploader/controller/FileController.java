package com.file.uploader.controller;

import com.file.uploader.controller.dto.FileDto;
import com.file.uploader.controller.mapper.FileMapper;
import com.file.uploader.model.FileModel;
import com.file.uploader.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class FileController {
    private FileService fileService;
    private FileMapper fileMapper;
    @PostMapping("/upload")
    public FileDto fileUploading(@RequestParam(name = "file")MultipartFile file) throws Exception {
        FileModel fileModel = fileService.save(file);
        return fileMapper.toRest(fileModel);
    }
}
