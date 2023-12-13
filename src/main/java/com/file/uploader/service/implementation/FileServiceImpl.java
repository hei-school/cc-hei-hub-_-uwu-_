package com.file.uploader.service.implementation;

import com.file.uploader.controller.exception.BadRequestException;
import com.file.uploader.model.FileModel;
import com.file.uploader.repository.FileRepository;
import com.file.uploader.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService {
    private FileRepository fileRepository;
    @Override
    public FileModel save(MultipartFile file) throws Exception {
        try {
            if (file.getBytes().length > (1024 * 1024)) {
                throw new BadRequestException("File size exceeds maximum limit");
            }
            FileModel fileModel = FileModel.builder()
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .data(file.getBytes())
                    .build();
            return fileRepository.save(fileModel);
        } catch (Exception e) {
            throw new BadRequestException("Could not save file: " + file.getName());
        }
    }

    @Override
    public List<FileModel> findAllFile() {
        return null;
    }
}
