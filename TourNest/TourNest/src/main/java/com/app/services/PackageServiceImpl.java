package com.app.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dtos.ApiResponse;
import com.app.dtos.PackageDTO;
import com.app.entities.Package;
import com.app.repositories.PackageRepository;

@Service
@Transactional
public class PackageServiceImpl implements PackageService {

	@Autowired
	private PackageRepository packRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public PackageDTO addPackage(PackageDTO dto) {
		Package package1 = mapper.map(dto, Package.class);
		package1.setLaunchDate(LocalDate.now());
		return mapper.map(packRepo.save(package1), PackageDTO.class);
	}

	@Override
	public PackageDTO updatePackage(Long id, PackageDTO dto) {
		if (packRepo.existsById(id)) {
			Package existingPack = packRepo.findById(id).orElse(null);

			if (existingPack != null) {
				existingPack.setName(dto.getName());
				existingPack.setType(dto.getType());
				existingPack.setPrice(dto.getPrice());
				existingPack.setDetails(dto.getDetails());
				existingPack.setFromDate(dto.getFromDate());
				existingPack.setToDate(dto.getToDate());
				return mapper.map(packRepo.save(existingPack), PackageDTO.class);
			}
		}
		throw new ResourceNotFoundException("Package Not Found!");
	}

	@Override
	public ApiResponse deletePackage(Long id) {
		if (packRepo.existsById(id)) {
//			Package package1 = packRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalid Package"));
			packRepo.deleteById(id);
			return new ApiResponse("Package Deleted Successfully!");
		}
		throw new ResourceNotFoundException("Package Not Found!");
	}

	@Override
	public PackageDTO viewPackage(Long id) {
		if (packRepo.existsById(id)) {
			Package pack = packRepo.findById(id).orElse(null);
			return mapper.map(pack, PackageDTO.class);
		}
		throw new ResourceNotFoundException("Package Not Found!");
	}

	@Override
	public List<PackageDTO> viewAllPackages() {
		return packRepo.findAll().stream().map(pakage -> mapper.map(pakage, PackageDTO.class))
				.collect(Collectors.toList());
	}
}
