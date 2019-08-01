package com.whir.mapper;

import com.whir.model.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DictMapper {

    List<Dict> find(String id);

}
