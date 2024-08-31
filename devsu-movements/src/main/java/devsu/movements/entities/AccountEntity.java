package devsu.movements.entities;

import jakarta.persistence.*;
import lombok.*;

//import java.util.HashSet;
import java.util.Set;
import static devsu.movements.commons.Util.generateAccountNumber;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "AccountEntity")
@Table(name = "TBL_ACCOUNT")
public class AccountEntity {
    @Id
    @Column(name = "ID_ACCOUNT", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAccount")
    @SequenceGenerator(sequenceName = "SEQ_ACCOUNT", allocationSize = 1, name = "seqAccount")
    private Long id;

    @Column(name = "CLIENT_ID_ACCOUNT", nullable = false)
    private Long clientId;

    @Column(name = "NUMBER_ACCOUNT", nullable = false)
    private String accountNumber;

    @Column(name = "TYPE_ACCOUNT", nullable = false)
    private String type;

    @Column(name = "INITIAL_BALANCE_ACCOUNT", nullable = false)
    private Double initialBalance;

    @Column(name = "CURRENT_BALANCE_ACCOUNT", nullable = false)
    private Double currentBalance;

    @Column(name = "STATUS_ACCOUNT")
    private Boolean status;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MovementEntity> movements;

    public boolean isActive() {
        return this.status;
    }

    public boolean isCurrentBalanceZero() {
        return this.currentBalance == 0;
    }

    @PrePersist
    protected void onCreate() {
        this.status = Boolean.TRUE;
        this.accountNumber = generateAccountNumber();
    }

}
