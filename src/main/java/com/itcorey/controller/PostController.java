package com.itcorey.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itcorey.entity.Post;
import com.itcorey.vo.CommentVo;
import com.itcorey.vo.PostVo;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 公众号：徐买狼
 * @since 2020-11-10
 */
@Controller
public class PostController extends BaseController {

    @GetMapping("/category/{id:\\d*}")
    public String category(@PathVariable(name = "id") Long id) {
        int pn = ServletRequestUtils.getIntParameter(req, "pn", 1);

        req.setAttribute("pn", pn);
        req.setAttribute("currentCategoryId", id);
        return "post/category";
    }

    @GetMapping("/post/{id:\\d*}")
    public String detail(@PathVariable(name = "id") Long id) {
        PostVo vo = postService.selectOnePost(new QueryWrapper<Post>().eq("p.id",id));
        Assert.notNull(vo,"文章已被删除！");

        // 1分页，2文章id，3用户id，排序
        IPage<CommentVo> results = commentService.paing(getPage(), vo.getId(), null, "created");
        req.setAttribute("currentCategoryId", vo.getCategoryId());
        req.setAttribute("pageDate", results);
        req.setAttribute("post", vo);
        return "post/detail";
    }
}
