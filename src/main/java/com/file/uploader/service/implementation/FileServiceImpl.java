package com.file.uploader.service.implementation;

import com.file.uploader.controller.exception.BadRequestException;
import com.file.uploader.controller.exception.DuplicatedFileException;
import com.file.uploader.controller.exception.FileNotFoundException;
import com.file.uploader.model.FileModel;
import com.file.uploader.repository.FileRepository;
import com.file.uploader.service.FileService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService {
  private FileRepository fileRepository;

  @Override
  public FileModel findByName(String name) {
    Optional<FileModel> fileModel = fileRepository.findByName(name);
    if (fileModel.isEmpty()) {
      throw new FileNotFoundException("The file " + name + " does not exist");
    }
    return fileModel.get();
  }

  @Override
  public FileModel save(MultipartFile file) {
    try {
      if (this.existsByName(file.getOriginalFilename())) {
        throw new DuplicatedFileException("File already exist");
      }
      FileModel fileModel =
          FileModel.builder()
              .name(file.getOriginalFilename())
              .type(file.getContentType())
              .data(file.getBytes())
              .build();
      return fileRepository.save(fileModel);
    } catch (Exception e) {
      throw new BadRequestException(e.getMessage());
    }
  }

  @Override
  @Transactional(timeout = 3)
  public List<FileModel> findAllFile() {
    return fileRepository.findAll();
  }

  @Override
  public boolean existsByName(String name) {
      return fileRepository.existsByName(name);
  }
}
