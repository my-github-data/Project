package com.app.controllers;

import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import java.io.IOException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.services.ImageService;

@RestController
@RequestMapping("/image")
@Validated
public class ImageController {

	@Autowired
	private ImageService imageService;

	@PostMapping(value = "/{id}", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImage(@PathVariable @NotNull Long id,
			@RequestParam @NotBlank MultipartFile imageFile) throws IOException {
		return ResponseEntity.status(HttpStatus.CREATED).body(imageService.uploadImage(id, imageFile));
	}

	@GetMapping(value = "/{id}", produces = { IMAGE_GIF_VALUE, IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE })
	public ResponseEntity<?> downloadImage(@PathVariable @NotNull Long id) throws IOException {
		return ResponseEntity.ok(imageService.downloadImage(id));
	}
}
