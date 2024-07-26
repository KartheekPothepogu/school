package com.ex.Payload;

import com.ex.Entity.School;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarksDto {

    private Long id;

    private Long maths;

    private Long science;

    private Long social;

    private Long physics;

    private School school;



}
