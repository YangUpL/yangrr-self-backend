package com.yangrr.center.mapper;

import com.yangrr.center.model.domain.JavaQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangrr.center.model.request.QuestionPageRequest;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 31841
* @description 针对表【java_question(java面试题)】的数据库操作Mapper
* @createDate 2024-07-27 15:19:42
* @Entity com.yangrr.center.model.domain.JavaQuestion
*/
public interface JavaQuestionMapper extends BaseMapper<JavaQuestion> {

//    @Select("select * from java_question limit #{startIndex},#{pageSize}")
    List<JavaQuestion> javaQuestion(QuestionPageRequest questionPageRequest);
}




