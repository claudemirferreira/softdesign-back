package com.softdesign.demo.base.core.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractModel {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID id;

    private Date createdAt;

    private Date updatedAt;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final AbstractModel that = (AbstractModel) obj;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
