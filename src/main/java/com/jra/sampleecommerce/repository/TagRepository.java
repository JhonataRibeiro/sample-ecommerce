package com.jra.sampleecommerce.repository;

import com.jra.sampleecommerce.model.entity.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TagRepository extends CrudRepository<Tag, UUID> {
}