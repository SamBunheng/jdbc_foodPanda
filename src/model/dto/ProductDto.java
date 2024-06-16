package model.dto;

import lombok.Builder;

import java.sql.Date;
@Builder
public record ProductDto(String productName, String productCode, boolean isDeleted, Date importDated,Date expiredDate,String description)
{ }