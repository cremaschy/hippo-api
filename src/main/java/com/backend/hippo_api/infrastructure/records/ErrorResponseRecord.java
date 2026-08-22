package com.backend.hippo_api.infrastructure.records;

import java.time.LocalDateTime;

public record ErrorResponseRecord(
        int status,
        String mensagem,
        LocalDateTime momentoExcecao
) {
}
