package com.app.services;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dtos.ApiResponse;
import com.app.entities.Image;
import com.app.repositories.ImageRepository;
import com.app.repositories.PackageRepository;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {
	@Autowired
	private ImageRepository imageRepo;

	@Autowired
	private PackageRepository packageRepo;

	@Value("${folder.location}")
	private String folderLocation;

	@PostConstruct
	public void init() {
		File folder = new File(folderLocation);
		if (!folder.exists())
			folder.mkdir();
	}

	@Override
	public byte[] downloadImage(Long id) throws IOException {
		com.app.entities.Package package1 = packageRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Package Id"));
		Image image = imageRepo.findByPakage(package1);
		String path = image.getPath();
		if (path != null)
			return FileUtils.readFileToByteArray(new File(path));
		else
			throw new ApiException("Image Not Assigned yet!!!");
	}

	@Override
	public ApiResponse uploadImage(Long id, MultipartFile imageFile) throws IOException {
		String path = folderLocation.concat(imageFile.getOriginalFilename());
		Image image = new Image();
		image.setPath(path);
		image.setPakage(
				packageRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Package Id")));
		FileUtils.writeByteArrayToFile(new File(path), imageFile.getBytes());
		imageRepo.save(image);
		return new ApiResponse("ImageSet for Package.");
	}
}
