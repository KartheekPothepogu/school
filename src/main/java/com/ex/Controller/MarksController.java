package com.ex.Controller;

import com.ex.Payload.MarksDto;
import com.ex.Service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/marks")
@RestController
public class MarksController {


    @Autowired
    private MarksService marksService;


    @PostMapping("/add")
    public ResponseEntity<MarksDto> add(@RequestBody MarksDto marksDto, @RequestParam Long id)
    {
        return new ResponseEntity<>(marksService.saveMarks(marksDto,id), HttpStatus.CREATED);
    }


}
