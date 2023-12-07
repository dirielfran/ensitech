package com.eareiza.ensitech.backend.model;

import com.eareiza.ensitech.backend.enums.TypeServiceEnum;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="character")
@SQLDelete(sql = "UPDATE character SET enabled=false WHERE id = ?")
public class CharacterRegistry extends EntityCommon implements Serializable {
    private String etag;
    private String type;
}
