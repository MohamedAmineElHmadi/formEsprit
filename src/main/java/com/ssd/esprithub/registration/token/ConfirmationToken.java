package com.ssd.esprithub.registration.token;

import com.ssd.esprithub.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id ;
    @Column(nullable = false)

    private String token;
    @Column ( nullable = false)

    private LocalDateTime createdAt;
    @Column(nullable = false)

    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn (
            nullable = false,
            name = "user_id"
    )
    private User user ;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt,  User user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.user = user;
    }
}
