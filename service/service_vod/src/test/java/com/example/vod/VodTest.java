package com.example.vod;

import com.aliyuncs.DefaultAcsClient;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;

import java.util.List;

public class VodTest {
    public static void main(String[] args) throws ClientException, ClientException {
        DefaultAcsClient client=InitObject.InitObject("LTAI5t6WCac6RK7QL1ARdLJR","eEOvzOlCcUIqbx7Ga3ZIf5weAAr2ws");
        GetPlayInfoRequest request=new GetPlayInfoRequest();
        GetPlayInfoResponse response=new GetPlayInfoResponse();
        request.setVideoId("71ae3893f2164519b9d0332553aa4ac8");
         response = client.getAcsResponse(request);

        List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
        //播放地址
        for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
            System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
        }
        //Base信息
        System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");
    }

}
