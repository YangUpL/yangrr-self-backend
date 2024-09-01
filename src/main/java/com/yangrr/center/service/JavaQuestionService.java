package com.yangrr.center.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yangrr.center.model.domain.JavaQuestion;
import com.yangrr.center.model.request.QuestionPageRequest;
import com.yangrr.center.model.resp.PageResp;

import java.util.List;

/**
* @author 31841
* @description 针对表【java_question(java面试题)】的数据库操作Service
* @createDate 2024-07-27 15:19:42
*/
public interface JavaQuestionService extends IService<JavaQuestion> {

    PageResp javaQuestion(QuestionPageRequest questionPageRequest);

}
