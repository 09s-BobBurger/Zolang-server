package com.kcs.zolang.controller;

import com.kcs.zolang.annotation.UserId;
import com.kcs.zolang.dto.global.ResponseDto;
import com.kcs.zolang.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Tag(name = "User", description = "유저 관련 API")
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/nickname-duplicate")
    @Operation(summary = "닉네임 중복 확인", description = "닉네임 중복을 확인합니다.")
    public ResponseDto<?> checkDuplicate(
            @RequestParam(value = "nickname") String nickname
    ) {
        return ResponseDto.ok(userService.checkDuplicate(nickname));
    }

}
