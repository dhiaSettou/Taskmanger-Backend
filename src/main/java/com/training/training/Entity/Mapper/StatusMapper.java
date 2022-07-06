package com.training.training.Entity.Mapper;

import com.training.training.Entity.DTO.StatusDto;
import com.training.training.Entity.Status;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface StatusMapper {
    StatusMapper instance = Mappers.getMapper(StatusMapper.class);

    StatusDto toDto(Status status);
    List<StatusDto> toDtos(List<Status> statuses);

    Status toEntity(StatusDto statusDto);

}
