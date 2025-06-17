package com.tutorial.springeducationweek1.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryFlatDto {
  Long id;
  String name;
  Long parentId;

}
