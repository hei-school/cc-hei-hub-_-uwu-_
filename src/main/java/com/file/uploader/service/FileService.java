package com.file.uploader.service;

import com.file.uploader.model.FileModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    FileModel save(MultipartFile file) throws Exception;
    FileModel findByName(String name);
    List<FileModel> findAllFile();
}
