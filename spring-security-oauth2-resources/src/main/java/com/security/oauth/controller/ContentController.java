package com.security.oauth.controller;

import com.security.oauth.domain.TbContent;
import com.security.oauth.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zjm
 * @date 2019/11/22
 */
@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping("/")
    public List<TbContent> list() {
        return contentService.getContent();
    }

}
