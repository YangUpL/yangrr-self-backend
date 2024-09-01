package com.yangrr.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangrr.center.model.domain.JavaQuestion;
import com.yangrr.center.model.request.QuestionPageRequest;
import com.yangrr.center.model.resp.PageResp;
import com.yangrr.center.service.JavaQuestionService;
import com.yangrr.center.mapper.JavaQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 31841
* @description 针对表【java_question(java面试题)】的数据库操作Service实现
* @createDate 2024-07-27 15:19:42
*/
@Service
public class JavaQuestionServiceImpl extends ServiceImpl<JavaQuestionMapper, JavaQuestion>
    implements JavaQuestionService{

    @Autowired
    private JavaQuestionMapper javaQuestionMapper;

    @Override
    public PageResp javaQuestion(QuestionPageRequest questionPageRequest) {
        Long current = questionPageRequest.getCurrent();
        Long size = questionPageRequest.getSize();

        Long startIndex = (current - 1) * size;
        questionPageRequest.setCurrent(startIndex);


        List<JavaQuestion> javaQuestions = javaQuestionMapper.javaQuestion(questionPageRequest);
        System.err.println("到啦");

        QueryWrapper<JavaQuestion> queryWrapper = new QueryWrapper<>();
        if (questionPageRequest.getQueName() != null) {
            queryWrapper.like("question", questionPageRequest.getQueName());
        }

        if (questionPageRequest.getClassification() != -1) {
            queryWrapper.eq("classification", questionPageRequest.getClassification());
        }

        Long total = javaQuestionMapper.selectCount(queryWrapper);
        PageResp pageResp = new PageResp(total,javaQuestions);

        return pageResp;
    }
}




