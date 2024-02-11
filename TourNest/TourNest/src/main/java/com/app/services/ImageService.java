package com.app.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.dtos.ApiResponse;

public interface ImageService {

	byte[] downloadImage(Long id) throws IOException;

	ApiResponse uploadImage(Long id, MultipartFile image) throws IOException;

}
