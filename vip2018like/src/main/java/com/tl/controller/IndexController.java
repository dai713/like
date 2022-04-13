package com.tl.controller;/*
 * ━━━━━━如来保佑━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━永无BUG━━━━━━
 * 图灵学院-悟空老师
 * www.jiagouedu.com
 * 悟空老师QQ：245553999
 */

import com.tl.pojo.TlIndex;
import com.tl.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequestMapping
@Controller
public class IndexController {

  @Autowired
    IndexService indexService;


  @RequestMapping("/data.json")
  @ResponseBody
    public List<String> data(HttpServletRequest request){
        String word=request.getParameter("word");
        List<TlIndex> search = indexService.search(word);
        List<String> all=new ArrayList<String>();
        if (null!=all&&!search.isEmpty()) {
            for (TlIndex index : search) {
                all.add(index.getCompany_name());
            }
        }
      return all;
    }

   @RequestMapping("/data2.json")
    @ResponseBody
    public Set<String> data2(HttpServletRequest request){
        String word=request.getParameter("word");
        return  indexService.search2(word);

    }



}
