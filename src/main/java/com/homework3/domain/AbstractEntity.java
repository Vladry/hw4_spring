package com.homework3.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.homework3.DTO.Views;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({Views.Public.class, Views.Internal.class})
    protected Long id;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING,
    pattern = "dd-MM-yyyy hh:mm:ss")
    @JsonView(Views.Public.class)
    protected Date createdDate;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING,
    pattern = "dd-MM-yyyy hh:mm:ss")
    @JsonView(Views.Public.class)
    protected Date lastModifiedDate;

}
