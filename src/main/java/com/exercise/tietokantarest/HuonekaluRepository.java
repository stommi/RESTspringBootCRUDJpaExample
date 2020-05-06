package com.exercise.tietokantarest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface HuonekaluRepository extends PagingAndSortingRepository<Huonekalut, Integer> {
    @Query("SELECT h.nimi, h.vari FROM Huonekalut h WHERE h.vari = 'punainen' ")
    Iterable<Huonekalut> getPunaisetHuonekalut();

    @Query("SELECT h.nimi, h.vari FROM Huonekalut h WHERE h.lkm = :maara")
    Iterable<Huonekalut> getHuonekalutByMaara(@Param("maara") Integer maara);
}