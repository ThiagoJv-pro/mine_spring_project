package com.mining.infrastructure.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mining.application.pool.yieldPoolCheck.YieldCheckOutput;
import com.mining.infrastructure.pool.model.GetBestPoolRequest;
import com.mining.infrastructure.pool.model.GetListPoolModel;
import com.mining.infrastructure.pool.model.GetPoolModel;

import jakarta.jms.JMSException;


@RequestMapping(value = "pool")
public interface PoolApi {

    @PostMapping(value = "/create")
    ResponseEntity<?> createPool();

    @GetMapping(value="/pools")
    List<GetListPoolModel> getPools();

    @GetMapping(value="/{id}")
    ResponseEntity<GetPoolModel> getPool(@PathVariable String id);

    @GetMapping(value="/bestPool")
    ResponseEntity<List<GetBestPoolRequest>> getBestPools() throws JMSException;
}
