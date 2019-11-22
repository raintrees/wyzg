package com.wyzg.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wyzg.pojo.CarSource;
import com.wyzg.pojo.GoodsSource;
import com.wyzg.pojo.PageResult;
import com.wyzg.service.CarSourceService;
import com.wyzg.service.GoodsSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsSourceController {

    @Autowired
    private GoodsSourceService goodsSourceService;

    /**
     * 查询所有货源并分页
     * @return
     */
    @GetMapping("/goods/resource/page")
    public ResponseEntity<PageResult<GoodsSource>> queryGoodsByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy",defaultValue = "id",required = false)String sortBy,
            @RequestParam(value = "desc",defaultValue = "true") Boolean desc,
            @RequestParam(value = "key",required = false)String key){

        PageResult<GoodsSource> goodsSources = goodsSourceService.queryGoodsByPage(page,rows,sortBy,desc,key);
        return ResponseEntity.ok(goodsSources);
    }

    /**
     * 货源添加
     * @param goodsSource
     * @return
     */
    @PostMapping("/goods/resource/add")
    public ResponseEntity<Void> saveGoods(GoodsSource goodsSource){

        goodsSourceService.insertGoods(goodsSource);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 根据id查询货源详情
     * @param id
     * @return
     */
    @GetMapping("/goods/resource/query/{id}")
    public ResponseEntity<GoodsSource> queryGoodsById(@PathVariable("id")Integer id){
        GoodsSource goodsSource = goodsSourceService.queryGoodsById(id);
        return ResponseEntity.ok(goodsSource);
    }

    /**
     * 修改货源信息
     * @param goodsSource
     * @return
     */
    @PutMapping("/goods/resource/update")
    public ResponseEntity<Void> updateGoods(GoodsSource goodsSource){
        goodsSourceService.updateGoods(goodsSource);
        return ResponseEntity.ok(null);
    }

    /**
     * 根据id删除货源信息
     */
    @DeleteMapping("/goods/resource/delete/{id}")
    public ResponseEntity<Void> deleteGoodsById(@PathVariable("id")Integer id){
        goodsSourceService.deleteGoodsById(id);
        return ResponseEntity.ok(null);
    }

}
