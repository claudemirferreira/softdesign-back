package com.softdesign.demo.base.core.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@JsonFilter("onlyQueryFieldsProperty")
public class BaseDTO implements Serializable {

    private UUID id;

    public BaseDTO() {}

    public BaseDTO(UUID id) {this.id = id;}

    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        BaseDTO baseDTO = (BaseDTO) o;
        return Objects.equals(id, baseDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

}
