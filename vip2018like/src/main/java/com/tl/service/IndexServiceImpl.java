package com.tl.service;/*
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

import com.tl.init.CacheInit;
import com.tl.mapper.IndexMapper;
import com.tl.pojo.TlIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service

public class IndexServiceImpl implements IndexService {

    @Autowired
    IndexMapper indexMapper;

    public List<TlIndex> search(String word){
       // return indexMapper.search(word);


        return indexMapper.search(word);

    }


    public Set<String> search2(String word){
        // return indexMapper.search(word);


        return (Set<String>) CacheInit.likeSearch.search(word,20);

    }


    @Override
    public List<TlIndex> all() {
        return indexMapper.listAll();
    }

}
