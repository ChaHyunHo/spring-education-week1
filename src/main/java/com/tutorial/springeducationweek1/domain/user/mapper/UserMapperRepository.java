package com.tutorial.springeducationweek1.domain.user.mapper;

import com.tutorial.springeducationweek1.domain.user.dto.SearchUserDto;
import com.tutorial.springeducationweek1.domain.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapperRepository {

  SearchUserDto selectUserById(int id);

  void insertUser(UserDto insertUser);

  void updateUser(UserDto insertUser);

  void deleteUser(Long id);
}
