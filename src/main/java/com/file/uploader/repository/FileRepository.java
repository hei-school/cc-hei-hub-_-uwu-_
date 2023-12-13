package com.file.uploader.repository;

import com.file.uploader.model.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileModel, String> {
    boolean existsByName(String name);
    Optional<FileModel> findByName(String name);
}
