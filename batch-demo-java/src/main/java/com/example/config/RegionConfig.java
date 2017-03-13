package com.example.config;

import com.example.com.example.common.support.JdbcGemfireTaskProperties;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.cache.client.Pool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RegionConfig {
	private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

	@Bean(name = "clientRegion" )
	public Region<?, ?> createTaskRegion(ClientCache cache, Pool pool) {
		LOG.info("creating clientRegion");
		ClientRegionFactory<?, ?> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
		crf.setPoolName(pool.getName());
		Region<?, ?> r = crf.create("person");
		LOG.info("Got region = {}", r.getName());
		return r;
	}

}


