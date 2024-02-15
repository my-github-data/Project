package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dtos.AddressDTO;
import com.app.entities.Address;
import com.app.repositories.AddressRepository;
import com.app.repositories.UserRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepository userRepo;

	@Override
	public AddressDTO addAddress(Long userId, AddressDTO dto) {
		Address address = mapper.map(dto, Address.class);
		address.setUser(userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid User!")));
		return mapper.map(addressRepo.save(address), AddressDTO.class);
	}

	@Override
	public AddressDTO updateAddress(Long id, AddressDTO dto) {
		Address address = addressRepo
				.findByUser(userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User!")))
				.orElseThrow(() -> new ResourceNotFoundException("Address Not Found."));
		address.setCity(dto.getCity());
		address.setCountry(dto.getCountry());
		address.setState(dto.getState());
		address.setZipCode(dto.getZipCode());
		address.setLandmark(dto.getLandmark());
		return mapper.map(addressRepo.save(address), AddressDTO.class);
	}

	@Override
	public AddressDTO getAddress(Long id) {
		return mapper.map(addressRepo
				.findByUser(userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User!")))
				.orElseThrow(() -> new ResourceNotFoundException("Address Not Found.")), AddressDTO.class);
	}
}
