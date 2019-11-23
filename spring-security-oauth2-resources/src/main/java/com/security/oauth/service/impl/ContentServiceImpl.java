package com.security.oauth.service.impl;

import com.security.oauth.domain.TbContent;
import com.security.oauth.mapper.ContentMapper;
import com.security.oauth.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zjm
 * @date 2019/11/22
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Resource
    private ContentMapper contentMapper;

    @Override
    public List<TbContent> getContent() {
        return contentMapper.selectAll();
    }
}
