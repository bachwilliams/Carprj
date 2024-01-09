USE [master]
GO
/****** Object:  Database [CafeManager_SP24]    Script Date: 1/9/2024 7:45:53 AM ******/
CREATE DATABASE [CafeManager_SP24]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'CafeManager_SP24', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\CafeManager_SP24.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'CafeManager_SP24_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\CafeManager_SP24_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [CafeManager_SP24] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [CafeManager_SP24].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [CafeManager_SP24] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET ARITHABORT OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [CafeManager_SP24] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [CafeManager_SP24] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET  ENABLE_BROKER 
GO
ALTER DATABASE [CafeManager_SP24] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [CafeManager_SP24] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET RECOVERY FULL 
GO
ALTER DATABASE [CafeManager_SP24] SET  MULTI_USER 
GO
ALTER DATABASE [CafeManager_SP24] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [CafeManager_SP24] SET DB_CHAINING OFF 
GO
ALTER DATABASE [CafeManager_SP24] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [CafeManager_SP24] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [CafeManager_SP24] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [CafeManager_SP24] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'CafeManager_SP24', N'ON'
GO
ALTER DATABASE [CafeManager_SP24] SET QUERY_STORE = OFF
GO
USE [CafeManager_SP24]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 1/9/2024 7:45:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[DisplayName] [nvarchar](100) NOT NULL,
	[UserName] [nvarchar](100) NOT NULL,
	[PassWord] [nvarchar](100) NOT NULL,
	[Type] [int] NOT NULL,
	[Email] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[UserName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 1/9/2024 7:45:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idTable] [int] NOT NULL,
	[DateCheckIn] [date] NOT NULL,
	[status] [bit] NOT NULL,
	[DateCheckout] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BillInfo]    Script Date: 1/9/2024 7:45:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idBill] [int] NOT NULL,
	[idFood] [int] NOT NULL,
	[count] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Food]    Script Date: 1/9/2024 7:45:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Food](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[idCategory] [int] NOT NULL,
	[price] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FoodCategory]    Script Date: 1/9/2024 7:45:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FoodCategory](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TableFood]    Script Date: 1/9/2024 7:45:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TableFood](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tokenPassword]    Script Date: 1/9/2024 7:45:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tokenPassword](
	[Id] [nvarchar](max) NOT NULL,
	[Date] [datetime] NOT NULL,
	[userName] [nvarchar](100) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Account] ([DisplayName], [UserName], [PassWord], [Type], [Email]) VALUES (N'Lê Huy Bách', N'huybach1', N'123', 1, N'Bachlh03@gmail.com')
INSERT [dbo].[Account] ([DisplayName], [UserName], [PassWord], [Type], [Email]) VALUES (N'Nguyễn Trung Kiên', N'trungkien', N'123', 0, NULL)
GO
SET IDENTITY_INSERT [dbo].[Bill] ON 

INSERT [dbo].[Bill] ([id], [idTable], [DateCheckIn], [status], [DateCheckout]) VALUES (2, 2, CAST(N'2024-01-01' AS Date), 0, NULL)
INSERT [dbo].[Bill] ([id], [idTable], [DateCheckIn], [status], [DateCheckout]) VALUES (3, 3, CAST(N'2024-01-01' AS Date), 1, CAST(N'2024-01-01' AS Date))
SET IDENTITY_INSERT [dbo].[Bill] OFF
GO
SET IDENTITY_INSERT [dbo].[BillInfo] ON 

INSERT [dbo].[BillInfo] ([id], [idBill], [idFood], [count]) VALUES (3, 2, 2, 3)
INSERT [dbo].[BillInfo] ([id], [idBill], [idFood], [count]) VALUES (4, 2, 3, 3)
INSERT [dbo].[BillInfo] ([id], [idBill], [idFood], [count]) VALUES (6, 2, 5, 2)
INSERT [dbo].[BillInfo] ([id], [idBill], [idFood], [count]) VALUES (7, 2, 4, 5)
INSERT [dbo].[BillInfo] ([id], [idBill], [idFood], [count]) VALUES (8, 3, 6, 2)
INSERT [dbo].[BillInfo] ([id], [idBill], [idFood], [count]) VALUES (9, 3, 1, 4)
SET IDENTITY_INSERT [dbo].[BillInfo] OFF
GO
SET IDENTITY_INSERT [dbo].[Food] ON 

