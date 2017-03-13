package com.example.config;


import com.example.com.example.common.support.JdbcGemfireTaskProperties;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {


    private static final Logger LOG = LoggerFactory.getLogger(CacheConfig.class);

    @Bean
    public ClientCache createCache(PropertyConfig props) {
        LOG.info("Initializing ClientCache..");
        // String pdxSerializedClasses = "io.pivotal.gemfire.pubs.model.*";

        Boolean readSerializedFlag = false;

        ClientCacheFactory ccf = new ClientCacheFactory();

        String[] sa1 = props.locators.split(",");
        for (String st : sa1) {
            String[] sat = st.split(":");
            String host = sat[0];
            int port = sat.length > 1 ? Integer.parseInt(sat[1]) : 10334;
            LOG.info("Adding Server to pool : host={}, port={}", host, port);

            ccf.addPoolLocator(host, port);

        }

        //ccf.setPdxReadSerialized(readSerializedFlag);
        //ccf.setPdxSerializer(new ReflectionBasedAutoSerializer(pdxSerializedClasses));
        LOG.info("Created ClientCache ");
        return ccf.create();
    }

    @Bean
    public Pool createPool(ClientCache cache) {
        LOG.info("creating pool");
        return cache.getDefaultPool();
    }
}
