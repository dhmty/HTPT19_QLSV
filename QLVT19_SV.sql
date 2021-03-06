USE [master]
GO
/****** Object:  Database [HTPT19_SV]    Script Date: 10/27/2021 2:15:58 AM ******/
CREATE DATABASE [HTPT19_SV]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'HTPT19_SV', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\HTPT19_SV.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'HTPT19_SV_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\HTPT19_SV_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [HTPT19_SV] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [HTPT19_SV].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [HTPT19_SV] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [HTPT19_SV] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [HTPT19_SV] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [HTPT19_SV] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [HTPT19_SV] SET ARITHABORT OFF 
GO
ALTER DATABASE [HTPT19_SV] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [HTPT19_SV] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [HTPT19_SV] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [HTPT19_SV] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [HTPT19_SV] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [HTPT19_SV] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [HTPT19_SV] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [HTPT19_SV] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [HTPT19_SV] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [HTPT19_SV] SET  DISABLE_BROKER 
GO
ALTER DATABASE [HTPT19_SV] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [HTPT19_SV] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [HTPT19_SV] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [HTPT19_SV] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [HTPT19_SV] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [HTPT19_SV] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [HTPT19_SV] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [HTPT19_SV] SET RECOVERY FULL 
GO
ALTER DATABASE [HTPT19_SV] SET  MULTI_USER 
GO
ALTER DATABASE [HTPT19_SV] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [HTPT19_SV] SET DB_CHAINING OFF 
GO
ALTER DATABASE [HTPT19_SV] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [HTPT19_SV] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [HTPT19_SV] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [HTPT19_SV] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'HTPT19_SV', N'ON'
GO
ALTER DATABASE [HTPT19_SV] SET QUERY_STORE = OFF
GO
USE [HTPT19_SV]
GO
USE [HTPT19_SV]
GO
/****** Object:  Sequence [hibernate_sequence]    Script Date: 10/27/2021 2:15:58 AM ******/
CREATE SEQUENCE [hibernate_sequence] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 1
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
/****** Object:  Table [SinhVien]    Script Date: 10/27/2021 2:15:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [SinhVien](
	[MaSV] [varchar](10) NOT NULL,
	[Ho] [nvarchar](50) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[Nganh] [nvarchar](50) NOT NULL,
	[GPA] [float] NOT NULL,
	[KhoaHoc] [varchar](50) NOT NULL,
 CONSTRAINT [PK_SinhVien] PRIMARY KEY CLUSTERED 
(
	[MaSV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [SinhVien] ([MaSV], [Ho], [Ten], [Email], [NgaySinh], [GioiTinh], [Nganh], [GPA], [KhoaHoc]) VALUES (N'N16DCAT234', N'Trần Văn', N'Đăng', N'dangtran@gmail.com', CAST(N'1998-02-23' AS Date), 1, N'An Toàn Thông Tin', 3, N'2016-2021')
INSERT [SinhVien] ([MaSV], [Ho], [Ten], [Email], [NgaySinh], [GioiTinh], [Nganh], [GPA], [KhoaHoc]) VALUES (N'N17DCKT023', N'Nguyễn Thị Thùy', N'Duyên', N'duyennguyen@gmail.com', CAST(N'1999-05-07' AS Date), 0, N'Kế Toán', 2.9, N'2017-2021')
INSERT [SinhVien] ([MaSV], [Ho], [Ten], [Email], [NgaySinh], [GioiTinh], [Nganh], [GPA], [KhoaHoc]) VALUES (N'N18DCCN144', N'Nguyễn Minh', N'Quang', N'NMQ@gmail.com', CAST(N'2000-02-03' AS Date), 1, N'Công Nghệ Phần Phềm', 3.1, N'2018-2023')
INSERT [SinhVien] ([MaSV], [Ho], [Ten], [Email], [NgaySinh], [GioiTinh], [Nganh], [GPA], [KhoaHoc]) VALUES (N'N20DCAT124', N'Trần Ngọc', N'Minh', N'minhtran@gmail.com', CAST(N'2001-02-23' AS Date), 0, N'An Toàn Thông Tin', 1.7100000381469727, N'2020-2025')
INSERT [SinhVien] ([MaSV], [Ho], [Ten], [Email], [NgaySinh], [GioiTinh], [Nganh], [GPA], [KhoaHoc]) VALUES (N'test', N'd', N'd', N'ttvn120820@gmail.com', CAST(N'2021-11-06' AS Date), 0, N'd', 0, N'dsa')
INSERT [SinhVien] ([MaSV], [Ho], [Ten], [Email], [NgaySinh], [GioiTinh], [Nganh], [GPA], [KhoaHoc]) VALUES (N'test1', N'1', N'1', N'doan675895@gmail.com', CAST(N'2021-10-19' AS Date), 1, N's', 0, N'dsa')
INSERT [SinhVien] ([MaSV], [Ho], [Ten], [Email], [NgaySinh], [GioiTinh], [Nganh], [GPA], [KhoaHoc]) VALUES (N'test2', N'ngaySinh', N'test', N'chucpro123@gmail.com', CAST(N'2021-10-29' AS Date), 1, N'test', 1, N'2017-2021')
GO
/****** Object:  Trigger [RoundGPA]    Script Date: 10/27/2021 2:15:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE trigger [RoundGPA] on [SinhVien]
	instead of insert
	as
	begin
		Declare @MaSV varchar(10)
		Declare @Ho nvarchar(50)
		Declare @Ten nvarchar(50)
		Declare @Email nvarchar(50)
		Declare @NgaySinh date
		Declare @GioiTinh bit
		Declare @Nganh nvarchar(50)
		Declare @GPA float
		Declare @KhoaHoc varchar(50)
		
		set @MaSV=(select MaSV from inserted)
		set @Ho=(select HO from inserted)
		set @Ten=(select TEN from inserted)
		set @Email=(select Email from inserted)
		set @NgaySinh=(select NGAYSINH from inserted)
		set @GioiTinh=(select GioiTinh from inserted)
		set @Nganh=(select Nganh from inserted)
		set @KhoaHoc=(select KhoaHoc from inserted)

		SET @GPA=Round((select GPA from inserted),2);
		insert into SinhVien values(@MaSV,@Ho,@Ten,@Email,@NgaySinh,@GioiTinh,@Nganh,@GPA,@KhoaHoc)
	end
GO
ALTER TABLE [dbo].[SinhVien] ENABLE TRIGGER [RoundGPA]
GO
USE [master]
GO
ALTER DATABASE [HTPT19_SV] SET  READ_WRITE 
GO
