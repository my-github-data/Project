package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.UserDTO;
import com.app.entities.User;
import com.app.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDTO addUser(UserDTO dto) {
		return mapper.map(userRepo.save(mapper.map(dto, User.class)), UserDTO.class);
	}
	
	@Override
	public UserDTO loginUser(UserDTO dto) {
        User user = userRepo.findByEmailIdAndPassword(dto.getEmailId(), dto.getPassword());
        if (user != null) {
            return mapper.map(user, UserDTO.class);
        } else {
            return null;
        }
    }

	@Override
	public UserDTO changePassword(UserDTO dto) {
		// TODO Auto-generated method stub
		User user = userRepo.findByEmailId(dto.getEmailId());
		if(user!=null) {
			user.setPassword(dto.getPassword());
			return mapper.map(user, UserDTO.class);	
		}
		else {
			return null;
		}		
	}

	@Override
	public String deleteUserDetails(Long UserId) {
		if(userRepo.existsById(UserId)) {
			userRepo.deleteById(UserId);
			return "Deleted User details";
		}
		return "User not found";
	}

}
