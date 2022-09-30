package com.matthew.linkshortener.service;

import com.matthew.linkshortener.api.ConvertLinkRequestDTO;
import com.matthew.linkshortener.api.ConvertedLinkResponseDTO;
import com.matthew.linkshortener.domain.Link;
import com.matthew.linkshortener.mapper.LinkMapper;
import com.matthew.linkshortener.repository.LinkRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class ConvertLinkServiceImpl implements ConvertLinkService{

    private final LinkMapper linkMapper;
    private final LinkRepository linkRepository;

    @Override
    public ConvertedLinkResponseDTO convertLink(ConvertLinkRequestDTO requestDTO, HttpServletRequest servletRequest) {
        Link linkEntity = new Link(requestDTO.originLink());
        linkEntity.setConvertedLink(generateNewLink(servletRequest));
        linkRepository.save(linkEntity);

        return linkMapper.mapLinkEntityToConvertedLinkDTO(linkEntity);
    }

    private String generateNewLink(HttpServletRequest servletRequest) {
        RandomString randomString = new RandomString();
        return servletRequest.getServerName() + ":" + servletRequest.getServerPort() + "/" + randomString.nextString();
    }
}
