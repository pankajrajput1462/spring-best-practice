package org.pankaj.demo.repo;

import org.pankaj.demo.model.Comment;
import org.pankaj.demo.model.leader.Leader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeaderRepository extends JpaRepository<Leader, Long> {
}