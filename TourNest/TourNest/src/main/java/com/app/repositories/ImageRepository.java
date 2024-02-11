package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Image;
import com.app.entities.Package;

public interface ImageRepository extends JpaRepository<Image, Long> {

	Image findByPakage(Package package1);

}
