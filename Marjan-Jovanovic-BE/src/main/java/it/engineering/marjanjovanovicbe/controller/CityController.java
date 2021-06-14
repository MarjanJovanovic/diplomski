package it.engineering.marjanjovanovicbe.controller;

import it.engineering.marjanjovanovicbe.dto.CityDto;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.engineering.marjanjovanovicbe.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/city")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getAll")
    public @ResponseBody
    ResponseEntity<List<CityDto>> getAll() throws MyEntityNotFoundException {
        List<CityDto> list = cityService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/findById{id}")
    public @ResponseBody ResponseEntity<Object> get(@PathVariable Long id) {
        Optional<CityDto> cityDto = cityService.findById(id);
        if (cityDto.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(cityDto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid city code!");
    }

    @GetMapping("/getAllFiltered")
    public @ResponseBody ResponseEntity<Page<CityDto>> getByPage(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.getAll(pageable));
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<Object> save(@Valid @RequestBody CityDto cityDto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cityService.save(cityDto));
        }catch (MyEntityAlreadyExistsException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error saving city entity: " + cityDto);
        }
    }

    @PutMapping("/update")
    public @ResponseBody ResponseEntity<CityDto> update(@Valid @RequestBody CityDto cityDto) throws MyEntityNotFoundException{
        Optional<CityDto> city = cityService.update(cityDto);
        if (city.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(city.get());
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cityDto);
        }
    }

    @DeleteMapping("/delete{cityCode}")
    public @ResponseBody ResponseEntity<String> delete(@PathVariable(name = "cityCode") Long cityCode){
        try{
            cityService.delete(cityCode);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted city with code: " + cityCode);
        } catch (MyEntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
