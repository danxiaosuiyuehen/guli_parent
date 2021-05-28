package com.example.cms.controller;


import com.example.cms.entity.CrmBanner;
import com.example.cms.service.CrmBannerService;
import com.example.utils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author yu
 * @since 2021-05-19
 */
@RestController
@RequestMapping("/cms/crm-banner")
@CrossOrigin
public class CrmBannerController {
    @Resource
    private CrmBannerService crmBannerService ;
    @GetMapping("getAllBanner")
    public R getAllBanner(){
        List<CrmBanner> list=crmBannerService.selectAllBanner();
        return R.ok().data("list",list);
    }
}

