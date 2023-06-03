package com.springframework.spring6webapp.services;

import com.springframework.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
