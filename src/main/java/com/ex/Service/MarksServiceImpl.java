package com.ex.Service;

import com.ex.Entity.Marks;
import com.ex.Entity.School;
import com.ex.Payload.MarksDto;
import com.ex.Repository.MarksRepository;
import com.ex.Repository.SchoolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarksServiceImpl implements MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MarksDto saveMarks(MarksDto marksDto, Long id) {

        School school = schoolRepository.findById(id).get();
        marksDto.setSchool(school);
        Marks map = modelMapper.map(marksDto, Marks.class);
        Marks save = marksRepository.save(map);

        return modelMapper.map(save, MarksDto.class);
    }

    @Override
    public MarksDto updateMarks(MarksDto marksDto, Long id) {
        return null;
    }

    @Override
    public MarksDto deleteMarks(Long id) {
        return null;
    }

    @Override
    public List<MarksDto> getAll() {
        List<Marks> all = marksRepository.findAll();
        return all.stream().map(i->modelMapper.map(i,MarksDto.class)).collect(Collectors.toList());
    }

    @Override
    public MarksDto findMarks(Long id) {
        return null;
    }
}
