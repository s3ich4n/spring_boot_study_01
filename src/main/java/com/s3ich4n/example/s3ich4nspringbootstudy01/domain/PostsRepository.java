package com.s3ich4n.example.s3ich4nspringbootstudy01.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @s
 * @implNote 엔티티와 같이 두는 것이 좋다. 엔티티는 이거 없으면 DB 처리를 못한다 RDBMS에 담으려고 Spring Data JPA 를 쓰는거지 (만일 다른데
 *     담으려면 다른 Spring Data를 썼겠지)
 *     <p>이게 있음으로서 기본적인 CRUD는 알아서 생성된다 앞으로 복잡한 쿼리를 어떻게 처리하느냐는 여기서 갖고온 결과를 조인하는지, 처음부터 조인용
 *     repository를 팔 수 있는지 더 공부해봐야 한다.
 *     <p>그리고 SQLAlchemy 처럼 insert 후에 .flush() 나 .add() 를 자체적으로 콜함으로인해, ORM 객체의 값이 영속 저장소에 알아서 반영되는
 *     개념을 Dirty checking이라고 하는 것으로 보인다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p order by p.id DESC")
    List<Posts> findAllDesc();
}
