# Everything on Spring Data MongoDB

Project generated via [spring.io](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.7.2&packaging=jar&jvmVersion=17&groupId=com.bwgjoseph&artifactId=spring-data-mongo-everything&name=spring-data-mongo-everything&description=Everything%20on%20Spring%20Data%20Mongo&packageName=com.bwgjoseph.spring-data-mongo-everything&dependencies=devtools,lombok,configuration-processor,web,data-mongodb)

## Goal

- [x] Basic CRUD usage
- [x] Domain Model with BaseRecord inheritance
- [ ] Inheritance
  - [ ] On same collection
  - [ ] On different collection
- [ ] Various [Schema Design Pattern](https://www.mongodb.com/blog/post/building-with-patterns-a-summary)
  - [ ] Polymorphic
  - [ ] Document Versioning
  - [ ] Schema Versioning
- [x] Using `@TypeAlias`
- [ ] Using `Converter`
- [ ] Using `@DBRef`
- [ ] Using `Criteria`
- [ ] Using `Java Record` as `Document`
- [ ] Sub-Document query via
  - [ ] Derived Query
  - [ ] Criteria Query
- [ ] Indexing
  - [ ] Single
  - [ ] Compound
- [ ] Validation
  - [ ] [JSON Schema](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo.jsonSchema)
  - [ ] Pojo
- [x] Versioning
  - [x] Root Document
  - [ ] Sub / Nested Document
- [ ] Publish Domain Event
- [ ] Route read / write query
- [ ] Aggregation Framework
- [ ] Change Stream
- [ ] [Fragments](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#repositories.single-repository-behavior)
- [ ] Default support for [pagable and sort](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#core.web.basic.paging-and-sorting)
- [ ] Integration
  - [ ] jackson
  - [ ] springdoc-openapi
  - [ ] spring-security
  - [ ] [spring-data-jpa-mongodb-expressions](https://github.com/mhewedy/spring-data-jpa-mongodb-expressions)
- [ ] [Mapping](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mapping-chapter)
- [ ] Projection
- [ ] [Lifecycle Events](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongodb.mapping-usage.events)

## References

- [spring-data-examples](https://github.com/spring-projects/spring-data-examples)