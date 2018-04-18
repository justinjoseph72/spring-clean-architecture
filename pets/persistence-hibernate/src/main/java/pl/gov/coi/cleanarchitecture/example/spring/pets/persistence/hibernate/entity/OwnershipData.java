package pl.gov.coi.cleanarchitecture.example.spring.pets.persistence.hibernate.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author <a href="krzysztof.suszynski@wavesoftware.pl">Krzysztof Suszyński</a>
 * @since 2018-01-18
 */
@Table
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class OwnershipData extends Record {

  private PetData pet;
  private PersonData person;
  private Date from;

  @Valid
  @NotNull
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "ownership")
  public PetData getPet() {
    return pet;
  }

  @Valid
  @NotNull
  @OneToOne(cascade = CascadeType.ALL)
  public PersonData getPerson() {
    return person;
  }

  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "date_from")
  public Date getFrom() {
    return from;
  }
}
