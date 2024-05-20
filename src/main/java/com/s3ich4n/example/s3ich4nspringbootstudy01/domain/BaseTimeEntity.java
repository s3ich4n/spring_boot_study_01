package com.s3ich4n.example.s3ich4nspringbootstudy01.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass // jpa entity가 이걸 상속하면 아래 필드가 알아서 컬럼으로 들어가짐
@EntityListeners(AuditingEntityListener.class) // auditing 기능을 내장함
public abstract class BaseTimeEntity {

    @CreatedDate private LocalDateTime createdDateTime;

    @LastModifiedDate private LocalDateTime modifiedDateTime;
}
