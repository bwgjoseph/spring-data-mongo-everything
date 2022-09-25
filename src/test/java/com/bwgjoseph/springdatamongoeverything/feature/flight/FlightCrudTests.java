package com.bwgjoseph.springdatamongoeverything.feature.flight;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.bwgjoseph.springdatamongoeverything.domain.core.AuditInfo;
import com.bwgjoseph.springdatamongoeverything.domain.core.Source;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
class FlightCrudTests {
    @Autowired
    private FlightRepository repository;

    private String createdId;

    Flight getFlight() {
        AuditInfo auditInfo = AuditInfo.builder()
                .createdAt(LocalDateTime.now())
                .createdBy("Joseph")
                .updatedAt(LocalDateTime.now())
                .updatedBy("Joseph")
                .build();

        List<Source> sources = List.of(
            new Source("SSA", "remarks")
        );

        return Flight.builder()
                .auditInfo(auditInfo)
                .sources(sources)
                .aircraft("aircraft")
                .origin("Singapore")
                .destination("UK")
                .departureDateTime(Instant.now())
                .arrivalDateTime(Instant.now())
                .flightTime(20L)
                .build();
    }

    @BeforeAll
    void beforeAll() {
        Flight saved = this.repository.insert(getFlight());
        this.createdId = saved.getId();
    }

    @Test
    @Order(1)
    void create() {
        Assertions.assertThat(this.createdId).isNotEmpty().isNotNull();
        Flight saved = this.repository.findById(this.createdId).get();

        Assertions.assertThat(saved)
            .usingRecursiveComparison()
            .ignoringFieldsOfTypes(LocalDateTime.class, Instant.class)
            .ignoringFields("id", "version")
            .isEqualTo(getFlight());
    }

    @Test
    @Order(2)
    void find() {
        Optional<Flight> found = this.repository.findById(this.createdId);

        Assertions.assertThat(found).isPresent();
    }

    @Test
    @Order(3)
    void update() {
        Flight found = this.repository.findById(this.createdId).get();
        Flight toUpdate = found.toBuilder().aircraft("aircraft2").build();
        Flight updated = this.repository.save(toUpdate);

        Assertions.assertThat(found.getVersion()).isZero();
        Assertions.assertThat(updated.getVersion()).isEqualTo(1L);
        Assertions.assertThat(updated.getAircraft()).isEqualTo("aircraft2");
    }

    @Test
    @Order(4)
    void delete() {
        this.repository.deleteById(this.createdId);
        Optional<Flight> deleted = this.repository.findById(this.createdId);

        Assertions.assertThat(deleted).isNotPresent();
    }
}
