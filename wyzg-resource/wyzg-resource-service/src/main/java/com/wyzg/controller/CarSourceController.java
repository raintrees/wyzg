package com.wyzg.controller;

import com.wyzg.common.VO.PageResult;
import com.wyzg.pojo.CarSource;
import com.wyzg.service.CarSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarSourceController {

    @Autowired
    private CarSourceService carSourceService;

    /**
     * 查询所有汽车资源并分页
     * @return
     */
    @GetMapping("/car/resource/page")
    public ResponseEntity<PageResult<CarSource>> queryCarByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy",defaultValue = "id",required = false)String sortBy,
            @RequestParam(value = "desc",defaultValue = "true")Boolean desc,
            @RequestParam(value = "key",required = false)String key){
        PageResult<CarSource> carSources = carSourceService.queryCarByPage(page,rows,sortBy,desc,key);
        return ResponseEntity.ok(carSources);
    }

    /**
     * 根据车源id查询车源详情
     * @param id
     * @return
     */
    @GetMapping("/car/resource/query/{id}")
    public ResponseEntity<CarSource> queryCarById(@PathVariable("id")Integer id){
        CarSource carSource = carSourceService.queryCarById(id);
        return ResponseEntity.ok(carSource);
    }

    /**
     * 添加车源信息
     * @param carSource
     * @return
     */
    @PostMapping("/car/resource/add")
    public ResponseEntity<Void> addCar(CarSource carSource){
        carSourceService.addCar(carSource);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 修改车源信息
     * @param carSource
     * @return
     */
    @PutMapping("/car/resource/update")
    public ResponseEntity<Void> updateCar(CarSource carSource){
        carSourceService.updateCar(carSource);
        return ResponseEntity.ok(null);
    }

    /**
     * 通过车源id删除车源信息
     * @param id
     * @return
     */
    @DeleteMapping("/car/resource/delete/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable("id")Integer id){
        carSourceService.deleteCarById(id);
        return ResponseEntity.ok(null);

    }

}
