/*
 * Copyright 2016 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.example.com.example.common.support;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("jdbcgemfire")
public class JdbcGemfireTaskProperties {

    public static final int DEFAULT_COMMIT_INTERVAL = 1000;

    public static final int DEFAULT_MAX_WORKERS = 2;

    /**
     * The GemFire region to write to.
     */
    public String regionName;

    /**
     * The GemFire servers to add to pool.
     */
    public String servers;

    /**
     * The properties location to be used.
     */
    private String propertiesLocation;

    /**
     * The security method to be used.
     */
    private String securityMethod;

    /**
     * The register url handler to be used.
     */
    private String registerUrlHandler;

    /**
     * The name of the table to be queried.
     */
    private String tableName;

    /**
     * The name of the columns to be queried.
     */
    private String columnNames;

    /**
     * Sql to be used to retrieve the data.
     */
    private String sql;

    /**
     * The commit interval for the application.
     */
    private int commitInterval = DEFAULT_COMMIT_INTERVAL;

    /**
     * The name of the column used to partition the data.
     */
    private String partitionColumn;

    /**
     * The name of the column used to determine if the data should be read.
     */
    private String checkColumn;

    /**
     * Is the batch job restartable.
     */
    private boolean restartable;

    /**
     * Maximum number of concurrent workers.
     */
    private int maxWorkers = DEFAULT_MAX_WORKERS;

    public String getPropertiesLocation() {
        return propertiesLocation;
    }

    public void setPropertiesLocation(String propertiesLocation) {
        this.propertiesLocation = propertiesLocation;
    }

    public String getSecurityMethod() {
        return securityMethod;
    }

    public void setSecurityMethod(String securityMethod) {
        this.securityMethod = securityMethod;
    }

    public String getRegisterUrlHandler() {
        return registerUrlHandler;
    }

    public void setRegisterUrlHandler(String registerUrlHandler) {
        this.registerUrlHandler = registerUrlHandler;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String columnNames) {
        this.columnNames = columnNames;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public int getCommitInterval() {
        return commitInterval;
    }

    public void setCommitInterval(int commitInterval) {
        this.commitInterval = commitInterval;
    }

    public String getPartitionColumn() {
        return partitionColumn;
    }

    public void setPartitionColumn(String partitionColumn) {
        this.partitionColumn = partitionColumn;
    }

    public String getCheckColumn() {
        return checkColumn;
    }

    public void setCheckColumn(String checkColumn) {
        this.checkColumn = checkColumn;
    }

    public boolean isRestartable() {
        return restartable;
    }

    public void setRestartable(boolean restartable) {
        this.restartable = restartable;
    }

    public int getMaxWorkers() {
        return maxWorkers;
    }

    public void setMaxWorkers(int maxWorkers) {
        this.maxWorkers = maxWorkers;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }
}
