package com.culture_lib.library_service.repository;

import com.culture_lib.library_service.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, String> {
}
