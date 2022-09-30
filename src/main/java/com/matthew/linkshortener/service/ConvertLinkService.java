package com.matthew.linkshortener.service;

import com.matthew.linkshortener.api.ConvertLinkRequestDTO;
import com.matthew.linkshortener.api.ConvertedLinkResponseDTO;

import javax.servlet.http.HttpServletRequest;

public interface ConvertLinkService {
    ConvertedLinkResponseDTO convertLink(ConvertLinkRequestDTO requestDTO, HttpServletRequest servletRequest);
}
