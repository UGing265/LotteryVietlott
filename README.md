# Trò Chơi Vé Số - Java Web

Dự án này là một ứng dụng web trò chơi vé số đơn giản được xây dựng bằng **Java**, **JDBC** và **SQL Server**. Người dùng có thể đăng ký tài khoản, đăng nhập, mua vé số và kiểm tra kết quả xổ số.

## Mục Lục

- [Giới Thiệu](#giới-thiệu)
- [Yêu Cầu Hệ Thống](#yêu-cầu-hệ-thống)
- [Cài Đặt](#cài-đặt)
- [Sử Dụng](#sử-dụng)
- [Cấu Trúc Dự Án](#cấu-trúc-dự-án)
- [MShiroru Thuyết Kế](#mshiroru-thuyết-kế)

## Giới Thiệu

1. **SQL Server**:  
   - **Mô tả**: Hệ quản trị cơ sở dữ liệu quan hệ của Microsoft, hỗ trợ lưu trữ và truy vấn dữ liệu mạnh mẽ.  
   - **Ứng dụng**: Lưu trữ thông tin người dùng, vé số đã mua, kết quả xổ số.

2. **Java**:  
   - **Mô tả**: Ngôn ngữ lập trình phổ biến, di động và ổn định.  
   - **Ứng dụng**: Phát triển backend, xử lý logic nghiệp vụ và tương tác với cơ sở dữ liệu.

3. **JDBC**:  
   - **Mô tả**: API giúp Java giao tiếp với cơ sở dữ liệu SQL.  
   - **Ứng dụng**: Kết nối và thực hiện truy vấn SQL trực tiếp với SQL Server, quản lý dữ liệu người dùng và vé số.

## Yêu Cầu Hệ Thống

- **Java 8** trở lên.
- **SQL Server** (Cấu hình cơ sở dữ liệu và kết nối).
- **Tomcat** (hoặc bất kỳ servlet container nào hỗ trợ Java).
- **NetBeans** IDE để phát triển dự án.
- **JDBC Driver** cho SQL Server.

## Cài Đặt

### 1. Cài Đặt Môi Trường

- Cài **JDK 8** hoặc phiên bản Java mới hơn.
- Cài **Tomcat** và cấu hình môi trường.
- Cài **SQL Server** và tạo cơ sở dữ liệu **LotteryDB**.

### 2. Cài Đặt Thư Viện JDBC

Tải **JDBC driver** cho SQL Server từ [Microsoft JDBC Driver](https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server) và thêm vào thư mục `lib` trong dự án của bạn.

### 3. Cấu Hình Tomcat

Cấu hình **Tomcat** và triển khai dự án lên máy chủ. 

- Cài đặt **Apache Tomcat**.
- Cấu hình Tomcat để nhận diện và triển khai dự án của bạn.
- Triển khai file WAR của dự án vào thư mục **webapps** của Tomcat.

### 4. Cài Đặt Dự Án

Mở dự án trong **NetBeans IDE** và kiểm tra cấu hình kết nối đến **SQL Server**.

1. Kiểm tra file cấu hình `DBUtil.java` để đảm bảo kết nối đến SQL Server là chính xác.
2. Chạy dự án từ NetBeans và kiểm tra xem ứng dụng có thể kết nối và hoạt động như mong đợi không.

## Sử Dụng

### 1. Đăng Ký Người Dùng

Truy cập trang `/register`, nhập tên người dùng và mật khẩu để tạo tài khoản mới.

### 2. Đăng Nhập

Sau khi đăng ký, bạn có thể đăng nhập vào trang `/login` bằng tài khoản đã đăng ký.

### 3. Mua Vé Số

Truy cập trang `/lottery` để mua vé số. Bạn có thể mua tối đa 20 vé với số ngẫu nhiên từ 1 đến 9999.

### 4. Kiểm Tra Kết Quả

Sau khi mua vé, truy cập trang `/lotteryResult` để xem kết quả xổ số và biết liệu bạn có trúng thưởng hay không.

## Cấu Trúc Dự Án

- WebContent/
  - index.jsp            # Trang chủ
  - login.jsp            # Trang đăng nhập
  - register.jsp         # Trang đăng ký
  - lottery.jsp          # Trang mua vé số
- src/
  - com/
    - lottery/
      - UserServlet.java  # Servlet xử lý đăng ký và đăng nhập
      - LotteryServlet.java # Servlet xử lý mua vé số
      - DBUtil.java        # Lớp tiện ích kết nối đến cơ sở dữ liệu
      - LotteryResult.java # Servlet xử lý kiểm tra kết quả xổ số
- WEB-INF/
  - web.xml              # Cấu hình servlet




## Tác giả MShiroru 

