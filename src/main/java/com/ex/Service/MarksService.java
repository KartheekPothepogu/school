package com.ex.Service;

import com.ex.Payload.MarksDto;
import com.ex.Payload.SchoolDto;

import java.util.List;

public interface MarksService {

    MarksDto saveMarks(MarksDto marksDto,Long id);

    MarksDto updateMarks(MarksDto marksDto,Long id);

    MarksDto deleteMarks(Long id);

    List<MarksDto> getAll();

    MarksDto findMarks(Long id);
}
