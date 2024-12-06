package org.koreait.pokemon.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import org.koreait.global.entities.BaseEntity;

@Data
@Entity
public class Pokemon extends BaseEntity {
    @Id
private Long seq;
@Column(length = 50)
private String name;
    @Column(length = 50)
    private String nameEn;
    private int weight;
    private int height;
    private int baseExperience;
    private String frontImage;
    @Lob
    private String flavorText;
    private String types;
    private String abilities;
}
