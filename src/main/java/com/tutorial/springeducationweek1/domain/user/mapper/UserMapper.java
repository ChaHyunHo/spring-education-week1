package com.tutorial.springeducationweek1.domain.user.mapper;

import com.tutorial.springeducationweek1.domain.user.dto.UserRequest;
import com.tutorial.springeducationweek1.domain.user.dto.UserResponse;
import com.tutorial.springeducationweek1.domain.user.dto.UserSearchResponse;
import com.tutorial.springeducationweek1.domain.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserResponse toResponse(User user);

  UserSearchResponse toSearch(User user);

  User toEntity(UserRequest userRequest);
}
