package com.file.uploader.controller.mapper;

import com.file.uploader.controller.dto.FileDto;
import com.file.uploader.model.FileModel;
import org.springframework.stereotype.Component;

@Component
public class FileMapper {
    public FileDto toRest(FileModel fileModel) {
        return FileDto.builder()
                .id(fileModel.getId())
                .name(fileModel.getName())
                .type(fileModel.getType())
                .build();
    }
}
