# 🚀 Cập nhật Render Backend - Hướng dẫn Chi tiết

## ⚠️ QUAN TRỌNG: Phải làm ngay!

Backend đã được update để dùng **environment variables**. Bạn cần cập nhật Render để app hoạt động đúng.

---

## 📋 Các Environment Variables CẦN THIẾT

### Bước 1: Truy cập Render Dashboard

1. Vào https://dashboard.render.com
2. Đăng nhập
3. Chọn service backend của bạn (chatplatform)
4. Click tab **"Environment"** bên trái

### Bước 2: Thêm Environment Variables

Click **"Add Environment Variable"** và thêm từng biến sau:

#### 🔴 DATABASE (Railway - BẮT BUỘC)
```
Key: DATABASE_URL
Value: jdbc:mysql://root:KQLWHqHJAgnWOLWVLXQurWUzLQmmzxtL@shinkansen.proxy.rlwy.net:15929/railway
```

```
Key: DATABASE_USERNAME
Value: root
```

```
Key: DATABASE_PASSWORD  
Value: KQLWHqHJAgnWOLWVLXQurWUzLQmmzxtL
```

#### 🔴 JPA/HIBERNATE
```
Key: JPA_DDL_AUTO
Value: update
```

```
Key: JPA_SHOW_SQL
Value: false
```

#### 🔴 FILE UPLOAD
```
Key: MAX_FILE_SIZE
Value: 50MB
```

```
Key: MAX_REQUEST_SIZE
Value: 50MB
```

#### 🔴 SERVER
```
Key: PORT
Value: 8080
```

#### 🔴 JWT SECURITY (QUAN TRỌNG!)
```
Key: JWT_SECRET
Value: chatplatform-super-secret-jwt-key-min-256-bits-change-this-later-abc123xyz789
```

⚠️ **Lưu ý**: Đây là secret tạm. Sau khi test xong, nên đổi bằng secret mạnh hơn!

```
Key: JWT_EXPIRATION
Value: 86400000
```

#### 🔴 AGORA
```
Key: AGORA_APP_ID
Value: 0230bbbb0b254599b2357e880af89d62
```

```
Key: AGORA_APP_CERTIFICATE
Value: your-agora-certificate-if-have
```

⚠️ Nếu không có certificate, để trống hoặc bỏ qua biến này.

#### 🔴 CORS (QUAN TRỌNG!)
```
Key: CORS_ORIGINS
Value: http://localhost:4200,https://chat-platform-frontend.netlify.app,https://chatplatform-frontend3.netlify.app
```

⚠️ **Cập nhật URL Netlify của bạn** vào đây!

#### 🔴 LOGGING
```
Key: LOG_LEVEL
Value: INFO
```

---

## 📸 Screenshot Hướng dẫn

1. **Tìm tab Environment**
   ```
   [Service Name] > Environment (tab bên trái)
   ```

2. **Click "Add Environment Variable"**
   - Mỗi lần click sẽ thêm 1 biến
   - Điền Key và Value
   - Click "Save Changes"

3. **Sau khi thêm hết tất cả**
   - Click **"Save Changes"** ở cuối trang
   - Render sẽ tự động **redeploy** (mất 2-3 phút)

---

## ✅ Checklist

Copy checklist này và tick khi làm xong:

- [ ] Đã vào Render Dashboard
- [ ] Đã chọn đúng service backend
- [ ] Đã vào tab Environment
- [ ] Đã thêm DATABASE_URL
- [ ] Đã thêm DATABASE_USERNAME  
- [ ] Đã thêm DATABASE_PASSWORD
- [ ] Đã thêm JPA_DDL_AUTO
- [ ] Đã thêm JPA_SHOW_SQL
- [ ] Đã thêm MAX_FILE_SIZE
- [ ] Đã thêm MAX_REQUEST_SIZE
- [ ] Đã thêm PORT
- [ ] Đã thêm JWT_SECRET
- [ ] Đã thêm JWT_EXPIRATION
- [ ] Đã thêm AGORA_APP_ID
- [ ] Đã thêm CORS_ORIGINS (với URL Netlify của bạn!)
- [ ] Đã thêm LOG_LEVEL
- [ ] Đã click "Save Changes"
- [ ] Render đang redeploy (xem tab "Events")

---

## 🔍 Kiểm tra Deployment

### Cách 1: Xem Logs trên Render

1. Tab **"Logs"** bên trái
2. Xem có lỗi không
3. Nếu thấy dòng này = **THÀNH CÔNG**:
   ```
   Started ChatplatformApplication in X.XXX seconds
   ```

### Cách 2: Test API

Mở trình duyệt hoặc Postman, test:

```
GET https://chatplatform3-11-yl72.onrender.com/api/rooms
```

Nếu trả về JSON (hoặc empty array []) = **THÀNH CÔNG** ✅

---

## 🐛 Troubleshooting

### Lỗi: "Database connection failed"

**Nguyên nhân**: DATABASE_URL sai format

**Giải pháp**: Kiểm tra lại Railway connection string:
```
jdbc:mysql://[username]:[password]@[host]:[port]/railway
```

### Lỗi: "CORS error" khi test từ frontend

**Nguyên nhân**: CORS_ORIGINS chưa có URL Netlify

**Giải pháp**: 
1. Lấy URL Netlify của bạn (vd: `https://abc123.netlify.app`)
2. Update CORS_ORIGINS:
   ```
   CORS_ORIGINS=https://abc123.netlify.app,https://www.abc123.netlify.app
   ```

### Lỗi: "Application failed to start"

**Nguyên nhân**: Thiếu env vars quan trọng

**Giải pháp**: Kiểm tra đã thêm đủ các biến DATABASE_*, JWT_SECRET, CORS_ORIGINS chưa

---

## 🎯 Sau khi Update xong

1. ✅ Render sẽ tự động redeploy (2-3 phút)
2. ✅ Kiểm tra Logs không có lỗi
3. ✅ Test API endpoint
4. ✅ Test từ frontend (login, chat, video call)

---

## 📞 Cần hỗ trợ?

Nếu gặp lỗi:
1. Check Render Logs (tab Logs)
2. Kiểm tra lại từng env var
3. Verify Railway database đang chạy
4. Test API trực tiếp

---

**Thời gian dự kiến: 5-10 phút** ⏱️

**Good luck! 🚀**
