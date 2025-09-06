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
@CrossOrigin(origins = "*") // hoặc domain frontend
public class AgoraController {

    private final String APP_ID = "YOUR_APP_ID";
    private final String APP_CERTIFICATE = "YOUR_APP_CERTIFICATE";

    @GetMapping("/token")
    public ResponseEntity<String> getToken(@RequestParam String channelName, @RequestParam int uid) {
        try {
            RtcTokenBuilder tokenBuilder = new RtcTokenBuilder();
            int currentTimestamp = (int) (System.currentTimeMillis() / 1000);
            int privilegeExpireTimestamp = currentTimestamp + 3600; // token 1h
            String token = tokenBuilder.buildTokenWithUid(
                    APP_ID,
                    APP_CERTIFICATE,
                    channelName,
                    uid,
                    RtcTokenBuilder.Role.Role_Publisher,
                    privilegeExpireTimestamp
            );
            System.out.println("Generated token for UID " + uid + ": " + token);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("");
        }
    }
}
