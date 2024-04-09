package com.fortune.fortune.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortune.fortune.Model.Horoscope;

public interface HoroscopeRepository extends JpaRepository<Horoscope, Long> {

}
