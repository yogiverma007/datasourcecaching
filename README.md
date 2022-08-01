# Datasource Module

This repository provides the datasource configuration for mysql

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


### Employee main entity class
```java
import com.freedom.datasource.dto.EmployeeExtendedInfoDto;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "employee")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Employee implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "contact", nullable = false)
  private String contact;

  @Column(name = "address")
  private String address;

  @Column(name = "status", nullable = false)
  private String status;

  @Column(name = "extended_info")
  @Type(type = "json")
  private EmployeeExtendedInfoDto extendedInfo;

  @Column(name = "created_on", insertable = false, updatable = false)
  private Date createdOn;

  @Column(name = "updated_on", insertable = false, updatable = false)
  private Date updatedOn;
}
```


In the main entity class  EmployeeExtendedInfoDto is the column which describes json from database table as: extended_info and whose defination is taken by @Type annotation.


Dev followed from this link: https://vladmihalcea.com/how-to-map-json-objects-using-generic-hibernate-types/