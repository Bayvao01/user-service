package com.user.service.repository;

import com.user.service.entities.UserPermissionTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermissionTable, Long> {

    List<UserPermissionTable> findAllByUserId(Long userId);
}
