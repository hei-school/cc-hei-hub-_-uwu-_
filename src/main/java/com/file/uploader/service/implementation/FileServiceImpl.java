package com.file.uploader.service.implementation;

import com.file.uploader.controller.exception.BadRequestException;
import com.file.uploader.controller.exception.DuplicatedFileException;
import com.file.uploader.controller.exception.NotFoundException;
import com.file.uploader.model.FileModel;
import com.file.uploader.repository.FileRepository;
import com.file.uploader.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService {
    private FileRepository fileRepository;

    @Override
    public FileModel findByName(String name) {
        Optional<FileModel> fileModel = fileRepository.findByName(name);
        if (fileModel.isEmpty()) {
            throw new NotFoundException("The file " + name +" does not exist");
        }
        return fileModel.get();
    }

    @Override
    public FileModel save(MultipartFile file) {
        try {
            if (fileRepository.existsByName(file.getOriginalFilename())) {
                throw new DuplicatedFileException("File already exist");
            }
            FileModel fileModel = FileModel.builder()
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
    public List<FileModel> findAllFile() {
        return fileRepository.findAll();
    }
}
