package com.mining.infrastructure.api;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mining.application.pool.yieldPoolCheck.YieldCheckOutput;
import com.mining.infrastructure.pool.model.GetListPoolModel;
import com.mining.infrastructure.pool.model.GetPoolModel;


@RequestMapping(value = "pool")
public interface PoolApi {

    @PostMapping(value = "/post")
    ResponseEntity<?> createPool();

    @GetMapping
    List<GetListPoolModel> getPools();

    @GetMapping(value="/{id}")
    ResponseEntity<GetPoolModel> getPool(@PathVariable String id);

    @GetMapping(value="/best")
    YieldCheckOutput getBestPools();
}