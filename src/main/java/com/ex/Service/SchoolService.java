package com.ex.Service;

import com.ex.Payload.MarksDto;
import com.ex.Payload.SchoolDto;

import java.util.List;
import java.util.Map;

public interface SchoolService {

    SchoolDto saveSchool(SchoolDto schoolDto);

    SchoolDto updateSchool(SchoolDto schoolDto,Long id);

    SchoolDto deleteSchool(Long id);

    List<SchoolDto> getAll();

    SchoolDto findSchool(Long id);

    List<SchoolDto> findSchoolByName(String name);

    Map<List<SchoolDto>,List<MarksDto>> getAllMarks();




}
