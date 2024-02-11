package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Package;

public interface PackageRepository extends JpaRepository<Package, Long> {

}
