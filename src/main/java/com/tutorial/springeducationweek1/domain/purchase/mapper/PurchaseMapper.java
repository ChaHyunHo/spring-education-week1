package com.tutorial.springeducationweek1.domain.purchase.mapper;

import com.tutorial.springeducationweek1.domain.purchase.dto.PurchaseResponse;
import com.tutorial.springeducationweek1.domain.purchase.entity.Purchase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

  PurchaseResponse fromEntity(Purchase purchase);
}
