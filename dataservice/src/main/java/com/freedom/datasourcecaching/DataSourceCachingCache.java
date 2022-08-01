package com.freedom.datasourcecaching;

import com.freedom.datasourcecaching.constants.Enums.DATA_SOURCE_TYPE;
import com.freedom.datasourcecaching.model.Properties;
import com.freedom.datasourcecaching.repositories.PropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.freedom.datasourcecaching.constants.Enums.DATA_SOURCE_TYPE.CACHE;
import static com.freedom.datasourcecaching.constants.Enums.DATA_SOURCE_TYPE.DATABASE;

@Component
public class DataSourceCachingCache {

  private final PropertiesRepository propertiesRepository;

  private Map<String, Properties> propertiesCache = new HashMap<>();

  @Autowired
  public DataSourceCachingCache(PropertiesRepository propertiesRepository) {
    this.propertiesRepository = propertiesRepository;
  }

  public List<Properties> findAllPropertiesList(DATA_SOURCE_TYPE dataSourceType) {
    return CACHE.equals(dataSourceType)
        ? propertiesCache.values().stream().collect(Collectors.toList())
        : DATABASE.equals(dataSourceType) ? propertiesRepository.findAll() : null;
  }

  public void refreshDataSourceCache() {
    refreshPropertiesCache();
  }

  private void refreshPropertiesCache() {
    Map<String, Properties> tempPropertiesCache =
        findAllPropertiesList(DATABASE).stream()
            .collect(Collectors.toMap(Properties::getName, Function.identity()));
    if (tempPropertiesCache != null) this.propertiesCache = tempPropertiesCache;
  }

  public Properties findByName(String name) {
    return propertiesCache.get(name);
  }
}
