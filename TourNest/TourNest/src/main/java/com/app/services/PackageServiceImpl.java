package com.app.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		return mapper.map(packRepo.save(mapper.map(dto, Package.class)), PackageDTO.class);
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
		return null;
	}

	@Override
	public PackageDTO deletePackage(Long id) {
		if (packRepo.existsById(id)) {
			Optional<Package> packageOptional = packRepo.findById(id);
			Package deletedPackage = packageOptional.get();
			packRepo.deleteById(id);
			return mapper.map(deletedPackage, PackageDTO.class);
		}
		return null;
	}

	@Override
	public PackageDTO viewPackage(Long id) {
		if (packRepo.existsById(id)) {
			Package pack = packRepo.findById(id).orElse(null);
			return mapper.map(pack, PackageDTO.class);
		}
		return null;
	}
}
