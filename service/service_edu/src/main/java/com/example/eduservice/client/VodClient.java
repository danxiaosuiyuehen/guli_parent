package com.example.eduservice.client;

import com.example.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name="service-vod",fallback = VodClientHystrix.class)

public interface VodClient {
    @DeleteMapping("/eduvod/video/deleteVodById/{id}")
     R deleteVodById(@PathVariable("id") String id);

}
