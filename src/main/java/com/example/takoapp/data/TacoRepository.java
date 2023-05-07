package com.example.takoapp.data;

import com.example.takoapp.domain.Taco;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TacoRepository extends PagingAndSortingRepository<Taco,Long> {

    Optional<Taco> findById(Long id);

    Taco save(Taco taco);
}
