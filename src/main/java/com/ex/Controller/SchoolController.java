package com.ex.Controller;

import com.ex.Payload.AddressDto;
import com.ex.Payload.MarksDto;
import com.ex.Payload.SchoolDto;
import com.ex.Repository.SchoolRepository;
import com.ex.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/save1")
    public ResponseEntity<SchoolDto> save(
           @RequestBody SchoolDto schoolDto)
    {
        SchoolDto schoolDto1 = schoolService.saveSchool(schoolDto);
        System.out.println("hi");
        System.out.println("hi");
        return new ResponseEntity<>(schoolDto1, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<SchoolDto> update(@RequestParam Long id, @RequestBody SchoolDto schoolDto)
    {
        SchoolDto schoolDto1 = schoolService.updateSchool(schoolDto,id);
        return new ResponseEntity<>(schoolDto1,HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<SchoolDto> delete(@RequestParam Long id)
    {
        SchoolDto schoolDto = schoolService.deleteSchool(id);
        return new ResponseEntity<>(schoolDto,HttpStatus.OK);
    }

    @GetMapping("/byId")
    public ResponseEntity<?> byId(@RequestParam Long id, BindingResult result)
    {
        if(result.hasErrors())
        {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
        }
        SchoolDto school = schoolService.findSchool(id);
        return new ResponseEntity<>(school,HttpStatus.OK);

    }

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<List<SchoolDto>> all()
    {
        List<SchoolDto> all = schoolService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @GetMapping("/getByName")
    public ResponseEntity<List<SchoolDto>> getByName(@RequestParam String name)
    {
        List<SchoolDto> schoolByName = schoolService.findSchoolByName(name);
        return new ResponseEntity<>(schoolByName,HttpStatus.OK);
    }

    @GetMapping("/getAllDetails")
     public ResponseEntity<Map<List<SchoolDto>,List<MarksDto>>> getAllDetails()
    {
        Map<List<SchoolDto>, List<MarksDto>> allMarks = schoolService.getAllMarks();
        return new ResponseEntity<>(allMarks,HttpStatus.OK);
    }



}