INSERT [dbo].[Food] ([id], [name], [idCategory], [price]) VALUES (1, N'Coca', 1, 6000)
INSERT [dbo].[Food] ([id], [name], [idCategory], [price]) VALUES (2, N'HANOI bear', 2, 10000)
INSERT [dbo].[Food] ([id], [name], [idCategory], [price]) VALUES (3, N'Salad', 4, 20000)
INSERT [dbo].[Food] ([id], [name], [idCategory], [price]) VALUES (4, N'MeatBalls', 3, 23000)
INSERT [dbo].[Food] ([id], [name], [idCategory], [price]) VALUES (5, N'Burger', 3, 15000)
INSERT [dbo].[Food] ([id], [name], [idCategory], [price]) VALUES (6, N'Pizza', 3, 21000)
INSERT [dbo].[Food] ([id], [name], [idCategory], [price]) VALUES (7, N'Water', 1, 5000)
SET IDENTITY_INSERT [dbo].[Food] OFF
GO
SET IDENTITY_INSERT [dbo].[FoodCategory] ON 

INSERT [dbo].[FoodCategory] ([id], [name]) VALUES (1, N'Soft Drinks')
INSERT [dbo].[FoodCategory] ([id], [name]) VALUES (2, N'Beer')
INSERT [dbo].[FoodCategory] ([id], [name]) VALUES (3, N'Meat')
INSERT [dbo].[FoodCategory] ([id], [name]) VALUES (4, N'Vagetables')
INSERT [dbo].[FoodCategory] ([id], [name]) VALUES (5, N'Seafood')
SET IDENTITY_INSERT [dbo].[FoodCategory] OFF
GO
SET IDENTITY_INSERT [dbo].[TableFood] ON 

INSERT [dbo].[TableFood] ([id], [name], [status]) VALUES (1, N'table 1', 0)
INSERT [dbo].[TableFood] ([id], [name], [status]) VALUES (2, N'table 2', 0)
INSERT [dbo].[TableFood] ([id], [name], [status]) VALUES (3, N'table 3', 0)
INSERT [dbo].[TableFood] ([id], [name], [status]) VALUES (4, N'table 4', 0)
INSERT [dbo].[TableFood] ([id], [name], [status]) VALUES (5, N'table 5', 0)
INSERT [dbo].[TableFood] ([id], [name], [status]) VALUES (6, N'table 6 ', 0)
SET IDENTITY_INSERT [dbo].[TableFood] OFF
GO
INSERT [dbo].[tokenPassword] ([Id], [Date], [userName]) VALUES (N'30df267543428024db6acbc061797477361995d7abab8c678105c895efbabd41', CAST(N'2024-01-08T22:11:08.787' AS DateTime), N'huybach1')
GO
ALTER TABLE [dbo].[Account] ADD  DEFAULT ('N/A') FOR [DisplayName]
GO
ALTER TABLE [dbo].[Account] ADD  DEFAULT ((0)) FOR [Type]
GO
ALTER TABLE [dbo].[Bill] ADD  DEFAULT (getdate()) FOR [DateCheckIn]
GO
ALTER TABLE [dbo].[BillInfo] ADD  DEFAULT ((0)) FOR [count]
GO
ALTER TABLE [dbo].[Food] ADD  DEFAULT ('N/A') FOR [name]
GO
ALTER TABLE [dbo].[FoodCategory] ADD  DEFAULT ('N/A') FOR [name]
GO
ALTER TABLE [dbo].[TableFood] ADD  DEFAULT ('no Name') FOR [name]
GO
ALTER TABLE [dbo].[TableFood] ADD  DEFAULT ('false') FOR [status]
GO
ALTER TABLE [dbo].[tokenPassword] ADD  CONSTRAINT [DF_tokenPassword_userName]  DEFAULT (getdate()) FOR [userName]
GO
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD FOREIGN KEY([idTable])
REFERENCES [dbo].[TableFood] ([id])
GO
ALTER TABLE [dbo].[BillInfo]  WITH CHECK ADD FOREIGN KEY([idBill])
REFERENCES [dbo].[Bill] ([id])
GO
ALTER TABLE [dbo].[BillInfo]  WITH CHECK ADD FOREIGN KEY([idFood])
REFERENCES [dbo].[Food] ([id])
GO
ALTER TABLE [dbo].[Food]  WITH CHECK ADD FOREIGN KEY([idCategory])
REFERENCES [dbo].[FoodCategory] ([id])
GO
USE [master]
GO
ALTER DATABASE [CafeManager_SP24] SET  READ_WRITE 
GO
