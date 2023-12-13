package com.file.uploader.repository;

import com.file.uploader.model.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileModel, String> {
}
