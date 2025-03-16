package com.example.teamservice.repository;

import com.example.teamservice.entity.TeamUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamUserRepository extends JpaRepository<TeamUser, Long> {
    @Query(value = "SELECT * FROM team_user WHERE user_id = :userId AND status = 'ACCEPTED'", nativeQuery = true)
    List<TeamUser> findByUserIdAndStatus(Long userId);

    @Query(value = "SELECT * FROM team_user WHERE team_id = :teamId AND status = 'ACCEPTED'", nativeQuery = true)
    List<TeamUser> findByTeamIdAndStatus(Long teamId);

    @Query(value = "SELECT * FROM team_user WHERE team_id IN (SELECT team_id FROM team_user WHERE user_id = :userId AND status = 'ACCEPTED') AND status = 'PENDING'", nativeQuery = true)
    List<TeamUser> findRequestsByUserID(@Param("userId") Long userId);

    @Modifying
    @Query(value = "UPDATE team_user SET status = 'ACCEPTED' WHERE id = :requestID", nativeQuery = true)
    int acceptTeamUser(@Param("requestID") Long requestID);

    @Modifying
    @Query(value = "UPDATE team_user SET status = 'REJECTED' WHERE id = :requestID", nativeQuery = true)
    int rejectTeamUser(@Param("requestID") Long requestID);
}

