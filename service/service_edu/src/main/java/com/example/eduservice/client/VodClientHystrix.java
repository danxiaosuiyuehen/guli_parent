package com.example.eduservice.client;

import com.example.utils.R;
import org.springframework.stereotype.Component;

@Component
public class VodClientHystrix implements VodClient {

    @Override
    public R deleteVodById(String id) {
        return R.error().message("熔断......");
    }
}
