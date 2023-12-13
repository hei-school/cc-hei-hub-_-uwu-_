package com.file.uploader.service;

import com.file.uploader.model.FileModel;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
  FileModel save(MultipartFile file);

  FileModel findByName(String name);

  List<FileModel> findAllFile();

  boolean existsByName(String name);
}
