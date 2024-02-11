package com.app.services;

import com.app.dtos.PackageDTO;

public interface PackageService {

	PackageDTO addPackage(PackageDTO dto);

	PackageDTO updatePackage(Long id, PackageDTO dto);

	PackageDTO deletePackage(Long id);

	PackageDTO viewPackage(Long id);
}
