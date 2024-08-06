package com.mine.infrastructure.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mine.infrastructure.pool.model.GetListPoolModel;


@RequestMapping(value = "pool")
public interface PoolApi {

    @PostMapping(value = "/post")
    ResponseEntity<?> createPool();

    @GetMapping
    List<GetListPoolModel> getPools();
}
