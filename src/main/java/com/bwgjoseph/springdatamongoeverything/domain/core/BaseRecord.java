package com.bwgjoseph.springdatamongoeverything.domain.core;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class BaseRecord {
    @Id
    @EqualsAndHashCode.Include
    private String id;

    private AuditInfo auditInfo;
    private List<Source> sources;

    @Version
    private Long version;
}
