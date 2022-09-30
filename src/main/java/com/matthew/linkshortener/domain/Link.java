package com.matthew.linkshortener.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "links")
@NoArgsConstructor
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Origin link cannot be null")
    private String originLink;

    private String shortedLink;

    public Link(String originLink) {
        this.originLink = originLink;
    }
}
