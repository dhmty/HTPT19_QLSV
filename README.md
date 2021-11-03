# HTPT19_QLSV
#NHOM_19
#Thành_Viên:
    ---MSSV---      ---Họ Và Tên---       ---Lớp---
    N18DCCN020      Ngô Mạnh Cường        D18CQCP01-N
    N18DCCN035      Lương Ngọc Đại        D18CQCP01-N
    N18DCCN044      Nguyễn Minh Đoan      D18CQCP01-N
    N18DCCN059      Lê Công Hậu           D18CQCP01-N
    N18DCCN098      Huỳnh Quốc Khánh      D18CQCP01-N

#ĐỀ_TÀI_19: XÂY DỰNG WEBSERVICE TƯƠNG TÁC CƠ SỞ DỮ LIỆU VÀ ỨNG DỤNG SỬ DỤNG WEBSERVICE

*CHỨC_NĂNG:
-	Xây dựng chương trình quản lý “Thông Tin Sinh Viên”, bao gồm các nghiệp vụ chính: Thêm, Xóa, Chỉnh Sửa, Xem danh sách sinh viên.
- Mô tả: 
    + Thông tin Sinh Viên là một bảng trong Cơ Sở Dữ Liệu được liên kết và tương tác với Webservice.
    + Webservice được xây dựng với mỗi chức năng ứng với API được tạo ra truy cập và thay đổi trực tiếp trong Cơ Sở Dữ Liệu. 
    + Ứng dụng Client sử dụng webservice thông qua các Request gửi tới Server và với một chính sách bảo mật Json Web Token (Token gửi kèm trong Header của Request), sau đó Webservice kiểm tra và trả về Response đúng nếu Token gửi là hợp lệ.
    + Ứng dụng Client tương tác trực tiếp với người sử dụng thông qua giao diện trang Web (được sử dụng trong Bài Tập Lớn này).

*CÔNG_NGHỆ_SỬ_DỤNG:
    - Webservice Tương Tác Cơ Sở Dữ Liệu: Spring Boot RestFul API + Hibernate + Maven + Microsoft SQL Server
    - Json Web Token: Bảo Mật cho quá trình sử dụng API
    - Ứng Dụng Sử Dụng Webservice: Java Spring Boot + HTML + CSS + JS + ThymeLeaf + Bootstrap

*CƠ_SỞ_DỮ_LIỆU[HTPT19_SV]
    - Table: [SinhVien]
                └── [MaSV]: Primary Key, varchar(10), not Null
                └── [Ho]: nvarchar(50), not Null
                └── [Ten]: nvarchar(50), not Null
                └── [Email]: varchar(50), not Null
                └── [NgaySinh]: date, not Null
                └── [GioiTinh]: bit, not Null
                └── [Nganh]: nvarchar(50), not Null
                └── [GPA]: float, not Null
                └── [KhoaHoc]: varchar(50), not Null

*PROJECT_FOLDER[HTPT19_QLSV]
│  README.md                                         #Giới thiệu tổng quan về project
│  HTPT19_SV.sql                                     #File scripts Cơ Sở Dữ Liệu   
└──[RestAPI]                                         #Project server webservice
│  │  pom.xml                                           #Cấu hình các thư viện cần thiết cho module RestAPI
│  └──[src]      
│     └──[main]                                            #Chứa các file chính của project 
│     │  └──[java]                                            #Chứa các file xử lý các chức năng WebService và apply JWT
│     │  │  └──[com.source.restapi]                           
│     │  │     └──[controller]   
│     │  │     │  └──   SinhVienController.java
│     │  │     └──[exception]
│     │  │     │  └──   ResourceNotFoundException.java                 
│     │  │     └──[model]
│     │  │     │  └──   SinhVien.java                
│     │  │     └──[repository]
│     │  │     │  └──[impl]
│     │  │     │  └──   SinhVienRepository.java     
│     │  │     └──[validation] 
│     │  │     │  └──   JwtRequestFilter.java           
│     │  │     └──[service]
│     │  │     └──[util]
│     │  │     └──  RestApiApplication.java
│     │  └──[resources]                                       #Chứa các cấu hình chung của project Springboot
│     │     └──   application.properties                      
│     └──[test]                                            #Chứa các file test (không chạy trong chương trình chính)
│        └──[java] 
│           └──[com.source.restapi]
│              └──    RestApiApplicationTests.java
└──[RestClient]                                      #Project Client Java WebApplication
   │  pom.xml                                           #Cấu hình các thư viện cần thiết cho module RestClient
   └──[src]      
      └──[main]                                            #Chứa các file chính của project 
      │  └──[java]                                            #Chứa các file xử lý các chức năng điều phối Client
      │  │  └──[com.source.restclient]                           
      │  │     └──[controller]   
      │  │     │  └──   SinhVienController.java            
      │  │     └──[model]
      │  │     │  └──   SinhVien.java                
      │  │     └──  RestClientApplication.java
      │  └──[resources]                                       #Chứa các cấu hình chung + các file giao diện
      │     └──   application.properties   
      │     └──[static]             
      │     │  └──[css]
      │     │  │  └──   main.css
      │     │  │  └──   reset_css.css
      │     │  └──[fonts]                       
      │     │  └──[img]                       
      │     └──[templates]    
      │        └──[SinhVien]   
      │           └──   addSV.html
      │           └──   editSV.html                        
      │           └──   error.html                        
      │           └──   listSV.html                        
      └──[test]                                            #Chứa các file test (không chạy trong chương trình chính)
         └──[java] 
            └──[com.source.restclient]
               └──    RestClientApplicationTests.java

*HƯỚNG_DẪN_THIẾT_LẬP_ỨNG_DỤNG:
    - Bước 1: 
        + Tại máy local, cài đặt môi trường Database Microsoft SQL Server, dùng File scripts tạo Cơ Sở Dữ Liệu.
        + Thiết lập môi trường Java với JDK 8+, Maven, Spring Boot và IDE thích hợp cho các project RestAPI (server.port=8080) và RestClient (server.port=8081).
    - Bước 2: Bắt đầu thực hiện chương trình: 							
        + Chạy RestAPI đóng vai trò là Webservice tương tác Cơ Sở Dữ Liệu.	          
        + Chạy RestClient đóng vai trò là Web Application giao diện sử dụng.		
        + Bắt đầu Kiểm tra và chạy thử các chức năng của chương trình.

*ĐÁNH_GIÁ_VÀ_CẢI_THIỆN_ỨNG_DỤNG:
    - Ứng dụng mang tính chất mô phỏng và hiểu luồng thực hiện của Webservice và cách sử dụng ở phía người sử dụng. 
	- Các chức năng cần cải thiện: chức năng liên kết mở rộng quy mô để phát triển Websercice rộng hơn và sử dụng tối ưu, giao diện hợp lý cũng như phù hợp với nhu cầu người dử dụng.