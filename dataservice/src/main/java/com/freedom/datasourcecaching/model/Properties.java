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

/*
DROP TABLE IF EXISTS `properties`;
CREATE TABLE `properties` (
    `id`                BIGINT          NOT NULL AUTO_INCREMENT,
    `name`              VARCHAR(200)    NOT NULL,
    `value`             VARCHAR(1000)   NOT NULL,
    `type`              VARCHAR(20)     NOT NULL,
    `extended_info`     JSON            DEFAULT NULL,
    `created_on`        DATETIME(3)     NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    `updated_on`        DATETIME(3)     NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
    `updated_by`        VARCHAR(200)    DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY (`name`, `type`)
);

insert into properties(name, value, type, extended_info) values('ENABLE_EMPLOYEE_RISK_FACTORS1', '65', 'APPLICATION', null);
insert into properties(name, value, type, extended_info) values('ENABLE_EMPLOYEE_RISK_FACTORS2', '65', 'APPLICATION', null);
insert into properties(name, value, type, extended_info) values('ENABLE_EMPLOYEE_RISK_FACTORS3', '65', 'APPLICATION', null);
insert into properties(name, value, type, extended_info) values('ENABLE_EMPLOYEE_RISK_FACTORS4', '65', 'APPLICATION', null);

*/
