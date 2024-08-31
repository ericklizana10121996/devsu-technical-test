package devsu.clients.entities.generic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity(name = "PersonEntity")
@Table(name="TBL_PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonEntity {

    @Id
    @Column(name = "ID_PERSON", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPerson")
    @SequenceGenerator(sequenceName = "SEQ_PERSON", allocationSize = 1, name = "seqPerson")
    private Long id;

    @Column(name="NAME_PERSON")
    private String name;

    @Column(name = "GENDER_PERSON")
    private String gender;

    @Column(name = "AGE_PERSON")
    private Integer age;

    @Column(name = "IDENTITY_DOCUMENT_PERSON")
    private String identityDocument;

    @Column(name = "ADDRESS_PERSON")
    private String address;

    @Column(name = "PHONE_PERSON")
    private String phone;
}
