-- phong ban
INSERT INTO phong_ban (phong_ban_id, ten_phong_ban, chuc_nang)
VALUES (1, 'Phòng IT', 'IT');

-- chuc vu
INSERT INTO chuc_vu (chuc_vu_id, ten_chuc_vu, tham_quyen)
VALUES (1, 'Nhân viên', 'làm việc');

INSERT INTO chuc_vu (chuc_vu_id, ten_chuc_vu, tham_quyen)
VALUES (2, 'Giám đốc', 'tất cả');
-- nhan vien
INSERT INTO nhan_vien (id, manv, ho_va_ten, ngay_sinh,
                       que_quan, sdt, email, phong_ban_id,
                       chuc_vu_id, luong, trang_thai)
VALUES (1, '000001', 'Nguyen Van A', '1990-01-01',
        'Hanoi', '0123456789', 'email@example.com', 1,
        1, 1000.00, 'HoatDong');

INSERT INTO nhan_vien (id, manv, ho_va_ten, ngay_sinh,
                       que_quan, sdt, email, phong_ban_id,
                       chuc_vu_id, luong, trang_thai)
VALUES (2, '000002', 'Nguyen Van B', '1990-01-01',
        'Hanoi', '0123456789', 'email@example.com', 1,
        1, 1000.00, 'HoatDong');

INSERT INTO nhan_vien (id, manv, ho_va_ten, ngay_sinh,
                       que_quan, sdt, email, phong_ban_id,
                       chuc_vu_id, luong, trang_thai)
VALUES (3, '000003', 'Nguyen Van B', '1990-01-01',
        'Hanoi', '0123456789', 'email@example.com', 1,
        2, 1000.00, 'HoatDong');
