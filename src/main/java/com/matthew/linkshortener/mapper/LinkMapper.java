package com.matthew.linkshortener.mapper;

import com.matthew.linkshortener.api.ConvertedLinkResponseDTO;
import com.matthew.linkshortener.domain.Link;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LinkMapper {
    ConvertedLinkResponseDTO mapLinkEntityToConvertedLinkDTO(Link linkEntity);
}
