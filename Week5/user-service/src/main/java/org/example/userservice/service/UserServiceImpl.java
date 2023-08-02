package org.example.userservice.service;

import java.util.List;

import org.example.userservice.dto.UserDto;
import org.example.userservice.model.UserEntity;
import org.example.userservice.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private ModelMapper modelMapper;

  @Override
  public List<UserEntity> listUsers() {
    return userRepository.findAll();
  }

  @Override
  public UserEntity findByUserId(String userId) {
    return userRepository.findByUserId(userId);
  }

  @Override
  public UserEntity createUser(UserDto userDto) {
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
    StringBuffer sb = new StringBuffer();
    sb.append(userDto.getPassword());
    userEntity.setEncryptedPassword(sb.reverse().toString());
    return userRepository.save(userEntity);
  }

}
