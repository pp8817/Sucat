package com.Sucat.domain.notify.controller;

import com.Sucat.domain.notify.service.NotifyService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
@RequestMapping(("/api/v1/notify"))
public class NotifyController {
    private final NotifyService notifyService;

    /**
     * 실제 클라이언트로부터 오는 알림 구독 요청을 받는다.
     * @param lastEventId: 이전에 받지 못한 이벤트가 존재하는 경우 (SSE 연결에 대한 시간 만료/종료), 받은 마지막 이벤트 ID 값을 넘겨 그 이후의 데이터부터 받을 수 있게 할 수 있는 정보를 의미
     */
    @GetMapping(value = "/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter subscribe(HttpServletRequest request,
                                @RequestHeader(value = "Last-Event-ID", required = false, defaultValue = "") String lastEventId) {

        return notifyService.subscribe(request, lastEventId); // 사용자의 구독을 처리
    }

}
