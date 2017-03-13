package com.example.com.example.common.support;

import com.example.BatchDemoJavaApplication;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.*;

/*
*
 * Generate Key class and methods via Reflection Use the key class to build
 * composite key Store in Gemfire : region.put(KeyClass,ValueClass);
*/


/*@EnableConfigurationProperties({JdbcGemfireTaskProperties.class})*/
@Component
public class GemfireDozerItemWriter implements ItemWriter<Map<String, Object>> {

    private static Logger LOG = LoggerFactory.getLogger(GemfireDozerItemWriter.class);

    @Autowired
    ClientCache cache;

    /*@Autowired
    DozerBeanMapper dmb;*/

    /*@Autowired
    JdbcGemfireTaskProperties props;*/

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void write(List<? extends Map<String, Object>> items) throws Exception {
        // TODO Auto-generated method stub
        LOG.info("RegionName : {}", "person");
        for (Map<String, Object> item : items) {
            try {
                LOG.info("Payload type : {}", item.getClass());
                Map payloadAsMap = item;
                Integer key = (Integer) payloadAsMap.get("id");
                BatchDemoJavaApplication.Person p = new BatchDemoJavaApplication.Person();
                p.setId((Integer) payloadAsMap.get("id"));
                p.setAge((Integer) payloadAsMap.get("age"));
                p.setEmail((String) payloadAsMap.get("email"));
                p.setFirstName((String) payloadAsMap.get("firstName"));

                Region region = cache.getRegion("person");
                LOG.info("Region to Load : {}", region.getFullPath());
                region.put(key, p);

            } catch (Exception e) {
                LOG.error("Exception in {} : Exception {} : Caused by: {}", "GemfireDozerItemWriter.class",
                        e.getMessage(), e.getCause());

            }
        }

    }
}
