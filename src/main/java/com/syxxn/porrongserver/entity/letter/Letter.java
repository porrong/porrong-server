package com.syxxn.porrongserver.entity.letter;

import com.syxxn.porrongserver.entity.BaseIdEntity;
import com.syxxn.porrongserver.entity.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tbl_letter")
@Entity
public class Letter  extends BaseIdEntity {

    @Column(nullable = false, length = 16000)
    private String content;

    @Column(nullable = false, length = 30)
    private String dear;

    @Column(nullable = false, length = 45)
    private String email;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Boolean isReleased;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public static Letter createLetter(String content, String dear, String email, LocalDate releaseDate, User user) {
        Letter letter = new Letter();
        letter.content = content;
        letter.dear = dear;
        letter.email = email;
        letter.releaseDate = releaseDate;
        letter.user = user;
        letter.isReleased = !LocalDate.now().isBefore(releaseDate);

        return letter;
    }

    public void isReleasedTrue() {
        this.isReleased = true;
    }

}
