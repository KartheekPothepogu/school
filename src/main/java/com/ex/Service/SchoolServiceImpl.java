package com.ex.Service;

import com.ex.Entity.Marks;
import com.ex.Entity.School;
import com.ex.Exception.ResourceNotFound;
import com.ex.Payload.MarksDto;
import com.ex.Payload.SchoolDto;
import com.ex.Repository.MarksRepository;
import com.ex.Repository.SchoolRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService{
//
//    @Autowired
    private ModelMapper modelMapper;
//
//    @Autowired
    private SchoolRepository schoolRepository;
//
//   @Autowired
   private MarksService marksService;

    @Override
    public SchoolDto saveSchool(SchoolDto schoolDto) {

        School map = modelMapper.map(schoolDto, School.class);
        School save = schoolRepository.save(map);

        return modelMapper.map(save,SchoolDto.class);
    }

    @Override
    public SchoolDto updateSchool(SchoolDto schoolDto, Long id) {

        School school = schoolRepository.findById(id).get();
        School map = modelMapper.map(schoolDto, School.class);
        school=map;
        school.setId(id);
        School save = schoolRepository.save(school);

        return modelMapper.map(save,SchoolDto.class);
    }

    @Override
    public SchoolDto deleteSchool(Long id) {
        School school = schoolRepository.findById(id).get();
        schoolRepository.deleteById(id);
        return modelMapper.map(school,SchoolDto.class);
    }

    @Override
    public List<SchoolDto> getAll() {
        return schoolRepository.findAll().stream().map(i->modelMapper.map(i,SchoolDto.class)).toList();

    }

    @Override
    public SchoolDto findSchool(Long id) {
        School school = schoolRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("this" + id + "not found"));
        return modelMapper.map(school,SchoolDto.class);

    }

    @Override
    public List<SchoolDto> findSchoolByName(String name) {

        List<School> byName = schoolRepository.findByName(name);
        List<SchoolDto> all = getAll();
        List<MarksDto> all1 = marksService.getAll();
        Map<List<SchoolDto>, List<MarksDto>> res= new HashMap<>();
        res.put(all,all1);
        return null;
    }

    @Override
    public Map<List<SchoolDto>, List<MarksDto>> getAllMarks() {
        return Map.of();
    }


}
