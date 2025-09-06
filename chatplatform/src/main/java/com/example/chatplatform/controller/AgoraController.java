package com.example.chatplatform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.agora.media.RtcTokenBuilder;
@RestController
@RequestMapping("/api/agora")
@CrossOrigin(origins = "https://inspiring-cobbler-196c25.netlify.app")
public class AgoraController {

    private final String APP_ID = "a7cc419ef65d49e0b456180f70a2668e";
    private final String APP_CERTIFICATE = "272baee99b414fa4a0841881349978da";

    @GetMapping("/token")
    public ResponseEntity<String> getToken(@RequestParam String channelName, @RequestParam int uid) {
        String token = createAgoraToken(channelName, uid);
        return ResponseEntity.ok(token);
    }

    private String createAgoraToken(String channelName, int uid) {
        RtcTokenBuilder tokenBuilder = new RtcTokenBuilder();
        int currentTimestamp = (int) (System.currentTimeMillis() / 1000);
        int expireSeconds = 3600;
        int privilegeExpireTimestamp = currentTimestamp + expireSeconds;

        // ✅ Sử dụng đúng enum theo JAR hiện tại
        RtcTokenBuilder.Role role = RtcTokenBuilder.Role.Role_Publisher;

        try {
            return tokenBuilder.buildTokenWithUid(
                    APP_ID,
                    APP_CERTIFICATE,
                    channelName,
                    uid,
                    role,
                    privilegeExpireTimestamp
            );
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


}
