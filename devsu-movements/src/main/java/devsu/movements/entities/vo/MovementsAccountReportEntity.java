package devsu.movements.entities.vo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity(name = "MovementsAccountReportEntity")
@Table(name = "REPORT_MOVEMENTS_ACCOUNT")
public class MovementsAccountReportEntity {
    @Id
    @Column(name = "ID_MOVEMENT")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_MOVEMENT")
    private LocalDate dateMovement;

    @Column(name = "CLIENT")
    private String client;

    @Column(name = "CLIENT_ID")
    private Long idCliente;

    @Column(name = "TYPE_ACCOUNT")
    private String typeAccount;

    @Column(name = "INITIAL_BALANCE_ACCOUNT")
    private Double initialBalance;

    @Column(name = "STATUS_MOVEMENT")
    private Boolean statusMovement;

    @Column(name = "MOVEMENT")
    private Double movement;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "CURRENT_BALANCE_ACCOUNT")
    private Double currentBalance;

}
