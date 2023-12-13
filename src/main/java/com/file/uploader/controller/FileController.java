package com.file.uploader.controller;

import com.file.uploader.controller.dto.FileDto;
import com.file.uploader.controller.mapper.FileMapper;
import com.file.uploader.model.FileModel;
import com.file.uploader.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @GetMapping("/{name}")
    public void getFile(@PathVariable(name = "name") String name, HttpServletResponse response) throws IOException {
        FileModel fileModel = fileService.findByName(name);
        response.setContentType(fileModel.getType());
        response.getOutputStream().write(fileModel.getData());
        response.getOutputStream().close();
    }
}
