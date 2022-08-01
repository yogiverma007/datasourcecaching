# Datasource Module

This repository provides the datasource caching 

You need to take care of mainly below items to use the library:
- Specify the environment variables in your environment and list can be found below:

- EMPLOYEE_DB_HOST=127.0.0.1
- EMPLOYEE_DB_PORT=3306
- EMPLOYEE_DB_NAME=employee
- EMPLOYEE_DB_USER=<username>
- EMPLOYEE_DB_PASSWORD=<password>

------------

### Database properties can be overridden in your configuration.
- employee.datasource.poolName=EmployeeDatabasePool
- employee.datasource.jdbcUrl=jdbc:mysql://${EMPLOYEE_DB_HOST}:${EMPLOYEE_DB_PORT}/${EMPLOYEE_DB_NAME}?&useSSL=false&allowPublicKeyRetrieval=true
- employee.datasource.username=${EMPLOYEE_DB_USER}
- employee.datasource.password=${EMPLOYEE_DB_PASSWORD}
- employee.datasource.prepStmtCacheSize=250
- employee.datasource.prepStmtCacheSqlLimit=2048
- employee.datasource.cachePrepStmts=true
- employee.datasource.maximumPoolSize=5
- employee.datasource.maxLifetime=1800000
- employee.datasource.connectionTimeout=250
- employee.datasource.leakDetectionThreshold=600000
- employee.datasource.autoCommit=true


### Properties main entity class
```java
package com.freedom.datasourcecaching.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "properties")
public class Properties implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "value", nullable = false)
  private String value;

  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "extended_info")
  private String extendedInfo;

  @Column(name = "updated_by")
  private String updatedBy;

  @Column(name = "created_on", nullable = false)
  private Date createdOn;

  @Column(name = "updated_on", nullable = false)
  private Date updatedOn;
}

```


