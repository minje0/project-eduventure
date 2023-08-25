package com.bit.eduventure.postIt.controller;

import com.bit.eduventure.postIt.dto.PostItDTO;
import com.bit.eduventure.postIt.service.PostItService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postit")
public class PostItController {

    @Autowired
    private PostItService postItService;

    @PostMapping("/send")
    public ResponseEntity<?> sendPostIt(@RequestBody PostItDTO postItDTO) {
        try {
            postItService.sendPostIt(postItDTO);

            return ResponseEntity.ok("포스트잇을 보냈습니다.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("포스트잇 전송 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}