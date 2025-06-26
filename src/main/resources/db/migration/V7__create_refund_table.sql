CREATE TABLE refunds
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    purchase_id   BIGINT       NOT NULL COMMENT '어떤 주문에 속하는지',
    reason        VARCHAR(255) NOT NULL COMMENT '환불 사유',
    status        VARCHAR(20)  NOT NULL COMMENT '환불 상태 (REQUESTED(요청), APPROVED(승인), REJECTED(거절), COMPLETED(완료) 등)',
    refund_amount DECIMAL(10, 2) DEFAULT 0 COMMENT '환불 금액',
    method        VARCHAR(50) COMMENT '환불 수단 (카드, 계좌이체, 포인트 등)',
    bank_account  VARCHAR(100) COMMENT '환불 계좌 정보 (선택)',
    is_partial    BOOLEAN        DEFAULT FALSE COMMENT '부분 환불 여부',
    refunded_by   VARCHAR(100) COMMENT '환불 처리자',
    refunded_at   DATETIME COMMENT '실제 환불 완료 시간',
    note          TEXT COMMENT '관리자 코멘트나 메모',
    created_at    DATETIME       DEFAULT CURRENT_TIMESTAMP,
    updated_at    DATETIME       DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)

