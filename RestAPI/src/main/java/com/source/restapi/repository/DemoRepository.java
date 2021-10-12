package com.source.restapi.repository;

import com.source.restapi.model.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<Demo,Long> {
}
