package com.yangrr.center.model.resp;

import com.yangrr.center.model.domain.JavaQuestion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @PATH com.yangrr.center.model.request.pageRequest
 * @Author YangRR
 * @CreateData 2024-08-19 10:19
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResp {
   private Long total;
   private List<JavaQuestion> javaQuestionList;
}
