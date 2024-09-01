package com.yangrr.center.model.request;

import lombok.Data;

/**
 * @PATH com.yangrr.center.model.request.pageRequest
 * @Author YangRR
 * @CreateData 2024-08-19 10:19
 * @Description:
 */
@Data
public class QuestionPageRequest {
    private Long current;
    private Long size;
    private String queName;
    private Integer classification;
}
