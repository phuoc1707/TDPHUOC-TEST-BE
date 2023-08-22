Thời gian thực hiện: 15h -22h 22/8


Database: MariaDB via docker
![image](https://github.com/phuoc1707/TDPHUOC-TEST-BE/assets/93043199/32d4c50a-1242-479f-ab33-bc8b05a4f87b)

Config database:
![image](https://github.com/phuoc1707/TDPHUOC-TEST-BE/assets/93043199/7a5bc369-550c-489e-baf6-d6c597a58abd)

**Thư viện sử dụng:**
  rsql-jpa-specification (https://github.com/perplexhub/rsql-jpa-specification?fbclid=IwAR039EeW33ns_DYgWE_jZJESNAZQKhpoPebLFvlrlWBzs7EoP6EpfxlPEBk) - hỗ trợ search
![image](https://github.com/phuoc1707/TDPHUOC-TEST-BE/assets/93043199/2338a6c6-160f-4218-add5-8e1b63ff338e)

**API filter với các bộ lọc đồng thời cho “Nhân Viên”:**

**Read:**
![image](https://github.com/phuoc1707/TDPHUOC-TEST-BE/assets/93043199/6747dd71-efb0-4d2d-ad0d-c6b79a52e26e)

**Create:**
![image](https://github.com/phuoc1707/TDPHUOC-TEST-BE/assets/93043199/cd38ad5c-386f-46dd-810c-1b704ca84165)

**Search:**

**Search By  HoVaTen, QueQuan, TenPhongBan, TenChucVu**: rsql-jpa-specification cho phép xây dựng các API tìm kiếm theo format: {URL}?{Tên thuộc tính} == {Giá trị tìm kiếm} - không cần định nghĩa các API cụ thể
![image](https://github.com/phuoc1707/TDPHUOC-TEST-BE/assets/93043199/241e0cb3-3e0d-4199-9030-adb441ca2299)


**Search By PhongBan:**
![image](https://github.com/phuoc1707/TDPHUOC-TEST-BE/assets/93043199/7dcbda0f-fe35-4481-b5bd-f2d36c84d134)

**Search By chucVu**
![image](https://github.com/phuoc1707/TDPHUOC-TEST-BE/assets/93043199/92b8279a-aa17-493f-8c6c-203fba5d99ff)

**Search By trangThai**
![image](https://github.com/phuoc1707/TDPHUOC-TEST-BE/assets/93043199/a120cf64-c43f-475b-9407-4ff321ddb126)


**Service GiamDoc**: (Sử dụng Bacth job để làm việc với file excel và lên lịch )

**API import file excel vào lưu lại:** POST - http://localhost:9090/api/GiamDoc/upload
![image](https://github.com/phuoc1707/TDPHUOC-TEST-BE/assets/93043199/d321f9d5-25e9-4f8e-a57e-18185dac9fb4)


 **Cập nhật thông tin lương vào ngày 15 hàng tháng** : sử dụng annotation @Scheduled (Tham khảo tại : https://crontab.guru/#00_00_15_*_* )
![image](https://github.com/phuoc1707/TDPHUOC-TEST-BE/assets/93043199/1840c79e-1a3e-4ad8-b4f7-bc36c882d01f)

	
