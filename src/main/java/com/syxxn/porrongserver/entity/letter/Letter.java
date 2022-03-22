package com.syxxn.porrongserver.entity.letter;

import com.syxxn.porrongserver.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_letter")
@Entity
public class Letter  extends BaseIdEntity {

    @Column(nullable = false, length = 16000)
    private String content;

    @Column(nullable = false)
    private LocalDateTime releaseDate;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, columnDefinition = "bit default 0")
    private Boolean isReleased = false;

    public static Letter createLetter(String content, LocalDateTime releaseDate) {
        Letter letter = new Letter();
        letter.content = content;
        letter.releaseDate = releaseDate;

        return letter;
    }

    public void isReleasedTrue() {
        this.isReleased = true;
    }

}
