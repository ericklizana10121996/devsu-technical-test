package devsu.movements.entities;

import devsu.movements.commons.MovementTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "MovementEntity")
@Table(name = "TBL_MOVEMENT")
public class MovementEntity {
    @Id
    @Column(name = "ID_MOVEMENT", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMovement")
    @SequenceGenerator(sequenceName = "SEQ_MOVEMENT", allocationSize = 1, name = "seqMovement")
    private Long id;

    /*@Column(name = "ACCOUNT_MOVEMENT", nullable = false)
    private Long accountId;*/

    @Column(name = "DATE_MOVEMENT", nullable = false)
    private LocalDate date;

    @Column(name = "TYPE_MOVEMENT", nullable = false)
    private String type;

    @Column(name = "VALUE_MOVEMENT", nullable = false)
    private Double value;

    @Column(name = "CURRENT_BALANCE_MOVEMENT", nullable = false)
    private Double currentBalance;

    @Column(name = "STATUS_MOVEMENT")
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID_MOVEMENT")
    private AccountEntity account;

    public boolean isActive() {
        return this.status;
    }

    @PrePersist
    void onCreate() {
        this.status = Boolean.TRUE;
        this.date = LocalDate.now();
        //this.type = this.value > 0 ? MovementTypeEnum.DEPOSITO.name() : MovementTypeEnum.RETIRO.name();
    }
}
