package com.hxg.girl.controller;

import com.hxg.girl.domain.Girl;
import com.hxg.girl.domain.Result;
import com.hxg.girl.repository.GirlRepository;
import com.hxg.girl.service.GirlService;
import com.hxg.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girl() {

        return girlRepository.findAll();
    }

    @GetMapping(value = "/girls/{id}")
    public Girl girl(@PathVariable("id") Integer id) {

        return girlService.findGirlById(id);
    }

    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }


    @PutMapping(value = "/girls/{id}")
    public Girl girlUpDate(@PathVariable("id") Integer id, String cupSize, Integer age) {

        Girl girl = new Girl(id, cupSize, age);

        return girlService.girlUpdate(girl);
    }

    @DeleteMapping(value = "/girl/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlService.girlDelete(id);
    }

    @GetMapping(value = "girls/getAge/{id}")
    public Girl getAge(@PathVariable("id") Integer id) throws Exception{
        return girlService.getAge(id);
    }

}
