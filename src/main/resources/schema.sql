USE `test-database`;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS nhan_vien, phong_ban, chuc_vu;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE phong_ban
(
    phong_ban_id  BIGINT       NOT NULL,
    ten_phong_ban VARCHAR(255) NULL,
    chuc_nang     VARCHAR(255)     NULL,
    CONSTRAINT pk_phongban PRIMARY KEY (phong_ban_id)
);

CREATE TABLE chuc_vu
(
    chuc_vu_id  BIGINT       NOT NULL,
    ten_chuc_vu VARCHAR(255) NULL,
    tham_quyen  VARCHAR(255)     NULL,
    CONSTRAINT pk_chucvu PRIMARY KEY (chuc_vu_id)
);

CREATE TABLE nhan_vien
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    manv         VARCHAR(6)            NOT NULL,
    ho_va_ten    VARCHAR(255)          NULL,
    ngay_sinh    datetime              NULL,
    que_quan     VARCHAR(255)          NULL,
    sdt          VARCHAR(255)          NULL,
    email        VARCHAR(255)          NULL,
    phong_ban_id BIGINT                NULL,
    chuc_vu_id   BIGINT                NULL,
    luong        DOUBLE                NULL,
    trang_thai   VARCHAR(255)          NULL,
    CONSTRAINT pk_nhanvien PRIMARY KEY (id)
);

ALTER TABLE nhan_vien
    ADD CONSTRAINT FK_NHANVIEN_ON_CHUCVUID FOREIGN KEY (chuc_vu_id) REFERENCES chuc_vu (chuc_vu_id);

ALTER TABLE nhan_vien
    ADD CONSTRAINT FK_NHANVIEN_ON_PHONGBANID FOREIGN KEY (phong_ban_id) REFERENCES phong_ban (phong_ban_id);
