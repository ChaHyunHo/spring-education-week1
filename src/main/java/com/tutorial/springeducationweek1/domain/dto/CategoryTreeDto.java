package com.tutorial.springeducationweek1.domain.dto;


import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryTreeDto {
  Long id;
  String name;
  List<CategoryTreeDto> children = new ArrayList<>();
}
