package com.fortune.fortune.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "horoscopes")
public class Horoscope {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sign_id", nullable = false)
    private Signs sign;

    @Enumerated(EnumType.STRING)
    @Column(name = "timeframe", nullable = false)
    private TimeFrame timeframe;

    @Column(name = "reading", nullable = false)
    private String reading;

    public Horoscope() {

    }

    public Horoscope(Long id, Signs sign, TimeFrame timeframe, String reading) {
        this.id = id;
        this.sign = sign;
        this.timeframe = timeframe;
        this.reading = reading;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Signs getSign() {
        return sign;
    }

    public void setSign(Signs sign) {
        this.sign = sign;
    }

    public TimeFrame getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(TimeFrame timeframe) {
        this.timeframe = timeframe;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    enum TimeFrame {
        DAILY,
        WEEKLY,
        MONTHLY
    }

}
