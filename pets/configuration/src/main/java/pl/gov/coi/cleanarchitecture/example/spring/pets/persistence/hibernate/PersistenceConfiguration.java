package pl.gov.coi.cleanarchitecture.example.spring.pets.persistence.hibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.gov.coi.cleanarchitecture.example.spring.pets.domain.model.gateway.PetsGateway;
import pl.gov.coi.cleanarchitecture.example.spring.pets.persistence.ExampleData;
import pl.gov.coi.cleanarchitecture.example.spring.pets.persistence.hibernate.mapper.PetToPetDataConverter;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * @author <a href="krzysztof.suszynski@wavesoftware.pl">Krzysztof Suszyński</a>
 * @since 2018-01-18
 */
@Profile("hibernate")
@Configuration
class PersistenceConfiguration {

  @Bean
  @Transactional
  public PetsGateway provide(ExampleData exampleData,
                             PetToPetDataConverter mapper,
                             EntityManager entityManager) {
    PetsGateway stub = new HibernatePetsGateway(entityManager, mapper);
    exampleData.createExamples(stub);
    return stub;
  }
}

