package com.example.savetodb.repo;

import com.example.savetodb.model.AppendixaRequestTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AppendixaRequestTestRepository extends JpaRepository<AppendixaRequestTest, UUID> {
}