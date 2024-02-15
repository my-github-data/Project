package com.app.services;

import com.app.dtos.ApiResponse;
import com.app.dtos.PackageDTO;

public interface PackageService {

	PackageDTO addPackage(PackageDTO dto);

	PackageDTO updatePackage(Long id, PackageDTO dto);

	ApiResponse deletePackage(Long id);

	PackageDTO viewPackage(Long id);
}
