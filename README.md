Thời gian thực hiện: 15h 22/8
Database: MariaDB via docker
![image](https://github.com/phuoc1707/TDPHUOC-TEST-BE/assets/93043199/32d4c50a-1242-479f-ab33-bc8b05a4f87b)


Thư viện sử dụng:
  rsql-jpa-specification (https://github.com/perplexhub/rsql-jpa-specification?fbclid=IwAR039EeW33ns_DYgWE_jZJESNAZQKhpoPebLFvlrlWBzs7EoP6EpfxlPEBk) - hỗ trợ search

**API filter với các bộ lọc đồng thời cho “Nhân Viên”:**


**Service GiamDoc**: (Sử dụng Bacth job để làm việc với file excel và lên lịch )

	**API import file excel vào lưu lại:** POST - http://localhost:9090/api/GiamDoc/upload
 	**Cập nhật thông tin lương vào ngày 15 hàng tháng** : sử dụng annotation Schedule (Tham khảo tại : https://crontab.guru/#00_00_15_*_* )
	![image](https://github.com/phuoc1707/TDPHUOC-TEST-BE/assets/93043199/1840c79e-1a3e-4ad8-b4f7-bc36c882d01f)

	
