package org.example.diary.repository;

import org.example.diary.entity.CallBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallBackRepository extends JpaRepository<CallBack,Long> {
}
