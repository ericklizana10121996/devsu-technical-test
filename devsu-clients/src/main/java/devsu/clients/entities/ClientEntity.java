package devsu.clients.entities;

import devsu.clients.entities.generic.PersonEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
@Entity(name = "ClientEntity")
@Table(name = "TBL_CLIENT")
public class ClientEntity extends PersonEntity {
    @Column(name = "PASSWORD_CLIENT", nullable = false)
    private String password;

    @Column(name = "STATUS_CLIENT")
    private Boolean status;

    public boolean isActive() {
        return this.status;
    }
}
