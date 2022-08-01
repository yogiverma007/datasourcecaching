package com.freedom.datasourcecaching.repositories;

import com.freedom.datasourcecaching.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository
    extends JpaRepository<Properties, Long>, JpaSpecificationExecutor<Properties> {
  Properties findByName(String name);
}
