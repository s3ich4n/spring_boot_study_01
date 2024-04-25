package com.s3ich4n.example.s3ich4nspringbootstudy01.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @s
 *
 * @implNote
 *  엔티티와 같이 두는 것이 좋다.
 *  엔티티는 이거 없으면 DB 처리를 못한다
 *  RDBMS에 담으려고 Spring Data JPA 를 쓰는거지
 *  (만일 다른데 담으려면 다른 Spring Data를 썼겠지)
 */
public interface PostsRepository extends JpaRepository<Posts, Long>{
}
