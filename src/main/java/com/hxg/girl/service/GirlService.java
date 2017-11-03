package com.hxg.girl.service;

import com.hxg.girl.domain.Girl;
import com.hxg.girl.enums.ResultEnum;
import com.hxg.girl.exception.GirlException;
import com.hxg.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("girlService")
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public Girl findGirlById(Integer id) {

        return girlRepository.findOne(id);
    }

    public Girl saveGirl(Girl girl) {

        return girlRepository.save(girl);
    }

    public Girl girlUpdate(Girl girl) {

        return girlRepository.save(girl);
    }

    public void girlDelete(Integer id) {
        girlRepository.delete(id);
    }

    public Girl getAge(Integer id) {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();

        if (age < 10) {
            //返回"你还在上小学吧" code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            //返回"你可能在上初中" code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        return girl;
    }
}
