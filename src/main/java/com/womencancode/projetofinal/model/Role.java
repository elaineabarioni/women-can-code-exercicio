package com.womencancode.projetofinal.model;

import com.mongodb.lang.NonNull;
import com.womencancode.projetofinal.service.BaseModel;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Role extends BaseModel {

    @NonNull
    private String name;

    @Builder
    public Role(String id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, String name) {
        super(id, createdDate, lastModifiedDate);
        this.name = name;
    }

}
