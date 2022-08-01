package com.freedom.datasourcecaching;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
@Qualifier("cacheManager")
public class CacheManager {

  private final DataSourceCachingCache dataSourceCachingCache;

  @Autowired
  public CacheManager(DataSourceCachingCache dataSourceCachingCache) {
    this.dataSourceCachingCache = dataSourceCachingCache;
  }

  @PostConstruct
  private void init() {
    refresh();
  }

  @Scheduled(fixedDelay = 60000)
  private void refresh() {
    log.info("Refreshing cache now");

    dataSourceCachingCache.refreshDataSourceCache();

    log.info("Cache refreshed");
  }
}
