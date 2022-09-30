package com.matthew.linkshortener.endpoint;

import com.matthew.linkshortener.api.ConvertLinkRequestDTO;
import com.matthew.linkshortener.api.ConvertedLinkResponseDTO;
import com.matthew.linkshortener.service.ConvertLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/converter")
public class LinkController {

    private final ConvertLinkService convertLinkService;

    @PostMapping
    public ResponseEntity<ConvertedLinkResponseDTO> convertLink(@RequestBody ConvertLinkRequestDTO requestDTO, HttpServletRequest servletRequest) {
        return new ResponseEntity<>(convertLinkService.convertLink(requestDTO, servletRequest), HttpStatus.OK);
    }

}
