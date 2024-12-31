package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SessionRepository extends JpaRepository<Session, Long> {
  Session save(Session session);

  @Query(value = "select * from session s where s.session_id = :sessionId", nativeQuery = true)
  Session getBySessionId(@Param("sessionId") String sessionId);

  @Query(value = "select * from session s where s.session_id = :sessionId and s.expires_at > :currentTime and s.is_deleted = FALSE",nativeQuery = true)
  Session findBySessionIdAndIsDeletedFalseAndExpiresAtGreaterThan(@Param("sessionId") String sessionId,@Param("currentTime") Long currentTime);
}
