package com.app.services;

import com.app.dtos.AddressDTO;

public interface AddressService {

	AddressDTO addAddress(Long userId, AddressDTO dto);

	AddressDTO updateAddress(Long id, AddressDTO dto);

	AddressDTO getAddress(Long id);

}
