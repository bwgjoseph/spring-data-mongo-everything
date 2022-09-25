package com.bwgjoseph.springdatamongoeverything.feature.flight;

import java.time.Instant;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bwgjoseph.springdatamongoeverything.domain.core.BaseRecord;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Document("flight")
@TypeAlias("flight")
public class Flight extends BaseRecord {
    private String aircraft;
    private String origin;
    private String destination;
    private Instant departureDateTime;
    private Instant arrivalDateTime;
    private Long flightTime;
}
