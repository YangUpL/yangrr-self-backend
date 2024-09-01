package com.yangrr.center.controller;

import com.yangrr.center.common.BaseResponse;
import com.yangrr.center.common.ResultUtils;
import com.yangrr.center.model.request.QuestionPageRequest;
import com.yangrr.center.model.resp.PageResp;
import com.yangrr.center.service.JavaQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @PATH com.yangrr.center.controller.QuestionController
 * @Author YangRR
 * @CreateData 2024-07-27 15:09
 * @Description:题目接口
 */
@CrossOrigin(value = {"http://localhost:5173"}, allowCredentials = "true")
@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private JavaQuestionService javaQuestionService;

    @PostMapping("java")
    public BaseResponse<PageResp> javaQuestion(@RequestBody QuestionPageRequest questionPageRequest){
        System.err.println(questionPageRequest);

        PageResp pageResp = javaQuestionService.javaQuestion(questionPageRequest);

        return ResultUtils.success(pageResp);
    }

}
